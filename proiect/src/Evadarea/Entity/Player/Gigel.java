package Evadarea.Entity.Player;

import Evadarea.Animations.Animation;
import Evadarea.Entity.Character;
import Evadarea.Graphics.Assets;
import Evadarea.Managers.Inventory.Inventory;
import Evadarea.RefLinks;
import Evadarea.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Gigel extends Character
{
    private Inventory inventory;

    private BufferedImage playerImg;

    // ma folosesc de acesti booli ca sa vad daca am coliziune
    // nu prea ma duce capul sa fac mai eficient
    private boolean canMoveL;
    private boolean canMoveR;
    private boolean canMoveU;
    private boolean canMoveD;

    private Animation upAnim;
    private Animation downAnim;
    private Animation leftAnim;
    private Animation rightAnim;


    public boolean showBaniTip;
    public boolean showFoarfeceTip;
    public boolean showTarnacopTip;
    public boolean showLinguraTip;
    public boolean showNimicTip;
    public boolean showToporTip;
    public boolean showVaslaTip;

    public boolean showFailLingura;


    // playerul, acesta are toate proprietatile unui caracter, putin modificate
    // aici se verifica coliziunea interactiunile si miscarea
    public Gigel(RefLinks refLink, float x, float y)
    {
        super(refLink, x, y, Character.DEFAULT_SIZE);

        inventory = new Inventory();

        playerImg = Assets.player1_f;

        //offsetul si marimea hitboxului playerului, adica a lui gigel

        //ecuatii ca sa calculez colliderul si daca redimensionez marimea dalelor
        normalBounds.x = ((Tile.TILE_SIZE * 3)/46);
        normalBounds.y = ((Tile.TILE_SIZE * 20)/46);

        // hitboxul este mai mic pe axa Y ca sa dau un efect de "3D"
        // adica atunci cand ma apropii de un perete din partea de sus
        // sa nu ma opresc la primul pixel al sprite-ului, sa las sa
        // treaca o parte din sprite peste perete

        // mie mi se pare ca este un efect frumos avand in vedere ca dalele
        // sunt facute intr-o perspectiva top-down, cu un unghi de ~45 de grade

        normalBounds.width = ((Tile.TILE_SIZE * 35)/46);
        normalBounds.height = ((Tile.TILE_SIZE * 24)/46);


        interactBounds.width = 3;
        interactBounds.height = 3;
        interactBounds.x = normalBounds.x + normalBounds.width/2 - interactBounds.width/2;
        interactBounds.y = normalBounds.y + normalBounds.height/2 - interactBounds.height/2;




        canMoveL = true;
        canMoveR = true;
        canMoveU = true;
        canMoveD = true;

        upAnim = new Animation(Assets.player1_b, Assets.player2_b, 15);
        downAnim = new Animation(Assets.player1_f, Assets.player2_f, 15);
        leftAnim = new Animation(Assets.player1_l, Assets.player2_l, 15);
        rightAnim = new Animation(Assets.player1_r, Assets.player2_r, 15);

        showBaniTip = false;
        showNimicTip = false;
        showLinguraTip = false;
        showFoarfeceTip = false;
        showFailLingura = false;
        showTarnacopTip = false;
        showToporTip = false;
        showVaslaTip = false;

    }

    public void Update()
    {

        /*
        System.out.println("canMoveU: " + canMoveU);
        System.out.println("canMoveD: " + canMoveD);
        System.out.println("canMoveL: " + canMoveL);
        System.out.println("canMoveR: " + canMoveR);
        */


        //System.out.println(refLink.GetEntitiesMap().GetEntityOnPosition((int)x,(int)y));

        GetInput();

        Move();

//        CheckCollision();

        CheckInteractions();



//        System.out.println("x = " + x);
//        System.out.println("y = " + y);


        //trebuie sa implementez clasa cu management de taste apasate
        //ca sa fac animatiile lui Gigel aista

        // !!!!!
        // problema la animatii
        //animatiile de schimba dupa o anumita durata de apasare a tastei
        //arat putin cam aiurea cand dai tap tap la tasta ca sa te misti
        //nu ramane chiar pe loc cu animatia, dar oarecum cand dai tap tap
        //te misti "un pas" dar fara animatie, eventual dupa suficiente
        //tap tap-uri animatia are loc

        // ar trebui sa fac cumva ca sa imi dea switch odata la animatie
        // imediat dupa ce apas tasta

        // recomand mie! cand o sa revin asupra problemei sa nu mai incerc
        // sa fac asta din clasa Animation, pentru ca nu merge cum trebuie
        // cel mai usor cred ca o fac de aici cu un switch la aninamtie  la
        // apasare si dupa sa verific sa se faca doar odata

        // ar fi foarte folositor sa implementez keyDown si keyUp cum aveam
        // in unity, imi usureaza munca

        if(refLink.GetKeyManager().up)
        {
            upAnim.Update();
            playerImg = upAnim.getCurrentFrame();
            //playerImg = Assets.player1_b;
        }
        if(refLink.GetKeyManager().down)
        {
            downAnim.Update();
            playerImg = downAnim.getCurrentFrame();
            //playerImg = Assets.player1_f;
        }
        if(refLink.GetKeyManager().left)
        {
            leftAnim.Update();
            playerImg = leftAnim.getCurrentFrame();
            //playerImg = Assets.player1_l;
        }
        if(refLink.GetKeyManager().right)
        {
            rightAnim.Update();
            playerImg = rightAnim.getCurrentFrame();
            //playerImg = Assets.player1_r;
        }
    }


    //se citesc taste ca sa se miste in directii si se verifica si daca se poate misca in acea directie
    private void GetInput()
    {
        xMove = 0;
        yMove = 0;


        if(refLink.GetKeyManager().up && canMoveU)
        {
            yMove = -speed;
            //System.out.println("up");
        }
        if(refLink.GetKeyManager().down && canMoveD)
        {
            yMove = speed;
            //System.out.println("down");
        }
        if(refLink.GetKeyManager().left && canMoveL)
        {
            xMove = -speed;
            //System.out.println("left");
        }
        if(refLink.GetKeyManager().right && canMoveR)
        {
            xMove = speed;
            //System.out.println("right");
        }
        if(refLink.GetKeyManager().interact)
        {
            //System.out.println("interact");
            EnlargeInteractBounds();
        }
        else
        {
            ShrinkInteractBounds();
        }


    }


    public void Draw(Graphics g)
    {
        g.drawImage(playerImg,
                (int)(x - refLink.GetGame().GetCamera().GetX()),
                (int)(y - refLink.GetGame().GetCamera().GetY()),
                size, size, null);

        //pentru vazut coliziunea

//        g.setColor(Color.MAGENTA);
//        g.drawRect((int)(x + bounds.x - refLink.GetGame().GetCamera().GetX()),
//                (int)(y + bounds.y - refLink.GetGame().GetCamera().GetY()),
//                bounds.width, bounds.height);
//
//        g.setColor(Color.WHITE);
//        g.drawRect((int)(x + interactBounds.x - refLink.GetGame().GetCamera().GetX()),
//                (int)(y + interactBounds.y - refLink.GetGame().GetCamera().GetY()),
//                interactBounds.width, interactBounds.height);

        // ca sa vad coltul caracterului excluzand coliziunea
        // am avut nevoie pentru ceva teste
//        g.setColor(Color.RED);
//        g.drawRect((int)x, (int)y, 1, 1);
    }


    // verific daca locatia playerului corespunde cu un tile cu coliziune
    //o mica explicatie pentru cum am implementat eu coliziunea:
//        ideea este ca eu verific colturile hitbox-ului, si in funtie de tipul dalei(solid/nonsolid)
//        impun restrictii pentru miscarea player-ului, pe langa astea mai verific cateva lucrui
//        fara de care player-ul mi s-ar misca in directia in care nu are voie daca unul din colturi
//        nu este o dala solida, pentru asta verific si dalele de lanag colturi, pentru ele am un
//        offset(collision_error), asta pentru ca viteza este 3, si imi intra player-ul cu 2 pixeli uneori
    private void CheckCollision()
    {

        int collision_error = 3; // asta imi rezolva oarecum coliziunea, mai exact tot trece gigel prin perete cu 2 pixeli, dar macar il pot misca cand e lipit de perete

        //astea sunt colturile hitboxului playerului
        float x1 = x + bounds.x;
        float x2 = x + bounds.x + normalBounds.width;

        float y1 = y + bounds.y;
        float y2 = y + bounds.y + normalBounds.height;

        //astea sunt tile-urile care intra in contact cu playerul in cele 4 colturi

        /*
        tlu tlur.........tral tru
        tlud ................trud
        .........................
        .........................
        .........................
        tldu.................trdu
        tld tldr.........trdl trd
        */

        boolean tlu = GetTileSolidity((int)(x1), (int)(y1));
        boolean tld = GetTileSolidity((int)(x1), (int)(y2));
        boolean tru = GetTileSolidity((int)(x2), (int)(y1));
        boolean trd = GetTileSolidity((int)(x2), (int)(y2));

        boolean tlur = GetTileSolidity((int)((x1+collision_error)), (int)(y1));
        boolean tral = GetTileSolidity((int)((x2-collision_error)), (int)(y1));
        boolean tldr = GetTileSolidity((int)((x1+collision_error)), (int)(y2));
        boolean trdl = GetTileSolidity((int)((x2-collision_error)), (int)(y2));

        boolean tlud = GetTileSolidity((int)((x1)), (int)((y1+collision_error)));
        boolean tldu = GetTileSolidity((int)((x1)), (int)((y2-collision_error)));
        boolean trud = GetTileSolidity((int)((x2)), (int)((y1+collision_error)));
        boolean trdu = GetTileSolidity((int)((x2)), (int)((y2-collision_error)));


        // pentru coltul din stanga sus si coltul din dreapta sus
        if( (tlur && tlu)
                || (tral && tru) )
        {
            canMoveU = false;
        }
        else
        {
            canMoveU = true;
        }

        // pentru coltul din stanga jos si coltul din dreapta jos
        if( (tldr && tld)
                || (trdl && trd) )
        {
            canMoveD = false;
        }
        else
        {
            canMoveD = true;
        }

        // pentru coltul din dreapta sus si coltul din dreapta jos
        if( (trud && tru)
                || (trdu && trd) )
        {
            canMoveR = false;
        }
        else
        {
            canMoveR = true;
        }

        // pentru coltul din stanga sus si coltul din stanga jos
        if( (tlud && tlu)
                || (tldu && tld) )
        {
            canMoveL = false;
        }
        else
        {
            canMoveL = true;
        }

    }

    // metoda care imi verifica tipul dalei(solid/nonsolid) in functie de o pozitie
    // dar mai verifica si daca pe pozitia respectiva se afla o alta entitate
    private boolean GetTileSolidity(int x, int y)
    {
        // coliziunea cu entitatile si cu harta
        if(refLink.GetGame().GetCurrentState().GetEntitiesMap().GetEntityOnPosition(x,y) != null)
        {
            return true;
        }
        else
        {
            return refLink.GetGame().GetCurrentState().GetMap().GetTile(x/Tile.TILE_SIZE, y/Tile.TILE_SIZE).IsSolid();
        }

    }


    // metoda care imi verifica coliziunea cu hitboxul de interactiuni(interactBounds)
    // aici se intampla majoritatea interactiunilor si se iau deciziile de actualizare al invenatrului sau a altor flaguri
    private void CheckInteractions()
    {

        // de data asta nu mai iau colturile pentru ca ar fi prea multe si nu este necesar
        // iau doar pixelii din colturile unui "+"
        Tile up = GetInteractableObjects((int)(x + interactBounds.x + interactBounds.width/2), (int)(y + interactBounds.y));
        Tile down = GetInteractableObjects((int)(x + interactBounds.x + interactBounds.width/2), (int)(y + interactBounds.y + interactBounds.height));
        Tile left = GetInteractableObjects((int)(x + interactBounds.x), (int)(y + interactBounds.y + interactBounds.height/2));
        Tile right = GetInteractableObjects((int)(x + interactBounds.x + interactBounds.width), (int)(y + interactBounds.y + interactBounds.height/2));


        // coliziunea cu marginea hartii pentru evadare
        if(x < 10*Tile.TILE_SIZE || x > (refLink.GetGame().GetCurrentState().GetMap().GetLength() - 10)*Tile.TILE_SIZE)
        {
            Evadarea.States.State.GetState().SetEscaped(true);
        }
        if(y < 10*Tile.TILE_SIZE || y > (refLink.GetGame().GetCurrentState().GetMap().GetHeight() - 10)*Tile.TILE_SIZE)
        {
            Evadarea.States.State.GetState().SetEscaped(true);
        }


        //pentru evadare cu masina
        if(up == Tile.car6 || down == Tile.car6 || left == Tile.car6 || right == Tile.car6)
        {
            Evadarea.States.State.GetState().SetEscaped(true);
        }


        //pentru evadare prin gard
        if(up == Tile.fence_o || down == Tile.fence_o || left == Tile.fence_o || right == Tile.fence_o)
        {
            // se verifica daca playerul are foarfece ca sa poata taia gardul
            if(inventory.isFoarfece())
            {
                // se verifica daca playerul este la gardul corect(nu are voie sa taie gardul din nord!)
                if ((int)(y / Character.DEFAULT_SIZE) == 22)
                {
                    // schimba dala gardului cu cea de iarba
                    refLink.GetGame().GetCurrentState().GetMap().ChangeTile((int)(x/46), 23, 17, 14);
                    inventory.resetFoarfece();
                }
                else
                {
                    System.out.println("te vede Dorel");
                }
            }

        }

        // se verifica daca playerul interactioneaza cu dulapul cu bani
        if(up == Tile.money_desk || down == Tile.money_desk || left == Tile.money_desk || right == Tile.money_desk)
        {
            inventory.SetBani();
            showBaniTip = true;
            refLink.GetGame().GetCurrentState().GetMap().ChangeTile(41, 22, 44, 46);
        }

        if(up == Tile.floor_bush || down == Tile.floor_bush || left == Tile.floor_bush || right == Tile.floor_bush)
        {
            if(inventory.isFoarfece())
            {
                System.out.println("taie tufa");
                refLink.GetGame().GetCurrentState().GetMap().ChangeTile((int)(x/46), (int)(y/46), 12, 14);
            }
        }

        if(up == Tile.cracked_wall || down == Tile.cracked_wall || left == Tile.cracked_wall || right == Tile.cracked_wall)
        {
            if(inventory.isTarnacop())
            {
                System.out.println("sparge peretele");
                if(refLink.GetGame().GetCurrentState().GetMap().getMapID() == 1)
                {
                    refLink.GetGame().GetCurrentState().GetMap().ChangeTile(39, 23, 45, 14);
                }
                else
                {
                    refLink.GetGame().GetCurrentState().GetMap().ChangeTile(57, 25, 45, 14);
                }
            }
            else if(inventory.isLingura())
            {
                System.out.println("nunu");
                inventory.resetLingura();
                showFailLingura = true;
            }
        }


        if((up == Tile.desk || down == Tile.desk || left == Tile.desk || right == Tile.desk))
        {
            System.out.println("Ai ciordit ceva");
            if(refLink.GetGame().GetCurrentState().GetMap().getMapID() == 1)
            {
                double rng = Math.random();
                GetRandomItem(rng);

                refLink.GetGame().GetCurrentState().GetMap().ChangeTile((int)(x/46), (int)(y/46), 21, 46);
            }
            else
            {
                double rng = Math.random();
                GetRandomItemSecondLevel(rng);

                refLink.GetGame().GetCurrentState().GetMap().ChangeTile((int)(x/46), (int)(y/46), 21, 46);
            }

        }

        if((up == Tile.topor_desk || down == Tile.topor_desk || left == Tile.topor_desk || right == Tile.topor_desk))
        {
            System.out.println("Ai gasit un topor!");
            inventory.SetTopor();
            showToporTip = true;
            refLink.GetGame().GetCurrentState().GetMap().ChangeTile(54,28,49,46);
        }

        if((up == Tile.treed || down == Tile.treed || left == Tile.treed || right == Tile.treed) && inventory.isTopor())
        {
            System.out.println("Ai taiat ciopacu");
            inventory.SetVasla();
            showVaslaTip = true;
            refLink.GetGame().GetCurrentState().GetMap().ChangeTile(52,36,34,14);
            refLink.GetGame().GetCurrentState().GetMap().ChangeTile(52,35,33,14);
        }

        if((up == Tile.boatl || down == Tile.boatl || left == Tile.boatl || right == Tile.boatl
            || up == Tile.boatr || down == Tile.boatr || left == Tile.boatr || right == Tile.boatr) && inventory.isVasla())
        {
            Evadarea.States.State.GetState().SetEscaped(true);
        }

    }

    // metoda care returneaza o dala de la o pozitie x si y
    // o folosesc in CheckInteractions()
    private Tile GetInteractableObjects(int x, int y)
    {
        return refLink.GetGame().GetCurrentState().GetMap().GetTile(x/Tile.TILE_SIZE, y/Tile.TILE_SIZE);

    }

    // metoda care activeaza modul de interact prin mariea hitboxului de interactiuni pana iese din hitboxul de coliziune
    private void EnlargeInteractBounds()
    {
        interactBounds.width = 50;
        interactBounds.height = 50;
        interactBounds.x = normalBounds.x - (interactBounds.width - normalBounds.width)/2;
        interactBounds.y = normalBounds.y - (interactBounds.height - normalBounds.height)/2;
    }

    // metoda de dezativare a modului interact
    private void ShrinkInteractBounds()
    {
        interactBounds.width = 3;
        interactBounds.height = 3;
        interactBounds.x = normalBounds.x + normalBounds.width/2 - interactBounds.width/2;
        interactBounds.y = normalBounds.y + normalBounds.height/2 - interactBounds.height/2;
    }

    public Inventory GetInventory()
    {
        return inventory;
    }


    // metoda care alege un item random din setul de iteme de la nivelul 1 si il pune in inventar
    // se foloseste la primul nivel cand se cauta prin dulapuri
    private void GetRandomItem(double rng)
    {
        if(rng < 0.1)
        {
            System.out.println("Ai gasit un foarfece!");
            inventory.SetFoarfece();
            showFoarfeceTip = true;

        }
        if(rng < 0.5 && rng >= 0.1)
        {
            System.out.println("Ai gasit o lingura");
            inventory.SetLingura();
            showLinguraTip = true;

        }
        if(rng >= 0.5)
        {
            System.out.println("Nu ai gasit nimic");
            showNimicTip = true;
        }
    }

    // metoda care alege un item random din setul de iteme de la nivelul 2 si il pune in inventar
    // se foloseste la al doilea nivel cand se cauta prin dulapuri
    private void GetRandomItemSecondLevel(double rng)
    {
        if(rng < 0.4)
        {
            System.out.println("Ai gasit un foarfece!");
            inventory.SetFoarfece();
            showFoarfeceTip = true;

        }
        if(rng < 0.8 && rng >= 0.4)
        {
            System.out.println("Ai gasit banet");
            inventory.SetBani();
            showBaniTip = true;

        }
        if(rng >= 0.8)
        {
            System.out.println("Nu ai gasit nimic");
            showNimicTip = true;
        }
    }

    public Rectangle GetInteractBounds()
    {
        return interactBounds;
    }

    public Rectangle GetNormalBounds()
    {
        return normalBounds;
    }

}
