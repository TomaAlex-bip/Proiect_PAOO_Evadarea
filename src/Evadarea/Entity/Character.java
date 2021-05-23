package Evadarea.Entity;

import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

public abstract class Character extends Entity
{
    public static final float DEFAULT_SPEED = 2f;       //exsita o problema la coliziunea mea daca am viteza diferita de 1
                                                        //practic trece cu 3-1 unitati prin perete, si asta imi cam buleste cateva chestii ca sa pot sa il fac sa mearga lipit de perete
    //public static final int DEFAULT_SIZE = 46;
    public static final int DEFAULT_SIZE = Tile.TILE_SIZE;

    protected float speed;
    protected float xMove;
    protected float yMove;


    // clasa de baza pentru caractere, aici se adauga optiuni pentru movement
    public Character(RefLinks refLink, float x, float y, int size)
    {
        super(refLink, x, y, size);

        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }


    public void Move()
    {
        MoveX();
        MoveY();
    }

    public void MoveX()
    {
        x += xMove;
    }

    public void MoveY()
    {
        y += yMove;
    }




}
