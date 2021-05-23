package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car7 extends Tile
{
    public Car7(int id)
    {
        super(Assets.car7, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
