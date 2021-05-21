package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_Tr extends Tile
{
    public Wall_Tr(int id)
    {
        super(Assets.wall_Tr, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
