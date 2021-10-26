package se.dreamerstudios.game.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class GUI {
    private ArrayList<GUIComponent> components;

    public GUI() {
        components = new ArrayList<>();
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        for(GUIComponent component : components) { component.init(gc, sbg); }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        for(GUIComponent component : components) { component.render(gc, sbg, g); }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        for(GUIComponent component : components) { component.update(gc, sbg, delta); }
    }

    public void addComponent(GUIComponent component) {
        components.add(component);
    }

    public void removeComponent(GUIComponent component) {
        components.remove(component);
    }

    public ArrayList<GUIComponent> getComponents() { return components; }
}
