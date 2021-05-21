package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.Tiles.Tile;

public class Gratii extends Tile
{
    public Gratii(int id)
    {
        super(Assets.gratii, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
