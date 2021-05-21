package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Bedd extends Tile
{
    public Bedd(int id)
    {
        super(Assets.bedd, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
