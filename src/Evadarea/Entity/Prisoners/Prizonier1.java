package Evadarea.Entity.Prisoners;

import Evadarea.Entity.Character;
import Evadarea.Graphics.Assets;
import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Prizonier1 extends Character
{

    private BufferedImage skin;


    // un simplu prizonier, acelasi lucru e valabil pentru toti ceilalti
    public Prizonier1(RefLinks refLink, float x, float y, boolean orientation)
    {
        super(refLink, x, y, Character.DEFAULT_SIZE);

        if(orientation)
        {
            skin = Assets.prizonier1_r;
        }
        else
        {
            skin = Assets.prizonier1_l;
        }

    }


    @Override
    public void Update()
    {


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
}
