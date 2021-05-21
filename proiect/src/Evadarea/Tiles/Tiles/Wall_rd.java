package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_rd extends Tile
{
    public Wall_rd(int id)
    {
        super(Assets.wall_rd, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
