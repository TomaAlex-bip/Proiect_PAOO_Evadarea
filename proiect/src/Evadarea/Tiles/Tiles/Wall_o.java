package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_o extends Tile
{
    public Wall_o(int id)
    {
        super(Assets.wall_o, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
