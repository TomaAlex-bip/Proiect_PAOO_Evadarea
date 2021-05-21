package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Floor_bush extends Tile
{
    public Floor_bush(int id)
    {
        super(Assets.floor_bush, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
