package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_lu extends Tile
{
    public Wall_lu(int id)
    {
        super(Assets.wall_lu, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
