package Evadarea.Animations;

import java.awt.image.BufferedImage;

public class Animation
{
    private BufferedImage frame1;
    private BufferedImage frame2;
    private BufferedImage currentFrame;
    private int delay;
    private int contor;


    // animatiile la mine in joc sunt foarte simple, sunt bazate pe doua frame-uri
    public Animation(BufferedImage frame1, BufferedImage frame2, int delay)
    {
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.delay = delay;
        contor = 0;
        currentFrame = frame1;
    }

    // metoda aceasta face switch intre cele doua frame-uri
    private BufferedImage NextFrame(BufferedImage currentFrame)
    {
        if(currentFrame == frame1)
        {
            return frame2;
        }
        else
        {
            return frame1;
        }
    }

    // medota Update se foloseste de metoda NextFrame ca sa dea switch la un numar de cadre ale jocului
    public void Update()
    {
        contor++;

        if(contor == delay)
        {
            currentFrame = NextFrame(currentFrame);
            contor = 0;
        }

    }


    public BufferedImage getCurrentFrame()
    {
        return currentFrame;
    }
}
