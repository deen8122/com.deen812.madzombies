package com.deen812.zombie.scene;

import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.deen812.zombie.Constants;
import com.deen812.zombie.R;
import com.deen812.zombie.Resource;
import com.deen812.zombie.SceneManager.AllScenes;
import com.deen812.zombie.main;


import android.content.Intent;

public class ByeScene {

	/*
	 * 	 */
	private Scene mScene;
	private Constants mConst;
	private Resource mRes;
	private main game;
	private ChangeableText col_coin;
	private ChangeableText col_heart;
	private ChangeableText col_hummer;
	private ChangeableText col_snow;

	public ByeScene(main game) {
		mRes = game.mRes;
		this.game = game;
		this.mScene = new Scene(0);
        this.mScene.attachChild(new Entity());
        this.mScene.setBackgroundEnabled(true);
        mConst = Constants.getInstance();
        
        
     //   mConst.COIN = 100;
        
        
        
        Sprite backgrund = new Sprite(0, 0, mRes.mBackgroundTextureRegion);
        Sprite backgrund2 = new Sprite(30, 20, mRes.board);
     //   Sprite backgrund2 = new Sprite(170, -40, mRes.game_name);
        
        backgrund2.setWidth(mConst.CAMERA_WIDTH-60);
        backgrund2.setHeight(mConst.CAMERA_HEIGHT-40);
        backgrund.setWidth(mConst.CAMERA_WIDTH);
        backgrund.setHeight(mConst.CAMERA_HEIGHT);
        backgrund.attachChild(backgrund2);
        this.mScene.setTouchAreaBindingEnabled(true);
        this.mScene.attachChild(backgrund);
        onLoadComplete();
    //    price_heart();
     //   price_hammer();
     //   price_snow();
        
        coin_bg();    
        btn_f();
        price_heart2();
        
        
      
	}
	
