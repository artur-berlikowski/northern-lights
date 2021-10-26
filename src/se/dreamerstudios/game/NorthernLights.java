package se.dreamerstudios.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import se.dreamerstudios.game.world.World;

public class NorthernLights  extends StateBasedGame {
    private final static String NAME = "Northern Lights";
    private final static String VERSION = "0.0.0.1";
    private final static String RELEASE = "Development";
    private final static String TITLE = NAME + " " + VERSION + " " + RELEASE;

    private final static int WIDTH = 1024;
    private final static int HEIGHT = 768;
    private final static int MULTISAMPLING = 2;
    private final static int TARGET_FPS = 60;

    private final static boolean FULLSCREEN = false;
    private final static boolean UPDATE_ONLY_WHEN_VISIBLE = true;
    private final static boolean ALWAYS_RENDER = false;
    private final static boolean CLEAR_EACH_FRAME = true;
    private final static boolean SHOW_FPS = true;
    private final static boolean SMOOTH_DELTAS = true;
    private final static boolean LOGGING = false;
    private final static boolean VSYNC = false;

    public NorthernLights(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) {
        addState(new World(0));
        enterState(0);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new NorthernLights(TITLE));

        container.setDisplayMode(WIDTH,HEIGHT,FULLSCREEN);
        container.setUpdateOnlyWhenVisible(UPDATE_ONLY_WHEN_VISIBLE);
        container.setAlwaysRender(ALWAYS_RENDER);
        container.setClearEachFrame(CLEAR_EACH_FRAME);
        container.setMultiSample(MULTISAMPLING);
        container.setShowFPS(SHOW_FPS);
        container.setSmoothDeltas(SMOOTH_DELTAS);
        container.setTargetFrameRate(TARGET_FPS);
        container.setVerbose(LOGGING);
        container.setVSync(VSYNC);

        container.start();
    }
}
