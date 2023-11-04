package com.deen812.zombie.object;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.LineJoint;
import com.badlogic.gdx.physics.box2d.joints.LineJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

import com.deen812.zombie.Constants;
import com.deen812.zombie.main;
import com.deen812.zombie.scene.GameScene;

public class Z1 {

	
	
	
	

	private PhysicsWorld mPhysicsWorld;
	private Scene mScene;
	private main game;
	private AnimatedSprite head_spr;
	private Body head_body;
	private Constants mConst;
	private AnimatedSprite body_spr;
	private Body body_body;
	private Body hand_body;
	private Body hand_body_left;
    private Body selected_body_hook;
	private Vector2 vectorHook;
	private Vector2 vectorHookLeft;
	private Vector2 vectorHookRight;
	private float powerHook= 500;
	private float x;
	private float y;
	private int move_to;
	private IUpdateHandler moveHandler;
	protected float x_step = 3;
	private boolean f_moved;
	private IUpdateHandler mainUpdateHandler;
	private int jumpForceY = 150;
	private int jumpForceX = 100;
	private int napX ;
	private Man man;
	private RevoluteJoint head_body_joint;
	private TimerHandler timerh;
	private boolean f_died = false;
	private Body body_leg1;
	private Sprite leg1;
	private Sprite leg2;
	private Body body_leg2;
	private RevoluteJoint leg1_body_joint;
	private RevoluteJoint leg2_body_joint;;
	 ;
	/*
	 * 
	 */
	public Z1(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) {
		this.mScene = mScene2.mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.game = game;
		this.man = mScene2.man;
		this.x = x;
		this.y = y;
		mConst = Constants.getInstance();
		head_spr = new AnimatedSprite(x,y,game.mRes.man_head.clone() );
		
		head_spr.animate( new long[] {1000,500 ,1000,500} , new int[] {0,1,2,3} , -1);
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(10f, 0.1f, 1f );
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
		head_spr.setCullingEnabled(true);
		
		
  head_body = PhysicsFactory.createBoxBody(mPhysicsWorld, head_spr, BodyType.DynamicBody, objectFixtureDef2);
         mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(head_spr, head_body, true, true));  
      //   head_body.setFixedRotation(true);
         head_body.setUserData(this);
         
         create_body();
         create_hang();
         mScene.attachChild(head_spr);
         
