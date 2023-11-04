package com.deen812.zombie.object;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;

import com.deen812.zombie.main;

public class CoinCtrl {
    public Sprite coin;
	public CoinCtrl(Scene mScene, main game) {
		this.coin = new Sprite(0,0,game.mRes.LIFE_PROGR_BG);
	}

}
