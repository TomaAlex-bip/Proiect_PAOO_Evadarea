package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class SearchedDesk extends Tile
{
    public SearchedDesk(int id)
    {
        super(Assets.desk, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
