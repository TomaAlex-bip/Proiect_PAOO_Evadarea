package Evadarea.Camera;

import Evadarea.Entity.Entity;
import Evadarea.Game;
import Evadarea.RefLinks;

public class Camera
{
    private Game game;
    private float x;
    private float y;


    private static Camera instance = new Camera(0,0);

    // singleton
    public static Camera getInstance()
    {
        return instance;
    }

    private Camera(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void SetUpCamera(Game game)
    {
        this.game = game;
    }

    // metoda Update actualizeaza pozitia camerei in functie de entitatea pe care o urmareste
    public void Update(Entity follow)
    {
        x = follow.GetX() - (float)game.GetLength()/2 + follow.GetSize()/2;
        y = follow.GetY() - (float)game.GetHeight()/2 + follow.GetSize()/2;
    }


    public float GetX() { return x; }

    public float GetY() { return y; }

}
