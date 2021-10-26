package se.dreamerstudios.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.gui.EditorGUIBuilder;
import se.dreamerstudios.game.object.Map;
import se.dreamerstudios.game.utility.FontLoader;

import java.awt.*;

public class Editor extends GameState {
    private final EditorGUIBuilder gui;
    private final Map map;

    public Editor(int id) {
        super(id);
        gui = new EditorGUIBuilder();
        map = new Map();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gc.setDefaultFont(FontLoader.loadFont("resource/font/ubuntu-mono/ubuntu-mono-regular.ttf", Font.TRUETYPE_FONT, 14));
        map.init(gc, sbg);
        gui.init(gc, sbg);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(gc, sbg, g);
        gui.render(gc, sbg, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        map.update(gc, sbg, delta);
        gui.update(gc, sbg, delta);
    }
}
