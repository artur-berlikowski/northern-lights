package se.dreamerstudios.game.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Map {
    private final int GRID_WIDTH = 64;
    private final int GRID_HEIGHT = 64;

    private Grid grid;

    private String mapPath;

    private float xOffs, yOffs;

    public Map() {
        mapPath = null;
        grid = new Grid(GRID_WIDTH,GRID_HEIGHT);
    }

    public Map(String mapPath) {
        this();
        setMapPath(mapPath);
    }

    public void init(GameContainer gc, StateBasedGame sbg) {
        grid.init(gc, sbg);
        xOffs = grid.getXOffs();
        yOffs = grid.getYOffs();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        grid.render(gc, sbg, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        grid.update(gc, sbg, delta);
    }

    private void setMapPath(String mapPath) { this.mapPath = mapPath; }

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
