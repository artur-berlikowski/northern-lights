package se.dreamerstudios.game.gui;

public class GUIComponent extends GUI {
    private float xOffs, yOffs, width, height;

    public void setXOffs(float xOffs) {
        this.xOffs = xOffs;
    }

    public void setYOffs(float yOffs) {
        this.yOffs = yOffs;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getXOffs() {
        return xOffs;
    }

    public float getYOffs() {
        return yOffs;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
