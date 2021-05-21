package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Tray extends Tile
{
    public Tray(int id)
    {
        super(Assets.tray, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
