package com.deen812.zombie.object;





import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;

import com.deen812.zombie.Constants;
import com.deen812.zombie.main;
import com.deen812.zombie.scene.Dialog;



public class Controller {

	private static HUD hud;
	protected boolean btn_down_pressed;
	private static Sprite btn_pause;
	protected boolean btn_pause_clicked;
	private static Sprite btn_C;
	private static Sprite btn_up;
	private static Sprite btn_down;
	private static Sprite btn_left;
	private static Sprite btn_right;
	private static Sprite btn_A;
	private static Sprite btn_B;
	private static Man man;
	private static Controller instance;



	//---------------------------------------------------------------------
	public static Controller getInstance(final Man man2, Scene mScene, main game) {
		if(instance == null) {instance = new Controller( man2,  mScene,  game);}
		 game.mSmoothCamera.getHUD().setVisible(true);
		 game.mSmoothCamera.getHUD().setPosition(0, 0);
		 man = man2;
		 registerTouch();

		return instance;}


	private static void registerTouch() {
		hud.registerTouchArea(btn_up);
		hud.registerTouchArea(btn_down);
		hud.registerTouchArea(btn_left);
		hud.registerTouchArea(btn_right);
		hud.registerTouchArea(btn_A);
		hud.registerTouchArea(btn_B);
	//	hud.registerTouchArea(btn_C);
		hud.registerTouchArea(btn_pause);
		hud.setTouchAreaBindingEnabled(true); 
		
	}


	private Controller(final Man man2, Scene mScene, main game) {
		
		
		 hud = new HUD();
		 this.man = man2;
		 game.mSmoothCamera.setHUD(hud);
			hud.setTouchAreaBindingEnabled(true); 
		// hud.set
		// hud.registerTouchArea(pTouchArea)
		 float y = 400;
		 float x = 110;
		 float x2= 90;
		 float y2= 60;
		 
	
		 /// UP	 
		  btn_up = new Sprite(x ,y - y2, game.mRes.btn_up){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.9f);
                 	// man.hand_up();
                	 man.btn_b_down();
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() || pSceneTouchEvent.isActionOutside()) {
                	 this.setScale(1.8f);
                	// man.hand_down();
                 }
                 return true;
             };
		};
	//	btn_up.setScale(1.8f);
	//	btn_up.setAlpha(0.5f);
	//	hud.attachChild(btn_up);
	//	hud.registerTouchArea(btn_up);
		//mScene.registerTouchArea(btn_up);

		
		
		
		//DOWN
		  btn_down = new Sprite(x ,y, game.mRes.btn_down){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.6f);
                 //	 man.sitdown();
                 	btn_down_pressed = true;
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() ) {
                	 this.setScale(1.5f);
                	// man.key_up();
                	 btn_down_pressed = false;
                 }
                 return true;
             };
		};
		btn_down.setScale(1.5f);
		btn_down.setAlpha(0.5f);
		hud.attachChild(btn_down);
		hud.registerTouchArea(btn_down);
		
		
		/*
		 * LEFT
		 */
		 btn_left = new Sprite(x - x2 ,y, game.mRes.btn_back){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.6f);
                 	  man.to_left();
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
                	 this.setScale(1.5f);
                	 man.key_up();
                 }
                 return true;
             };
		};
		btn_left.setScale(1.5f);
		btn_left.setAlpha((float) 0.5);
		hud.attachChild(btn_left);
		hud.registerTouchArea(btn_left);
		
		
		  btn_right = new Sprite(x + x2 ,y, game.mRes.btn_next){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.6f);
                 	 man.to_right();
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() ) {
                	 this.setScale(1.5f);
                	 man.key_up();
                 }
                 return true;
             };
		};
		btn_right.setScale(1.5f);
		btn_right.setAlpha((float) 0.5);
		hud.attachChild(btn_right);
		hud.registerTouchArea(btn_right);
		
		
		/*
		 * 
		 *  ÕŒœ ¿ ¿
		 */
		Constants mConst = Constants.getInstance();
		  btn_A = new Sprite(mConst.CAMERA_WIDTH -200 ,y, game.mRes.btn_a){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.6f);
                 	// man.to_right();
                 	 //if(btn_down_pressed) { man.hookLeg();}
                 	// else man.btn_a_down();
                 	 if(btn_down_pressed) { man.hookLeg();}
                  	 else 
                 	man.btn_a_down();
                 	 //Dialog.getInstance().GamerLose();
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() ) {
                	 this.setScale(1.5f);
                	// man.key_up();
                 }
                 return true;
             };
		};
		btn_A.setScale(1.5f);
		btn_A.setAlpha((float) 0.5);
		hud.attachChild(btn_A);
		hud.registerTouchArea(btn_A);
		
		
		/*
		 * 
		 *  ÕŒœ ¿ B
		 */
	
		  btn_B = new Sprite(mConst.CAMERA_WIDTH -100 ,y, game.mRes.btn_b){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.6f);
                 	// man.hookLeg();
                 	// if(btn_down_pressed) { man.hookLeg();}
                  	// else man.btn_b_down();
                 	man.btn_b_down();
                 	// Dialog.getInstance().GamerWin();
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() ) {
                	 this.setScale(1.5f);
                	// man.btn_b_up();
                	// man.key_up();
                 }
                 return true;
             };
		};
		btn_B.setScale(1.5f);
		btn_B.setAlpha((float) 0.5);
		hud.attachChild(btn_B);
		hud.registerTouchArea(btn_B);
		
		/*
		 * 
		 *  ÕŒœ ¿ C
		 
	
		  btn_C = new Sprite(mConst.CAMERA_WIDTH -100 ,y, game.mRes.btn_c){
			 @Override
             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                 if (pSceneTouchEvent.isActionDown()     ) {
                 	 this.setScale(1.6f);
                 	man.btn_a_down();
                 	 
        
                 }
                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() ) {
                	 this.setScale(1.5f);
                	// man.btn_b_up();
                 }
                 return true;
             };
		};
	//	btn_C.setScale(1.5f);
	//	btn_C.setAlpha((float) 0.5);
	//	hud.attachChild(btn_C);
	//	hud.registerTouchArea(btn_C);
		*/
		
		//BTN_PAUSE
		 btn_pause = new Sprite(mConst.CAMERA_WIDTH -game.mRes.btn_menu.getWidth()-10  ,10, game.mRes.btn_pause){
		

			@Override
           public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
               if (pSceneTouchEvent.isActionDown()  && Dialog.getInstance().btn_paused_on==false ) {
               	 this.setScale(1.1f);
               	 Dialog.getInstance().ShowPaused();
               	 btn_pause_clicked  = true;
               	
      
               }
               if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() || pSceneTouchEvent.isActionOutside()) {
              	 this.setScale(1.0f);
              	// man.key_up();
               }
               return true;
           };
		};
	
		
		hud.attachChild(btn_pause);
		hud.registerTouchArea(btn_pause);
		
		
		
		 
		
	}
	
	
	public HUD getHUD() {
		return this.hud;
	}


}
