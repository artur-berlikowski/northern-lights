package se.dreamerstudios.game.map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Map {
    public final int GRID_WIDTH = 64;
    public final int GRID_HEIGHT = 64;

    private final Grid grid;

    private Tile mouseOver;

    private float xOffs, yOffs, mouseX, mouseY;

    public Map() {
        grid = new Grid(GRID_WIDTH,GRID_HEIGHT);
    }

    public void init(GameContainer gc) {
        grid.init(gc);
        setMouseOver(null);
        setXOffs(grid.getXOffs());
        setYOffs(grid.getYOffs());
    }

    public void render(Graphics g) {
        grid.render(g);
        if(mouseOver != null) {
            g.fillRect(mouseOver.getXOffs(), mouseOver.getYOffs(), mouseOver.getWidth(), mouseOver.getHeight());
        }
    }

    public void update(GameContainer gc) {
        grid.update(gc);

        setMouseOver(grid.getMouseOver());
    }

    public Tile getMouseOver() {
        return mouseOver;
    }

    public void setXOffs(float xOffs) {
        this.xOffs = xOffs;
        grid.setXOffs(getXOffs());
    }
    public void setYOffs(float yOffs) {
        this.yOffs = yOffs;
        grid.setYOffs(getYOffs());
    }

    public void setMouseX(float mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(float mouseY) {
        this.mouseY = mouseY;
    }

    public float getXOffs() { return xOffs; }
    public float getYOffs() { return yOffs; }

    public float getMouseX() {
        return mouseX;
    }

    public float getMouseY() {
        return mouseY;
    }

    private void setMouseOver(Tile mouseOver) {
        this.mouseOver = mouseOver;
    }
}
