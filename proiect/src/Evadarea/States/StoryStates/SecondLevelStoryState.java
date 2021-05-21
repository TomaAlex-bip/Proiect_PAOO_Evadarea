package Evadarea.States.StoryStates;

import Evadarea.Camera.HUD;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;

import java.awt.*;

public class SecondLevelStoryState extends State
{

    // starea de poveste de inainte de nivelul 2
    // aici este continuarea primei povesti
    // tot aici este afisat scorul de primul nivel
    public SecondLevelStoryState(RefLinks refLink)
    {
        super(refLink);
    }

    @Override
    public void Update()
    {
        if(refLink.GetKeyManager().next)
        {
            refLink.GetGame().GetSecondLevelState().ResetState();
            refLink.GetGame().GetSecondLevelState().GetHud().ResetTimer();
            Evadarea.States.State.SetState(refLink.GetGame().GetSecondLevelState());
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
        g.drawString("Felicitari! Gigel este liber.", 100, 60);

        int score = refLink.GetGame().GetFirstLevelState().GetScore();
        g.drawString("Timp pentru evadare: " + score, 100, 100);

        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        g.drawString("Singura problema este ca acum nu mai are niciun ban, asa ca talharul nostru revine", 100, 120+25);
        g.drawString("la vechea lui meserie, jefuitul de banci si magazine de bijuterii.", 50, 120+25+25);

        g.drawString("Insa lucrurile s-au schimbat de cand talharul a intrat la rece, politistii sunt mai bine", 100, 120+25+25+30);
        g.drawString("pregatiti, iar tehnicile vechi nu mai functioneaza.", 50, 120+25+25+30+25);

        g.drawString("Nu a durat mult pana sa intre iar la rece talharul, iar de data asta politstii nu au mai", 100, 120+25+25+30+25+30);
        g.drawString("fost la fel de prietenosi ca prima data", 50, 120+25+25+30+25+30+25);


        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        g.drawString("Ajuta-l pe Gigel sa evadeze, din nou!", 80, 400);



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
