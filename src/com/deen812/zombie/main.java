package com.deen812.zombie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.SmoothCamera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.extension.input.touch.controller.MultiTouch;
import org.anddev.andengine.extension.input.touch.controller.MultiTouchController;
import org.anddev.andengine.extension.input.touch.detector.PinchZoomDetector;
import org.anddev.andengine.extension.input.touch.exception.MultiTouchException;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.input.touch.detector.ScrollDetector;
import org.anddev.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.anddev.andengine.input.touch.detector.SurfaceScrollDetector;
import org.anddev.andengine.level.LevelLoader;
import org.anddev.andengine.level.LevelLoader.IEntityLoader;
import org.anddev.andengine.level.util.constants.LevelConstants;
import org.anddev.andengine.sensor.accelerometer.AccelerometerData;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.deen812.game.util.IabHelper;
import com.deen812.game.util.IabResult;
import com.deen812.game.util.Inventory;
import com.deen812.game.util.Purchase;
import com.deen812.zombie.SceneManager.AllScenes;
import com.deen812.zombie.scene.Dialog;





public class main extends BaseGameActivity implements  IOnSceneTouchListener, IOnAreaTouchListener, IScrollDetectorListener
{

	public SmoothCamera mSmoothCamera;
	private Constants mConst;
	public SceneManager sceneManager;
	public Resource mRes;
	private Scene mScene;
	private SurfaceScrollDetector mScrollDetector;
	private IabHelper mHelper;
	private String TAG="main";


	private boolean mIsPremium = false;
	private static final String TAG_ENTITY = "entity";

	private static final String ITEM_SKU = "pay";
    static final String SKU_PREMIUM = "pay";
	 static final int RC_REQUEST = 10001;
	protected static final String SCU_LIFE = "life3";
	protected static final int TANK_MAX = 10;
	protected static final String SKU_GAS = null;
	private int mTank;
	public boolean f_man_die = false;

