package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Fence_o extends Tile
{
    public Fence_o(int id)
    {
        super(Assets.fence_o, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}


