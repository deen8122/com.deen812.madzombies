package com.deen812.zombie;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import com.deen812.zombie.object.LifeCtrl;
import com.deen812.zombie.object.ProgressCtrl;
import com.deen812.zombie.scene.ByeScene;
import com.deen812.zombie.scene.GameScene;



public class Constants {
	private static final String COL_COIN = "COL_COIN";

	public final String LEVEL_NAME = "LEVEL";

	public String base64EncodedPublicKey ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsCPLciPo5MeDT7Mg9ei34XZZEMl4j+OA8NhLuLQYtBcWfw3GQm+rW75DOyFTABWmof12uCzMNt2FakT+GBURNiXYJBl4xSS3uOdBhyd7xkHGSY8y6OjIFipjqrLzC1C2Jt5ix735q9qvBfse8rKnE5+nR2BNribEsbjnUVSmco+NhJx1SQ09Wz+qWN92AaMFZACeZdgmA4PNuyfbh0O6NgWHVn6GbA4No7NACTzFTok4AJcVt4cc2w8uIkk5uyvHAdfpMMDTz5NMnuyf0Jcao5EMSPxQv6nLlo4+8XYcn6UmPgsIMG3eRVzEUjp3B96F3xxttnKlG9D4U9fFQIIehwIDAQAB";
	
	//chunk_split($publicKey, 64, "\n") 
	//AIzaSyBfNkrtXBZu9EyLB61v33FEM8FZysw0z-I
	public String base64EncodedPublicKey2 ="31129deen";
	int CAMERA_Y_CENTER = 240;
	public float CAMERA_WIDTH = 800;
	public float CAMERA_HEIGHT = 480;  
	public float TABLE_WIDTH = 750;
	public float TABLE_HEIGHT = 420;  
    float GAME_TABLE_X = 210;
    float GAME_TABLE_Y = 210;
	public float WORLD_WIDTH = 2000 ;
	public float WORLD_HEIGHT = CAMERA_HEIGHT;
    float ZOOM_MAX =1.5f;
    float ZOOM_MIN = 0.5f;
    float GROUND_HEIGHT = 150;

    
    //BOMBS
    int APPLE    =  1;
    int HUMMER   =  2;
    int DINAMIT  =  3;
    
    //BOXES
    int  PALKA = 1;//проста€ палка. при сильном удрае ломатес€ 
    int  PALKA2 = 2;
    int  PALKA3 = 3;
    //----------------------
    int PLAYER_BALL_N = 0;
	int ENEMY_BALL_N = 0;
    
    //---------------------
    int  BOX = 4;
    int  BOX2 = 5;
    int  BOX3 = 6;
	 int BREAKER=7;
	 int CAT_PLAYER = 0x1;
	 int CAT_ENEMY  = 0x2;
	 
	 //int CAT_PLAYER_COL = 0;
	 //int CAT_ENEMY_COL = 0;
	 
	 //BONUS TYPE--------------------------------
	 int BONUS_LIFE = 0;
	 int BONUS_PLUS_POWER = 3;
	 int BONUS_DOUBLE = 4;
	 int BONUS_PLUS = 2;
	 int BONUS_DINAMIT = 1;
	 //-----------------------------------------
	public int PLAYER = 0;
	public int ENEMY =  1;
    
	int COL_DINAMIT = 10;
	protected int BOMB_OSK = 0x5;
	public int POINT_SIMPLE = 0;
	public int FACE_CIRCLE = 0;
	public int FACE_BOX = 1;
	public int MOVED_BALL_PLAYER =0;
	public int MOVED_BALL_ENEMY =0;
	public int WHO_MOVE = 10;
	
	//TEXT
	public int TEXT_YOU_TURN  = 3;
	public int TEXT_EXCELLENT = 4;
	public int TEXT_OOPS = 2;
	public boolean BALL_PRESSED = false;
	public int TEXT_YOU_WIN  = 0;
	public Body ball = null;
	public int BALL_U = 0;
	//public Vector2 point1 = null;
	public float LEN_FIRST=0;
	protected Vector2 point3;
	public float point3_x;
	public float point3_y;
	protected float BALL_X = 0;
	public float BALL_Y = 0;
	public int PLAYER_SCORE = 0;
	public int LEVEL= 1;
	public int TEXT_U_LOST = 1;
	public int MAX_LEVEL = 45;
	public int SELECTED_MAP = 0;

	public int COIN =101;

	public int COL_HEART = 8;

	public int COL_HUMMER = 3;

	public int COL_SNOW = 3;

	public String COIN_NAME ="COIN";

	public String HEART_NAME="HEART";

	public String HUMMER_NAME ="HUMMER";

	public String SNOW_NAME = "SNOW";

	public ProgressCtrl prg_ctrl;

	public int ZOMBIE_COL;

	public int CURRENT_ZOMBIE_I = 0;

	public Scene CURRENT_SCENE;

	public HUD hud;



	//public int LIFE_COL;

	public int USER_KILL_Z =0;

	public LifeCtrl life_ctrl;

	public boolean F_ENEMY_END = false;

	public main main_activity;

	public GameScene gameScene;

	public int KILLED_ZOMBIE;

	public int LIFE_COL_INIT;

	public Engine mEngine;

	public int LIFE_CURRENT;

	public int LIFE_CURRENT2;

	public int COL_HEART2;

	public int SOUND_ON = 1;

	public int MUSIC_ON = 0;

	public PhysicsWorld mPhysicsWorld;

	public AnimatedSprite MAN;

	public ByeScene BYE_SCENE;
	
	
	
	
	
	
    private static Constants instance;

	  public static Constants getInstance() {
	    if(instance == null) {
	      instance = new Constants();
	    }
	    return instance;
	  }

	  private Constants() {
	    
	  }

	  /*
	   * ќбновл€ем параметры которые можно купить за деньги
	   * 
	   */
	public void updateByeParam(main game) {

		
		

	}
	  
	  
}
