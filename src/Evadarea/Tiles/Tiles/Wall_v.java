package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_v extends Tile
{
    public Wall_v(int id)
    {
        super(Assets.wall_v, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
