package Evadarea.Entity.Guards;

import Evadarea.Entity.Character;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Garcea extends Character
{
    private BufferedImage garcea;


    // un gardian simplu fara proprietati de miscare sau de resetare nivel, precum "Dorel"
    // totusi proprietatea lui este ca se poate "deplasa"(teleporta) in alta locatie atunci cand nu este randat de camera
    public Garcea(RefLinks refLink, float x, float y)
    {
        super(refLink, x , y, Character.DEFAULT_SIZE);

        garcea = Assets.garcea_r;

        normalBounds.x = bounds.x;
        normalBounds.y = bounds.y;

        normalBounds.width = bounds.width;
        normalBounds.height = bounds.height;

    }

    @Override
    public void Update()
    {

        Gigel player = refLink.GetGame().GetCurrentState().GetPlayer();

        // daca playerul ia o distanta suficienta astfel incat sa nu mai fie pe ecran Garcea, se poate randomiza pozitia lui
        if(player.GetX() > 30 * 46)
        {
            // mai este loc de imbunatatiri evident, au avut loc deja, totul merge bine
            double rng = Math.random();

//        System.out.println("RNG = " + rng);

            // odata ce a plecat, are sansa sa mai si revina
            if(rng > 0.999)
            {
                x = 16 * Character.DEFAULT_SIZE;
                y = 23 * Character.DEFAULT_SIZE;
//                System.out.println("pleaca garcea");

            }

            // sansa sa plece de la locul lui de paza este destul de mica
            if(rng < 0.005)
            {
                x = 21 * Character.DEFAULT_SIZE;
                y = 14 * Character.DEFAULT_SIZE;
//                System.out.println("revine la loc garcea");

            }

        }


    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(garcea, (int)(x - refLink.GetGame().GetCamera().GetX()),
                (int)(y - refLink.GetGame().GetCamera().GetY()),
                size, size, null);

//        g.setColor(Color.GREEN);
//        g.drawRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

    }


    public int GetMapPositionX()
    {
        return (int)GetX()/ Character.DEFAULT_SIZE;
    }
    public int GetMapPositionY()
    {
        return (int)GetY()/ Character.DEFAULT_SIZE;
    }
}
