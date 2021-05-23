package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_ld extends Tile
{
    public Wall_ld(int id)
    {
        super(Assets.wall_ld, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