	//-----------------------------------------------------------------------
	@Override
	public Engine onLoadEngine() {
		    //this.getResources().getString(R.string.app_name);
	       
		    mConst  =  Constants.getInstance();
		    mConst.main_activity = this;
		    init_PREFERNCE();
		    DisplayMetrics dm = new DisplayMetrics();
	        getWindowManager().getDefaultDisplay().getMetrics(dm);
            this.mSmoothCamera = new SmoothCamera(0, 0, mConst.CAMERA_WIDTH, mConst.CAMERA_HEIGHT, mConst.WORLD_WIDTH, mConst.WORLD_HEIGHT, 1.0f);
               // mSmoothCamera.setBounds(0, mConst.WORLD_WIDTH, 0, mConst.WORLD_HEIGHT);
               // mSmoothCamera.setBoundsEnabled(true); 
               EngineOptions engineOptions =   new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(mConst.CAMERA_WIDTH, mConst.CAMERA_HEIGHT), this.mSmoothCamera);
                             engineOptions.setNeedsSound(true);
                             engineOptions.setNeedsMusic(true);
                            // engineOptions.setn.setNeedsMultiTouch(true);
                            //engineOptions.getTouchOptions().m.setNeedsMultiTouch(true);
                            // engineOptions.getTouchOptions().
                             //engineOptions.getTouchOptions().setNeedsMultiTouch(true);
                             //engineOptions.getRenderOptions().getRenderOptions().setDithering(true); 
                             engineOptions.getRenderOptions().disableExtensionVertexBufferObjects();
                             mSmoothCamera.setMaxVelocityX(1);
                           //  mSmoothCamera.setm
        final Engine mEngine = new Engine(engineOptions);
        this.mEngine = mEngine;
        mConst.mEngine = this.mEngine;
        try {
			if(MultiTouch.isSupported(this)) {
				mEngine.setTouchController(new MultiTouchController());
				if(MultiTouch.isSupportedDistinct(this)) {
				//	Toast.makeText(this, "MultiTouch detected --> Drag multiple Sprites with multiple fingers!", Toast.LENGTH_LONG).show();
				} else {
					//Toast.makeText(this, "MultiTouch detected --> Drag multiple Sprites with multiple fingers!\n\n(Your device might have problems to distinguish between separate fingers.)", Toast.LENGTH_LONG).show();
				}
			} else {
				//Toast.makeText(this, "Sorry your device does NOT support MultiTouch!\n\n(Falling back to SingleTouch.)", Toast.LENGTH_LONG).show();
			}
		} catch (final MultiTouchException e) {
		//	Toast.makeText(this, "Sorry your Android Version does NOT support MultiTouch!\n\n(Falling back to SingleTouch.)", Toast.LENGTH_LONG).show();
		}

        
	        return mEngine;
	}

	
	
	 // Вызывается перед выходом из "активного" состояния
    @Override
    public void onPause(){
        // "Замораживает" пользовательский интерфейс, потоки 
        // или трудоемкие процессы, которые могут не обновляться, 
        // пока Активность не находится на переднем плане.
    	//mRes.mysound.stop();
    	if(mRes !=null)mRes.mysound.pause();
        super.onPause();
    }
    @Override
    public void onResume() {
    	 super.onResume();
    	Log.v(TAG,"onResume");
    	if(mRes !=null && Constants.getInstance().SOUND_ON==1)mRes.mysound.play();
    }
    // Вызывается перед тем, как Активность перестает быть "видимой".
    @Override
    public void onStop(){
        // "Замораживает" пользовательский интерфейс, потоки 
        // или операции, которые могут подождать, пока Активность
        // не отображается на экране. Сохраняйте все введенные
        // данные и изменения в UI так, как будто после вызова
        // этого метода процесс должен быть закрыт.
    	//mRes.mysound.stop();
        super.onStop();
    }

	//--------------------------------------------------------------------------
	@Override
	public void onLoadResources() {
		sceneManager = new SceneManager(this, mEngine, mSmoothCamera);
		sceneManager.loadSplashResources();
		 mRes  = Resource.getInstance();
		 mRes.onLoadResources(this ,this.mEngine );
	}
	
	//------------------------------------------------------------------------------

	@Override
	public Scene onLoadScene() {
	    this.mEngine.registerUpdateHandler(new FPSLogger());
        this.mScene =    sceneManager.createSplashScene();
       
		sceneManager.setRes(mRes);
        this.mScrollDetector = new SurfaceScrollDetector(this);
        this.mScrollDetector.setEnabled(true);
        
   
	
        return this.mScene;
	}

	//----------------------------------------------------------------------------------
	@Override
	public void onLoadComplete() {
	/*
	 *  МУЗЫКА	
	 */
		mRes.mysound.setLooping(true);
		mRes.mysound.setVolume(0.9f);
	
   	 
   	 /*
   	  * 
   	  */
     mEngine.registerUpdateHandler(new TimerHandler(3f,
				new ITimerCallback() {

					@Override
					public void onTimePassed(TimerHandler pTimerHandler) {
						Log.v("GAME","onTimePassed ");
						mEngine.unregisterUpdateHandler(pTimerHandler);
						sceneManager.createMenuScene();
						sceneManager.setCurrentScene(AllScenes.MENU);
						//sceneManager.setCurrentScene(AllScenes.GAME);
					}
				}));
		
	}

	@Override
	public void onScroll(ScrollDetector pScollDetector, TouchEvent pTouchEvent,
			float pDistanceX, float pDistanceY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			ITouchArea pTouchArea, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		return false;
	}


	/*
	 * --------------------------------------------------------------------------
	 * PERFERENCE
	 * 
	 */
	private void init_PREFERNCE() {
		SharedPreferences mSettings = getSharedPreferences("SETTING", Context.MODE_PRIVATE);
		mConst.COIN = mSettings.getInt(mConst.COIN_NAME, 0);
		
		mConst.COL_HEART = mSettings.getInt(mConst.HEART_NAME, 3);
		mConst.COL_HUMMER = mSettings.getInt(mConst.HUMMER_NAME, 1);
     	mConst.COL_SNOW = mSettings.getInt(mConst.SNOW_NAME, 1);
     	mConst.LEVEL =  mSettings.getInt(mConst.LEVEL_NAME, 1);
     	mConst.LIFE_CURRENT =mSettings.getInt("LIFE_CURRENT", 100);
     	
     	//mConst.SOUND_ON
     	mConst.SOUND_ON =mSettings.getInt("SOUND_ON", 1);
     	mConst.MUSIC_ON =mSettings.getInt("MUSIC_ON", 1);
     	Log.v("MAIN","mConst.LEVEL ="+mConst.LEVEL);
     	init_bye();
	}
	public void updateByeParam() {
		
		    Log.v("MAIN","updateByeParam()");
		    //SharedPreferences.Editor spe = getPreferences(MODE_PRIVATE).edit();
		    SharedPreferences mSettings = getSharedPreferences("SETTING", Context.MODE_PRIVATE);
		    Editor spe = mSettings.edit();
		    
		    spe.putInt(mConst.COIN_NAME, mConst.COIN);
		    spe.commit();
		    
		  
			
		//	editor.putInt(APP_PREFERENCES_COUNTER, game.map);
		//	editor.commit();
		    spe.putInt(mConst.HEART_NAME, mConst.COL_HEART);spe.commit();
		    
		    spe.putInt(mConst.HUMMER_NAME, mConst.COL_HUMMER);spe.commit();
		
		    spe.putInt(mConst.SNOW_NAME, mConst.COL_SNOW);spe.commit();
	}
	//-------------------------------------------------------------------------------------







	public void KILL_ZOMBIE() {
		if(f_man_die == true) return;

		mConst.KILLED_ZOMBIE++;
		Log.v("MAIN","KILL_ZOMBIE()");
		
		
		if( (mConst.ZOMBIE_COL ==mConst.KILLED_ZOMBIE)) {
			   Log.v("MAIN","KILL_ZOMBIE()   PLAYER WIN! mConst.SELECTED_MAP="+mConst.SELECTED_MAP +" mConst.LEVEL="+mConst.LEVEL );
			// ЕСЛИ ИГРОК ВЫИГРАЛ
			/*
			 * НЕ ПРАВИЛЬНО! ЭТА ФУНКЦИ НЕ ДОЛЖНА БЫТЬ ЗДЕСЬ!
			 */
			
			
		    if(mConst.SELECTED_MAP ==  mConst.LEVEL) {
		    	mConst.LEVEL+=1;
		    	mConst.SELECTED_MAP = mConst.LEVEL;
		    }else {
		    	mConst.SELECTED_MAP+=1;
		    }
			SharedPreferences mSettings = getSharedPreferences("SETTING", Context.MODE_PRIVATE);
			Editor editor = mSettings.edit();
			// УРОВЕНЬ
			editor.putInt(mConst.LEVEL_NAME, mConst.LEVEL);
			
			// ЖИЗНЬ
			editor.putInt(mConst.HEART_NAME, Constants.getInstance().COL_HEART2);
			editor.putInt("LIFE_CURRENT", Constants.getInstance().LIFE_CURRENT2);
			Constants.getInstance().LIFE_CURRENT =Constants.getInstance().LIFE_CURRENT2;
			Constants.getInstance().COL_HEART =Constants.getInstance().COL_HEART2;
			// УБИТЫХ ЗОМБИ
			
			// МОНЕТЫ
			//mConst.COIN += mConst.KILLED_ZOMBIE;
			mConst.KILLED_ZOMBIE = 0;
			editor.putInt(mConst.COIN_NAME, mConst.COIN);
			
			
			 editor.commit();
		
			 mEngine.registerUpdateHandler(new TimerHandler(1f,
						new ITimerCallback() {

							@Override
							public void onTimePassed(TimerHandler pTimerHandler) {
							
								mEngine.unregisterUpdateHandler(pTimerHandler);
								 Dialog.getInstance().GamerWin();
							}
						}));
			 this.sceneManager.ms3.updateLevels();
			
			this.runOnUiThread(new Runnable() {
		        @Override
		        public void run() {
		        mConst.F_ENEMY_END = false;
			//	Toast.makeText(main.this, "Игра закончилась!", Toast.LENGTH_SHORT).show();
				
				
		        }
		    });
		}
		
	}





