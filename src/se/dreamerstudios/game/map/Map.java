package se.dreamerstudios.game.map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Map {
    public final int GRID_WIDTH = 64;
    public final int GRID_HEIGHT = 64;

    private final Grid grid;

    private float xOffs, yOffs;

    public Map() {
        grid = new Grid(GRID_WIDTH,GRID_HEIGHT);
    }

    public void init(GameContainer gc) {
        grid.init(gc);
        xOffs = grid.getXOffs();
        yOffs = grid.getYOffs();
    }

    public void render(Graphics g) {
        grid.render(g);
    }

    public void update() {
        grid.update();
    }

    public Tile getMouseOverTile(int mouseX, int mouseY) {
        return grid.mouseOver(mouseX,mouseY);
    }

    public void setXOffs(float xOffs) {
        this.xOffs = xOffs;
        grid.setXOffs(getXOffs());
    }
    public void setYOffs(float yOffs) {
        this.yOffs = yOffs;
        grid.setYOffs(getYOffs());
    }

    public float getXOffs() { return xOffs; }
    public float getYOffs() { return yOffs; }
}