	private void price_heart2() {
		 Sprite spr  = new Sprite( 80 , mConst.CAMERA_HEIGHT/2 -30, mRes.panel_heart); 
	     mScene.attachChild(spr);
	     
	 	Sprite btn_plus  = new Sprite(spr.getWidth()-100 , spr.getHeight()/2 -30 , mRes.btn_plus) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	               	mRes.m_pak.play();
	                }
	                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	                //--------------------------------
	               	 if( (mConst.COIN - 10) >= 0){
	               		mConst.COIN-=10;
	               		mConst.COL_HEART++;
	               		col_coin.setText(mConst.COIN+"");
	               	}else {
	               		coin_empty();
	               	}
	               	 update_coin( );
	               	 
	               	 
	          

	                }
	                
	                return true;
	            }; 
	     };
	     spr.attachChild(btn_plus);
	     this.mScene.registerTouchArea(btn_plus);
	   
	     float correct = 0;
	     if(mConst.COL_HEART>9)
	    	 correct= -5;
	     if(mConst.COL_HEART>99)
	    	 correct= -10;
	     
	     col_heart = new ChangeableText(250,39, mRes.mFont, +mConst.COL_HEART+" ");
	     col_heart.setScale(1.6f);
	     col_heart.setColor(0.3f, 0.2f, 0f);
	     spr.attachChild(col_heart);
	     
	     // ЦЕННИК
	    
	     Text  heart_price = new Text(120,45, mRes.mFont, "=10");
	     heart_price.setColor(1, 1, 1);
	     heart_price.setScale(1.1f);
	     spr.attachChild(heart_price);
	}

	public void UPDATE() {
		update_coin();
	}
	
	
	
	private void btn_f() {
		 Sprite btn_plus  = new Sprite(mConst.CAMERA_WIDTH - 200 , 50 , mRes.btn_f) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	               //	Process.killProcess(Process.thisMainScene.myPid());
	               	// game.sceneManager.setCurrentScene(AllScenes.MENU);
	               //	game.finish();
	           //    	android.os.Process.killProcess(android.os.Process.myPid());

	                }
	                
	                return true;
	            }; 
	     };
	   //  mScene.attachChild(btn_plus);
	   //  this.mScene.registerTouchArea(btn_plus);
	     
	     
	     Sprite btn_twitter  = new Sprite(mConst.CAMERA_WIDTH - 300 , 50 , mRes.btn_twitter) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);


	                }
	                
	                return true;
	            }; 
	     };
	  //   mScene.attachChild(btn_twitter);
	  //   this.mScene.registerTouchArea(btn_twitter);
	     
	     
	     
	     Sprite btn_google  = new Sprite(mConst.CAMERA_WIDTH - 400 , 50 , mRes.btn_google) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	  
	                }
	                
	                return true;
	            }; 
	     };
	  //   mScene.attachChild(btn_google);
	  //   this.mScene.registerTouchArea(btn_google);
	     
	     
	     Sprite btn_play  = new Sprite(mConst.CAMERA_WIDTH - 110 , mConst.CAMERA_HEIGHT/2 , mRes.txt_start) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.0);
	               	mRes.m_pak.play();
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 0.8);
	               	 game.sceneManager.setCurrentScene(AllScenes.SELECT_LEVEL);
	  
	                }
	                
	                return true;
	            }; 
	     };
	     btn_play.setScale(0.8f);
	     mScene.attachChild(btn_play);
	     this.mScene.registerTouchArea(btn_play);
		
	}

	private void coin_bg() {
		 Sprite spr  = new Sprite( 80 , 40, mRes.coin_bg); 
	     mScene.attachChild(spr);
	     Sprite btn_plus  = new Sprite(spr.getWidth()-30 , 0 , mRes.btn_plus) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	               	mRes.m_pak.play();
	                       /*
	                        * покупка в прилоении
	                        */
                            mConst.main_activity.bye();
	                }
	                
	                return true;
	            }; 
	     };
	     spr.attachChild(btn_plus);
	     this.mScene.registerTouchArea(btn_plus);
	     
	     
	     col_coin = new ChangeableText(78,10, mRes.mFont,"    ");
	     col_coin.setText(mConst.COIN+"");
	     col_coin.setScale(0.8f);
	     col_coin.setColor(255f, 255f, 0f);
	     
	     spr.attachChild(col_coin);
		
	}

	
	
	//-------------------------------------------------------------------------------------
	public void price_heart(){
		/*
		 Sprite spr  = new Sprite( 80 , mConst.CAMERA_HEIGHT/2 -50, mRes.price_heart); 
	     mScene.attachChild(spr);
	     
	 	Sprite btn_plus  = new Sprite(40 , spr.getHeight() -30 , mRes.btn_plus) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	               	mRes.m_pak.play();
	                }
	                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	                //--------------------------------
	               	 if( (mConst.COIN - 10) >= 0){
	               		mConst.COIN-=10;
	               		mConst.COL_HEART++;
	               		col_coin.setText(mConst.COIN+"");
	               	}else {
	               		coin_empty();
	               	}
	               	 update_coin( );
	               	 
	               	 
	          

	                }
	                
	                return true;
	            }; 
	     };
	     spr.attachChild(btn_plus);
	     this.mScene.registerTouchArea(btn_plus);
	   
	     float correct = 0;
	     if(mConst.COL_HEART>9)
	    	 correct= -5;
	     if(mConst.COL_HEART>99)
	    	 correct= -10;
	     
	     col_heart = new ChangeableText(60+correct,90, mRes.mFont, +mConst.COL_HEART+" ");
	     col_heart.setScale(1.4f);
	     col_heart.setColor(0.9f, 0.2f, 0f);
	     spr.attachChild(col_heart);
	     */
	     
	}
	
	
	protected void coin_empty() {
		// TODO Auto-generated method stub
		
	}

	
	
	public void update_coin() {
		col_heart.setText(mConst.COL_HEART+"");
		col_coin.setText(mConst.COIN+"");
		//col_hummer.setText(mConst.COL_HUMMER+"");
		//col_snow.setText(mConst.COL_SNOW+"");
		game.updateByeParam();
	}

	
	
	public void price_hammer(){
		/*
		 Sprite spr  = new Sprite( 300 , mConst.CAMERA_HEIGHT/2 - 50, mRes.price_hammer); 
	     mScene.attachChild(spr);
	 	Sprite btn_plus  = new Sprite(40 , spr.getHeight() -30 , mRes.btn_plus) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	               	if( (mConst.COIN - 20) >= 0){
	               		mConst.COIN-=20;
	               		mConst.COL_HUMMER++;
	               		col_coin.setText(mConst.COIN+"");
	               	}else {
	               		coin_empty();
	               	}
	               	 update_coin( );

	                }
	                
	                return true;
	            }; 
	     };
	     spr.attachChild(btn_plus);
	     this.mScene.registerTouchArea(btn_plus);
	     
	     float correct = 0;
	     if(mConst.COL_HUMMER>9)
	    	 correct= -5;
	     if(mConst.COL_HUMMER>99)
	    	 correct= -10;
	     
	     col_hummer = new ChangeableText(70+correct,90, mRes.mFont, +mConst.COL_HUMMER+" ");
	     col_hummer.setScale(1.4f);
	     col_hummer.setColor(0.9f, 0.2f, 0f);
	     spr.attachChild(col_hummer);
	     
	     */
	     
	}
	
	
	public void price_snow(){
		/*
		 Sprite spr  = new Sprite( 500 , mConst.CAMERA_HEIGHT/2 -50, mRes.price_snow); 
	     mScene.attachChild(spr);
	 	Sprite btn_plus  = new Sprite(40 , spr.getHeight() -30 , mRes.btn_plus) {
	   		 @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	               	if( (mConst.COIN - 30) >= 0){
	               		mConst.COIN-=30;
	               		col_coin.setText(mConst.COIN+"");
	               	}else {
	               		coin_empty();
	               	}
	               	 update_coin( );
	                }
	                
	           
	                
	                return true;
	            }; 
	     };
	     spr.attachChild(btn_plus);
	     this.mScene.registerTouchArea(btn_plus);
	     
	     float correct = 0;
	     if(mConst.COL_SNOW>9)
	    	 correct= -5;
	     if(mConst.COL_SNOW>99)
	    	 correct= -10;
	     
	     col_snow = new ChangeableText(60+correct,90, mRes.mFont, +mConst.COL_SNOW+" ");
	     col_snow.setScale(1.4f);
	     col_snow.setColor(0.9f, 0.2f, 0f);
	     spr.attachChild(col_snow);
	     */
	}
	
	public void onLoadComplete() {
		
		// TextView tvBottom = (TextView) findViewById(R.id.tvBottom);
		 //String dtr = findViewById(R.id.hello);
		//R.string.hello;
	//	this.getText(R.string.hello);
	//	this.getResources().getString(R.string.app_name)
	//	String str=(String)game.getResources().getString(R.string.about);
		             
		//Text t = new Text(0, 0, mRes.mFont, str);
		//this.mScene.attachChild(t);
		Sprite btn_exit2  = new Sprite(mConst.CAMERA_WIDTH - 80 , 30, mRes.btn_exit) {
   		 @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
                if (pSceneTouchEvent.isActionDown()     ) {
               	 this.setScale((float) 1.2);
               	 mRes.m_pak.play();
                }
                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
               	 this.setScale((float) 1.0);
               //	Process.killProcess(Process.thisMainScene.myPid());
               	 game.sceneManager.setCurrentScene(AllScenes.MENU);
               //	game.finish();
           //    	android.os.Process.killProcess(android.os.Process.myPid());

                }
                
                return true;
            }; 
     };
     mScene.attachChild(btn_exit2);
     this.mScene.registerTouchArea(btn_exit2);
     
	
			
		}

	private String findViewById(int text1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.mScene;
	}
	

}
