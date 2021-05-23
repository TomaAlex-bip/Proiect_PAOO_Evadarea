package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car4 extends Tile
{
    public Car4(int id)
    {
        super(Assets.car4, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
