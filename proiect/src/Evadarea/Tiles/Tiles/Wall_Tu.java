package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_Tu extends Tile
{
    public Wall_Tu(int id)
    {
        super(Assets.wall_Tu, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
