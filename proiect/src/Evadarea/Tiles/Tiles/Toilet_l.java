package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Toilet_l extends Tile
{
    public Toilet_l(int id)
    {
        super(Assets.toilet_l, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
