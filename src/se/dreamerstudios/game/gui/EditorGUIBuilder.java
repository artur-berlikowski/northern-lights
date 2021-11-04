package se.dreamerstudios.game.gui;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class EditorGUIBuilder {
    private GUI gui;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        build(gc);
        gui.init(gc,sbg);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        gui.render(gc, sbg, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        gui.update(gc,sbg,delta);
    }

    private void build(GameContainer gc) {
        gui = new GUI(gc.getWidth(),gc.getHeight(),0,0);

        gui.setBackgroundColor(Color.red);
    }
}
