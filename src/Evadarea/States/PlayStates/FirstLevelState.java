package Evadarea.States.PlayStates;

import Evadarea.Camera.Camera;
import Evadarea.Camera.HUD;
import Evadarea.Entity.*;
import Evadarea.Entity.Character;
import Evadarea.Entity.Guards.Dorel;
import Evadarea.Entity.Guards.Garcea;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Entity.Prisoners.Prizonier1;
import Evadarea.Entity.Prisoners.Prizonier2;
import Evadarea.Entity.Prisoners.Prizonier4;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;

import java.awt.*;

public class FirstLevelState extends State
{

    private Camera camera;

    private Map map;

    private Gigel player;

    private Dorel guard1;
    private Garcea garcea;

    private Prizonier4 prizonier4;
    private Prizonier2 prizonier2;
    private Prizonier1 prizonier1;

    private EntitiesMap entitiesMap;

    private HUD hud;

    private boolean firstTip;

    private int score;


    // starea de joc a primului nivel, aici avem harta unica, player unic, entitati unice
    public FirstLevelState(RefLinks refLink)
    {
        super(refLink);

        camera = Camera.getInstance();

        map = refLink.GetFactoryMap().getMap(1);
//        map.AfisareMatriceHarta();

        player = new Gigel(refLink, (29 + 10) * Character.DEFAULT_SIZE, (11 + 10) * Character.DEFAULT_SIZE);

        guard1 = new Dorel(refLink, (22 + 10) * Character.DEFAULT_SIZE, (2 + 10) * Character.DEFAULT_SIZE-30, 24, 32, false);

        garcea = new Garcea(refLink, (11 + 10) * Character.DEFAULT_SIZE, (4 + 10) * Character.DEFAULT_SIZE);

        prizonier4 = new Prizonier4(refLink, (6 + 10) * Character.DEFAULT_SIZE, (8 + 10) * Character.DEFAULT_SIZE, true);
        prizonier2 = new Prizonier2(refLink, (13 + 10) * Character.DEFAULT_SIZE, (16 + 10) * Character.DEFAULT_SIZE, false);
        prizonier1 = new Prizonier1(refLink, (24 + 10) * Character.DEFAULT_SIZE, (4 + 10) * Character.DEFAULT_SIZE, true);

        entitiesMap = new EntitiesMap(refLink, new Entity[]{garcea, guard1, prizonier4, prizonier2, prizonier1}, 1);
        refLink.SetEntitiesMap(entitiesMap);

        hud = new HUD(refLink);

        firstTip = true;


    }

    @Override
    public void Update()
    {

        CheckCompleteLevel();

        map.Update();
        player.Update();

        camera.Update(player);

        entitiesMap.Update();

        if(refLink.GetKeyManager().escape)
        {
            Evadarea.States.State.SetState(refLink.GetGame().GetPauseState());
        }

        hud.Update();


        if(firstTip)
        {
            firstTip = false;
            hud.SetTutorial();
        }

        if(player.showBaniTip)
        {
            hud.SetBaniTip();
            player.showBaniTip = false;
        }

        if(prizonier4.showTarnacopTip)
        {
            hud.SetTarnacopTip();
            prizonier4.showTarnacopTip = false;
        }

        if(player.showFoarfeceTip)
        {
            hud.SetFoarfeceTip();
            player.showFoarfeceTip = false;
        }

        if(player.showLinguraTip)
        {
            hud.SetLinguraTip();
            player.showLinguraTip = false;
        }

        if(player.showNimicTip)
        {
            hud.SetNimicTip();
            player.showNimicTip = false;
        }

        if(player.showFailLingura)
        {
            hud.SetFailLingura();
            player.showFailLingura = false;
        }


    }

    // aici se randeaza harta, playerul, entitatile si hud-ul aferente nivelului
    @Override
    public void Draw(Graphics g)
    {

        map.Draw(g);

        entitiesMap.Draw(g);

        player.Draw(g);

        hud.Draw(g);
    }

