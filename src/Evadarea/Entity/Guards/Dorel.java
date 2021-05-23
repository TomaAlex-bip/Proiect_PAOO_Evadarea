package Evadarea.Entity.Guards;

import Evadarea.Animations.Animation;
import Evadarea.Entity.Character;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Dorel extends Character
{

    private final int INTERACT_BOUNDS_WIDTH = 200;
    private final int INTERACT_BOUNDS_HEIGHT = 80;

    private BufferedImage dorel;

    private boolean moveL = false;
    private boolean moveR = false;

    private Animation leftAnim;
    private Animation rightAnim;

    private int xMinMove;
    private int xMaxMove;

    private boolean dangerous;


    // gardian care se poate misca si poate sa te trimita inapoi in celula
    public Dorel(RefLinks refLink, float x, float y, int xMinMove, int xMaxMove, boolean dangerous)
    {
        super(refLink, x, y, Character.DEFAULT_SIZE);

        dorel = Assets.guard1_l;

        normalBounds.x = bounds.x;
        normalBounds.y = bounds.y;

        normalBounds.width = bounds.width;
        normalBounds.height = bounds.height;

        interactBounds.width = INTERACT_BOUNDS_WIDTH;
        interactBounds.height = INTERACT_BOUNDS_HEIGHT;
        interactBounds.x = normalBounds.x - (interactBounds.width - normalBounds.width);
        interactBounds.y = normalBounds.y - (interactBounds.height - normalBounds.height)/2;


        leftAnim = new Animation(Assets.guard1_l, Assets.guard2_l, 25);
        rightAnim = new Animation(Assets.guard1_r, Assets.guard2_r, 25);

        this.xMinMove = xMinMove;
        this.xMaxMove = xMaxMove;

        this.dangerous = dangerous;

    }

    @Override
    public void Update()
    {

        UpdateBounds();

        CheckInteractions();

        Movement();

    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(dorel, (int)(x - refLink.GetGame().GetCamera().GetX()),
                (int)(y - refLink.GetGame().GetCamera().GetY()),
                size, size, null);

//        g.setColor(Color.WHITE);
//        g.drawRect((int)(x + interactBounds.x - refLink.GetGame().GetCamera().GetX()),
//                (int)(y + interactBounds.y - refLink.GetGame().GetCamera().GetY()),
//                interactBounds.width, interactBounds.height);



    }


    // metoda care schimba hitboxul de interactiune(cel care face ca playerul sa fie trimis inapoi in celula)
    // daca se misca la dreapta, hitboxul vreau sa fie indreptat spre dreapta, analog la stanga
    //practic acest hitbox reprezinta raza de viziune a politistului
    private void UpdateBounds()
    {
        if(moveL)
        {
            interactBounds.width = INTERACT_BOUNDS_WIDTH;
            interactBounds.height = INTERACT_BOUNDS_HEIGHT;
            interactBounds.x = normalBounds.x - (interactBounds.width - normalBounds.width);
            interactBounds.y = normalBounds.y - (interactBounds.height - normalBounds.height)/2;
        }
        if(moveR)
        {
            interactBounds.width = INTERACT_BOUNDS_WIDTH;
            interactBounds.height = INTERACT_BOUNDS_HEIGHT;
            interactBounds.x = normalBounds.x;
            interactBounds.y = normalBounds.y - (interactBounds.height - normalBounds.height)/2;
        }
    }


    // o metoda care realizeaza o miscare simpla de stanga dreapta continua, bazata pe o pozitie maxima si una minima
    private void Movement()
    {
        if(x == xMaxMove * Character.DEFAULT_SIZE)//32
        {
            moveL = true;
            moveR = false;
        }
        if(x == xMinMove * Character.DEFAULT_SIZE)//24
        {
            moveR = true;
            moveL = false;
        }

        if(moveL)
        {
            leftAnim.Update();
            dorel = leftAnim.getCurrentFrame();
            x += -1;
        }
        if(moveR)
        {
            rightAnim.Update();
            dorel = rightAnim.getCurrentFrame();
            x += 1;
        }
    }


    // metoda care verifica daca playerul a intrat in raza de viziune a gardianului, daca da, reseteaza nivelul
    private void CheckInteractions()
    {
        Gigel player = refLink.GetGame().GetCurrentState().GetPlayer();

        int x1 = (int) (player.GetX() + player.GetNormalBounds().x);
        int x2 = (int) ((player.GetX() + player.GetNormalBounds().x + player.GetNormalBounds().width));
        int y1 = (int) (player.GetY() + player.GetNormalBounds().y);
        int y2 = (int) (player.GetY() + (player.GetNormalBounds().y + player.GetNormalBounds().height));



        for(int i = (int)(x + interactBounds.x); i < (int)(x + interactBounds.x+interactBounds.width); i++)
        {
            for (int j = (int)(y + interactBounds.y); j < (int)(y + interactBounds.y+interactBounds.height); j++)
            {
                if ((x1 == i || x2 == i) && (y1 == j || y2 == j) && dangerous)
                {
                    System.out.println("restart");
                    refLink.GetGame().GetCurrentState().ResetState();
                }
            }
        }

    }

}
