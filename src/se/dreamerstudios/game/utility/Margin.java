package se.dreamerstudios.game.utility;

public class Margin {
    public int top, right, left, bottom;

    public Margin(int margin) {
        setTop(margin);
        setRight(margin);
        setBottom(margin);
        setLeft(margin);
    }

    public Margin(int top, int right, int bottom, int left) {
        setTop(top);
        setRight(right);
        setBottom(bottom);
        setLeft(left);
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
