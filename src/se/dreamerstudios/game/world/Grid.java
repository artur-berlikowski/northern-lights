package se.dreamerstudios.game.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Grid {
    private Rectangle[][] tiles;
    private Rectangle mouseOver;
    private float xOffs, yOffs;
    private int width, height, tilesX, tilesY, mouseX, mouseY;

    public void init(GameContainer gc, StateBasedGame sbg) {
        mouseOver = null;
        setTilesX((gc.getWidth() / width) + (gc.getWidth() % width > 0 ? 2 : 0));
        setTilesY((gc.getHeight() / height) + (gc.getHeight() % height > 0 ? 2 : 0));
        setXOffs(gc.getWidth() - (width * tilesX));
        setYOffs(gc.getHeight() - (height * tilesY));
        createTiles();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        drawTiles(g);
        if(mouseOver != null) {
            g.fillRect(mouseOver.getMinX(), mouseOver.getMinY(), mouseOver.getWidth(), mouseOver.getHeight());
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        Input input = gc.getInput();

        int mouseX = input.getAbsoluteMouseX();
        int mouseY = input.getAbsoluteMouseY();

        createTiles();

        mouseOver = mouseOverTile();
    }

    private void createTiles() {
        Rectangle[][] tiles = new Rectangle[getTilesY()][getTilesX()];
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                float xOffs = getXOffs() + (x * getWidth());
                float yOffs = getYOffs() + (y * getHeight());
                tiles[y][x] = new Rectangle(xOffs, yOffs, getWidth(), getHeight());
            }
        }
        setTiles(tiles);
    }

    private void drawTiles(Graphics g) {
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                Rectangle tile = getTiles()[y][x];
                g.drawRect(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
            }
        }
    }

    private Rectangle mouseOverTile() {
        Rectangle mouseOver = null;
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                Rectangle tile = getTiles()[y][x];
                if(getMouseX() >= tile.getMinX() && getMouseY() >= tile.getMinY() && getMouseX() <= tile.getMaxX() && getMouseY() <= tile.getMaxY()) {
                    mouseOver = tile;
                }
            }
        }
        return mouseOver;
    }

    public Grid(int width, int height) {
        setWidth(width);
        setHeight(height);
        setYOffs(0);
        setYOffs(0);
        setTilesX(0);
        setTilesY(0);
    }

    public Grid(int width, int height, int xOffs, int yOffs) {
        this(width,height);
        setXOffs(xOffs);
        setYOffs(yOffs);
    }

    public Grid(int width, int height, int xOffs, int yOffs, int tilesX, int tilesY) {
        this(width, height, xOffs, yOffs);
        setTilesX(tilesX);
        setTilesY(tilesY);
    }

    public void setTiles(Rectangle[][] tiles) {
        this.tiles = tiles;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setXOffs(float xOffs) {
        this.xOffs = xOffs;
    }

    public void setYOffs(float yOffs) {
        this.yOffs = yOffs;
    }

    public void setTilesX(int tilesX) {
        this.tilesX = tilesX;
    }

    public void setTilesY(int tilesY) {
        this.tilesY = tilesY;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public Rectangle[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getXOffs() {
        return xOffs;
    }

    public float getYOffs() {
        return yOffs;
    }

    public int getTilesX() {
        return tilesX;
    }

    public int getTilesY() {
        return tilesY;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
