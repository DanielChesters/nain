package org.oni.nain.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.oni.nain.NainGame;

public class DesktopLauncher {
    private DesktopLauncher() {

    }

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new NainGame(), config).setLogLevel(LwjglApplication.LOG_DEBUG);
    }
}
