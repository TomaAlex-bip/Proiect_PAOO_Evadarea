package Evadarea.States;

import Evadarea.Camera.HUD;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;

import java.awt.*;

public abstract class State
{

    private static State previousState = null;
    private static State currentState = null;

    protected RefLinks refLink;

    protected static boolean escaped1 = false;
    protected static boolean escaped2 = false;

    //protected boolean escaped = false;

    public State(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
    }

    public static State GetState()
    {
        return currentState;
    }

    public static State GetPreviousState()
    {
        return previousState;
    }

    public abstract void Update();

    public abstract void Draw(Graphics g);

    public abstract Map GetMap();
    public abstract EntitiesMap GetEntitiesMap();

    public abstract boolean GetEscaped();
    public abstract void SetEscaped(boolean escaped);

    public abstract Gigel GetPlayer();

    public abstract void ResetState();

    public abstract int GetScore();

    public abstract void SaveInDataBase();


    public abstract void LoadDataBase();

    public abstract HUD GetHud();
}
