package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Wall_Tl extends Tile
{
    public Wall_Tl(int id)
    {
        super(Assets.wall_Tl, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
