package Evadarea.States.MenuStates;

import Evadarea.Camera.HUD;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;
import Evadarea.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PauseState extends State
{

    private BufferedImage continueButton;
    private BufferedImage soundOnButton;
    private BufferedImage soundOffButton;
    private BufferedImage saveButton;
    private BufferedImage mainMenuButton;

    private BufferedImage[][] background;

    // starea de pauza a jocului, se acceseaza apasand escape in timp ce jucatorul se alfa intr-un nivel
    // de aici se pune pauza, se poate reveni la joc, se poate salva progresul in baza de date, se poate reveni la meniul principal, se poate porni sau opri muzica
    public PauseState(RefLinks refLink)
    {
        super(refLink);
        continueButton = Assets.continue_button;
        soundOffButton = Assets.sound_off_button;
        soundOnButton = Assets.sound_on_button;
        saveButton = Assets.save_game_button;
        mainMenuButton = Assets.main_menu_button;

        GenerateBackground();
    }

    @Override
    public void Update()
    {
        if(refLink.GetKeyManager().continue_game)
        {
            Evadarea.States.State.SetState(GetPreviousState());
        }

        if(refLink.GetKeyManager().quit)
        {
            Evadarea.States.State.SetState(refLink.GetGame().GetMainMenuState());
        }

        if(refLink.GetKeyManager().save)
        {
            System.out.println("Salvam in baza de date!");
            DataBaseSave();
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
        for(int y=0; y<600/46+1; y++)
        {
            for(int x=0; x<800/46+1; x++)
            {
                g.drawImage(background[x][y], x* Tile.TILE_SIZE, y * Tile.TILE_SIZE, null);
            }
        }

        g.setColor(Color.black);
        g.fillRoundRect(225-5, 100-5, 350+10, 400+10, 10, 10);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(225, 100, 350, 400, 10, 10);

        g.drawImage(continueButton, 400 - continueButton.getWidth()/2, 140, null);
        g.drawImage(Assets.C, 400-15, 140+35, null);

        g.drawImage(saveButton, 400 - saveButton.getWidth()/2, 140+80, null);
        g.drawImage(Assets.S, 400-15, 140+80+35, null);

        g.drawImage(mainMenuButton, 400 - mainMenuButton.getWidth()/2, 140 + 2*80, null);
        g.drawImage(Assets.Q, 400-15, 140+80*2+35, null);

        g.drawImage(soundOnButton, 300, 400, null);
        g.drawImage(Assets.P, 300+15, 400+45, null);

        g.drawImage(soundOffButton, 500 - soundOffButton.getWidth(), 400, null);
        g.drawImage(Assets.M, 500-soundOffButton.getWidth()+15, 400+45, null);

    }

    private BufferedImage RandomTileGenerator()
    {
        double rng = Math.random();

        if(rng < 0.1)
        {
            return Assets.floor_flowers;
        }
        if(rng < 0.3)
        {
            return Assets.floor_bush;
        }
        return Assets.floor_grass;
    }

    private void GenerateBackground()
    {
        background = new BufferedImage[800/46+2][600/46+2];
        for(int y=0; y<600/46+1; y++)
        {
            for(int x=0; x<800/46+1; x++)
            {
                background[x][y] = RandomTileGenerator();
            }
        }
    }

    private void DataBaseSave()
    {
        if(refLink.GetGame().sound)
        {
            refLink.GetGame().GetDataBase().UpdateSettings(1);
        }
        else
        {
            refLink.GetGame().GetDataBase().UpdateSettings(0);
        }
        Evadarea.States.State.GetPreviousState().SaveInDataBase();
    }

    @Override
    public Map GetMap() {
        return null;
    }

    @Override
    public EntitiesMap GetEntitiesMap() {
        return null;
    }

    @Override
    public boolean GetEscaped() {
        return false;
    }

    @Override
    public void SetEscaped(boolean escaped) {

    }

    @Override
    public Gigel GetPlayer() {
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

    @Override
    public void LoadDataBase()
    {

    }

    @Override
    public HUD GetHud()
    {
        return null;
    }
}
