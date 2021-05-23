package Evadarea.Map;

import Evadarea.Entity.Character;
import Evadarea.Entity.Entity;
import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SecondLevelMap implements Map
{
    private RefLinks refLink;

    private int length;
    private int height;
    private int[][] tiles;
    private int[][] oldTiles;


    // harta a doua, in mare parte totul e identic cu prima harta, cu mici diferente la initializare
    public SecondLevelMap(RefLinks refLink)
    {
        this.refLink = refLink;

        LoadWorld();
    }


    @Override
    public void Update()
    {

        OpenDoors();

    }

    @Override
    public void Draw(Graphics g)
    {
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < length; x++)
            {
                GetTile(x,y).Draw(g,
                        (int)(x * Tile.TILE_SIZE - refLink.GetGame().GetCamera().GetX()),
                        (int)(y * Tile.TILE_SIZE - refLink.GetGame().GetCamera().GetY()));
            }
        }
    }

    @Override
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= length || y >= height)
        {
            return Tile.water;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.floor_grass;
        }
        return t;
    }

    @Override
    public void LoadWorld()
    {
        int[][] map = InitMap();

        length += 20;
        height += 20;
        tiles = new int[length][height];
        oldTiles = new int[length][height];

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < length; x++)
            {
                if(y>9 && y<height-10 && x>9 && x<length-10)
                {
                    tiles[x][y] = map[y-10][x-10];
                    oldTiles[x][y] = map[y-10][x-10];
                }

                else
                {
                    tiles[x][y] = TileGeneratorForExteriorMap();
                    oldTiles[x][y] = TileGeneratorForExteriorMap();
                }
            }
        }
    }

    private int TileGeneratorForExteriorMap()
    {
        return 23; // water

    }

    @Override
    public void ChangeTile(int x, int y, int oldTileID, int newTileID)
    {
        try
        {
            // centru
            if (tiles[x][y] == oldTileID)
            {
                tiles[x][y] = newTileID;
            }

            // sus
            if (tiles[x][y + 1] == oldTileID)
            {
                tiles[x][y + 1] = newTileID;
            }

            // jos
            if (tiles[x][y - 1] == oldTileID)
            {
                tiles[x][y - 1] = newTileID;
            }

            // stanga
            if (tiles[x - 1][y] == oldTileID)
            {
                tiles[x - 1][y] = newTileID;
            }

            // dreapta
            if (tiles[x + 1][y] == oldTileID)
            {
                tiles[x + 1][y] = newTileID;
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Incercare de modificare dala in afara hartii!");
            e.printStackTrace();
        }
    }

    @Override
    public void ResetMap()
    {
        System.out.println("Map Reset 2");
        for(int x = 0; x < length; x++)
        {
            for(int y = 0; y < height; y++)
            {
                tiles[x][y] = oldTiles[x][y];
            }
        }
    }

    public void SaveMapInDataBase()
    {
        for(int y=0; y<height; y++)
        {
            StringBuilder s = new StringBuilder();
            for(int x=0; x<length; x++)
            {
                int id = GetTile(x,y).GetId();
                char c = (char)(id+'0');
                s.append(c);
            }
            refLink.GetGame().GetDataBase().UpdateMap(2,y, s.toString());
            System.out.println(s);
        }
    }

    public void LoadMapFromDataBase()
    {
        for(int y=0; y<height; y++)
        {
            String s = refLink.GetGame().GetDataBase().SelectMap(2,y);

//            System.out.println(s);

            for(int x=0; x<length; x++)
            {
                tiles[x][y] = s.charAt(x) - '0';
            }

        }
    }


    private int[][] InitMap()
    {
        String locatieHarta;
        length = 50;
        height = 31;

        locatieHarta = "res/Maps/Inchisoarea_Jilava";

        int[][] map = new int[height][length];

        int c;

        FileReader f = null;

        try
        {
            f = new FileReader(locatieHarta);

            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < length; j++)
                {
                    if ((c = f.read()) != -1)
                    {
                        map[i][j] = c - '0'; // ca sa transform din char in int(bine, nu transform, e doar chestia ca read() imi da un int care reprezinta codul ascii al caracterului, si eu nu vreau asta, vreu un index, asa ca scad codul ascii al lui 0 si e gataaa) #bestcomentariu
                        f.read();
                    }
                    else
                    {
                        System.out.println("Harta 2 are dimensiuni bulite!!!");
                        i = height + 1;
                        j = length + 1;
                    }
                }
                f.read();
            }

            f.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nu avem harta 2!");
        }
        catch (IOException e)
        {
            System.out.println("Eroare naspa!");
        }

        return map;
    }

    private void OpenDoors()
    {
        // referinte pentru player si coordonatele colturilor
        Entity player = refLink.GetGame().GetCurrentState().GetPlayer();
        int x1 = (int) (player.GetX() / Character.DEFAULT_SIZE);
        int x2 = (int) ((player.GetX() + player.GetSize()) / Character.DEFAULT_SIZE);
        int y1 = (int) (player.GetY() / Character.DEFAULT_SIZE);
        int y2 = (int) ((player.GetY() + player.GetSize()) / Character.DEFAULT_SIZE);


        // ca sa facem frumos sa se deschida usile la atingere
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < length; x++)
            {

                if(GetTile(x,y) == Tile.door || GetTile(x,y) == Tile.door_open)
                {
                    if((x1 == x || x2 == x) && (y1 == y || y2 == y))
                    {
                        tiles[x][y] = 43;
                    }
                    else
                    {
                        tiles[x][y] = 20;
                    }

                }
            }
        }
    }

    @Override
    public float GetLength()
    {
        return length;
    }

    @Override
    public float GetHeight()
    {
        return height;
    }

    @Override
    public int getMapID()
    {
        return 2;
    }

}
