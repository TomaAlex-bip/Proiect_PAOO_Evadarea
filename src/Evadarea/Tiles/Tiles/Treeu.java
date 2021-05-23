package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Treeu extends Tile
{
    public Treeu(int id)
    {
        super(Assets.treeu, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
