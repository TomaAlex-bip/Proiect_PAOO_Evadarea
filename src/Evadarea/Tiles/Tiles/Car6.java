package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car6 extends Tile
{
    public Car6(int id)
    {
        super(Assets.car6, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
