package se.dreamerstudios.game.map;

public class Tile {
    private float xOffs, yOffs;
    private int width, height;

    public Tile(float xOffs, float yOffs, int width, int height) {
        setXOffs(xOffs);
        setYOffs(yOffs);
        setWidth(width);
        setHeight(height);
    }

    public void setXOffs(float xOffs) {
        this.xOffs = xOffs;
    }

    public void setYOffs(float yOffs) {
        this.yOffs = yOffs;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getXOffs() {
        return xOffs;
    }

    public float getYOffs() {
        return yOffs;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getMinX() {
        return getXOffs();
    }

    public float getMinY() {
        return getYOffs();
    }

    public float getMaxX() {
        return getXOffs() + getWidth();
    }

    public float getMaxY() {
        return getYOffs() + getHeight();
    }
}
