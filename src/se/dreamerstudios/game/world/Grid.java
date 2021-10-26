package se.dreamerstudios.game.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Grid {
    private Rectangle[][] tiles;
    private float xOffs, yOffs;
    private int width, height, tilesX, tilesY;

    public void init(GameContainer gc) {
        setTilesX((gc.getWidth() / width) + (gc.getWidth() % width > 0 ? 2 : 0));
        setTilesY((gc.getHeight() / height) + (gc.getHeight() % height > 0 ? 2 : 0));
        setXOffs(gc.getWidth() - (width * tilesX));
        setYOffs(gc.getHeight() - (height * tilesY));
        createTiles();
    }

    public void render(Graphics g) {
        drawTiles(g);
    }

    public void update() {
        createTiles();
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

    public Rectangle mouseOver(int mouseX, int mouseY) {
        Rectangle mouseOver = null;
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                Rectangle tile = getTiles()[y][x];
                if(mouseX >= tile.getMinX() && mouseY >= tile.getMinY() && mouseX <= tile.getMaxX() && mouseY <= tile.getMaxY()) {
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
}
