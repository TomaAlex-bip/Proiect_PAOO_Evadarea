package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Box extends Tile
{
    public Box(int id)
    {
        super(Assets.box, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