/*
 * СОХРАНЯЕМ ЗВУК
 */

	public void setSound(int i) {
		SharedPreferences mSettings = getSharedPreferences("SETTING", Context.MODE_PRIVATE);
		Editor editor = mSettings.edit();
		// УРОВЕНЬ
		editor.putInt("SOUND_ON", mConst.SOUND_ON);
		editor.commit();
		
	}
	
	public void setSound2(int i) {
		SharedPreferences mSettings = getSharedPreferences("SETTING", Context.MODE_PRIVATE);
		Editor editor = mSettings.edit();
		// УРОВЕНЬ
		editor.putInt("MUSIC_ON", mConst.MUSIC_ON);
		editor.commit();
		
	}

	
	
	
	
	
public void init_bye(){
	Log.v(TAG,"init_bye()");
	mHelper = new IabHelper(this, mConst.base64EncodedPublicKey);
	// включаем дебагинг (в релизной версии ОБЯЗАТЕЛЬНО выставьте в false)
	mHelper.enableDebugLogging(false);
	mHelper.startSetup(new  IabHelper.OnIabSetupFinishedListener() {
	   	        public void onIabSetupFinished(IabResult result) 
	             {
	                   if (!result.isSuccess()) {
	                           Log.v(TAG, "In-app Billing setup failed: " + result);
	           } else {        Log.v(TAG, "In-app Billing is set up OK");
               }
	         }
	});
}




