package Evadarea.Map;

import Evadarea.Entity.Character;
import Evadarea.Entity.Entity;
import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FirstLevelMap implements Map
{

    private RefLinks refLink;

    private int length;
    private int height;
    private int[][] tiles;
    private int[][] oldTiles;


    // harta primului nivel
    public FirstLevelMap(RefLinks refLink)
    {
        this.refLink = refLink;

        LoadWorld();
    }


    // fac update la dale in caz ca se modifica harta
    @Override
    public void Update()
    {

        OpenDoors();

    }

    // salvam harta in baza de date
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
            refLink.GetGame().GetDataBase().UpdateMap(1,y, s.toString());
            System.out.println(s);
        }
    }

    // incarcam harta din baza de date
    public void LoadMapFromDataBase()
    {
        for(int y=0; y<height; y++)
        {
            String s = refLink.GetGame().GetDataBase().SelectMap(1,y);

//            System.out.println(s);

            for(int x=0; x<length; x++)
            {
                tiles[x][y] = s.charAt(x) - '0';
            }

        }
    }

    // desenam harta
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

    // metoda folosita pentru draw, aici se verifica daca harta a fost initializata corect, daca harta a fosr incarcata bine, se alege tile-ul pentru pozitia aferenta
    // daca au aparut probleme si harta sau bucatin din ea au ramas neinitializate, se trimite mai departe o dala "default", in cazul nostru, iarba
    @Override
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= length || y >= height)
        {
            return Tile.floor_bush;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.floor_grass;
        }
        return t;
    }

    //incarc harta citita din fisier
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

    // generator de tile aleator intre tufis, iarba sau flori pentru a genera marginea hartii, ca sa nu mai stochez date inutile in fisier
    private int TileGeneratorForExteriorMap()
    {
        double rng = Math.random();

        if(rng < 0.2)
        {
            return 12; // bush
        }
        else if(rng < 0.3)
        {
            return 15; // flower
        }
        else
        {
            return 14; // grass
        }
    }

    // schimba un tile cu altul de la o pozitie data
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

    //reseteaza harta, la initializare, fac o copie a hartii pe care nu o modific, iar cand vreau sa resetez harta, incarc in harta curenta pe cea veche nemodificata
    @Override
    public void ResetMap()
    {
        System.out.println("Map Reset 1");
        for(int x = 0; x < length; x++)
        {
            for(int y = 0; y < height; y++)
            {
                tiles[x][y] = oldTiles[x][y];
            }
        }
    }

    // initializeaza harta
    // citeste din fisier
    private int[][] InitMap()
    {
        String locatieHarta;
        length = 34;
        height = 19;

        locatieHarta = "res/Maps/Inchisoarea_Craiova";

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
                        System.out.println("Harta 1 are dimensiuni bulite!!!");
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
            System.out.println("Nu avem harta 1!");
        }
        catch (IOException e)
        {
            System.out.println("Eroare naspa!");
        }

        return map;
    }

    // metoda care face ca usile sa se deschida daca playerul intra in contact cu ele
    // functioneaza foarte simplu,se parcurge toat harta, daca playerul este pe o pozitie la care se alfa si o usa, tile-ul usii se schimba cu un tile de podea, daca nu, usa ramane
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

    public int getMapID()
    {
        return 1;
    }
}
