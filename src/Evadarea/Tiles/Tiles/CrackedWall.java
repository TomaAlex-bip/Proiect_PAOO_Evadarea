package Evadarea.Tiles.Tiles;

import Evadarea.Graphics.Assets;
import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

public class CrackedWall extends Tile
{
    public CrackedWall(int id)
    {
        super(Assets.cracked_wall, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
