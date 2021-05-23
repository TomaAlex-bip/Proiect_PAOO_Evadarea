package Evadarea;

import Evadarea.Camera.Camera;
import Evadarea.Graphics.Assets;
import Evadarea.Managers.DataBase.DataBase;
import Evadarea.Managers.Input.KeyManager;
import Evadarea.Managers.Audio.AudioManager;
import Evadarea.States.*;
import Evadarea.States.MenuStates.MainMenuState;
import Evadarea.States.MenuStates.PauseState;
import Evadarea.States.PlayStates.FirstLevelState;
import Evadarea.States.PlayStates.SecondLevelState;
import Evadarea.States.StoryStates.FinalStoryState;
import Evadarea.States.StoryStates.FirstLevelStoryState;
import Evadarea.States.StoryStates.SecondLevelStoryState;
import Evadarea.Tiles.Tile;
import Evadarea.Window.Window;

import java.lang.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{

    private final boolean RESET_BD = false;

    private Window window;
    private boolean runState;
    private Thread gameThread;
    private BufferStrategy bs;

    private Graphics g;

    private State currentState;

    private State firstLevelState;
    private State firstLevelStoryState;
    private State secondLevelState;
    private State secondLevelStoryState;
    private State finalStoryState;
    private State mainMenuState;
    private State pauseState;

    private KeyManager keyManager;

    private RefLinks refLink;

    private Camera camera;

    private AudioManager audioManager;

    private DataBase dataBase;

    public boolean sound;


    private static Game instance = new Game("Evadarea", 800, 600);

    // singleton
    public static Game getInstance()
    {
        return instance;
    }


    // "inima" jocului
    // aici sunt apelate si folosite toate clasele si metodele
    private Game(String title, int Xres, int Yres)
    {
        window = new Window(title, Xres, Yres);

        runState = false;

        keyManager = KeyManager.getInstance();

        camera = Camera.getInstance();

        audioManager = AudioManager.getInstance();

        dataBase = DataBase.getInstance();

//        sound = true;

    }

    private void CreateDB()
    {
        // pentru resetare baza de date
        dataBase.Create();
        dataBase.Insert();
        dataBase.CreateSettings();
        dataBase.CreateMaps(55, 71);


        for(int i=0; i<19+20; i++)
        {
            dataBase.InsertMap(1, i);
        }

        for(int i=0; i<31+20; i++)
        {
            dataBase.InsertMap(2, i);
        }
    }

    public void InitGame()
    {

        if(RESET_BD)
        {
            CreateDB();
        }


        camera.SetUpCamera(this);

        window.CreateWindow();

        window.GetFrame().addKeyListener(keyManager);


        Assets.Init();

        refLink = new RefLinks(this);

        mainMenuState = new MainMenuState(refLink);
        currentState = mainMenuState;

        firstLevelState = new FirstLevelState(refLink);
        secondLevelState = new SecondLevelState(refLink);

        firstLevelStoryState = new FirstLevelStoryState(refLink);
        secondLevelStoryState = new SecondLevelStoryState(refLink);
        finalStoryState = new FinalStoryState(refLink);

        pauseState = new PauseState(refLink);

        sound = dataBase.SelectSettings() == 1;

//        refLink.GetMap().AfisareMatriceHarta();

        Evadarea.States.State.SetState(mainMenuState);

    }

    private void PlayMusic()
    {
        if(sound)
        {
            audioManager.PlayMusic();
        }
        else
        {
            audioManager.StopMusic();
        }
    }

    public void run()
    {
        InitGame();
        long oldTime = System.nanoTime();
        long currentTime;

        final float FPS = 60;
        final double timeFrame = 1000000000/FPS;

        while(runState)
        {
            currentTime = System.nanoTime();

            if((currentTime - oldTime) > timeFrame)
            {

                Update();

                Draw();

                oldTime = currentTime;

            }
        }


    }

    public synchronized void StartGame()
    {
        if(!runState)
        {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState)
        {
            runState = false;

            try
            {
                gameThread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }

    private void Update()
    {
        PlayMusic();

        keyManager.Update();

        if(Evadarea.States.State.GetState() != null)
        {
            currentState = Evadarea.States.State.GetState();
            Evadarea.States.State.GetState().Update();
        }

        //System.out.println(this.GetCurrentState().GetEscaped());
    }

    private void Draw()
    {
        bs = window.GetCanvas().getBufferStrategy();

        if(bs == null)
        {
            try
            {
                window.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        g = bs.getDrawGraphics();

        g.clearRect(0,0,window.GetWindowLength(), window.GetWindowHeight());

        if(Evadarea.States.State.GetState() != null)
        {
            State.GetState().Draw(g);
        }

        bs.show();

        g.dispose();

    }


    public int GetLength()
    {
        return window.GetWindowLength();
    }

    public int GetHeight()
    {
        return window.GetWindowHeight();
    }

    public KeyManager GetKeyManager()
    {
        return keyManager;
    }

    public Camera GetCamera() { return camera; }

    public State GetCurrentState()
    {
        return currentState;
    }

    public State GetFirstLevelState()
    {
        return firstLevelState;
    }

    public State GetSecondLevelState()
    {
        return secondLevelState;
    }

    public State GetFirstLevelStoryState()
    {
        return firstLevelStoryState;
    }

    public State GetSecondLevelStoryState()
    {
        return secondLevelStoryState;
    }

    public State GetFinalStoryState()
    {
        return finalStoryState;
    }

    public State GetMainMenuState()
    {
        return mainMenuState;
    }

    public State GetPauseState()
    {
        return pauseState;
    }

    public DataBase GetDataBase()
    {
        return dataBase;
    }


    public AudioManager GetAudioManager()
    {
        return audioManager;
    }
}
