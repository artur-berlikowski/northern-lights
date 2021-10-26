package se.dreamerstudios.game.map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Grid {
    private Tile[][] tiles;
    private Tile mouseOver;
    private float xOffs, yOffs, mouseX, mouseY;
    private int width, height, tilesX, tilesY;

    public void init(GameContainer gc) {
        setTiles(null);
        setMouseOver(null);
        setTilesX((gc.getWidth() / width) + (gc.getWidth() % width > 0 ? 2 : 0));
        setTilesY((gc.getHeight() / height) + (gc.getHeight() % height > 0 ? 2 : 0));
        setXOffs(gc.getWidth() - (width * tilesX));
        setYOffs(gc.getHeight() - (height * tilesY));
        setMouseY(0);
        setMouseX(0);
        createTiles();
    }

    public void render(Graphics g) {
        drawTiles(g);
    }

    public void update(GameContainer gc) {
        Input input = gc.getInput();

        setMouseX(input.getMouseX());
        setMouseY(input.getMouseY());

        createTiles();

        setMouseOver(getMouseOver(mouseX,mouseY));
    }

    private void createTiles() {
        Tile[][] tiles = new Tile[getTilesY()][getTilesX()];
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                float xOffs = getXOffs() + (x * getWidth());
                float yOffs = getYOffs() + (y * getHeight());
                tiles[y][x] = new Tile(xOffs, yOffs, getWidth(), getHeight());
            }
        }
        setTiles(tiles);
    }

    private void drawTiles(Graphics g) {
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                Tile tile = getTiles()[y][x];
                g.drawRect(tile.getXOffs(), tile.getYOffs(), tile.getWidth(), tile.getHeight());
            }
        }
    }

    private Tile getMouseOver(float mouseX, float mouseY) {
        Tile mouseOver = null;
        for(int y = 0; y < getTilesY(); y++) {
            for(int x = 0; x < getTilesX(); x++) {
                Tile tile = getTiles()[y][x];
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

    public void setTiles(Tile[][] tiles) {
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

    public float getMouseX() {
        return mouseX;
    }

    public float getMouseY() {
        return mouseY;
    }

    public Tile getMouseOver() {
        return mouseOver;
    }

    public void setTilesX(int tilesX) {
        this.tilesX = tilesX;
    }

    public void setTilesY(int tilesY) {
        this.tilesY = tilesY;
    }

    public Tile[][] getTiles() {
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

    private void setMouseX(float mouseX) {
        this.mouseX = mouseX;
    }

    private void setMouseY(float mouseY) {
        this.mouseY = mouseY;
    }

    private void setMouseOver(Tile mouseOver) {
        this.mouseOver = mouseOver;
    }
}
