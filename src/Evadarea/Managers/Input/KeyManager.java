package Evadarea.Managers.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private boolean[] keys;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean interact;

    public boolean escape;
    public boolean next;

    public boolean sound_on;
    public boolean sound_off;
    public boolean new_game;
    public boolean continue_game;
    public boolean quit;
    public boolean save;


    private static KeyManager instance = new KeyManager();

    // manager pentru taste apasate
    private KeyManager()
    {
        keys = new boolean[256];
    }

    public static KeyManager getInstance()
    {
        return instance;
    }

    public void Update()
    {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        interact = keys[KeyEvent.VK_E];

        sound_on = keys[KeyEvent.VK_P];
        sound_off = keys[KeyEvent.VK_M];
        new_game = keys[KeyEvent.VK_N];
        continue_game = keys[KeyEvent.VK_C];
        quit = keys[KeyEvent.VK_Q];
        save = keys[KeyEvent.VK_S];

        escape = keys[KeyEvent.VK_ESCAPE];
        next = keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }



}
