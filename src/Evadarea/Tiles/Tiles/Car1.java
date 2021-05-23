package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car1 extends Tile
{
    public Car1(int id)
    {
        super(Assets.car1, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
