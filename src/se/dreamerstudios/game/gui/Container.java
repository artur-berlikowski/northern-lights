package se.dreamerstudios.game.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.constant.Direction;
import se.dreamerstudios.game.constant.Orientation;


public class Container extends GUIComponent {
    private Orientation orientation, contentOrientation;
    private Direction direction;

    public Container(Orientation orientation, Orientation contentOrientation, Direction direction) {
        setOrientation(orientation);
        setContentOrientation(contentOrientation);
        setDirection(direction);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        adjustDimensions();
        adjustOffsets(gc.getWidth(), gc.getHeight());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        super.update(gc, sbg, delta);
        adjustDimensions();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        super.render(gc, sbg, g);
        g.drawRect(getXOffs(),getYOffs(),getWidth(),getHeight());
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setContentOrientation(Orientation contentOrientation) {
        this.contentOrientation = contentOrientation;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //Adjust the total width and height of the container based on the content, and it's direction.
    private void adjustDimensions() {
        float totalWidth = 0;
        float totalHeight = 0;

        for(GUIComponent component : getComponents()) {
            if(direction == Direction.HORIZONTAL) {
                totalWidth += component.getWidth();
                if(totalHeight < component.getHeight()) totalHeight = component.getHeight();
            } else if(direction == Direction.VERTICAL) {
                totalHeight += component.getHeight();
                if(totalWidth < component.getWidth()) totalWidth = component.getWidth();
            }
        }

        setWidth(totalWidth);
        setHeight(totalHeight);
    }

    //Adjust container offsets based on the orientation
    private void adjustOffsets(int screenWidth, int screenHeight) {
        switch(orientation) {
            case CENTER -> {
                setXOffs((screenWidth - getWidth()) / 2);
                setYOffs((screenHeight - getHeight()) / 2);
                adjustComponentOffsets();
            }
        }
    }

    //Adjust internal component offsets based on container offset
    private void adjustComponentOffsets() {
        float nextX = getXOffs();
        float nextY = getYOffs();

        for(GUIComponent component : getComponents()) {
            switch (direction) {
                case VERTICAL -> {
                    component.setXOffs((int)(nextX + (contentOrientation == Orientation.CENTER ? ((getWidth() - component.getWidth()) / 2) : 0)));
                    component.setYOffs(nextY);
                    nextY += component.getHeight();
                }
            }
        }
    }
}
