package Evadarea.Map;

import Evadarea.Entity.Character;
import Evadarea.Entity.Entity;
import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

import java.awt.*;


public class EntitiesMap
{

    private int length;
    private int height;

    private Entity[][] entityMap;

    private Entity[] entities;

    // o sa il fac sa primeasca un vector de entitati ca sa fie mai usor
    // sa lucrez cu numar diferit de entitati pe fiecare nivel
    // daca o sa fie nevoie, a fost nevoie :))


    // harta mai speciala, nu retine dale(tiles), ci retine entitati(entities)
    public EntitiesMap(RefLinks refLink, Entity[] entities, int id)
    {
        length = (int)refLink.GetFactoryMap().getMap(id).GetLength() * Tile.TILE_SIZE;
        height = (int)refLink.GetFactoryMap().getMap(id).GetHeight() * Tile.TILE_SIZE;

        this.entities = new Entity[entities.length];

        for(int i=0; i < entities.length; i++)
        {
            this.entities[i] = entities[i];
        }

        InitMap(this.entities);
    }


    // modifica matricea de entitati in functie de pozitiile lor
    public void Update()
    {
        for(int i=0; i< entities.length; i++)
        {
            entities[i].Update();
        }


        for(int i=0; i< length; i++)
        {
            for(int j=0; j<height; j++)
            {
                entityMap[i][j] = null;
            }
        }

        for(int i=0; i < entities.length; i++)
        {
            for(int x = (int)entities[i].GetX(); x < (int)entities[i].GetX()+ Character.DEFAULT_SIZE; x++)
            {
                for(int y = (int)entities[i].GetY(); y < (int)entities[i].GetY()+Character.DEFAULT_SIZE; y++)
                {
                    entityMap[x][y] = entities[i];
                }
            }
        }



    }

    private void InitMap(Entity[] entities)
    {
        entityMap = new Entity[length][height];

        for(int i=0; i < entities.length; i++)
        {
            for(int x = (int)entities[i].GetX(); x < (int)entities[i].GetX()+ Character.DEFAULT_SIZE; x++)
            {
                for(int y = (int)entities[i].GetY(); y < (int)entities[i].GetY()+Character.DEFAULT_SIZE; y++)
                {
                    entityMap[x][y] = entities[i];
                }
            }
        }


    }

    public Entity GetEntityOnPosition(int x, int y)
    {
        if(x>length || x<0 || y>height || y<0)
        {
            return null;
        }
        if(entityMap[x][y] != null)
        {
            return entityMap[x][y];
        }
        else
        {
            return null;
        }
    }

    // am integrat metodele Draw() ale entitatilor intr-o singura metoda
    // astfel daca pe parcurs adau noi entitati nu mai trebuie sa umblu peste tot in cod sa le dau Draw()
    // ci pot sa vin aici si de restul se ocupa codul deja scris
    public void Draw(Graphics g)
    {
        for(int i=0; i<entities.length; i++)
        {
            entities[i].Draw(g);
        }
    }

}
