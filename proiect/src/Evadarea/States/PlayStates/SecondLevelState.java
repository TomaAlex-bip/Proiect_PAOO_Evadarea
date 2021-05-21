package Evadarea.States.PlayStates;

import Evadarea.Camera.Camera;
import Evadarea.Camera.HUD;
import Evadarea.Entity.*;
import Evadarea.Entity.Character;
import Evadarea.Entity.Guards.Dorel;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Entity.Prisoners.Prizonier4;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;

import java.awt.*;

public class SecondLevelState extends State
{

    private Camera camera;

    private Map map;

    private Gigel player;

    private Dorel guard1;
    private Dorel guard2;
    private Dorel guard3;
    private Dorel guard4;
    private Dorel guard5;

    private Prizonier4 prizonier4;

    private EntitiesMap entitiesMap;

    private HUD hud;

    private int score;


    // starea de joc a celui de-al doilea nivel
    public SecondLevelState(RefLinks refLink)
    {
        super(refLink);

        camera = Camera.getInstance();

        map = refLink.GetFactoryMap().getMap(2);
//        map.AfisareMatriceHarta();

        player = new Gigel(refLink, (33 + 10) * Character.DEFAULT_SIZE, (13 + 10) * Character.DEFAULT_SIZE);

        // ala de sus din tunelul lung
        guard1 = new Dorel(refLink, (29 + 10) * Character.DEFAULT_SIZE, (10 + 10) * Character.DEFAULT_SIZE - 20, 29+10,44+10, true);

        // ala de la gard de sta pe loc
        guard2 = new Dorel(refLink, (48 + 10) * Character.DEFAULT_SIZE, (26 + 10) * Character.DEFAULT_SIZE,0,0, false);

        // ala din camera mare din labirint
        guard3 = new Dorel(refLink, (12 + 10) * Character.DEFAULT_SIZE, (16 + 10) * Character.DEFAULT_SIZE,3+10,12+10, true);

        // ala de nu pazeste nimic jos, e doar de intimidare
        guard4 = new Dorel(refLink, (14 + 10) * Character.DEFAULT_SIZE, (18 + 10) * Character.DEFAULT_SIZE,14+10,21+10, true);

        // ala de sus din tunelul scurt
        guard5 = new Dorel(refLink, (12 + 10) * Character.DEFAULT_SIZE, (4 + 10) * Character.DEFAULT_SIZE,12+10,19+10, true);

        prizonier4 = new Prizonier4(refLink, (28 + 10) * Character.DEFAULT_SIZE, (14 + 10) * Character.DEFAULT_SIZE, true);

        entitiesMap = new EntitiesMap(refLink, new Entity[]{guard1, guard2, guard3, guard4, guard5, prizonier4},2);
        refLink.SetEntitiesMap(entitiesMap);

        hud = new HUD(refLink);


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


        if(player.showFoarfeceTip)
        {
            hud.SetFoarfeceTip();
            player.showFoarfeceTip = false;
        }

        if(player.showBaniTip)
        {
            hud.SetBaniTip();
            player.showBaniTip = false;
        }

        if(player.showNimicTip)
        {
            hud.SetNimicTip();
            player.showNimicTip = false;
        }

        if(prizonier4.showTarnacopTip)
        {
            hud.SetTarnacopTip();
            prizonier4.showTarnacopTip = false;
        }

        if(player.showToporTip)
        {
            hud.SetToporTip();
            player.showToporTip = false;
        }

        if(player.showVaslaTip)
        {
            hud.SetVaslaTip();
            player.showVaslaTip = false;
        }

    }

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
        return escaped2;
    }

    public void SetEscaped(boolean escaped)
    {
        if(escaped)
        {
            refLink.GetGame().GetDataBase().Update(2, "escaped2", 1);
        }
        escaped2 = escaped;
    }

    private void CheckCompleteLevel()
    {
        if(escaped2)
        {
            score = hud.GetTime();
            ResetState();
            Evadarea.States.State.SetState(refLink.GetGame().GetFinalStoryState());
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
        refLink.GetGame().GetDataBase().Update(2, "PlayerX", player.GetX());
        refLink.GetGame().GetDataBase().Update(2, "PlayerY", player.GetY());
        refLink.GetGame().GetDataBase().Update(2, "score", hud.GetTime());



        if(player.GetInventory().isFoarfece())
        {
            refLink.GetGame().GetDataBase().Update(2,"foarfece", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(2,"foarfece", 0);
        }

        if(player.GetInventory().isBani())
        {
            refLink.GetGame().GetDataBase().Update(2,"bani", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(2,"bani", 0);
        }

        if(player.GetInventory().isTarnacop())
        {
            refLink.GetGame().GetDataBase().Update(2,"tarnacop", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(2,"tarnacop", 0);
        }

        if(player.GetInventory().isTopor())
        {
            refLink.GetGame().GetDataBase().Update(2,"topor", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(2,"topor", 0);
        }

        if(player.GetInventory().isVasla())
        {
            refLink.GetGame().GetDataBase().Update(2,"vasla", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(2,"vasla", 0);
        }

        if(prizonier4.GetHasTarnacop())
        {
            refLink.GetGame().GetDataBase().Update(2,"hasTarnacop", 1);
        }
        else
        {
            refLink.GetGame().GetDataBase().Update(2,"hasTarnacop", 0);
        }

        map.SaveMapInDataBase();
    }

    @Override
    public void LoadDataBase()
    {
        float x = refLink.GetGame().GetDataBase().SelectFloat(2, "PlayerX");
        float y = refLink.GetGame().GetDataBase().SelectFloat(2, "PlayerY");

        player.SetPosition(x, y);

        hud.SetTimer(refLink.GetGame().GetDataBase().SelectInt(2, "score"));

        prizonier4.SetHasTarnacop(refLink.GetGame().GetDataBase().SelectInt(2, "hasTarnacop") == 1);

        player.GetInventory().SetInventory(
                refLink.GetGame().GetDataBase().SelectInt(2, "foarfece") == 1,
                refLink.GetGame().GetDataBase().SelectInt(2, "bani") == 1,
                refLink.GetGame().GetDataBase().SelectInt(2, "tarnacop") == 1,
                refLink.GetGame().GetDataBase().SelectInt(2, "topor") == 1,
                refLink.GetGame().GetDataBase().SelectInt(2, "vasla") == 1,
                false
        );


        map.LoadMapFromDataBase();

    }

    @Override
    public void ResetState()
    {
        System.out.println("State Reset 2");

        player.SetPosition((33 + 10) * Character.DEFAULT_SIZE, (13 + 10) * Character.DEFAULT_SIZE);

        guard1.SetPosition((29 + 10) * Character.DEFAULT_SIZE, (10 + 10) * Character.DEFAULT_SIZE - 20);

        guard2.SetPosition((48 + 10) * Character.DEFAULT_SIZE, (26 + 10) * Character.DEFAULT_SIZE);

        guard3.SetPosition((12 + 10) * Character.DEFAULT_SIZE, (16 + 10) * Character.DEFAULT_SIZE);

        guard4.SetPosition((14 + 10) * Character.DEFAULT_SIZE, (18 + 10) * Character.DEFAULT_SIZE);

        guard5.SetPosition((12 + 10) * Character.DEFAULT_SIZE, (4 + 10) * Character.DEFAULT_SIZE);


        player.GetInventory().Reset();

        prizonier4.Reset();

        map.ResetMap();

        hud.ResetAll();

        hud.SetCaughtText();
    }

    public HUD GetHud()
    {
        return hud;
    }


}
