package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Car5 extends Tile
{
    public Car5(int id)
    {
        super(Assets.car5, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
