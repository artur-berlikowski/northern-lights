package se.dreamerstudios.game.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.constant.Direction;
import se.dreamerstudios.game.constant.Orientation;
import se.dreamerstudios.game.utility.Margin;
import se.dreamerstudios.game.utility.Padding;


public class Container extends GUIComponent {
    private Orientation orientation, contentOrientation;
    private Direction direction;

    private Margin margin;
    private Padding padding;

    private int spacing;

    public Container(Orientation orientation, Orientation contentOrientation, Direction direction, Margin margin, Padding padding, int spacing) {
        setOrientation(orientation);
        setContentOrientation(contentOrientation);
        setDirection(direction);
        setMargin(margin);
        setPadding(padding);
        setSpacing(spacing);
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

    public void setPadding(Padding padding) {
        this.padding = padding;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    //Adjust the total width and height of the container based on the content, and it's direction.
    private void adjustDimensions() {
        float totalWidth = 0;
        float totalHeight = 0;

        for(GUIComponent component : getComponents()) {
            //Check if the need to add spacing exists
            boolean addSpacing = getComponents().indexOf(component) > 0 && getComponents().indexOf(component) < getComponents().size();

            //If direction is horizontal
            if(direction == Direction.HORIZONTAL) {
                totalWidth += component.getWidth();
                if(totalHeight < component.getHeight()) totalHeight = component.getHeight();
                //Add spacing to total width
                if (addSpacing) totalWidth += spacing;
            //If direction is vertical
            } else if(direction == Direction.VERTICAL) {
                totalHeight += component.getHeight();
                if(totalWidth < component.getWidth()) totalWidth = component.getWidth();
                //Add spacing to total height
                if(addSpacing) totalHeight += spacing;
            }
        }

        setWidth(totalWidth + padding.left + padding.right);
        setHeight(totalHeight + padding.top + padding.bottom);
    }

    //Adjust container offsets based on the orientation
    private void adjustOffsets(int screenWidth, int screenHeight) {
        switch(orientation) {
            case CENTER -> {
                setXOffs((screenWidth - (getWidth() + padding.left + padding.right)) / 2);
                setYOffs((screenHeight - getHeight() + padding.top + padding.bottom) / 2);
                adjustComponentOffsets();
            }
        }
    }

    //Adjust internal component offsets based on container offset
    private void adjustComponentOffsets() {
        float nextX = getXOffs();
        float nextY = getYOffs();

        switch(direction) {
            case VERTICAL -> nextY += padding.top;
        }

        for(GUIComponent component : getComponents()) {
            //Check the need to add spacing
            boolean addSpacing = getComponents().indexOf(component) < getComponents().size();

            switch (direction) {
                //If direction is vertical
                case VERTICAL -> {
                    component.setXOffs((int)(nextX + (contentOrientation == Orientation.CENTER ? ((getWidth() - component.getWidth()) / 2) : 0)));
                    component.setYOffs(nextY);
                    nextY += component.getHeight();
                    //Add spacing to yOffs
                    if(addSpacing) nextY += spacing;
                }
            }
        }
    }
}
