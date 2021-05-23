package Evadarea.Graphics;

import java.awt.image.BufferedImage;

public class Assets
{
    public static BufferedImage wall_o;
    public static BufferedImage wall_lu;
    public static BufferedImage wall_ld;
    public static BufferedImage wall_v;
    public static BufferedImage wall_Tu;
    public static BufferedImage wall_Tr;
    public static BufferedImage wall_Tl;
    public static BufferedImage wall_Td;
    public static BufferedImage wall_ru;
    public static BufferedImage wall_rd;
    public static BufferedImage floor_wood;
    public static BufferedImage floor_tiles;
    public static BufferedImage floor_bush;
    public static BufferedImage floor_gravel;
    public static BufferedImage floor_grass;
    public static BufferedImage floor_flowers;
    public static BufferedImage floor_concrete;
    public static BufferedImage fence_v;
    public static BufferedImage fence_o;
    public static BufferedImage gratii;
    public static BufferedImage door;
    public static BufferedImage desk;
    public static BufferedImage box;
    public static BufferedImage water;
    public static BufferedImage tray;
    public static BufferedImage food;
    public static BufferedImage table;
    public static BufferedImage toilet_l;
    public static BufferedImage toilet_r;
    public static BufferedImage chair;
    public static BufferedImage stairs;
    public static BufferedImage door_open;
    public static BufferedImage cracked_wall;

    public static BufferedImage bedu;
    public static BufferedImage bedd;
    public static BufferedImage treeu;
    public static BufferedImage treed;
    public static BufferedImage boatl;
    public static BufferedImage boatr;
    public static BufferedImage car1;
    public static BufferedImage car2;
    public static BufferedImage car3;
    public static BufferedImage car4;
    public static BufferedImage car5;
    public static BufferedImage car6;
    public static BufferedImage car7;
    public static BufferedImage car8;

    public static BufferedImage guard1_r;
    public static BufferedImage guard2_r;
    public static BufferedImage guard1_l;
    public static BufferedImage guard2_l;
    public static BufferedImage garcea_r;
    public static BufferedImage garcea_l;

    public static BufferedImage prizonier1_r;
    public static BufferedImage prizonier1_l;
    public static BufferedImage prizonier2_r;
    public static BufferedImage prizonier2_l;
    public static BufferedImage prizonier3_r;
    public static BufferedImage prizonier3_l;
    public static BufferedImage prizonier4_r;
    public static BufferedImage prizonier4_l;

    public static BufferedImage player1_r;
    public static BufferedImage player2_r;
    public static BufferedImage player1_l;
    public static BufferedImage player2_l;
    public static BufferedImage player1_f;
    public static BufferedImage player2_f;
    public static BufferedImage player1_b;
    public static BufferedImage player2_b;

    public static BufferedImage player_head;

    public static BufferedImage menuBackground;
    public static BufferedImage new_game_button;
    public static BufferedImage continue_button;
    public static BufferedImage sound_on_button;
    public static BufferedImage sound_off_button;
    public static BufferedImage save_game_button;
    public static BufferedImage main_menu_button;

    public static BufferedImage M;
    public static BufferedImage P;
    public static BufferedImage C;
    public static BufferedImage N;
    public static BufferedImage Q;
    public static BufferedImage S;
    public static BufferedImage Space;



    // metoda care initializeaza toate imaginile jocului dintr-un sprite sheet
    public static void Init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sprite_sheet.png"));

