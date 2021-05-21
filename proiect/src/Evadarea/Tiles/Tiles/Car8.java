package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car8 extends Tile
{
    public Car8(int id)
    {
        super(Assets.car8, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
