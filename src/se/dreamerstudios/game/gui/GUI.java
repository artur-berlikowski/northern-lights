package se.dreamerstudios.game.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GUI {
    private GUIComponent gui;

    public GUI(float width, float height, float xOffs, float yOffs) {
        gui = new GUIComponent(width,height,xOffs,yOffs);
    }

    public void init(GameContainer gc, StateBasedGame sbg) {
        gui.init(gc, sbg);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        gui.render(gc, sbg, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        gui.update(gc, sbg, delta);
    }

    public void add(GUIComponent component) {
        gui.add(component);
    }

    public void setBackgroundColor(Color backgroundColor) {
        gui.setBackgroundColor(backgroundColor);
    }
}
