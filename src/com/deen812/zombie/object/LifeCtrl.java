package com.deen812.zombie.object;

import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;

import com.deen812.zombie.Constants;
import com.deen812.zombie.main;

public class LifeCtrl {
    public Sprite life;
	private ChangeableText scoreText;
	private int lfie_col;
	private int life_current;
	private ChangeableText scoreTextZ32;
	private main game;
	private Sprite zh32;
	private boolean man_die = false;
	private Rectangle redRectangle;
	public LifeCtrl(Scene mScene, main game, HUD hud) {
		this.life = new Sprite(0,0,game.mRes.LIFE_PROGR_BG);
		this.game = game;
		lfie_col = Constants.getInstance().COL_HEART;
	//	lfie_col = Constants.getInstance().LIFE_COL;
		life_current = Constants.getInstance().LIFE_CURRENT ;
		Constants.getInstance().LIFE_CURRENT2 =Constants.getInstance().LIFE_CURRENT ;
		Constants.getInstance().COL_HEART2 = Constants.getInstance().COL_HEART;
		scoreText = new ChangeableText(60, 0, game.mRes.mFont, lfie_col+"x"+life_current, 10);
		scoreText.setColor(0, 0, 0);
		
		hud.attachChild(scoreText);
		
		 zh32  = new Sprite(0,40,game.mRes.HUD_Z32);
		hud.attachChild(zh32);
		scoreTextZ32 = new ChangeableText(60,40, game.mRes.mFont,""+ Constants.getInstance().COIN, 10);
		hud.attachChild(scoreTextZ32);
		scoreTextZ32.setColor(0, 0, 0);
		redRectangle = new Rectangle(0,0,Constants.getInstance().CAMERA_WIDTH,Constants.getInstance().CAMERA_HEIGHT );
		redRectangle.setColor(1, 0, 0);
		redRectangle.setAlpha(0.5f);
	}

	public void MinusLife(int life) {
		if(life <=0) return;
		if( man_die) return;
		if(lfie_col <= 0 && life_current<=0 ) return ;
		Constants.getInstance().hud.attachChild(redRectangle);
		
		Constants.getInstance().CURRENT_SCENE.registerUpdateHandler(new IUpdateHandler() {  
			
			@Override  
        public void onUpdate(float arg0) { 
			
				Constants.getInstance().CURRENT_SCENE.unregisterUpdateHandler(this);
				Constants.getInstance().hud.detachChild(redRectangle);
				
		         }  

      @Override  
       public void reset() {   }  
    });  
		life_current-=life;
		Constants.getInstance().LIFE_CURRENT2 = life_current;
		if(life_current <= 0) {
			life_current = 0;
			lfie_col--;
			Constants.getInstance().COL_HEART2--;
			life_current=100;
			if(lfie_col < 0) {
				if(man_die  == false) {
				Constants.getInstance().gameScene.ManDie();
				man_die = true;
				
				
				}
				lfie_col = 0;
				life_current = 0;
			}
		}
		scoreText.setText(lfie_col+"x"+life_current);
	}
	
	public void PlusZombieKill() {
		Constants.getInstance().COIN++;
		scoreTextZ32.setText(""+Constants.getInstance().COIN);
		this.game.KILL_ZOMBIE();
		
		
	}

	
	
	public void dispose() {
		Constants.getInstance().hud.detachChild(life);
		Constants.getInstance().hud.detachChild(redRectangle);
		redRectangle = null;
		Constants.getInstance().hud.detachChild(scoreText);
		Constants.getInstance().hud.detachChild(zh32);
		Constants.getInstance().hud.detachChild(scoreTextZ32);
	}

	public void clearRect() {
		// TODO Auto-generated method stub
		
	}
}
