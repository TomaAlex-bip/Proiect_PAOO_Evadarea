package Evadarea.States.StoryStates;

import Evadarea.Camera.HUD;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;

import java.awt.*;

public class FinalStoryState extends State
{

    // starea de poveste finala
    // aici se afiseaza scorul de la nivelul 2 si este scrisa povestea finala a jocului
    public FinalStoryState(RefLinks refLink)
    {
        super(refLink);
    }

    @Override
    public void Update()
    {
        if(refLink.GetKeyManager().next)
        {
            Evadarea.States.State.SetState(refLink.GetGame().GetMainMenuState());
        }
    }

    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0,0,800,600);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(20, 20, 760, 560, 10, 10);

        g.setColor(Color.yellow);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 22));

        int score = refLink.GetGame().GetSecondLevelState().GetScore();
        g.drawString("Timp pentru evadare: " + score, 100, 60);

        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawString("Dupa kilometri buni de vaslit, Gigel ajunge in sfarsit la mal, iar de aici la libertatea", 100, 100);
        g.drawString("mult ravnita de maestrul talhar, dar si un bun evadator dupa cum s-a observat pana acum.", 50, 100+25);


        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        g.drawString("Gigel este in sfarsit liber, poate de data asta o sa fie mai cuminte.", 80, 200);
        g.drawString("Felicitari!", 80, 230);

        g.setColor(Color.orange);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        g.drawString("Multumesc ca ai jucat.", 270, 400);

        g.drawImage(Assets.player_head, 400 - (30*5)/2, 250, 30*5, 23*5, null);

        g.drawImage(Assets.continue_button, 400 - Assets.continue_button.getWidth()/2, 480, null);
        g.drawImage(Assets.Space, 400-15, 480+40, null);


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
