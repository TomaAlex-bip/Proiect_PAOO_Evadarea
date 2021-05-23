package Evadarea.Managers.Audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class AudioManager
{

    Clip music;


    private static AudioManager instance = new AudioManager("music/AlfredHitchcockPresentsTheme.wav");

    public static AudioManager getInstance()
    {
        return instance;
    }

    //manager pentru sunete, porneste din fisier muzica
    private AudioManager(String locatie)
    {
        try
        {
            File file = new File(locatie);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            music = AudioSystem.getClip();
            music.open(audioInputStream);


        }
        catch (Exception e)
        {
            System.out.println("Eroare la gasire muzica");
            e.printStackTrace();
        }
    }

    //porneste muzica
    public void PlayMusic()
    {
        // am folosit loop ca sa se repete
        // daca foloseam play() imi canta o data si atat
        music.loop(9999999);
    }

    //opreste muzica
    public void StopMusic()
    {
        music.stop();
    }
}
