package se.dreamerstudios.game.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.map.Map;

public class World extends BasicGameState {
    private final int ID;

    private final Map map;

    private float speed, xOffs, yOffs;

    public World(int id) {
        ID=id;
        map = new Map();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) {
        map.init(gc);

        setSpeed(2f);
        setXOffs(map.getXOffs());
        setYOffs(map.getYOffs());
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        map.render(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        Input input = gc.getInput();

        if(input.isKeyDown(Input.KEY_W)) { moveUp(getSpeed()); }
        if(input.isKeyDown(Input.KEY_S)) { moveDown(getSpeed()); }
        if(input.isKeyDown(Input.KEY_A)) { moveLeft(getSpeed()); }
        if(input.isKeyDown(Input.KEY_D)) { moveRight(getSpeed()); }

        map.update(gc);
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

    public void setSpeed(float speed) { this.speed = speed; }
    public void setXOffs(float xOffs) { this.xOffs = xOffs; }
    public void setYOffs(float yOffs) { this.yOffs = yOffs; }

    public float getSpeed() { return speed; }
    public float getXOffs() { return xOffs; }
    public float getYOffs() { return yOffs; }

    @Override
    public int getID() {
        return ID;
    }
}
