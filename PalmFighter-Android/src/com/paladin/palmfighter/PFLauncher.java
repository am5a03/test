package com.paladin.palmfighter;
import android.app.Activity;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class PFLauncher extends AndroidApplication {
          public void onCreate (android.os.Bundle
                                savedInstanceState) {
                  super.onCreate(savedInstanceState);
                  initialize(new PalmFighter(), false);
          }
}