         vectorHookRight = new Vector2(powerHook,0);
         vectorHookLeft  = new Vector2(-powerHook,0);
         vectorHook = new Vector2();
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
       /*
       mainUpdateHandler = new IUpdateHandler() {  
			 @Override  
             public void onUpdate(float arg0) { Update(); }  

           @Override  
            public void reset() {   }  
         };
        mScene.registerUpdateHandler(mainUpdateHandler);
        */
       float time = (float) (Math.random()*5+1);
    timerh =    new TimerHandler(time,true, new ITimerCallback(){

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
                       
				 Update();
			}
			   
		   });
  	mScene.registerUpdateHandler(timerh);
	}
	
	
	/*
	 * 
	 * 
	 */
	//------------------------- ГЛАВНЙ ЦИКЛ ОБЬЕКТА ------------------
	protected void Update() {
	//	sprLeg.animate(new long[] {200,200,200} ,new int[] {0,1,2},0);
		if(this.man.getX()  < this.head_spr.getX()){
			napX=-1;
		}else napX = 1;
		body_body.applyLinearImpulse(new Vector2(napX*jumpForceX,-jumpForceY), body_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		
	}
	//------------------------------------------------

	private void create_hang() {
		
		
          
          
          
  
         
	}
	

	private void create_body() {
		body_spr = new AnimatedSprite( this.x , this.y,game.mRes.man_body.clone() );
		body_spr.setCullingEnabled(true);
		mScene.attachChild(body_spr);
		//head_spr.animate( new long[] {1000,500 ,1000,500} , new int[] {0,1,2,3} , -1);
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(10f, 0.3f, 0.3f );
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
        //objectFixtureDef2.filter.groupIndex=2;
       // objectFixtureDef2.filter.categoryBits = 0x08;
       // objectFixtureDef2.filter.maskBits=0x07;
         body_body = PhysicsFactory.createBoxBody(mPhysicsWorld, body_spr, BodyType.DynamicBody, objectFixtureDef2);
         mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(body_spr, body_body, true, true));  
         body_body.setFixedRotation(true);
         body_body.setUserData(this);
         
         // крепим ГОЛОВУ И ТЕЛО
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
	       revoluteJointDef.localAnchorB.add(new Vector2(0f,  - body_spr.getHeight()/70 ));
	       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
	       revoluteJointDef.enableMotor = true;
	       
	       head_body_joint = (RevoluteJoint)mPhysicsWorld.createJoint(revoluteJointDef);
	       
	       
	     
			       
		       
	}

	public void set_position( float x , float y) {
		body_body.setTransform(x, y, 0);
	}
	
	

	public void hook() {
		this.hand_body.applyLinearImpulse( vectorHook, hand_body.getWorldCenter());
	}
	
	public void zashita() {
		
	}
	
	
	public void sitdown() {
		
	}
	
	public void jump() {
		this.hook();
		
	}
	
	
	public void to_left() {
		vectorHook = vectorHookLeft;
		//selected_body_hook = this.hand_body_left;
		this.head_spr.getTextureRegion().setFlippedHorizontal(false);
		this.body_spr.getTextureRegion().setFlippedHorizontal(false);
		
		if(move_to == 1) {
			
		}
		x_step  = -0.1f;
         if(f_moved == false) {
        	 f_moved = true;
		     mScene.registerUpdateHandler(moveHandler); 
         }
		
	}
	
	public void key_up() {
		f_moved = false;
		mScene.unregisterUpdateHandler(moveHandler);
	}
	public void to_right() {
		x_step  = 0.1f;
		vectorHook = vectorHookRight;
		//selected_body_hook = this.hand_body_right;
		this.body_body.applyLinearImpulse(new Vector2( 1000 , 0), body_body.getWorldCenter());
		this.head_spr.getTextureRegion().setFlippedHorizontal(true);
		this.body_spr.getTextureRegion().setFlippedHorizontal(true);
		  if(f_moved == false) {
	        	 f_moved = true;
			     mScene.registerUpdateHandler(moveHandler); 
	         }
	}


	public void man_contact() {
	
		if(f_died  == false){
			f_died = true;
			mScene.unregisterUpdateHandler(timerh);
			this.body_body.setFixedRotation(false);
			 mScene.registerUpdateHandler(new IUpdateHandler() {  
					
					@Override  
		           public void onUpdate(float arg0) { 
						mScene.unregisterUpdateHandler(this);
						mPhysicsWorld.destroyJoint(head_body_joint);
				         }  

		         @Override  
		          public void reset() {   }  
		       });  

			 
			 
			
	  
		}
       // mPhysicsWorld.destroyJoint(leg_body_joint);
		
	}
	
	
	
	
	
	
	
	
	
	  /*
    // LEGS
    final FixtureDef objectFixtureDef3 = PhysicsFactory.createFixtureDef(10f, 0.3f, 0.3f );
		     objectFixtureDef3.filter.categoryBits = 0x04;
		     objectFixtureDef3.filter.maskBits = 0x0A;
		  //   objectFixtureDef3.filter.groupIndex=2;
		  //   objectFixtureDef3.filter.categoryBits = 0x08;
		  //   objectFixtureDef3.filter.maskBits=0x07;
       leg1 = new Sprite( this.x-100 , this.y,game.mRes.z1_leg.clone() );
       leg2 = new Sprite( this.x , this.y,game.mRes.z1_leg.clone() );
       body_leg1 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg1, BodyType.DynamicBody, objectFixtureDef3);
      mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg1, body_leg1, true, true));
     
      
      body_leg2 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg2, BodyType.DynamicBody, objectFixtureDef3);
      mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg2, body_leg2, true, true));
      
      body_leg1.setUserData(this);
      body_leg2.setUserData(this);
      //body_spr.attachChild(leg1);
     // body_spr.attachChild(leg2);
      mScene.attachChild(leg1);
      mScene.attachChild(leg2);
     
      RevoluteJointDef  revoluteJointDef1 = new RevoluteJointDef();
      revoluteJointDef1.bodyA =body_leg1; //первое тело соединения
      revoluteJointDef1.bodyB = body_body; //второе тело соединения
  
	       revoluteJointDef1.collideConnected = false; //тела не сталкиваются
	      // revoluteJointDef.motorSpeed = -10f;
	     //  revoluteJointDef.maxMotorTorque=10f;
	       revoluteJointDef1.enableLimit = true;
	       //-45 * Math.PI / 180; //нижний предел
	       revoluteJointDef1.referenceAngle =(float) (-180* Math.PI/180f);
	       revoluteJointDef1.upperAngle =  (float) (5* Math.PI/180f);;
	       revoluteJointDef1.lowerAngle = - (float) (5* Math.PI/180f);;
	       revoluteJointDef1.localAnchorA.add(new Vector2(0, -leg1.getHeight()/60));//.obtain(0,0);
	       revoluteJointDef1.localAnchorB.add(new Vector2(body_spr.getWidth()/60,  body_spr.getHeight()/60 ));
	       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
	      // revoluteJointDef.enableMotor = true;
	       
	       leg1_body_joint = (RevoluteJoint)mPhysicsWorld.createJoint(revoluteJointDef1);
	       
	   
	       RevoluteJointDef revoluteJointDef2 = new RevoluteJointDef();
	         revoluteJointDef2.bodyA =body_leg2; //первое тело соединения
	         revoluteJointDef2.bodyB = body_body; //второе тело соединения
	     
		       revoluteJointDef2.collideConnected = false; //тела не сталкиваются
			      // revoluteJointDef.motorSpeed = -10f;
			     //  revoluteJointDef.maxMotorTorque=10f;
			      revoluteJointDef2.enableLimit = true;
			       //-45 * Math.PI / 180; //нижний предел
			       revoluteJointDef2.referenceAngle =(float) (-180* Math.PI/180f);
			       revoluteJointDef2.upperAngle = (float) (5* Math.PI/180f);;
			       revoluteJointDef2.lowerAngle = -(float) (5* Math.PI/180f);;
			       revoluteJointDef2.localAnchorA.add(new Vector2(0, -leg1.getHeight()/60));//.obtain(0,0);
			       revoluteJointDef2.localAnchorB.add(new Vector2(-body_spr.getWidth()/60,  body_spr.getHeight()/60 ));
		       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
		     //  revoluteJointDef.enableMotor = true;
		       
		      leg2_body_joint = (RevoluteJoint)mPhysicsWorld.createJoint(revoluteJointDef2);
		    */
	
}//end
