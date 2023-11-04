package com.deen812.zombie.object;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.AnimatedSprite.IAnimationListener;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;
import org.anddev.andengine.util.MathUtils;

import android.content.Entity;
import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.LineJoint;
import com.badlogic.gdx.physics.box2d.joints.LineJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;


import com.deen812.zombie.Constants;
import com.deen812.zombie.main;

public class Man {

	
	
	
	

	private PhysicsWorld mPhysicsWorld;
	private Scene mScene;
	private main game;
	public AnimatedSprite head_spr;
	private Body head_body;
	private Constants mConst;

	private Body body_body;
	private Body hand_body;
	private Body hand_body_left;
    private Body selected_body_hook;
	private Vector2 vectorHook;
	private Vector2 vectorHookLeft;
	private Vector2 vectorHookRight;
	private float powerHook= 500;
	private float powerHookLeg= 1500;
	private float x;
	private float y;
	private int move_to = 1;
	private IUpdateHandler moveHandler;
	protected float x_step = 10;
	private boolean f_moved = false;
	private boolean f_hook_nad = true;
	private AnimatedSprite leg_spr;
	//private AnimatedSprite body_spr2;
	private Rectangle body_rect;
	private AnimatedSprite hand_r;
	private AnimatedSprite hand_l;
	private Sprite body;
	public boolean canJump = true;
	public boolean canJump2 = false;
	private Body leg_body;
	private Vector2 vectorHookLegLeft;
	private Vector2 vectorHookLegRight;
	private Vector2 vectorHookLeg;
	private boolean f_right = false;
	/*


	 * 
	 */
	public Man(float x,float y,final Scene mScene, PhysicsWorld mPhysicsWorld, final main game) {
		this.mScene = mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.game = game;
		this.x = x;
		this.y = y;
		mConst = Constants.getInstance();
		head_spr = new AnimatedSprite(x,y,game.mRes.man_h);
		head_animate();
	//	head_spr.animate( new long[] {1000,500 ,1000,500} , new int[] {0,1,2,3} , -1);
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(10f, 0.1f, 1f );
		   objectFixtureDef2.filter.groupIndex=2;
	        objectFixtureDef2.filter.categoryBits = 0x08;
	        objectFixtureDef2.filter.maskBits=0x07;
              head_body = PhysicsFactory.createBoxBody(mPhysicsWorld, head_spr, BodyType.DynamicBody, objectFixtureDef2);
         mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(head_spr, head_body, true, true));  
      //   head_body.setFixedRotation(true);
         head_body.setUserData(this);
  
         //game.mSmoothCamera.setChaseEntity(head_spr);
       //  game.mSmoothCamera.get
         create_body();
         create_leg();
         create_hang();
       
         
         vectorHookRight = new Vector2(powerHook,0);
         vectorHookLeft  = new Vector2(-powerHook,0);
         vectorHookLegRight = new Vector2(powerHookLeg,0);
         vectorHookLegLeft  = new Vector2(-powerHookLeg,0);
         vectorHook = new Vector2();
         vectorHookLeg = new Vector2();
         final float cw2 = mConst.CAMERA_WIDTH/2;
         final float cw = mConst.WORLD_WIDTH -mConst.CAMERA_WIDTH/2;
         
         
         // ПРИКРЕПЛЯЕМ КАМЕРУ
          mScene.registerUpdateHandler(new IUpdateHandler() {  
		@Override  
          public void onUpdate(float arg0) { 
			if(head_spr.getX() > cw2 && (head_spr.getX() < cw ))
			//	if(head_spr.getY() < 300) {
			//		game.mSmoothCamera.setCenterDirect(head_spr.getX(),head_spr.getY()  );
			//	}else {
			//		game.mSmoothCamera.setCenterDirect(head_spr.getX(),game.mSmoothCamera.getCenterY() );
			//	}
			game.mSmoothCamera.setCenterDirect(head_spr.getX(),game.mSmoothCamera.getCenterY() );
	         }  

        @Override  
         public void reset() {   }  
      });
		moveHandler = new IUpdateHandler() {  
			
			@Override  
           public void onUpdate(float arg0) { 
				//mScene.unregisterUpdateHandler(this);
			//	body_body.applyLinearImpulse(new Vector2( -1000 , 0), body_body.getWorldCenter());
				body_body.setTransform(   body_body.getPosition().x + x_step , body_body.getPosition().y, 0);
				
	
		         }  
         @Override  
          public void reset() {   }  
       };
      
