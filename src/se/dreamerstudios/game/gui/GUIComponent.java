package se.dreamerstudios.game.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.constant.Orientation;

import java.util.ArrayList;

public class GUIComponent {
    private ArrayList<GUIComponent> components;
    private GUIComponent parent;
    private Color backgroundColor;
    private Orientation orientation;

    private float width, height, xOffs, yOffs;

    public GUIComponent(float width, float height, float xOffs, float yOffs) {
        components = new ArrayList<>();

        setParent(null);
        setBackgroundColor(null);
        setOrientation(Orientation.AUTO);
        setWidth(width);
        setHeight(height);
        setXOffs(xOffs);
        setYOffs(yOffs);
    }

    public void init(GameContainer gc, StateBasedGame sbg) {
        if(getParent() != null && orientation == Orientation.AUTO) setOrientation(Orientation.INHERIT);
        for(GUIComponent component : getComponents()) component.init(gc, sbg);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        Color current = g.getColor();
        if(getBackgroundColor() != null) g.setColor(getBackgroundColor());
        g.fillRect(xOffs,yOffs,width,height);
        g.setColor(current);
        for(GUIComponent component : getComponents()) component.render(gc, sbg, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        for(GUIComponent component : getComponents()) component.update(gc, sbg, delta);
    }

    public void add(GUIComponent component) {
        component.setParent(this);
        components.add(component);
    }

    public void setParent(GUIComponent parent) {
        this.parent = parent;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setXOffs(float xOffs) {
        this.xOffs = xOffs;
    }

    public void setYOffs(float yOffs) {
        this.yOffs = yOffs;
    }

    public ArrayList<GUIComponent> getComponents() {
        return components;
    }

    public GUIComponent getParent() {
        return parent;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getXOffs() {
        return xOffs;
    }

    public float getYOffs() {
        return yOffs;
    }
}
