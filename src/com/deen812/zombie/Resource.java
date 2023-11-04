package com.deen812.zombie;


import java.io.IOException;
import java.util.ArrayList;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
//import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
//import org.anddev.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlas;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

public class Resource {


public Engine mEngine;
public TextureRegion mBackgroundTextureRegion;
public TextureRegion board;
//ÊÎØÊÀ
public TiledTextureRegion cat_head;
public TextureRegion cat_body;
public TextureRegion cat_hand;
	
//BOMB
public TextureRegion bomb_apple;
public TextureRegion hummer;
public TextureRegion bomb_osk2;
public TiledTextureRegion z_head;	
//zombie
public TiledTextureRegion z0;


//TEXT
public Texture mFontTexture;
public Font mFont;
public TiledTextureRegion z_body;
public TiledTextureRegion z_leg;
public TextureRegion z_hand;
public TextureRegion cat_hvost;
public TextureRegion btn_hummer;
public TiledTextureRegion btn_apple;
public TiledTextureRegion btn_dinamit;
public TextureRegion dinamit;
public TiledTextureRegion boom;
//BOSS1
public TiledTextureRegion boss1_head;
public TextureRegion boss1_body;
public TiledTextureRegion boss1_leg;
public TextureRegion boss1_hand;

//GUN
public TextureRegion gun_body_txrgn;
public TextureRegion gun_stvol_txrgn;

//BOXES
public TiledTextureRegion palka1;
public TiledTextureRegion palka3;
public TiledTextureRegion palka2;
public TextureRegion box;
public TextureRegion box_osk0;
public TextureRegion box_osk1;
public TextureRegion box_osk2;
public TextureRegion circle;
//BREAK
public TiledTextureRegion breaker;
public TiledTextureRegion cat;

public TiledTextureRegion cat_enemy;
// BIRD
public TiledTextureRegion bird_bonus;
public TiledTextureRegion bonus;
public TextureRegion circle_point;

// BUttons
public TextureRegion btn_pause;
public TextureRegion paused;
public TiledTextureRegion ball_purpure;
public TiledTextureRegion point;
public TiledTextureRegion face_box;
public TiledTextureRegion face_circle;
public TextureRegion bg1;
public TextureRegion wall1;
public TextureRegion wall2;
public TiledTextureRegion face_box_enemy;
public TiledTextureRegion face_circle_enemy;
public TiledTextureRegion text;
public TextureRegion paused_content;
public TextureRegion btn_reload;
public TextureRegion btn_menu;
public TextureRegion bg2;
public TextureRegion btn_exit;
public TextureRegion bg4;
public TextureRegion txt_start;
public TextureRegion btn_sound;

public TextureRegion btn_back;
public TextureRegion  btn_next;
public TiledTextureRegion menu_level;
public TextureRegion game_name;
public TextureRegion btn_prev;
public TextureRegion head_select;
public TextureRegion btn_bye;
public TextureRegion btn_info;
public TextureRegion btn_no;
public Music music_ok;
public Music mysound;
//public TextureRegion how;
public TextureRegion vibro;
public TextureRegion music;



//--------------------------------------------------
//public TextureRegion price_heart;
//public TextureRegion price_hammer;
//public TextureRegion price_snow;
public TextureRegion btn_plus;
public TextureRegion coin_bg;
public TextureRegion btn_f;
public TextureRegion btn_twitter;
public TiledTextureRegion btn_atlas;
public TextureRegion btn_google;
public TiledTextureRegion man_head;
public TiledTextureRegion man_body;
public TextureRegion btn_up;
public TextureRegion btn_down;
public TextureRegion hand_box;
public TextureRegion btn_a;
public TextureRegion btn_b;
public TextureRegion z1_leg;
public TiledTextureRegion z1_body;
//public TiledTextureRegion man_hand;
public TiledTextureRegion man_leg;
public TiledTextureRegion man_body_hand;
public TiledTextureRegion man_hand_r;
public TiledTextureRegion man_hand_l;
public TextureRegion man_b;
public TiledTextureRegion man_h;
public TextureRegion LIFE_PROGR_BG;
public TextureRegion Z_PROGRESS_BG;
public TextureRegion Z_PROGRESS;
public TextureRegion HUD_Z32;
public Font mFont_Plok;
public TextureRegion bg_home;
public TextureRegion btn_c;
public TextureRegion panel_heart;




public Sound hook;
public Sound a_zombie;
public Sound d_zombie;
public Sound a_yah;
public Sound m_pak;
public Sound man_hook;
public Sound man_hook1;
public Sound man_hook2;
public Sound uuu;
public Sound uuu2;
public Sound oi;
public Sound a_bah2;
public TiledTextureRegion z2_head;
public TiledTextureRegion z2_leg;
public TextureRegion btn_help;
public TextureRegion how_play;
public TiledTextureRegion dog;
public TextureRegion btn_music;
public TextureRegion bulava;
public TiledTextureRegion boss2_head;
public TextureRegion zh2;
public TextureRegion zh1;
public TiledTextureRegion boss2_body;
public TextureRegion boss2_head2;
public TextureRegion boss2_hand;

private static Resource instance;

