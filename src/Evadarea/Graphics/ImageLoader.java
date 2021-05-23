package Evadarea.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader
{
    // realizeaza citirea imaginii(sprite sheet-ul) bazata pe o locatie
    public static BufferedImage LoadImage(String locatie)
    {
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(locatie));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
