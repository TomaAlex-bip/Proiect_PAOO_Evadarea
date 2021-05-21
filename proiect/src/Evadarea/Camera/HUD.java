package Evadarea.Camera;

import Evadarea.Graphics.Assets;
import Evadarea.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HUD
{
    private RefLinks refLink;

    private boolean baniTip;
    private boolean foarfeceTip;
    private boolean tarnacopTip;
    private boolean linguraTip;
    private boolean nimicTip;
    private boolean toporTip;
    private boolean vaslaTip;

    private boolean failLingura;

    private boolean caughtText;

    private boolean tutorial;

    private float timer;


    // Heads up display
    // este ce se vede pe ecran in plus fata de harta, player si entitati
    // in cazul meu sunt niste "ferestre" separate care contin informatii utile
    public HUD(RefLinks refLink)
    {

        this.refLink = refLink;

    }


    public void Update()
    {
        TimerUpdate();

        if(refLink.GetKeyManager().continue_game)
        {
            baniTip = false;
            foarfeceTip = false;
            tarnacopTip = false;
            linguraTip = false;
            nimicTip = false;
            toporTip = false;
            vaslaTip = false;
            failLingura = false;
            caughtText = false;
            tutorial = false;
        }
//        System.out.println(baniTip);
    }

    private void TimerUpdate()
    {
        timer += 1;
    }

    public void Draw(Graphics g)
    {

        DrawTimer(g);

        if(baniTip)
        {
            if(refLink.GetGame().GetCurrentState().GetMap().getMapID() == 1)
            {
                DrawBaniTip(g);
            }
            else
            {
                DrawBaniTip2(g);
            }
        }

        if(foarfeceTip)
        {
            if(refLink.GetGame().GetCurrentState().GetMap().getMapID() == 1)
            {
                DrawFoarfeceTip(g);
            }
            else
            {
                DrawFoarfeceTip2(g);
            }
        }

        if(tarnacopTip)
        {
            if(refLink.GetGame().GetCurrentState().GetMap().getMapID() == 1)
            {
                DrawTarnacopTip(g);
            }
            else
            {
                DrawTarnacopTip2(g);
            }
        }

        if(linguraTip)
        {
            DrawLinguraTip(g);
        }

        if(nimicTip)
        {
            if(refLink.GetGame().GetCurrentState().GetMap().getMapID() == 1)
            {
                DrawNimicTip(g);
            }
            else
            {
                DrawNimicTip2(g);
            }
        }

        if(failLingura)
        {
            DrawFailLingura(g);
        }

        if(caughtText)
        {
            DrawCaughtText(g);
        }

        if(toporTip)
        {
            DrawToporTip(g);
        }

        if(vaslaTip)
        {
            DrawVaslaTip(g);
        }

        if(tutorial)
        {
            DrawTutorial1(g);
        }

    }

    private void DrawTimer(Graphics g)
    {
        g.fillRoundRect(10, 10, 120, 35, 7, 7);

        g.setColor(Color.green);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        g.drawString("TIME: " + (int)(timer/60),15, 35);
    }

    private void DrawTutorial1(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 700, 500, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 700-10, 500-10, 10, 10);

        g.drawImage(Assets.continue_button, 400 - Assets.continue_button.getWidth()/2, 470, null);
        g.drawImage(Assets.C, 400 - Assets.C.getWidth()/2, 470 + 35, null);

        g.setColor(Color.white);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Foloseste W, A, S, D pentru a te misca in directia dorita.", 140, 80);
        g.drawString("Iar tasta E este pentru a interactiona cu diverse obiecte si NPC-uri.", 130, 80+25);

        g.drawString("Poti sa interactionezi cu diverse obiecte de pe harta.", 70, 80+25+25+25);
        g.drawImage(Assets.desk, 80, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.fence_o, 80+70, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.cracked_wall, 80+70+70, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.floor_bush, 80+70+70+70, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.boatl, 80+70+70+70+70, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.boatr, 80+70+70+70+70+46, 80+25+25+25+25, 46, 46, null);

        g.drawImage(Assets.car1, 80+70+70+70+70+70+46, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.car2, 80+70+70+70+70+70+46+46, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.car3, 80+70+70+70+70+70+46+46+46, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.car4, 80+70+70+70+70+70+46+46+46+46, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.car5, 80+70+70+70+70+70+46, 80+25+25+25+25+46, 46, 46, null);
        g.drawImage(Assets.car6, 80+70+70+70+70+70+46+46, 80+25+25+25+25+46, 46, 46, null);
        g.drawImage(Assets.car7, 80+70+70+70+70+70+46+46+46, 80+25+25+25+25+46, 46, 46, null);
        g.drawImage(Assets.car8, 80+70+70+70+70+70+46+46+46+46, 80+25+25+25+25+46, 46, 46, null);

        g.drawImage(Assets.treeu, 80+70+70+70+70+70+46+46+46+46+70, 80+25+25+25+25, 46, 46, null);
        g.drawImage(Assets.treed, 80+70+70+70+70+70+46+46+46+46+70, 80+25+25+25+25+46, 46, 46, null);




        g.drawString("Poti sa interactionezi si cu unele NPC-uri.", 70, 260);
        g.drawImage(Assets.prizonier4_r, 100, 270, 46, 46, null);

        g.drawString("Urmareste garzile, unele se misca constant, iar unele stau intr-un singur loc, sau poate", 70, 350);
        g.drawString("mai iau cate o pauza din cand in cand. Totodata ai grija ca nu fii vazut de ei cand esti ", 70, 375);
        g.drawString("prin zone \"interesante\". ", 70, 400);
        g.drawImage(Assets.garcea_r, 100, 410, 46, 46, null);
        g.drawImage(Assets.guard2_r, 200, 410, 46, 46, null);
    }

    private void DrawBaniTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.green);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Huh? se pare ca sunt norocos azi, vechiul prizonier", 140, 80);
        g.drawString("a lasat cativa dolari aici, poate reusesc sa fac", 130, 80+25);
        g.drawString("ceva cu ei, din cate am auzit este un prizonier care lucreaza ", 70, 80+25+25);
        g.drawString("in depozit si vinde un tarnacop, ar putea fi folositor.", 70, 80+25+25+25);

    }

    private void DrawBaniTip2(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.green);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Ce avem noi aici? Bani! Cine lasa bani in", 140, 80);
        g.drawString("dulapurile astea parasite? Poate reusesc sa fac", 130, 80+25);
        g.drawString("ceva cu ei, prizonierul nou venit imi pare familiar", 70, 80+25+25);
        g.drawString("poate vinde si el un tarnacop, ar putea fi folositor.", 70, 80+25+25+25);

    }

    private void DrawFoarfeceTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.gray);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Hey hey hey, ce avem noi aici? Un foarfece numai", 140, 80);
        g.drawString("bun de taiat chestii cu el, sper sa nu se supere ", 130, 80+25);
        g.drawString("proprietarul de drept... nah cui ii pasa, sigur l-a furat si el", 70, 80+25+25);
        g.drawString("As putea sa il folosesc sa tai gardul daca nu ma vede cineva,", 70, 80+25+25+25);
        g.drawString("sau daca ma apuca gradinaritul, vreun tufis enervant.", 70, 80+25+25+25+25);
    }

    private void DrawFoarfeceTip2(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.gray);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Hey hey hey, ce avem noi aici? Un foarfece numai", 140, 80);
        g.drawString("bun de taiat chestii cu el, acum clar nu are cine sa se", 130, 80+25);
        g.drawString("supere, depozitul asta e lasat in paragina.", 70, 80+25+25);
        g.drawString("Eu as putea sa il folosesc sa tai tufisul ala enervant din", 70, 80+25+25+25);
        g.drawString("gradina exterioara, ca sa am dupa acces la zidul acela crapat.", 70, 80+25+25+25+25);
        g.drawString("Gardul nu pot sa il tai ca ma vede un Dorel, si oricum nu rezolv", 70, 80+25+25+25+25+25);
        g.drawString("nimic, toata inchisoarea e imprejmuita de apa.", 70, 80+25+25+25+25+25+25);
    }

    private void DrawTarnacopTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Scump domn'le scump... dar foarte folositor ;)", 140, 80);
        g.drawString("pacat ca toti peretii sunt prea puternici pentru unealta", 130, 80+25);
        g.drawString("asta veche si ruginita, hmm... totusi, peretii din celula mea", 70, 80+25+25);
        g.drawString("nu pareau a fi cei mai rezistenti, as putea incerca ceva.", 70, 80+25+25+25);

    }

    private void DrawTarnacopTip2(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Scump domn'le scump... chiar mai scump ca data", 140, 80);
        g.drawString("trecuta. Dar se merita, chiar o sa imi fie de folos.", 130, 80+25);
        g.drawString("Sigur e suficient de bun ca sa sparg peretele crapat din ", 70, 80+25+25);
        g.drawString("nordul gradinii exterioare, iar de acolo ajung usor la o barca.", 70, 80+25+25+25);

    }

    private void DrawLinguraTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.orange);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("O lingura? Mna, ce-am gasit al meu sa fie!", 140, 80);
        g.drawString("Macar daca era mai bine spalata, clar nu se poate", 130, 80+25);
        g.drawString("manca cu ea. Oare as putea sa sap o gaura in peretele slabit", 70, 80+25+25);
        g.drawString("din celula mea cum am mai vazut prin filme?", 70, 80+25+25+25);
    }

    private void DrawNimicTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.white);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("...nimic aici...nimic...nimic nici aici", 140, 80);
        g.drawString("Ce saracie de om, tine dulapul gol de zici ca se fura", 130, 80+25);
        g.drawString("prin inchisoarea asta plina de oameni minunati si altruisti.", 70, 80+25+25);
        g.drawString("Ehh... asta e, ma descurc cu ce am.", 70, 80+25+25+25);
    }

    private void DrawNimicTip2(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.white);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("...nimic aici...nimic...nimic nici aici", 140, 80);
        g.drawString("Doar praf si niste scame, ceva normal in depozitul", 130, 80+25);
        g.drawString("asta derapanat.", 70, 80+25+25);
        g.drawString("Ehh... asta e, ma descurc cu ce am.", 70, 80+25+25+25);
    }

    private void DrawFailLingura(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.red);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Auch! Mda, ce idee grozava, sa sapi cu o lingura", 140, 80);
        g.drawString("intr-un perete de beton, o fi el vechi, dar tot se tine", 130, 80+25);
        g.drawString("in picioare. Am nevoie de o unealta mai buna, poate unul", 70, 80+25+25);
        g.drawString("dintre prizonieri ma poate ajuta.", 70, 80+25+25+25);
    }

    private void DrawCaughtText(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.cyan);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Auch! Auch! nu da la fata, ma invinetesc usor!", 140, 80);
        g.drawString("Bine, bine, am inteles ideea, nu am voie prin tunele.", 130, 80+25);
        g.drawString(". . . . .", 130, 80+25+25);
        g.drawString("Pfiu, ce bine ca am scapat doar cu putina bataie, daca era", 70, 80+25+25+25);
        g.drawString("Garcea nu cred ca se gandea de doua ori ianinte sa traga", 70, 80+25+25+25+25);
        g.drawString("cu pusca.", 70, 80+25+25+25+25+25);
    }

    private void DrawToporTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.yellow);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Hopaaa, ce frumooos, fix ce imi trebuia, un topor", 140, 80);
        g.drawString("As putea sa ma iau la bataie cu toata inchisoarea, ", 130, 80+25);
        g.drawString("sau as putea sa dobor copacul din curtea exterioara si sa ", 70, 80+25+25);
        g.drawString("improvizez o vasla pentru una din barcile din afara inchisorii.", 70, 80+25+25+25);
        g.drawString("Iar apoi, doar cativa kilometri buni de vaslit si sunt liber!", 70, 80+25+25+25+25);
    }

    private void DrawVaslaTip(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRoundRect(50, 50, 500, 300, 10, 10);

        g.setColor(Color.darkGray);
        g.fillRoundRect(50+5, 50+5, 500-10, 300-10, 10, 10);

        g.drawImage(Assets.continue_button, 300 - Assets.continue_button.getWidth()/2, 270, null);
        g.drawImage(Assets.C, 300 - Assets.C.getWidth()/2, 270 + 35, null);

        g.setColor(Color.green);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

        g.drawImage(Assets.player_head, 10, 10, 30*4, 23*4, null);


        g.drawString("Da-te ba ca cadeeee!", 140, 80);
        g.drawString("Eh, bine ca polistul ala nu vede prea bine.", 130, 80+25);
        g.drawString("De aici partea mai grea, punem asta asa, si pe asta o lipim,", 70, 80+25+25);
        g.drawString("stai oleaca sa cioplesc bucata asta ... si e gata!", 70, 80+25+25+25);
        g.drawString("Pfai, cel mai bun tamplar, sper sa ma tina, am de vaslit oleaca.", 70, 80+25+25+25+25);
    }


    public void SetTutorial()
    {
        tutorial = true;
    }

    public void SetBaniTip()
    {
        baniTip = true;
    }
    public void SetFoarfeceTip()
    {
        foarfeceTip = true;
    }
    public void SetTarnacopTip()
    {
        tarnacopTip = true;
    }
    public void SetLinguraTip()
    {
        linguraTip = true;
    }
    public void SetNimicTip()
    {
        nimicTip = true;
    }
    public void SetFailLingura()
    {
        failLingura = true;
    }
    public void SetCaughtText()
    {
        caughtText = true;
    }
    public void SetToporTip()
    {
        toporTip = true;
    }
    public void SetVaslaTip()
    {
        vaslaTip = true;
    }

    public void ResetTimer()
    {
        timer = 0;
    }

    public int GetTime()
    {
        return (int)(timer/60);
    }

    public void ResetAll()
    {
        baniTip = false;
        foarfeceTip = false;
        tarnacopTip = false;
        linguraTip = false;
        nimicTip = false;
        toporTip = false;
        vaslaTip = false;
        failLingura = false;
        caughtText = false;
        tutorial = false;
    }

    public void SetTimer(int timer)
    {
        this.timer = timer*60;
    }
}
