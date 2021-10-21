package se.dreamerstudios.game.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class World extends BasicGameState {
    private final int ID;

    private Map map;

    private float speed, xOffs, yOffs;

    public World(int id) {
        ID=id;

        map = new Map();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map.init(gc,sbg);
        speed = 2f;
        xOffs = map.getXOffs();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(gc,sbg, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();

        if(input.isKeyDown(Input.KEY_W)) { moveUp(speed); }
        if(input.isKeyDown(Input.KEY_S)) { moveDown(speed); }
        if(input.isKeyDown(Input.KEY_A)) { moveLeft(speed); }
        if(input.isKeyDown(Input.KEY_D)) { moveRight(speed); }

        map.update(gc,sbg,delta);
    }

    private void moveUp(float speed) {
        setYOffs(getYOffs() + speed);
        map.setYOffs(getYOffs());
    }

    private void moveDown(float speed) {
        setYOffs(getYOffs() - speed);
        map.setYOffs(getYOffs());
    }

    private void moveLeft(float speed) {
       setXOffs(getXOffs() + speed);
       map.setXOffs(getXOffs());
    }

    private void moveRight(float speed) {
        setXOffs(getXOffs() - speed);
        map.setXOffs(getXOffs());
    }

    public void setXOffs(float xOffs) { this.xOffs = xOffs; }
    public void setYOffs(float yOffs) { this.yOffs = yOffs; }

    public float getXOffs() { return xOffs; }
    public float getYOffs() { return yOffs; }

    @Override
    public int getID() {
        return ID;
    }
}
