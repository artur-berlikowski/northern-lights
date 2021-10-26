package se.dreamerstudios.game.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.constant.Direction;
import se.dreamerstudios.game.constant.Orientation;
import se.dreamerstudios.game.utility.Margin;
import se.dreamerstudios.game.utility.Padding;

public class EditorGUIBuilder {
    private final GUI gui;

    public EditorGUIBuilder() {
        gui = new GUI();
    }

    private void build() {
        Container container = new Container(Orientation.CENTER, Orientation.CENTER, Direction.VERTICAL, new Margin(0), new Padding(16), 16);

        Label label1 = new Label("Hello Container!");
        Label label2 = new Label("Hello Next Row!");
        Label label3 = new Label("And just for the fuck of it :)");

        label1.setColor(Color.red);
        label2.setColor(Color.green);
        label3.setColor(Color.blue);

        container.addComponent(label1);
        container.addComponent(label2);
        container.addComponent(label3);

        gui.addComponent(container);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        build();
        gui.init(gc,sbg);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        gui.render(gc,sbg,g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        gui.update(gc,sbg,delta);
    }
}