public void bye(){
	 Log.v(TAG,"bye()");
	 String payload = "deen812";
	 Log.v(TAG, "НАЧИНАЕМ ПОКУПКУ.");
     /*
      * для безопасности сгенерьте payload для верификации. В данном
      * примере просто пустая строка юзается. Но в реальном приложение
      * подходить к этому шагу с умом.
      */
     mHelper.launchPurchaseFlow(this, SCU_LIFE, RC_REQUEST,mPurchaseFinishedListener, payload);
     
}//----------------------------------------------------------



// Does the user have an active subscription to the infinite gas plan?
boolean mSubscribedToInfiniteGas = false;


// Вызывается по завершении выполнения запроса купленных продуктов в магазине.     
// Создаем новый экземпляр класса  
//IabHelper.QueryInventoryFinishedListener 
IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
	
	public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
        Log.v(TAG, " 441 Query inventory finished.");
      
       
        // Have we been disposed of in the meantime? If so, quit.
        if (mHelper == null) return;

        // Is it a failure?
        if (result.isFailure()) {
            complain("Failed to query inventory: " + result);
            return;
        }

        Log.d(TAG, "Query inventory was successful.");

        /*
         * Check for items we own. Notice that for each purchase, we check
         * the developer payload to see if it's correct! See
         * verifyDeveloperPayload().
         */

        // Do we have the premium upgrade?
        /*
         * Проверяются покупки. Обратите внимание, что надо проверить каждую
         * покупку, чтобы убедиться, что всё норм! см.
         * verifyDeveloperPayload().
         */

       
        Purchase premiumPurchase = inventory.getPurchase(SKU_PREMIUM);
        
        mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
        Log.d(TAG, "User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));
        if( mIsPremium ) {
        	
        	 // пользователь купил приложение!
        	 // сохраняем данные
        	 
        }
        
        
      
    /*    
        // Do we have the infinite gas plan?
        Purchase infiniteGasPurchase = inventory.getPurchase(SCU_LIFE);
        mSubscribedToInfiniteGas = (infiniteGasPurchase != null &&verifyDeveloperPayload(infiniteGasPurchase));
        Log.v(TAG, "User " + (mSubscribedToInfiniteGas ? "HAS" : "DOES NOT HAVE") + " infinite gas subscription.");
        
        if (mSubscribedToInfiniteGas) { mTank = TANK_MAX;
      //      mConst.COL_HEART = TANK_MAX;
        }
*/
        // Check for gas delivery -- if we own gas, we should fill up the tank immediately
        Purchase gasPurchase = inventory.getPurchase(SCU_LIFE);
        if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
            Log.v(TAG, "We have gas. Consuming it.");
            mHelper.consumeAsync(inventory.getPurchase(SCU_LIFE), mConsumeFinishedListener);
            return;
        }

       // updateUi();
        setWaitScreen(false);
        Log.d(TAG, "Initial inventory query finished; enabling main UI.");
     
    }

	private boolean verifyDeveloperPayload(Purchase premiumPurchase) {
		// TODO Auto-generated method stub
		return true;
	}
};

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
    if (mHelper == null) return;

    // Pass on the activity result to the helper for handling
    if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
        // not handled, so handle it ourselves (here's where you'd
        // perform any handling of activity results not related to in-app
        // billing...
        super.onActivityResult(requestCode, resultCode, data);
    }
    else {
        Log.d(TAG, "onActivityResult handled by IABUtil.");
    }
}