	  public static Resource getInstance() {
	    if(instance == null) {
	      instance = new Resource();
	    }
	    return instance;
	  }

	  private Resource() {
		    
	  }
//=============================================================
	public void onLoadResources(Context ctx , Engine mEngine){
		   this.mEngine = mEngine;
		   
		   SoundFactory.setAssetBasePath("mfx/");
		   MusicFactory.setAssetBasePath("mfx/");
		      
		//   BitmapTextureAtlas;
		//   try
		//   {
		  //     music_ok = MusicFactory.createMusicFromAsset(mEngine.getMusicManager(), ctx,"munch.ogg");
		//   }
		//   catch (IOException e)
		//   {
	//	       e.printStackTrace();
		//   }
		   
		 //load
		
		
		
		  // BitmapTextureAtlas a;
		   TextureRegionFactory.setAssetBasePath("gfx/");
		//   TextureAtlasFactory
		   Constants mConst = Constants.getInstance();
	        //this.mCatTexture = new Texture(128, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	      //  mCatTextureRegion = TextureRegionFactory.createTiledFromAsset(this.mCatTexture,  ctx,  "cat3.png", 0, 0, 3, 6); //96-192/ 64x32
	          
		 //Çàãðóæàþ øðèôò BosaNova ðàçìåðîì 22 ïèêñåëÿ
		//   BitmapTextureAtlas font_BosaNova22_Texture = new BitmapTextureAtlas(512, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		 //  Font font_BosaNova22 = FontFactory.createFromAsset(font_BosaNova22_Texture, this, "fonts/bosanova.ttf", 22, true, Color.WHITE);
		    
		   //Çàãðóæàþ øðèôò BosaNova ðàçìåðîì 54 ïèêñåëÿ
		   //FontFactory.createStrokeFromAsset(pTexture, pContext, pAssetPath, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor, pStrokeOnly)
		 
		   FontFactory.setAssetBasePath("font/");

		   Texture font_BosaNova54_Texture = new Texture(512, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		   mFont_Plok = FontFactory.createFromAsset(font_BosaNova54_Texture, 
				                                    ctx, "d1.ttf", 46, true, android.graphics.Color.WHITE);
		   this.mEngine.getTextureManager().loadTextures(font_BosaNova54_Texture);  
		   
		//   this.mEngine.getTextureManager().loadTextures(font_BosaNova22_Texture, font_BosaNova54_Texture );
		//   this.mEngine.getFontManager().loadFonts(font_BosaNova22, font_BosaNova54);
		    this.mFontTexture = new Texture(512, 256, TextureOptions.BILINEAR);      
	        this.mFont = new Font(this.mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 38, true, Color.WHITE );
	        this.mEngine.getTextureManager().loadTexture(this.mFontTexture); 
	        this.mEngine.getFontManager().loadFonts(this.mFont,mFont_Plok);  

	   

	 	   Texture mBackgroundTexture = new Texture(1024, 1024,  TextureOptions.BILINEAR);
	        this.mBackgroundTextureRegion = TextureRegionFactory.createFromAsset(mBackgroundTexture, ctx, "bg0.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture);
	          
	        /*
	         * PTVKZ
	         */
	        Texture t6 = new Texture(32, 32,  TextureOptions.REPEATING);
	        this.wall1 = TextureRegionFactory.createFromAsset(t6, ctx, "ground_1.png", 0, 0);
	        
	        this.wall1.setWidth((int) mConst.WORLD_WIDTH);
	        this.wall1.setHeight(96);
	       
	        this.mEngine.getTextureManager().loadTextures(t6);
	        
	        
	        
	        /*
	         * -----------------------------
	         * MAN
	         */
	        Texture t2 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_head = TextureRegionFactory.createTiledFromAsset(t2, ctx, "z_head.png", 0, 0, 7, 1); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t2);
		    
		    Texture t3 = new Texture(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_body = TextureRegionFactory.createTiledFromAsset(t3, ctx, "z_body.png", 0, 0, 1, 1); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t3);
		    
	        Texture ttt = new Texture(16, 16,  TextureOptions.BILINEAR);
	        this.hand_box = TextureRegionFactory.createFromAsset(ttt, ctx, "hand_box.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(ttt);
	        
	        // HANDS
	      //   t3 = new Texture(256, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		  //  man_hand = TextureRegionFactory.createTiledFromAsset(t3, ctx, "man_hand.png", 0, 0, 3, 1); // 64x32
		  //  this.mEngine.getTextureManager().loadTextures(t3);
		    
		    t3 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_body_hand = TextureRegionFactory.createTiledFromAsset(t3, ctx, "man_hook.png", 0, 0, 4, 1); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t3);
		    
		    t3 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_hand_l = TextureRegionFactory.createTiledFromAsset(t3, ctx, "man_hook_l.png", 0, 0, 4, 1); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t3);
		    t3 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_hand_r = TextureRegionFactory.createTiledFromAsset(t3, ctx, "man_hook_r.png", 0, 0, 4, 1); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t3);
		    
