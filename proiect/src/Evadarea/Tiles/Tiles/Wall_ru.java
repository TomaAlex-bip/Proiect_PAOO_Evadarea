package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_ru extends Tile
{
    public Wall_ru(int id)
    {
        super(Assets.wall_ru, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
