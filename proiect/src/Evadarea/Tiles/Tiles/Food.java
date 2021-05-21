package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Food extends Tile
{
    public Food(int id)
    {
        super(Assets.food, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
