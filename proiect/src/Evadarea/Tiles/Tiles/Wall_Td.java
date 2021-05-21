package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_Td extends Tile
{
    public Wall_Td(int id)
    {
        super(Assets.wall_Td, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
