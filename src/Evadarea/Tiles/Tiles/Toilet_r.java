package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Toilet_r extends Tile
{
    public Toilet_r(int id)
    {
        super(Assets.toilet_r, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
