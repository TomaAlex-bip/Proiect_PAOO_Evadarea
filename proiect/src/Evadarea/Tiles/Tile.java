package Evadarea.Tiles;

import Evadarea.Tiles.Tiles.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{
    private static final int TILES_NUMBER = 78;

    public static Tile[] tiles = new Tile[TILES_NUMBER];

    public static Tile wall_o = new Wall_o(0);
    public static Tile wall_lu = new Wall_lu(1);
    public static Tile wall_ld = new Wall_ld(2);
    public static Tile wall_v = new Wall_v(3);
    public static Tile wall_Tu = new Wall_Tu(4);
    public static Tile wall_Tr = new Wall_Tr(5);
    public static Tile wall_Tl = new Wall_Tl(6);
    public static Tile wall_Td = new Wall_Td(7);
    public static Tile wall_ru = new Wall_ru(8);
    public static Tile wall_rd = new Wall_rd(9);
    public static Tile floor_wood = new Floor_wood(10);
    public static Tile floor_tiles = new Floor_tiles(11);
    public static Tile floor_bush = new Floor_bush(12);
    public static Tile floor_gravel = new Floor_gravel(13);
    public static Tile floor_grass = new Floor_grass(14);
    public static Tile floor_flowers = new Floor_flowers(15);
    public static Tile floor_concrete = new Floor_concrete(16);
    public static Tile fence_o = new Fence_o(17);
    public static Tile fence_v = new Fence_v(18);
    public static Tile grati = new Gratii(19);
    public static Tile door = new Door(20);
    public static Tile desk = new Desk(21);
    public static Tile box = new Box(22);
    public static Tile water = new Water(23);
    public static Tile tray = new Tray(24);
    public static Tile food = new Food(25);
    public static Tile table = new Table(26);
    public static Tile toilet_l = new Toilet_l(27);
    public static Tile toilet_r = new Toilet_r(28);
    public static Tile chair = new Chair(29);
    public static Tile stairs = new Stairs(30);
    public static Tile door_open = new Door_open(43);
    public static Tile money_desk = new Desk(44);
    public static Tile cracked_wall = new CrackedWall(45);
    public static Tile searched_desk = new SearchedDesk(46);
    public static Tile topor_desk = new Desk(49);

    public static Tile bedu = new Bedu(31);
    public static Tile bedd = new Bedd(32);
    public static Tile treeu = new Treeu(33);
    public static Tile treed = new Treed(34);
    public static Tile car1 = new Car1(35);
    public static Tile car2 = new Car2(36);
    public static Tile car3 = new Car3(37);
    public static Tile car4 = new Car4(38);
    public static Tile car5 = new Car5(39);
    public static Tile car6 = new Car6(40);
    public static Tile car7 = new Car7(41);
    public static Tile car8 = new Car8(42);
    public static Tile boatl = new Boatl(47);
    public static Tile boatr = new Boatr(48);


    public static final int TILE_SIZE = 46; //46 pixeli dimensiunea originala

    protected BufferedImage img;
    protected final int id;


    // clasa de baza pentru dale(tiles)
    public Tile(BufferedImage img, int id)
    {
        this.img = img;
        this.id = id;

        tiles[id] = this;
    }

    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {
        g.drawImage(img, x, y, TILE_SIZE, TILE_SIZE, null);
    }

    public boolean IsSolid()
    {
        return false;
    }

    public int GetId()
    {
        return id;
    }



}
