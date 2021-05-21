package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Boatl extends Tile
{
    public Boatl(int id)
    {
        super(Assets.boatl, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
