package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car2 extends Tile
{
    public Car2(int id)
    {
        super(Assets.car2, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
