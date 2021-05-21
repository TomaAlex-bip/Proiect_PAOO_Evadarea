package Evadarea.Managers.Inventory;

public class Inventory
{
    private boolean foarfece;
    private boolean bani;
    private boolean tarnacop;
    private boolean topor;
    private boolean vasla;
    private boolean lingura;


    // manager pentru inventar, aici am "iteme", care sunt niste flaguri pentru anumite interactiuni
    public Inventory()
    {
        foarfece = false;
        bani = false;
        tarnacop = false;
        topor = false;
        vasla = false;
        lingura = false;

    }

    public void SetFoarfece()
    {
        foarfece = true;
    }

    public void SetLingura()
    {
        lingura = true;
    }

    public void SetBani()
    {
        System.out.println("ai gasit bani");
        bani = true;
    }

    public void SetTarnacop()
    {
        if(bani && !tarnacop)
        {System.out.println("ai cumparat tarnacop");
            tarnacop = true;
            bani = false;
        }
    }

    public void SetTopor()
    {
        System.out.println("ai gasit topor");
        topor = true;
    }

    public void SetVasla()
    {
        if(topor)
        {
            System.out.println("ai facut vasla");
            vasla = true;
        }
    }

    public boolean isFoarfece()
    {
        return foarfece;
    }
    public boolean isTarnacop()
    {
        return tarnacop;
    }
    public boolean isVasla()
    {
        return vasla;
    }
    public boolean isTopor()
    {
        return topor;
    }
    public boolean isLingura()
    {
        return lingura;
    }
    public boolean isBani()
    {
        return bani;
    }

    public void Reset()
    {
        foarfece = false;
        bani = false;
        tarnacop = false;
        topor = false;
        vasla = false;
        lingura = false;
    }

    public void resetFoarfece()
    {
        foarfece = false;
    }

    public void resetLingura()
    {
        lingura = false;
    }


    public void SetInventory(boolean foarfece, boolean bani, boolean tarnacop, boolean topor, boolean vasla, boolean lingura)
    {
        this.foarfece = foarfece;
        this.bani = bani;
        this.tarnacop = tarnacop;
        this.topor = topor;
        this.vasla = vasla;
        this.lingura = lingura;
    }

}
