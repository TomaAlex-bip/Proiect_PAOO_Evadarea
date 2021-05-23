package Evadarea.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage spriteSheet;
    private static final int tileSize = 46; // 46 pixels

    // aici am poza mare(sprite sheet-ul) si din ea imi extrag poze mici(tiles, entities, buttons)
    public SpriteSheet(BufferedImage spriteSheet)
    {
        this.spriteSheet = spriteSheet;
    }

    // pentru extragerea dalelor cu marimi egale si fixe
    public BufferedImage getTile(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize);
    }

    // pentru extragerea dalelor cu marimi disticte
    // nu am avut timp sa o folosesc pentri optimizari
    public BufferedImage getTile(int x, int y, int width, int height)
    {
        return spriteSheet.getSubimage(x*tileSize, y*tileSize, width*tileSize, height*tileSize);
    }

    // pentru extragerea imaginilor la pozitii inexacte si de dimensiuni diverse
    // am folosit doar pentru butoane, iar pozitiile le-am aflat cu photoshop
    public BufferedImage getImage(int x, int y, int width, int height)
    {
        return spriteSheet.getSubimage(x, y, width, height);
    }


}
