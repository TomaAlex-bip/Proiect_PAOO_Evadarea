package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Water extends Tile
{
    public Water(int id)
    {
        super(Assets.water, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }


}