    public Map GetMap()
    {
        return map;
    }

    public EntitiesMap GetEntitiesMap()
    {
        return entitiesMap;
    }

    public boolean GetEscaped()
    {
        return escaped1;
    }

    public void SetEscaped(boolean escaped)
    {
        if(escaped)
        {
            refLink.GetGame().GetDataBase().Update(1, "escaped1", 1);
        }
        escaped1 = escaped;
    }

    // se verifica daca nivelul a fost completat pentru a se trece la urmatorul
    private void CheckCompleteLevel()
    {
        if(escaped1)
        {
            score = hud.GetTime();
            ResetState();
            Evadarea.States.State.SetState(refLink.GetGame().GetSecondLevelStoryState());
            hud.ResetTimer();
        }
    }

    public Gigel GetPlayer()
    {
        return player;
    }

    public int GetScore()
    {
        return score;
    }

    @Override
    public void SaveInDataBase()
    {
        refLink.GetGame().GetDataBase().Update(1, "PlayerX", player.GetX());
        refLink.GetGame().GetDataBase().Update(1, "PlayerY", player.GetY());
        refLink.GetGame().GetDataBase().Update(1, "score", hud.GetTime());



        if(player.GetInventory().isFoarfece())
        {
            refLink.GetGame().GetDataBase().Update(1,"foarfece", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(1,"foarfece", 0);
        }

        if(player.GetInventory().isBani())
        {
            refLink.GetGame().GetDataBase().Update(1,"bani", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(1,"bani", 0);
        }

        if(player.GetInventory().isTarnacop())
        {
            refLink.GetGame().GetDataBase().Update(1,"tarnacop", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(1,"tarnacop", 0);
        }

        if(player.GetInventory().isLingura())
        {
            refLink.GetGame().GetDataBase().Update(1,"lingura", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(1,"lingura", 0);
        }

        if(prizonier4.GetHasTarnacop())
        {
            refLink.GetGame().GetDataBase().Update(1,"hasTarnacop", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(1,"hasTarnacop", 0);
        }

        if(escaped1)
        {
            refLink.GetGame().GetDataBase().Update(1, "escaped1", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(1, "escaped1", 0);
        }

        map.SaveMapInDataBase();


    }

    public void LoadDataBase()
    {
        float x = refLink.GetGame().GetDataBase().SelectFloat(1, "PlayerX");
        float y = refLink.GetGame().GetDataBase().SelectFloat(1, "PlayerY");

        player.SetPosition(x, y);

        hud.SetTimer(refLink.GetGame().GetDataBase().SelectInt(1, "score"));

        prizonier4.SetHasTarnacop(refLink.GetGame().GetDataBase().SelectInt(1, "hasTarnacop") == 1);

        player.GetInventory().SetInventory(
                refLink.GetGame().GetDataBase().SelectInt(1, "foarfece") == 1,
                refLink.GetGame().GetDataBase().SelectInt(1, "bani") == 1,
                refLink.GetGame().GetDataBase().SelectInt(1, "tarnacop") == 1,
                false,
                false,
                refLink.GetGame().GetDataBase().SelectInt(1, "lingura") == 1
                );


        //TO DO:
        //LoadMapFromDataBase

        map.LoadMapFromDataBase();

    }

    @Override
    public HUD GetHud()
    {
        return hud;
    }


    // resetare nivel
    public void ResetState()
    {
        System.out.println("State Reset 1");
        player.SetPosition((29 + 10) * Character.DEFAULT_SIZE, (11 + 10) * Character.DEFAULT_SIZE);
        guard1.SetPosition((22 + 10) * Character.DEFAULT_SIZE, (2 + 10) * Character.DEFAULT_SIZE-30);
        garcea.SetPosition((11 + 10) * Character.DEFAULT_SIZE, (4 + 10) * Character.DEFAULT_SIZE);

        player.GetInventory().Reset();

        prizonier4.Reset();

        map.ResetMap();

        player.showBaniTip = false;

        firstTip = true;

        hud.ResetAll();

    }

}
