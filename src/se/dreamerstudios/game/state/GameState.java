package se.dreamerstudios.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {
    private final int ID;

    public GameState(int id) { ID = id; }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

    }

    @Override
    public int getID() {
        return ID;
    }
}
