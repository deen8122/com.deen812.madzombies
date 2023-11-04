package com.deen812.zombie;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.IBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.deen812.zombie.scene.AboutScene;
import com.deen812.zombie.scene.ByeScene;
import com.deen812.zombie.scene.GameScene;
import com.deen812.zombie.scene.MainScene;
import com.deen812.zombie.scene.SelectScene;


import android.util.Log;

public class SceneManager {

	private AllScenes currentScene;
	private main activity;
	private Engine engine;
	private Camera camera;
	//private BitmapTextureAtlas splashTA;
	//private ITextureRegion splashTR;
	private Scene splashScene, gameScene, menuScene;
	private TextureRegion face_box_enemy;
	private Resource mRes;
	private Scene settingScene;
	private Scene selectLevel;
	private Scene lastScene;
	//private SelectScene ss;
	private Scene HelpScene;
	private Scene helpC;
	private Scene aboutscene;
	private Scene byescene;
	public Scene selectscene;
	private GameScene gsm;
	public SelectScene ms3;
	private ByeScene bys;

	public enum AllScenes {
		SPLASH, MENU, GAME,SELECT_LEVEL, SETTING,HELP,ABOUT, BYE
	}

	public SceneManager(main game, Engine eng, Camera cam) {
		// TODO Auto-generated constructor stub
		this.activity = game;
		this.engine = eng;
		this.camera = cam;
		mRes = game.mRes; 
	}

	public void loadSplashResources() {
		   TextureRegionFactory.setAssetBasePath("gfx/");
		    Texture t8 = new Texture(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        face_box_enemy = TextureRegionFactory.createFromAsset(t8, this.activity, "z_h_48x48.png", 0, 0); // 64x32
	        engine.getTextureManager().loadTextures(t8);

	}

	public void loadGameResources() {

	}

	public void loadMenuResources() {

	}

	public Scene createSplashScene() {
		splashScene = new Scene( 0 );
		//splashScene.setBackground(new IBackground());
		final Sprite icon = new Sprite(0, 0,  face_box_enemy);
		icon.setPosition((camera.getWidth() - icon.getWidth()) / 2,
				(camera.getHeight() - icon.getHeight()) / 2);
		splashScene.attachChild(icon);
		splashScene.registerUpdateHandler(new IUpdateHandler() {  
			float a = icon.getRotation();
			@Override  
              public void onUpdate(float arg0) { 
				icon.setRotation(a);;
				a+=8;
		         }  

            @Override  
             public void reset() {   }  
          });  
		return splashScene;
	}

	public Scene createMenuScene() {
		  Log.v("SCENE_MANAGER","createMenuScene");
		    MainScene ms = new MainScene(this.activity);
		    menuScene = ms.getScene();
		    
		   // HelpScene hs = new HelpScene(this.activity);
		 //   HelpScene = hs.getScene();
		    AboutScene as = new AboutScene(this.activity);
		    aboutscene = as.getScene();
		  //   ss = new SelectScene(this.activity);
		  //  selectLevel = ss.getScene();
		    bys = new ByeScene(this.activity);
		    byescene= bys.getScene();
		   
		     ms3 = new SelectScene(this.activity);
		   selectscene= ms3.getScene();
		   
		    gsm  = new GameScene(this.activity);
		   gameScene= gsm.getScene();
		    
		   
		   com.deen812.zombie.scene.HelpScene hs2 = new com.deen812.zombie.scene.HelpScene(this.activity);
		    this.HelpScene = hs2.getScene();
		return menuScene;

	}

	public Scene createGameScene() {
		return null;
	}

	public AllScenes getCurrentScene() {
		return currentScene;
	}

	public void setCurrentScene(AllScenes currentScene) {
		
		//camera.setCenter(0, 0);
		//activity.closeScene();
		this.currentScene = currentScene;
		switch (currentScene) {
		case SPLASH:
			break;
		case MENU:
	//		camera.getHUD().clearChildScene();
			
			engine.setScene(menuScene);
			break;
		case GAME:
			 gsm  = new GameScene(this.activity);
			   gameScene= gsm.getScene();
			gsm.start_game();
			engine.setScene(gameScene);
			break;
		case SETTING:
			engine.setScene(settingScene);
			break;
		case HELP:
			engine.setScene(HelpScene);
			break;	
		case BYE:
			if(byescene==null){
				     bys = new ByeScene(this.activity);
				    byescene= bys.getScene();
				
			} 
			bys.UPDATE();
			Constants.getInstance().BYE_SCENE = bys;
			engine.setScene(byescene);
			break;		
		case ABOUT:
			engine.setScene(aboutscene);
			break;	
		case SELECT_LEVEL:
			//menuScene.
			//  SelectScene ss = new SelectScene(this.activity);
			  //  selectLevel = ss.getScene();
			//selectLevel.checkLevels();
			//ss.checkLevels();
			
			engine.setScene(selectscene);
			break;
		default:
			break;
		}
		//this.lastScene = currentScene;
	}

	public void setRes(Resource mRes2) {
		mRes = mRes2; 
		
	}

	public Scene createSettingScene() {
	
	//	  SettingScene ms = new SettingScene(this.activity);
		//  settingScene = ms.getScene();
		return settingScene;
		
	}

	public void setSelectScene() {
	//	camera.setCenter(0, 0);
	//	ss.checkLevels();
	//	this.currentScene = AllScenes.SELECT_LEVEL;
	//	engine.setScene(selectLevel);
		
	}
	
	
}