       this.to_left();
       this.key_up();
	}
	
	private void create_hang() {
		
		Sprite hand_box = new Sprite(this.x,this.y, game.mRes.hand_box);
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(50f, 0f, 1f );
	    objectFixtureDef2.filter.groupIndex=2;
        objectFixtureDef2.filter.categoryBits = 0x08;
        objectFixtureDef2.filter.maskBits=0x07;
        
         hand_body = PhysicsFactory.createBoxBody(mPhysicsWorld, hand_box, BodyType.DynamicBody, objectFixtureDef2);
         hand_body.getFixtureList().get(0).setUserData("man_hand");
         mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(hand_box, hand_body, true, true));  
        // hand_body.setFixedRotation(true);
         hand_body.getFixtureList().get(0).setUserData("man_hand");
         hand_body.setUserData(new Man_hand());
         hand_body.setBullet(true);
      //   mScene.attachChild(hand_box);
         PrismaticJointDef lineJointDef = new PrismaticJointDef();
         lineJointDef.bodyA = hand_body; //первое тело соединения
         lineJointDef.bodyB =  body_body; //второе тело соединения
         lineJointDef.collideConnected = false; //тела не сталкиваются
         lineJointDef.localAnchorA.add(    new Vector2(0, 0f)   ); //якорная точка первого тела
         lineJointDef.localAnchorB.add(    new Vector2(0, -0.8f)   ); //якорная точка второго тела
         lineJointDef.enableLimit = true; //включаем пределы
         lineJointDef.lowerTranslation = -2f; //нижний предел
         lineJointDef.upperTranslation = 2f; //верхний предел
         mPhysicsWorld.createJoint(lineJointDef);
         
         DistanceJointDef djf = new DistanceJointDef();
         djf.bodyA = hand_body; //первое тело соединения
         djf.bodyB =  head_body; //второе тело соединения
         djf.collideConnected = false; //тела не сталкиваются
         djf.dampingRatio  = 1;
         djf.frequencyHz =1;
         djf.length = 0f; //длина соединения
         mPhysicsWorld.createJoint(djf);
         
         
        // РУКИ 
         hand_r = new AnimatedSprite (14,-3, game.mRes.man_hand_r);
         hand_l = new AnimatedSprite (6,0, game.mRes.man_hand_l);
         body = new Sprite(0,0, game.mRes.man_b);
      //  body_spr2 = new AnimatedSprite(3,-3, game.mRes.man_body_hand);
      //  body_rect.attachChild(body_spr2);
       //  body_spr2.animate(500);
        body_rect.attachChild(hand_r);
        hand_r.setCurrentTileIndex(0);
        hand_l.setCurrentTileIndex(0);
        body_rect.attachChild(body);
        mScene.attachChild(head_spr);
        body_rect.attachChild(hand_l);
     //   body_rect.attachChild(leg_spr);
        body.attachChild(leg_spr); 
	}
	
	
	

	private void create_leg() {
		 leg_spr = new AnimatedSprite( -15 , 58,game.mRes.man_leg );
		
			
		    Rectangle hand_box = new Rectangle(this.x,this.y, 30,10);
			final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(50f, 0f, 0.1f );
		    objectFixtureDef2.filter.groupIndex=2;
	        objectFixtureDef2.filter.categoryBits = 0x08;
	        objectFixtureDef2.filter.maskBits=0x07;
	        
	         leg_body = PhysicsFactory.createBoxBody(mPhysicsWorld, hand_box, BodyType.DynamicBody, objectFixtureDef2);
	         
	         mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(hand_box, leg_body, true, true));  
	        // hand_body.setFixedRotation(true);
	         leg_body.getFixtureList().get(0).setUserData("man_hand");
	         leg_body.setUserData(new Man_hand());
	         leg_body.setBullet(true);
	       // mScene.attachChild(hand_box);
	         PrismaticJointDef lineJointDef = new PrismaticJointDef();
	         lineJointDef.bodyA = leg_body; //первое тело соединения
	         lineJointDef.bodyB =  body_body; //второе тело соединения
	         lineJointDef.collideConnected = false; //тела не сталкиваются
	         lineJointDef.localAnchorA.add(    new Vector2(0, 0f)   ); //якорная точка первого тела
	         lineJointDef.localAnchorB.add(    new Vector2(0, 0.8f)   ); //якорная точка второго тела
	         lineJointDef.enableLimit = true; //включаем пределы
	         lineJointDef.lowerTranslation = -2f; //нижний предел
	         lineJointDef.upperTranslation = 2f; //верхний предел
	         mPhysicsWorld.createJoint(lineJointDef);
	         
	         DistanceJointDef djf = new DistanceJointDef();
	         djf.bodyA = leg_body; //первое тело соединения
	         djf.bodyB =  body_body; //второе тело соединения
	         djf.collideConnected = false; //тела не сталкиваются
	         djf.dampingRatio  = 1f;
	         djf.frequencyHz =1.8f;
	         djf.length = 0f; //длина соединения
	         mPhysicsWorld.createJoint(djf);
		
	}
	private void create_body() {

		body_rect = new Rectangle(this.x , this.y,44,120);
		body_rect.setAlpha(0.0f);
	  	mScene.attachChild(body_rect);
		//head_spr.animate( new long[] {1000,500 ,1000,500} , new int[] {0,1,2,3} , -1);
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(500f, 0f, 0.1f );
        objectFixtureDef2.filter.groupIndex=2;
        objectFixtureDef2.filter.categoryBits = 0x08;
        objectFixtureDef2.filter.maskBits=0x07;
         body_body = PhysicsFactory.createBoxBody(mPhysicsWorld, body_rect, BodyType.DynamicBody, objectFixtureDef2);
         mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(body_rect, body_body, true, true));  
         body_body.setFixedRotation(true);
        // body_body.setUserData(this);
         body_body.getFixtureList().get(0).setUserData("man_body"); 
         RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
         revoluteJointDef.bodyA =head_body; //первое тело соединения
         revoluteJointDef.bodyB = body_body; //второе тело соединения
     
	       revoluteJointDef.collideConnected = false; //тела не сталкиваются
	       revoluteJointDef.motorSpeed = -10f;
	       revoluteJointDef.maxMotorTorque=10f;
	       revoluteJointDef.enableLimit = true;
	       revoluteJointDef.upperAngle = 0.3f;
	       revoluteJointDef.lowerAngle = -0.3f;
	       revoluteJointDef.localAnchorA.add(new Vector2(0f, head_spr.getHeight()/70));//.obtain(0,0);
	       revoluteJointDef.localAnchorB.add(new Vector2(0f,  - body_rect.getHeight()/70 ));
	       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
	       revoluteJointDef.enableMotor = true;
           mPhysicsWorld.createJoint(revoluteJointDef);
       
       
           
     float rect_w = 1;
     float rect_h = 1;
     Rectangle rect = new Rectangle(0,0,rect_w,rect_h);
     rect.setColor(0, (float) 0.8, 2);
     mScene.attachChild(rect);
     final FixtureDef footSensor = PhysicsFactory.createFixtureDef(1, 0, 0);
     footSensor.isSensor = true;
    footSensor.filter.groupIndex=2;
    footSensor.filter.categoryBits = 0x08;
     footSensor.filter.maskBits=0x07;
     Body body_sensor = PhysicsFactory.createBoxBody(mPhysicsWorld, rect, BodyType.DynamicBody, footSensor);
     mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(rect, body_sensor, true, false));  
     body_sensor.setUserData("man_sensor");
     revoluteJointDef = new RevoluteJointDef();
     revoluteJointDef.bodyA =body_sensor; //первое тело соединения
     revoluteJointDef.bodyB = body_body; //второе тело соединения
     revoluteJointDef.collideConnected = false; //тела не сталкиваются
     revoluteJointDef.enableLimit = true;
     revoluteJointDef.upperAngle = 0.1f;
     revoluteJointDef.lowerAngle = -0.1f;
	 revoluteJointDef.localAnchorA.add(new Vector2(0f, -rect.getHeight()/60));//.obtain(0,0);
	 revoluteJointDef.localAnchorB.add(new Vector2(0f,   body_rect.getHeight()/59 ));
     revoluteJointDef.enableMotor = false;
     mPhysicsWorld.createJoint(revoluteJointDef);
           
       /*
           float rect_w = 40;
           float rect_h = 10;
       Rectangle rect = new Rectangle(0,0,rect_w,rect_h);
       rect.setColor(0, (float) 0.8, 2);
       body_rect.attachChild(rect);
      
       // create the bottom sensor
       final FixtureDef footSensor = PhysicsFactory.createFixtureDef(0, 0, 0);
       footSensor.isSensor = true;
       final BodyDef mBodyDef = new BodyDef();
       mBodyDef.type = BodyType.StaticBody;
       mBodyDef.position.x = 0.5f;
       mBodyDef.position.y = body_rect.getY()/30+0.7f;
       final Body mBody = mPhysicsWorld.createBody(mBodyDef);
       final PolygonShape mPoly = new PolygonShape();
       mPoly.setAsBox(rect_w/30, rect_h/30, new Vector2(0,0), 0);
       
       footSensor.shape = mPoly;
       mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(rect, mBody, true, true));  
	   Fixture footSensorFixture = body_body.createFixture(footSensor);
	   String str = "man_sensor";
	   footSensorFixture.setUserData(str);	
	   mBody.setUserData(str);
	   body_body.createFixture(footSensor);
	   */
	  
	}
	/*
	 * УРПАВЛЕНИЕ
	 *          float rect_w = 40;
           float rect_h = 10;
       Rectangle rect = new Rectangle(0,0,rect_w,rect_h);
       rect.setColor(0, (float) 0.8, 2);
       body_rect.attachChild(rect);
      
       // create the bottom sensor
       final FixtureDef footSensor = PhysicsFactory.createFixtureDef(0, 0, 0);
       footSensor.isSensor = true;
       Body body_sensor = PhysicsFactory.createBoxBody(mPhysicsWorld, rect, BodyType.DynamicBody, footSensor);
       mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(rect, body_sensor, true, true));  
       
       revoluteJointDef = new RevoluteJointDef();
       revoluteJointDef.bodyA =body_sensor; //первое тело соединения
       revoluteJointDef.bodyB = body_body; //второе тело соединения
   
	       revoluteJointDef.collideConnected = false; //тела не сталкиваются
	       revoluteJointDef.motorSpeed = -10f;
	       revoluteJointDef.maxMotorTorque=10f;
	       revoluteJointDef.enableLimit = true;
	       revoluteJointDef.upperAngle = 0.3f;
	       revoluteJointDef.lowerAngle = -0.3f;
	       revoluteJointDef.localAnchorA.add(new Vector2(0f, rect.getHeight()/70));//.obtain(0,0);
	       revoluteJointDef.localAnchorB.add(new Vector2(0f,   body_rect.getHeight()/60 ));
	       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
	       revoluteJointDef.enableMotor = true;
         mPhysicsWorld.createJoint(revoluteJointDef);
	 */
	public void set_position( float x , float y) {
		body_body.setTransform(x, y, 0);
	}
	
	
	public void hand_up() {
		hand_r.setRotationCenter(5, 15);
		hand_l.setRotationCenter(5, 15);
		hand_r.setRotation(-90);
		hand_l.setRotation(-80);
	}
	public void hand_down() {
		hand_r.setRotation(0);
		hand_l.setRotation(0);
		
	}

	public void head_animate() {
		head_spr.animate( new long[] {1000,500,1000 ,500,500,500,1000} , new int[] {0,1,0,1,0,1,0} , -1);
	}
	public void hook() {
	//mConst.prg_ctrl.plus();
		this.head_spr.stopAnimation(2);
		//this.head_spr.setCurrentTileIndex(4);
		game.mRes.man_hook.play();
		if(f_hook_nad) {
			f_hook_nad = false;
			hand_r.animate( new long[] {50,50 ,80,50,50} , new int[] {0,1,2,1,0} , 0);
		}else {
			f_hook_nad = true;
			hand_l.animate( new long[] {50,50 ,80,50,50} , new int[] {0,1,2,1,0} , 0);
		}
		
		
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
				
				@Override  
	           public void onUpdate(float arg0) { 
					mScene.unregisterUpdateHandler(this);
					hand_body.applyLinearImpulse( vectorHook, hand_body.getWorldCenter());
					//leg_body
					//leg_body.applyLinearImpulse( vectorHook, hand_body.getWorldCenter());
			         }  

	         @Override  
	          public void reset() {   }  
	       });  

		
	}
	
	
	public void hookLeg() {
		this.head_spr.stopAnimation(2);
		game.mRes.man_hook.play();
if(f_right)  leg_spr.setPosition(-2, leg_spr.getY());
else         leg_spr.setPosition(-30, leg_spr.getY());
		 leg_spr.animate(new long[] {80,100,80}, new int[]{9,10,9}, 0 ,new IAnimationListener() {

		        public void onAnimationStarted(AnimatedSprite pAnimatedSprite,
		                int pInitialLoopCount) {
		        }

		        public void onAnimationLoopFinished(AnimatedSprite pAnimatedSprite,
		                int pRemainingLoopCount, int pInitialLoopCount) {
		        }

				@Override
				public void onAnimationEnd(AnimatedSprite pAnimatedSprite) {
					 leg_spr.setPosition(-15, leg_spr.getY());
					 leg_spr.setCurrentTileIndex(8);
					 head_animate();
					
				}
		    });
		
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
				
				@Override  
	           public void onUpdate(float arg0) { 
					mScene.unregisterUpdateHandler(this);
					//hand_body.applyLinearImpulse( vectorHook, hand_body.getWorldCenter());
					//leg_body
					leg_body.applyLinearImpulse( vectorHookLeg, hand_body.getWorldCenter());
			         }  

	         @Override  
	          public void reset() {   }  
	       });  

		
	}
	
	public void zashita() {
		
	}
	
	
	public void sitdown() {
		
	}
	
	public void jump() {

		if( this.canJump) {
			 canJump = false;
			 Log.v("MAN", "canJump=false");
		 mScene.registerUpdateHandler(new IUpdateHandler() {  			
				@Override  
	           public void onUpdate(float arg0) { 
					mScene.unregisterUpdateHandler(this);					
					body_body.applyLinearImpulse( new Vector2(0,-25000), body_body.getWorldCenter());					
			         }  
	         @Override  
	          public void reset() {   }  
	       }); 
		}
	}

	
	public void to_left() {
		leg_spr.setPosition(-15, leg_spr.getY());
		f_right = false;
		vectorHook = vectorHookLeft;
		vectorHookLeg = vectorHookLegLeft;
		//selected_body_hook = this.hand_body_left;
		this.head_spr.getTextureRegion().setFlippedHorizontal(true);
		this.hand_l.getTextureRegion().setFlippedHorizontal(true);
		this.hand_r.getTextureRegion().setFlippedHorizontal(true);
		this.body.getTextureRegion().setFlippedHorizontal(true);
		
		
		leg_spr.getTextureRegion().setFlippedHorizontal(true);
		
		
		this.hand_l.setPosition(-body.getWidth()/2, hand_l.getY());
		this.hand_r.setPosition(-body.getWidth()/2-20, hand_r.getY());
		//hand_spr_1.getTextureRegion().setFlippedHorizontal(true);
		//hand_spr_1.setPosition(-hand_spr_1.getWidth()/2, hand_spr_1.getY());
		
		//hand_spr_2.getTextureRegion().setFlippedHorizontal(true);
		//hand_spr_2.setPosition(-hand_spr_2.getWidth()/2-3, hand_spr_1.getY());
		
		
		if(move_to == 1) {
			
		}
		x_step  = -0.2f;
         if(f_moved == false) {
        	 f_moved = true;
        	 leg_spr.animate(new long[] {80,80,80,80,80,80,80,80}, new int[]{0,1,2,3,4,5,6,7}, -1);
        	// leg_spr.animate(new long[] {1000,1000,1000,1000,1000,1000,1000,1000}, new int[]{0,1,2,3,4,5,6,7}, -1);
		     mScene.registerUpdateHandler(moveHandler); 
         }
		
	}
	
	public void key_up() {
		f_moved = false;
		mScene.unregisterUpdateHandler(moveHandler);
		head_animate();
		 leg_spr.stopAnimation();
		 leg_spr.setPosition(-15, leg_spr.getY());
		 leg_spr.setCurrentTileIndex(8);
	}
	
	
	
	public void to_right() {
		leg_spr.setPosition(-15, leg_spr.getY());
		x_step  = 0.2f;
		f_right = true;
		vectorHook = vectorHookRight;
		vectorHookLeg = vectorHookLegRight;
		leg_spr.getTextureRegion().setFlippedHorizontal(false);
		//selected_body_hook = this.hand_body_right;
	//	this.body_body.applyLinearImpulse(new Vector2( 1000 , 0), body_body.getWorldCenter());
		this.head_spr.getTextureRegion().setFlippedHorizontal(false);
	//	this.body_spr2.getTextureRegion().setFlippedHorizontal(false);
	//	this.body_spr2.setPosition(0, 0);
		this.body.getTextureRegion().setFlippedHorizontal(false);
		this.hand_l.getTextureRegion().setFlippedHorizontal(false);
		this.hand_r.getTextureRegion().setFlippedHorizontal(false);
		    // hand_r = new AnimatedSprite (14,-3, game.mRes.man_hand_r);
	     //    hand_l = new AnimatedSprite (6,0, game.mRes.man_hand_l);
		hand_r.setPosition(14, -3);
		hand_l.setPosition(6, 0);
	//	hand_spr_1.setPosition(0, 0);
	//	hand_spr_2.getTextureRegion().setFlippedHorizontal(false);
	//	hand_spr_2.setPosition(3, hand_spr_2.getY());
		  if(f_moved == false) {
	        	 f_moved = true;
	        	 leg_spr.animate(new long[] {80,80,80,80,80,80,80,80}, new int[]{0,1,2,3,4,5,6,7}, -1);
			     mScene.registerUpdateHandler(moveHandler); 
	         }
	}

	public void btn_a_down() {
		this.hook();
		
	}

	public float getX() {
		return head_spr.getX();
	}
	public float getY() {
		return head_spr.getY();
	}

	public void btn_b_down() {
		jump();
		
	}


	
	public void die() {
		// TODO Auto-generated method stub
		  body_body.setFixedRotation(false);
	}


	
	
}//end

class ManHand {
	
}
