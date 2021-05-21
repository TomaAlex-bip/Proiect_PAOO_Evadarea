package Evadarea.Map;

import Evadarea.Tiles.Tile;

import java.awt.*;

public interface Map
{


    public void Update();

    public void Draw(Graphics g);

    public Tile GetTile(int x, int y);

    public void LoadWorld();

    public void ChangeTile(int x, int y, int oldTileID, int newTileID);

    public void ResetMap();

    public float GetLength();

    public float GetHeight();

    public int getMapID();

    public void SaveMapInDataBase();

    public void LoadMapFromDataBase();


}