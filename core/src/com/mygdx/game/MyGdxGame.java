package com.mygdx.game;

import com.badlogic.gdx.Game;
import screens.JGameScreen;

public class MyGdxGame extends Game 
{
	@Override
	public void create () {
            setScreen(new JGameScreen());
	}
}