/*
 * вызывается после успешной покупки
 */
IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
    
	public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
        Log.v(TAG, " 537 Покупка завершена: Purchase finished: " + result + ", purchase: " + purchase);
        
        // if we were disposed of in the meantime, quit.
        if (mHelper == null) return;

        if (result.isFailure()) {
        	 Log.v(TAG, " 543 Покупка завершена: result.isFailure()");
     //   	 mHelper.consumeAsync(purchase, mConsumeFinishedListener);
            complain("ОШИБКА: " + result);
            setWaitScreen(false);
            return;
        }
        if (!verifyDeveloperPayload(purchase)) {
            complain("Error purchasing. Authenticity verification failed.");
           // setWaitScreen(false);
            return;
        }

        Log.v(TAG, "Успех !        Purchase successful.");

        if (purchase.getSku().equals(SKU_GAS)) {
            // bought 1/4 tank of gas. So consume it.
           // Log.d(TAG, "Purchase is gas. Starting gas consumption.");
        //    
        }
        else if (purchase.getSku().equals(SKU_PREMIUM)) {
            // bought the premium upgrade!
            Log.d(TAG, "Purchase is premium upgrade. Congratulating user.");
            alert("Thank you for upgrading to premium!");
            mIsPremium = true;
          //  updateUi();
         //   setWaitScreen(false);
        }
        else if (purchase.getSku().equals(SCU_LIFE)) {
            Log.v(TAG,"Купили жизнь!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            mHelper.consumeAsync(purchase, mConsumeFinishedListener);

        }
    }
};

/*
 * Вызывается при завершении  процедуры подтверждения расходования продукта магазином     
 * // Создаем новый экземпляр класса IabHelper.OnConsumeFinishedListener и определяем в нем      
 * // метод onConsumeFinished    
 *  IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {       
 *    public void onConsumeFinished(Purchase purchase, IabResult result) {           
 *      Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);            
 *        // Мы знаем, что "gas" это единственный продукт потребляемый в нашем приложении,             
 *        // но если в вашем приложении более одного потребляемого продукта,           
 *          // то имеет смысл тут установить проверку на идентификатор продукта.           
 *            if (result.isSuccess()) {               
 *              // Потребление продукта прошло успешно.               
 *                // Активируем логику приложения и заправим наш танк.                
 *                 Log.d(TAG, "Consumption successful. Provisioning.");               
 *                   mTank = mTank == TANK_MAX ? TANK_MAX : mTank + 1;                
 *                    // Сохраняем данные о танке.                 
 *                    saveData();               
 *                      // Сообщаем пользователю, на сколько заполнен бак его танка                
 *                       alert("You filled 1/4 tank. Your tank is now " + String.valueOf(mTank) + "/4 full!");           
 *                         } else {                
 *                          // Иначе сообщаем пользователю об ошибке         
 *                                 complain("Error while consuming: " + result);          
 *                                    }           
 *                                      // Обновляем графический интерфейс приложения            
 *                                       updateUi();           
 *   // Отключаем заставку ожидания данных в программе.            
 *    setWaitScreen(false);          
 *       Log.d(TAG, "End consumption flow.");       
 *         }   
 *           }; 
 */


IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
    public void onConsumeFinished(Purchase purchase, IabResult result) {
        Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);
        if (mHelper == null) return;

        if (result.isSuccess()) {
        	 // Потребление продукта прошло успешно.               
             // Активируем логику приложения и заправим наш танк.
             saveData();
             alert("Вы купили  100 монет! можете обменять их на жизнь!");
           // alert("You filled 1/4 tank. Your tank is now " + String.valueOf(mTank) + "/4 full!");
        }
        else {
            complain("Error while consuming: " + result);
        }

       // updateUi();
     //   setWaitScreen(false);
      //  Log.d(TAG, "End consumption flow.");
    }
};



/** Verifies the developer payload of a purchase. */
boolean verifyDeveloperPayload(Purchase p) {
    String payload = p.getDeveloperPayload();

    /*
     * TODO: verify that the developer payload of the purchase is correct. It will be
     * the same one that you sent when initiating the purchase.
     *
     * WARNING: Locally generating a random string when starting a purchase and
     * verifying it here might seem like a good approach, but this will fail in the
     * case where the user purchases an item on one device and then uses your app on
     * a different device, because on the other device you will not have access to the
     * random string you originally generated.
     *
     * So a good developer payload has these characteristics:
     *
     * 1. If two different users purchase an item, the payload is different between them,
     *    so that one user's purchase can't be replayed to another user.
     *
     * 2. The payload must be such that you can verify it even when the app wasn't the
     *    one who initiated the purchase flow (so that items purchased by the user on
     *    one device work on other devices owned by the user).
     *
     * Using your own server to store and verify developer payloads across app
     * installations is recommended.
     */

    return true;
}
// Enables or disables the "please wait" screen.
void setWaitScreen(boolean set) {
   // findViewById(R.id.screen_main).setVisibility(set ? View.GONE : View.VISIBLE);
   // findViewById(R.id.screen_wait).setVisibility(set ? View.VISIBLE : View.GONE);
}

void complain(String message) {
    Log.e(TAG, "**** TrivialDrive Error: " + message);
    alert("Error: " + message);
}
void alert(String message) {
   // AlertDialog.Builder bld = new AlertDialog.Builder(this);
   // bld.setMessage(message);
  //  bld.setNeutralButton("OK", null);
    Log.d(TAG, "Showing alert dialog: " + message);
  //  bld.create().show();
}

void saveData() {
Log.v(TAG,"saveData()");
    /*
     * WARNING: on a real application, we recommend you save data in a secure way to
     * prevent tampering. For simplicity in this sample, we simply store the data using a
     * SharedPreferences.
     */

    SharedPreferences.Editor spe = getPreferences(MODE_PRIVATE).edit();
	//..mConst.COIN = mSettings.getInt(mConst.COIN_NAME, 0);
    mConst.COIN+=100;
    spe.putInt(mConst.COIN_NAME, mConst.COIN);
    spe.commit();
    Constants.getInstance().BYE_SCENE.update_coin();
  //  Log.d(TAG, "Saved data: tank = " + String.valueOf(mTank));
}

void loadData() {
  //  SharedPreferences sp = getPreferences(MODE_PRIVATE);
   // mTank = sp.getInt("tank", 2);
   // Log.d(TAG, "Loaded data: tank = " + String.valueOf(mTank));
}



	
}//enf class

