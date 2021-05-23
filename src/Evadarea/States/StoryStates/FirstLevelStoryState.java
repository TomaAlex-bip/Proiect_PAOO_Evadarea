package Evadarea.States.StoryStates;

import Evadarea.Camera.HUD;
import Evadarea.Entity.Player.Gigel;
import Evadarea.Graphics.Assets;
import Evadarea.Map.EntitiesMap;
import Evadarea.Map.Map;
import Evadarea.RefLinks;
import Evadarea.States.State;

import java.awt.*;

public class FirstLevelStoryState extends State
{



    // starea de poveste de inceput
    // aici este prezentata povestea jocului
    public FirstLevelStoryState(RefLinks refLink)
    {
        super(refLink);
    }

    @Override
    public void Update()
    {
        if(refLink.GetKeyManager().next)
        {
            Evadarea.States.State.SetState(refLink.GetGame().GetFirstLevelState());
        }

    }

    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0,0,800,600);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(20, 20, 760, 560, 10, 10);


        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        g.drawString("Gigel era un talhar notoriu din orasul Craiova. Insa intr-o zi normala de lucru, adica", 100, 60);
        g.drawString("jefuit banci si magazine de bijuterii, a facut o greseala devastatoare pentru viitorul lui.", 50, 80);
        g.drawString("Acesta s-a aliat cu un hacker necunoscut pentru a-l ajuta la dezactivarea camerelor de", 100, 100);
        g.drawString("supraveghere ale bancii ce urma sa fie jefuita. Hackerul lucra pentru politia romana, dar Gigel", 50, 120);
        g.drawString("al nostru nu stia acest detaliu.", 50, 140);
        g.drawString("La inceput jaful a mers impecabil, Gigel intra in banca prin sistemul de ventilatie,", 100, 160);
        g.drawString("camerele si senzorii de miscare sunt dezactivati, nicio alarma nu porneste. Gigel intra in seif", 50, 180);
        g.drawString("si incepe sa isi umple geanta cu bani, singurii care stiau ca banca era jefuita erau doar el ", 50, 200);
        g.drawString("si hackerul, dar a fost suficient. Dupa ce talharul nostru a luat o suma impresionanta cu el,", 50, 220);
        g.drawString("odata ajuns afara, tot perimetrul bancii era impanzit de politie si jandarmi.", 50, 240);

        g.drawString("Gigel nu a avut de ales, nu era nicio cale de scapare, maretul talhar al Craiovei ", 100, 270);
        g.drawString("trece de partea celalta a gratiilor.", 50, 290);

        g.drawString("Sentinta era pe viata, asa ca lui Gigel i-a venit in minte singura metoda de a iesi", 100, 320);
        g.drawString("de la racoare, sa evadeze!", 50, 340);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        g.drawString("Ajuta-l pe Gigel sa evadeze, sunt multiple cai pentru a face acest lucru,", 80, 400);
        g.drawString("exploreaza inchisoarea si cauta goluri in securitate!", 50, 430);


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
