package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Table extends Tile
{
    public Table(int id)
    {
        super(Assets.table, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