        // 1 bucata tiles
        wall_o = sheet.getTile(0,0);
        wall_lu = sheet.getTile(1,0);
        wall_ld = sheet.getTile(2,0);
        wall_v = sheet.getTile(3,0);
        wall_Tu = sheet.getTile(4,0);
        wall_Tr = sheet.getTile(5,0);
        wall_Tl = sheet.getTile(6,0);
        wall_Td = sheet.getTile(7,0);
        wall_ru = sheet.getTile(8,0);
        wall_rd = sheet.getTile(9,0);
        floor_wood = sheet.getTile(0,1);
        floor_tiles = sheet.getTile(1,1);
        floor_bush = sheet.getTile(2,1);
        floor_gravel = sheet.getTile(3,1);
        floor_grass = sheet.getTile(4,1);
        floor_flowers = sheet.getTile(5,1);
        floor_concrete = sheet.getTile(6,1);
        fence_v = sheet.getTile(7,1);
        fence_o = sheet.getTile(8,1);
        gratii = sheet.getTile(9,1);
        door = sheet.getTile(0,2);
        desk = sheet.getTile(1,2);
        box = sheet.getTile(2,2);
        water = sheet.getTile(3,2);
        tray = sheet.getTile(4,2);
        food = sheet.getTile(5,2);
        table = sheet.getTile(6,2);
        toilet_l = sheet.getTile(7,2);
        toilet_r = sheet.getTile(8,2);
        chair = sheet.getTile(9,2);
        stairs = sheet.getTile(10,2);
        // ar trebui sa fac o textura pentru usa deschisa, dar merge si asa
        door_open = sheet.getTile(3,1); //13,2
        cracked_wall = sheet.getTile(13,2);

        // n bucati tiles
        bedu = sheet.getTile(10,0);
        bedd = sheet.getTile(10,1);
        treeu = sheet.getTile(11,0);
        treed = sheet.getTile(11,1);
        boatl = sheet.getTile(11,2);
        boatr = sheet.getTile(12,2);
        car1 = sheet.getTile(12,0);
        car2 = sheet.getTile(13,0);
        car3 = sheet.getTile(14,0);
        car4 = sheet.getTile(15,0);
        car5 = sheet.getTile(12,1);
        car6 = sheet.getTile(13,1);
        car7 = sheet.getTile(14,1);
        car8 = sheet.getTile(15,1);


        // Player
        player1_r = sheet.getTile(0,5);
        player2_r = sheet.getTile(1,5);
        player1_l = sheet.getTile(2,5);
        player2_l = sheet.getTile(3,5);
        player1_f = sheet.getTile(4,5);
        player2_f = sheet.getTile(5,5);
        player1_b = sheet.getTile(6,5);
        player2_b = sheet.getTile(7,5);

        player_head = sheet.getImage(14*46,2*46,30,23);

        // politisti
        guard1_r = sheet.getTile(0,3);
        guard2_r = sheet.getTile(1,3);
        guard1_l = sheet.getTile(2,3);
        guard2_l = sheet.getTile(3,3);
        garcea_r = sheet.getTile(4,3);
        garcea_l = sheet.getTile(5,3);

        // prizonieri
        prizonier1_r = sheet.getTile(0,4);
        prizonier1_l = sheet.getTile(1,4);
        prizonier2_r = sheet.getTile(2,4);
        prizonier2_l = sheet.getTile(3,4);
        prizonier3_r = sheet.getTile(4,4);
        prizonier3_l = sheet.getTile(5,4);
        prizonier4_r = sheet.getTile(6,4);
        prizonier4_l = sheet.getTile(7,4);

        // butoane, nimic uau
        new_game_button = sheet.getImage(0,277,140,49);
        continue_button = sheet.getImage(0,327,140,49);
        sound_on_button = sheet.getImage(142,277,62,49);
        sound_off_button = sheet.getImage(142,327,62,49);
        save_game_button = sheet.getImage(206,277,140,49);
        main_menu_button = sheet.getImage(206,327,140,49);

        // mini butoane
        M = sheet.getImage(348, 277, 31, 30);
        P = sheet.getImage(380, 277, 31, 30);
        C = sheet.getImage(412, 277, 31, 30);
        N = sheet.getImage(444, 277, 32, 33);
        Q = sheet.getImage(476, 277, 31, 30);
        S = sheet.getImage(508, 277, 31, 30);
        Space = sheet.getImage(508+31, 277, 31, 30);

        menuBackground = sheet.getImage(0, 376, 800, 600);

    }
}
