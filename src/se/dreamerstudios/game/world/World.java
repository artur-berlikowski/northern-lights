package se.dreamerstudios.game.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.map.Map;
import se.dreamerstudios.game.map.Tile;

public class World extends BasicGameState {
    private final int ID;

    private final Map map;

    private Tile mouseOverTile;

    private float speed, xOffs, yOffs;

    private int mouseX, mouseY;

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
        if(getMouseOverTile() != null) {
            Tile tile = getMouseOverTile();
            g.fillRect(tile.getXOffs(), tile.getYOffs(), tile.getWidth(), tile.getHeight());
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        Input input = gc.getInput();

        setMouseX(input.getMouseX());
        setMouseY(input.getMouseY());

        if(input.isKeyDown(Input.KEY_W)) { moveUp(getSpeed()); }
        if(input.isKeyDown(Input.KEY_S)) { moveDown(getSpeed()); }
        if(input.isKeyDown(Input.KEY_A)) { moveLeft(getSpeed()); }
        if(input.isKeyDown(Input.KEY_D)) { moveRight(getSpeed()); }

        map.update();

        setMouseOverTile(map.getMouseOverTile(getMouseX(), getMouseY()));
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

    public void setMouseOverTile(Tile mouseOverTile) { this.mouseOverTile = mouseOverTile; }
    public void setSpeed(float speed) { this.speed = speed; }
    public void setXOffs(float xOffs) { this.xOffs = xOffs; }
    public void setYOffs(float yOffs) { this.yOffs = yOffs; }
    public void setMouseX(int mouseX) { this.mouseX = mouseX; }
    public void setMouseY(int mouseY) { this.mouseY = mouseY; }

    public Tile getMouseOverTile() { return mouseOverTile; }
    public float getSpeed() { return speed; }
    public float getXOffs() { return xOffs; }
    public float getYOffs() { return yOffs; }
    public int getMouseX() { return mouseX; }
    public int getMouseY() { return mouseY; }

    @Override
    public int getID() {
        return ID;
    }
}
