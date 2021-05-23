package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car3 extends Tile
{
    public Car3(int id)
    {
        super(Assets.car3, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
