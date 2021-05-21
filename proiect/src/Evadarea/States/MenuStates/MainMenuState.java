package Evadarea.States.MenuStates;

import Evadarea.Camera.HUD;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenuState extends State
{

    private BufferedImage newGameButton;
    private BufferedImage continueButton;
    private BufferedImage soundOnButton;
    private BufferedImage soundOffButton;

    private BufferedImage N;
    private BufferedImage C;
    private BufferedImage P;
    private BufferedImage M;

    private BufferedImage menuBackground;

    // Starea jocului pentru meniul principal
    // de aici se incepe un joc nou, se continua un joc care se incarca din baza de date, se opreste muzica sau se porneste
    public MainMenuState(RefLinks refLink)
    {
        super(refLink);

        newGameButton = Assets.new_game_button;
        continueButton = Assets.continue_button;
        soundOnButton = Assets.sound_on_button;
        soundOffButton = Assets.sound_off_button;
        menuBackground = Assets.menuBackground;

        N = Assets.N;
        C = Assets.C;
        P = Assets.P;
        M = Assets.M;

    }

    @Override
    public void Update()
    {


        escaped1 = false;
        escaped2 = false;


        //asta pentru new game
        if(refLink.GetKeyManager().new_game)
        {
            refLink.GetGame().GetFirstLevelState().ResetState();
            refLink.GetGame().GetSecondLevelState().ResetState();
            Evadarea.States.State.SetState(refLink.GetGame().GetFirstLevelStoryState());


        }

        //asta pentru continue
        if(refLink.GetKeyManager().continue_game)
        {
            LoadDataBase();
        }


        if(refLink.GetKeyManager().sound_on)
        {
            refLink.GetGame().sound = true;
        }

        if(refLink.GetKeyManager().sound_off)
        {
            refLink.GetGame().sound = false;
        }



    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(menuBackground, 0,0, null);

        g.drawImage(newGameButton, 243,32, null);
        g.drawImage(N, 243+newGameButton.getWidth()/2 - 15, 32+35, null);

        g.drawImage(continueButton, 414,32, null);
        g.drawImage(C, 414+continueButton.getWidth()/2 - 15, 32+35, null);

        g.drawImage(soundOffButton, 683,25, null);
        g.drawImage(M, 683+soundOffButton.getWidth()/2 - 15, 25+45, null);

        g.drawImage(soundOnButton, 52,25, null);
        g.drawImage(P, 52+soundOnButton.getWidth()/2 - 15, 25+45, null);


    }

    public void LoadDataBase()
    {
        System.out.println("Incarcam din baza de date!");

        if(refLink.GetGame().GetDataBase().SelectInt(1, "escaped1") == 0)
        {

            if(refLink.GetGame().GetDataBase().SelectFloat(1, "PlayerX") == 0
                && refLink.GetGame().GetDataBase().SelectFloat(1, "PlayerY") == 0)
            {
                System.out.println("Nu ai un joc salvat!");
            }
            else
            {
//                System.out.println("Reset State 1 din meniu");
                refLink.GetGame().GetFirstLevelState().ResetState();
                refLink.GetGame().GetFirstLevelState().LoadDataBase();
                Evadarea.States.State.SetState(refLink.GetGame().GetFirstLevelState());
            }
        }
        else if(refLink.GetGame().GetDataBase().SelectInt(2, "escaped2") == 0)
        {
//            System.out.println("Reset State 2 din meniu");
            refLink.GetGame().GetSecondLevelState().ResetState();
            refLink.GetGame().GetSecondLevelState().LoadDataBase();
            Evadarea.States.State.SetState(refLink.GetGame().GetSecondLevelState());
        }
        else
        {
            System.out.println("Jocul e terminat, trebuie sa incepi un joc nou!");
        }



    }

    @Override
    public HUD GetHud()
    {
        return null;
    }

    public Map GetMap()
    {
        return null;
    }

    public EntitiesMap GetEntitiesMap()
    {
        return null;
    }




    @Override
    public boolean GetEscaped() {
        return false;
    }

    @Override
    public void SetEscaped(boolean escaped) {

    }

    public Gigel GetPlayer()
    {
        return null;
    }

    @Override
    public void ResetState() {

    }

    @Override
    public int GetScore()
    {
        return 0;
    }

    @Override
    public void SaveInDataBase()
    {

    }
}
