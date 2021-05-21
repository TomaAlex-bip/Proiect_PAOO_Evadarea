package Evadarea.Map;

import Evadarea.RefLinks;

public class FactoryMap
{
    private RefLinks refLink;

    // fabrica de harti, in functie de preferinta primesc harta 1 sau harta 2
    public FactoryMap(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public Map getMap(int mapID)
    {
        if(mapID == 1)
        {
            return new FirstLevelMap(refLink);
        }
        else if(mapID == 2)
        {
            return new SecondLevelMap(refLink);
        }
        else
        {
            return null;
        }
    }
}