		    // man head
		    t3 = new Texture(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_h = TextureRegionFactory.createTiledFromAsset(t3, ctx, "man_h_tiled.png", 0, 0, 3, 2); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t3);
		    // man
		     ttt = new Texture(64, 64,  TextureOptions.BILINEAR);
	        man_b = TextureRegionFactory.createFromAsset(ttt, ctx, "man_b.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(ttt);
	        
	        
		    t3 = new Texture(1024, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		    man_leg = TextureRegionFactory.createTiledFromAsset(t3, ctx, "leg.png", 0, 0, 8, 2); // 64x32
		    this.mEngine.getTextureManager().loadTextures(t3);
	        /*
	         * ------------------------------
	         * 
	         */
	        
	        
	        
	        /*
	         * Z1
	         */
	        //LEG
            Texture bulletTx6 = new Texture(256, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.z_leg  =TextureRegionFactory.createTiledFromAsset(bulletTx6, ctx, "z_leg2.png", 0, 0,5,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx6);
            // ÒÅËÎ
            Texture bulletTx5 = new Texture(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.z_body  =TextureRegionFactory.createTiledFromAsset(bulletTx5, ctx, "z_body.png", 0, 0,1,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx5);
            
            Texture bulletTx7 = new Texture(32, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.z_hand = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "z_hand.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx7);
	        
	        // ÒÅËÎ
	        bulletTx5 = new Texture(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.z1_body  =TextureRegionFactory.createTiledFromAsset(bulletTx5, ctx, "z1_body.png", 0, 0,1,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx5);
	        
            
            /*
             * BOSS2
             */
             bulletTx7 = new Texture(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.bulava = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "bulava.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx7);
	        
	        //boss2_head
	        bulletTx6 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss2_head  =TextureRegionFactory.createTiledFromAsset(bulletTx6, ctx, "boss2_head.png", 0, 0,3,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx6);
            
            bulletTx5 = new Texture(512, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss2_body  =TextureRegionFactory.createTiledFromAsset(bulletTx5, ctx, "boss2_body.png", 0, 0,5,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx5);
            
            bulletTx7 = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss2_hand = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "boss2_hand.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx7);
            //boss2_head2
         //   bulletTx7 = new Texture(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	      //  this.boss2_head2 = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "boss2_head2.png", 0, 0);
	      //  this.mEngine.getTextureManager().loadTextures(bulletTx7);
            //bulava
            /*
             * DOG
             */
             bulletTx6 = new Texture(1024, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.dog  =TextureRegionFactory.createTiledFromAsset(bulletTx6, ctx, "dog.png", 0, 0,9,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx6);
            /*
             * ÎÁÜÅÊÒÛ ÐÀÇÍÛÅ
             */
            
            bulletTx7 = new Texture(32, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.box = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "box.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx7);
	       //PRICE
	        /*
	         * 
	         */
	        bulletTx7 = new Texture(64, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.zh1 = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "zh1.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx7);
	        
	        bulletTx7 = new Texture(64, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.zh2 = TextureRegionFactory.createFromAsset(bulletTx7, ctx, "zh2.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx7);
	       //----------------------------
		   // Texture mBackgroundTexture2 = new Texture(256, 256,  TextureOptions.BILINEAR);
	      //  this.price_heart = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "price_heart.png", 0, 0);
	      //  this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	     //    mBackgroundTexture2 = new Texture(256, 256,  TextureOptions.BILINEAR);
	     //   this.price_hammer = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "price_hammer.png", 0, 0);
	     //   this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        
	   //     mBackgroundTexture2 = new Texture(256, 256,  TextureOptions.BILINEAR);
	   //     this.price_snow = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "price_snow.png", 0, 0);
	    //    this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        Texture  mBackgroundTexture2 = new Texture(512, 128,  TextureOptions.BILINEAR);
	        this.panel_heart = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "panel_heart.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(256, 256,  TextureOptions.BILINEAR);
	        this.how_play = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "how_play.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        /*
	         * 
	         * 
	         * 
	         */
	        
	        /*
			    * LIFE
			    */
			    Texture life2 = new Texture(64, 64,  TextureOptions.BILINEAR);
		        this.LIFE_PROGR_BG = TextureRegionFactory.createFromAsset(life2, ctx, "heart.png", 0, 0);
		        this.mEngine.getTextureManager().loadTextures(life2);
		      //public TextureRegion Z_PROGRESS_BG;
		        //public TextureRegion Z_PROGRESS;  
		        life2 = new Texture(512, 64,  TextureOptions.BILINEAR);
		        this.Z_PROGRESS_BG = TextureRegionFactory.createFromAsset(life2, ctx, "progress0.png", 0, 0);
		        this.mEngine.getTextureManager().loadTextures(life2);
		        
		        life2 = new Texture(512, 64,  TextureOptions.BILINEAR);
		        this.Z_PROGRESS = TextureRegionFactory.createFromAsset(life2, ctx, "progress1.png", 0, 0);
		        this.mEngine.getTextureManager().loadTextures(life2);
		        
		        life2 = new Texture(32, 32,  TextureOptions.BILINEAR);
		        this.HUD_Z32 = TextureRegionFactory.createFromAsset(life2, ctx, "z_h_32.png", 0, 0);
		        this.mEngine.getTextureManager().loadTextures(life2);
	        
	        /*
	         * 
	         * BUTTONS
	         */
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_plus = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_plus.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_up = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_up2.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_down = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_down2.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_a = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_a.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_b = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_b.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_c = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_c.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        //btn_music
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_music = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "music.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	   
	        /*
	         * 
	         * 
	         */
	        
	        /*
	         * ZOMBIES
	         */
	        mBackgroundTexture2 = new Texture(32, 64,  TextureOptions.BILINEAR);
	        this.z1_leg = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "z1_leg.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	     
	         t2 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	         z_head = TextureRegionFactory.createTiledFromAsset(t2, ctx, "z_head.png", 0, 0, 7, 1); // 64x32
		     this.mEngine.getTextureManager().loadTextures(t2);
	        //F
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_f = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "b_f.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_twitter = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "b_t.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_google = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "b_g.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        
	        
	        /*
	         * ZOMBIES2
	         */
	         t2 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	         z2_head = TextureRegionFactory.createTiledFromAsset(t2, ctx, "z2_head.png", 0, 0, 7, 1); // 64x32
		     this.mEngine.getTextureManager().loadTextures(t2);

		     t2 = new Texture(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	         z2_leg = TextureRegionFactory.createTiledFromAsset(t2, ctx, "z2_leg.png", 0, 0, 4, 3); // 64x32
		     this.mEngine.getTextureManager().loadTextures(t2);
		   //  mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		     
		    // BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	        
		   //  BitmapTextureAtlas Texture1 = new BitmapTextureAtlas(512, 512, TextureOptions.NEAREST_PREMULTIPLYALPHA);
		     
	        
	        /*
	         * COIN_BG
	         * coin_bg
	         */
	        mBackgroundTexture2 = new Texture(256, 128,  TextureOptions.BILINEAR);
	        this.coin_bg = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "coin_bg.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        //board
	        Texture mBackgroundTexture12 = new Texture( 1024, 512, TextureOptions.BILINEAR);
	        this.board = TextureRegionFactory.createFromAsset(mBackgroundTexture12, ctx, "bg6.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture12);
	        
	       

	        
	        
	        //TEXTS
	      //  Texture t10= new Texture(512, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	      //  text = TextureRegionFactory.createTiledFromAsset(t10, ctx, "text.png", 0, 0, 1, 5); // 64x32
	       // this.mEngine.getTextureManager().loadTextures(t10);
	        
	        
	        
	        
	        
	        //BTN
	        Texture t11 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_pause = TextureRegionFactory.createFromAsset(t11, ctx, "btn_pause.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t11);
	        
	        Texture t12 = new Texture(512, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.paused_content = TextureRegionFactory.createFromAsset(t12, ctx, "paused.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t12);
	        
	        Texture t14 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_reload = TextureRegionFactory.createFromAsset(t14, ctx, "btn_replay.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t14);
	        
	        
	        Texture t13 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_menu = TextureRegionFactory.createFromAsset(t13, ctx, "btn_menu.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t13);
	        
	        Texture t15 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_exit = TextureRegionFactory.createFromAsset(t15, ctx, "btn_exit.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t15);
	        
	        
	        
	        Texture t16 = new Texture(128, 128,  TextureOptions.REPEATING);
	        this.txt_start = TextureRegionFactory.createFromAsset(t16, ctx, "play_btn.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t16);
	      
	        //btn_help
	        mBackgroundTexture2 = new Texture(64, 64,  TextureOptions.BILINEAR);
	        this.btn_help = TextureRegionFactory.createFromAsset(mBackgroundTexture2, ctx, "btn_who.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(mBackgroundTexture2);
	        
	        
	        
	        
	        Texture t17 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_sound = TextureRegionFactory.createFromAsset(t17, ctx, "sound.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t17);
	        
	        
	        Texture t171 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_info = TextureRegionFactory.createFromAsset(t171, ctx, "btn_info.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t171);
	        
	        
	        Texture t172 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_bye = TextureRegionFactory.createFromAsset(t172, ctx, "btn_bye.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t172);
	        
	        Texture t173 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_no = TextureRegionFactory.createFromAsset(t173, ctx, "btn_no.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t173);
	 //       Texture t18 = new Texture(512, 128,  TextureOptions.REPEATING);
	//        this.txt_exit = TextureRegionFactory.createFromAsset(t18, ctx, "txt_exit.png", 0, 0);
	//        this.mEngine.getTextureManager().loadTextures(t18);
	  //      
	        
	        Texture t19 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_back = TextureRegionFactory.createFromAsset(t19, ctx, "prev2.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t19);
	        
	        Texture t20 = new Texture(64, 64,  TextureOptions.REPEATING);
	        this.btn_next = TextureRegionFactory.createFromAsset(t20, ctx, "next2.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(t20);
	        
	        Texture btntxt2 = new Texture(128, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.menu_level = TextureRegionFactory.createTiledFromAsset(btntxt2, ctx, "sel_origin.png", 0, 0,1,2);
	        this.mEngine.getTextureManager().loadTextures(btntxt2);
	        //public TextureRegion btn_back;
	        //public TiledTextureRegion menu_level;
	        
	        //Texture t21 = new Texture(512, 256,  TextureOptions.REPEATING);
	        //this.game_name = TextureRegionFactory.createFromAsset(t21, ctx, "game_name.png", 0, 0);
	        //this.mEngine.getTextureManager().loadTextures(t21);
	        
	        
	        //Texture t22 = new Texture(512, 256,  TextureOptions.REPEATING);
	        //this.head_select = TextureRegionFactory.createFromAsset(t22, ctx, "select_level_text.png", 0, 0);
	        //this.mEngine.getTextureManager().loadTextures(t22);
	        
	        //Texture t22 = new Texture(64, 64,  TextureOptions.REPEATING);
	     //   this.btn_prev = TextureRegionFactory.createFromAsset(t22, ctx, "next1.png", 0, 0);
	      //  this.mEngine.getTextureManager().loadTextures(t22);
	        
	     // BOSS1
	        Texture bulletTx9 = new Texture(512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss1_head  =TextureRegionFactory.createTiledFromAsset(bulletTx9, ctx, "boss1_head.png", 0, 0,7,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx9);
            
            Texture bulletTx10 = new Texture(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss1_body = TextureRegionFactory.createFromAsset(bulletTx10, ctx, "boss1_body.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx10);
	        
	        Texture bulletTx12 = new Texture(512, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss1_leg  =TextureRegionFactory.createTiledFromAsset(bulletTx12, ctx, "boss1_leg.png", 0, 0,5,1);
            this.mEngine.getTextureManager().loadTextures(bulletTx12);
            
            Texture bulletTx13 = new Texture(32, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.boss1_hand = TextureRegionFactory.createFromAsset(bulletTx13, ctx, "boss1_hand.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx13);
	        
	        
	        /*
	         * ÇÀÄÍÈÉ ÔÎÍ ÄËß ÈÃÐÛ
	         */
	        
	        bulletTx10 = new Texture(1024, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	        this.bg_home = TextureRegionFactory.createFromAsset(bulletTx10, ctx, "b3.png", 0, 0);
	        this.mEngine.getTextureManager().loadTextures(bulletTx10);
	
	
	        /*
	         * ÌÓÇÛÊÀ È ÇÂÓÊÈ
	         */
	
	        try {
	 		   a_yah = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "a_yah.mp3");
	 		   } catch (IOException e) {
	 		   e.printStackTrace();
	 		   }
	        
	        try {
	        	a_zombie = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "a_zombie.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   }
	        
	        try {
	        	d_zombie = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "d_zombie.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   }
	        
	        
	        try {
	        	m_pak = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "pak.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   } 
	        
	        try {
	        	man_hook = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "man_hook.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   } 
	        
	        try {
	        	man_hook1 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "man_hook1.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   } 
	        
	        try {
	        	man_hook2 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "man_hook3.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   } 
	        
	        try {
	        	uuu = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "uuu.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   }
	        
	        try {
	        	uuu2 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "uuu2.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   }
	        
	        try {
	        	oi = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "oi.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   }
	        
	        try {
	        	a_bah2 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "a_bah2.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   }
	        /*
	        try {
	        	a_yah = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), ctx, "a_yah.mp3");
		 		   } catch (IOException e) {
		 		   e.printStackTrace();
		 		   } 
		 		   */
	      // ÑÀÓÍËÒÐÅÊ
	        try {
	 		   mysound = MusicFactory.createMusicFromAsset(mEngine.getMusicManager(), ctx, "osvincem.mp3");
	 		   } catch (IOException e) {
	 		   e.printStackTrace();
	 		   }
	
	}
}

