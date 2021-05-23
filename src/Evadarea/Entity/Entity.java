package Evadarea.Entity;

import Evadarea.RefLinks;

import java.awt.*;

public abstract class Entity
{
    protected float x;
    protected float y;
    protected int size;

    protected Rectangle bounds;
    protected Rectangle normalBounds;
    protected Rectangle interactBounds;

    protected RefLinks refLink;

    // clasa de baza pentru entitati, aici se afla doar pozitia si marimea
    public Entity(RefLinks refLink, float x, float y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.refLink = refLink;

        normalBounds = new Rectangle(0,0,size,size);
        interactBounds = new Rectangle(0,0,size*2,size*2);

        bounds = normalBounds;
    }

    public abstract void Update();
    public abstract void Draw(Graphics g);

    // get-eri, sa vad daca trebuie

    public float GetX()
    {
        return x;
    }

    public float GetY()
    {
        return y;
    }

    public float GetSize()
    {
        return size;
    }

    // set-eri, sa vad daca trebuie

    public void SetPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }


}
