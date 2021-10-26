package se.dreamerstudios.game.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Label extends GUIComponent {
    private Color color;
    private String label;

    public Label(String label) {
        setColor(null);
        setLabel(label);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) {
        setWidth(gc.getDefaultFont().getWidth(label));
        setHeight(gc.getDefaultFont().getHeight(label));
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        Color current = g.getColor();
        if(color != null) { g.setColor(color); }
        gc.getDefaultFont().drawString(getXOffs(),getYOffs(),label,g.getColor());
        g.setColor(current);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getLabel() {
        return label;
    }
}
