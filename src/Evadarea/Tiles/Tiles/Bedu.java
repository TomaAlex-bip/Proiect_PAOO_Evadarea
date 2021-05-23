package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Bedu extends Tile
{
    public Bedu(int id)
    {
        super(Assets.bedu, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
