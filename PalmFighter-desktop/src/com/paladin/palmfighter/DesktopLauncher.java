package com.paladin.palmfighter;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopLauncher {
        public static void main (String[] args) {
                new LwjglApplication(new PalmFighter(), "Game",
                                       480, 320, false);
        }
}