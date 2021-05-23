package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Boatr extends Tile
{
    public Boatr(int id)
    {
        super(Assets.boatr, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
