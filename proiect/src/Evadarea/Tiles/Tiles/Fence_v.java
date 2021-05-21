package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Fence_v extends Tile
{
    public Fence_v(int id)
    {
        super(Assets.fence_v, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
