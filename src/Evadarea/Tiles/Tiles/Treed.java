package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Treed extends Tile
{
    public Treed(int id)
    {
        super(Assets.treed, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
