package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Chair extends Tile
{
    public Chair(int id)
    {
        super(Assets.chair, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
