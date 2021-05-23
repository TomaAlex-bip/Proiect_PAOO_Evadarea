package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Desk extends Tile
{
    public Desk(int id)
    {
        super(Assets.desk, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
