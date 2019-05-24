package gaim.engine.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import engine.TestGame;


/**
 * Main is the main class of <b>Test</b> for Java. The sole purpose of this
 * class is to hold the main method. Any other operation should be placed in a
 * separate class. <b>You can not instantiate this class.</b>
 *
 * @author Matthew 'siD' van der bijl
 */
public final class DesktopLauncher {

    /**
     * You can not instantiate this class.
     */
    private DesktopLauncher() {
    }


    public static void main(String[] args) {
        final LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Test";

        cfg.width = 640;//1600;
        cfg.height = 480;//900;

        cfg.vSyncEnabled = true;
        cfg.fullscreen = false;
        cfg.resizable = false;
        
        // cfg.samples = 16;
        cfg.preferencesFileType = Files.FileType.Internal;

        new LwjglApplication(new TestGame(), cfg);
    }
}
