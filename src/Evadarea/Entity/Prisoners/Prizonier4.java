package Evadarea.Entity.Prisoners;

import Evadarea.Entity.Character;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Prizonier4 extends Character
{

    private BufferedImage skin;

    private boolean hasTarnacop;

    public boolean showTarnacopTip;


    // acest prizonier are in plus un "inventar" cu un tarnacop si poate interactiona cu playerul
    public Prizonier4(RefLinks refLink, float x, float y, boolean orientation)
    {
        super(refLink, x, y, Character.DEFAULT_SIZE);

        if(orientation)
        {
            skin = Assets.prizonier4_r;
        }
        else
        {
            skin = Assets.prizonier4_l;
        }

        hasTarnacop = true;
        showTarnacopTip = false;

    }


    @Override
    public void Update()
    {
        Gigel player = refLink.GetGame().GetCurrentState().GetPlayer();

        int x1 = (int) (player.GetX() + player.GetInteractBounds().x);
        int x2 = (int) ((player.GetX() + player.GetInteractBounds().x + player.GetInteractBounds().width));
        int y1 = (int) (player.GetY() + player.GetInteractBounds().y);
        int y2 = (int) (player.GetY() + (player.GetInteractBounds().y + player.GetInteractBounds().height));


//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println(y1);
//        System.out.println(y2);

//        System.out.println(x);//1564
//        System.out.println(y);//644



        for(int i = (int)x; i < (int)x + 46; i++)
        {
            for (int j = (int)y; j < (int)y + 46; j++)
            {
                if ((x1 == i || x2 == i) && (y1 == j || y2 == j) && hasTarnacop && refLink.GetGame().GetCurrentState().GetPlayer().GetInventory().isBani())
                {
                    player.GetInventory().SetTarnacop();
                    hasTarnacop = false;
                    showTarnacopTip = true;
                }
            }
        }


    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(skin, (int)(x - refLink.GetGame().GetCamera().GetX()),
                (int)(y - refLink.GetGame().GetCamera().GetY()),
                size, size, null);


//        g.drawRect((int)(x - refLink.GetGame().GetCamera().GetX()),
//                (int)(y - refLink.GetGame().GetCamera().GetY()),
//                46, 46);


        //g.setColor(Color.GREEN);
        //g.drawRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

    }

    public void Reset()
    {
        hasTarnacop = true;
        showTarnacopTip = false;
    }

    public boolean GetHasTarnacop()
    {
        return hasTarnacop;
    }

    public void SetHasTarnacop(boolean hasTarnacop)
    {
        this.hasTarnacop = hasTarnacop;
    }
}
