package Evadarea;

import Evadarea.Managers.Input.KeyManager;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.FactoryMap;

public class RefLinks
{
    private Game game;
    private EntitiesMap entitiesMap;

    private FactoryMap factoryMap;


    // clasa care contine referinte la unele obiecte
    public RefLinks(Game game)
    {
        this.game = game;
        factoryMap = new FactoryMap(this);
    }

    public int GetLength()
    {
        return game.GetLength();
    }

    public int GetHeight()
    {
        return game.GetHeight();
    }

    public Game GetGame()
    {
        return game;
    }

    public void SetGame(Game game)
    {
        this.game = game;
    }

    public FactoryMap GetFactoryMap()
    {
        return factoryMap;
    }

    public void SetEntitiesMap(EntitiesMap entitiesMap)
    {
        this.entitiesMap = entitiesMap;
    }

    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }




}
