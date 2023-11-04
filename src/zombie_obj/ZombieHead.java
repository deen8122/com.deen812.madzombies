package zombie_obj;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.deen812.zombie.Constants;
import com.deen812.zombie.Resource;

import android.util.Log;

public class ZombieHead extends Zomb {

	private Body body_HEAD_2;
	private RevoluteJoint RJ_h_h2;
	private Sprite r2;

	public ZombieHead(float x , float y){
	
		this.updateTime = 3;
		this.ManEntity = Constants.getInstance().MAN;
		this.spr_Body = new Sprite(x,y, Resource.getInstance().zh1);
		this.life=200;
		final FixtureDef objectFixtureDef_HEAD = PhysicsFactory.createFixtureDef(50f, 0.8f, 1f);
		objectFixtureDef_HEAD.filter.categoryBits = 0x04;
		objectFixtureDef_HEAD.filter.maskBits = 0x0A;
		//IShape asl = null;
		//asl = new Rectangle(x,y,40,40);
		mScene.attachChild(spr_Body);
		//asl.attachChild(spr_Body);
		
		this.body_HEAD = CreateBody((Sprite)spr_Body,objectFixtureDef_HEAD);
		body_HEAD.getFixtureList().get(0).setUserData("zombiezh"); 
		body_HEAD.setFixedRotation(true);
		 r2 = new Sprite(x,y,Resource.getInstance().zh2);
		//r2.attachChild(this.spr_Body);
		mScene.attachChild(r2);
		this.body_HEAD_2 = CreateBody(r2,objectFixtureDef_HEAD);

	       
	       
		//this.RJ_h_h2 = this.createRevoluteJoint(body_HEAD, body_HEAD_2, new Vector2(asl.getWidth()/65 , asl.getHeight()/65),   new Vector2(r2.getWidth()/65 , -r2.getHeight()/65));
		//CreateHead();
	//	this.life_create((Entity) spr_Body);
		to_left();
	}

	

	@Override
	void Update() {
		//body_HEAD.setTransform(body_HEAD_2.getPosition(), 0);
		body_HEAD.applyLinearImpulse(new Vector2(this.napX*400,-400), body_HEAD_2.getWorldCenter());
		
	}

	@Override
	void to_right() {
		spr_Body.getTextureRegion().setFlippedHorizontal(true);
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
			 private boolean fOne = true;
		

			@Override  
	          public void onUpdate(float arg0) { 
				if(RJ_h_h2 != null) {
				 mPhysicsWorld.destroyJoint(RJ_h_h2);
				}
		         RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
			       revoluteJointDef.bodyA =body_HEAD; //первое тело соединения
			       revoluteJointDef.bodyB = body_HEAD_2; //второе тело соединения
			       revoluteJointDef.collideConnected = false; //тела не сталкиваются
			       revoluteJointDef.motorSpeed = -5f;
			      /// revoluteJointDef.maxMotorTorque=10f;
			      revoluteJointDef.enableLimit = true;
			       revoluteJointDef.upperAngle = 0.2f;
			       revoluteJointDef.lowerAngle = -0.2f;
			       revoluteJointDef.localAnchorA.add( new Vector2(-spr_Body.getWidth()/65 , spr_Body.getHeight()/65) );//.obtain(0,0);
			       revoluteJointDef.localAnchorB.add( new Vector2(-r2.getWidth()/65 , -r2.getHeight()/65));

			       revoluteJointDef.enableMotor = false;
			      RJ_h_h2 =  (RevoluteJoint) mPhysicsWorld.createJoint(revoluteJointDef);
				//}
				 mScene.unregisterUpdateHandler(this);
	          
		         }  

	        @Override  
	         public void reset() {   }  
	      });  
		
	}

	@Override
	void to_left() {
		spr_Body.getTextureRegion().setFlippedHorizontal(false);
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
			 private boolean fOne = true;
		

			@Override  
	          public void onUpdate(float arg0) { 
				if(RJ_h_h2 != null) {
				 mPhysicsWorld.destroyJoint(RJ_h_h2);
				}
		         RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
			       revoluteJointDef.bodyA =body_HEAD; //первое тело соединения
			       revoluteJointDef.bodyB = body_HEAD_2; //второе тело соединения
			       revoluteJointDef.collideConnected = false; //тела не сталкиваются
			       revoluteJointDef.motorSpeed = -5f;
			      /// revoluteJointDef.maxMotorTorque=10f;
			      revoluteJointDef.enableLimit = true;
			       revoluteJointDef.upperAngle = 0.2f;
			       revoluteJointDef.lowerAngle = -0.2f;
			       revoluteJointDef.localAnchorA.add( new Vector2(spr_Body.getWidth()/65 , spr_Body.getHeight()/65) );//.obtain(0,0);
			       revoluteJointDef.localAnchorB.add( new Vector2(r2.getWidth()/65 , -r2.getHeight()/65));

			       revoluteJointDef.enableMotor = false;
			      RJ_h_h2 =  (RevoluteJoint) mPhysicsWorld.createJoint(revoluteJointDef);
				//}
				 mScene.unregisterUpdateHandler(this);
		       }  

	        @Override  
	         public void reset() {   }  
	      });  
		   
	}

	@Override
	public  void beginContact(float f) {
	//	Log.v("ZH","beginContact");
		if(this.life < 0)return ;
		this.life-=f;
		if(this.life<0) {
			die();
			die2();
		}
		
	}



	private void die2() {
		game.mRes.uuu.play();
		body_HEAD.getFixtureList().get(0).setUserData("died");
		body_HEAD.setFixedRotation(false);
	    mScene.registerUpdateHandler(new IUpdateHandler() {  
			 private boolean fOne = true;
			@Override  
	          public void onUpdate(float arg0) { 
				if(fOne ){

					// mPhysicsWorld.destroyJoint(RJ_h_h2);
					 fOne = false;
  
				}
	          
	          
	          time_life --;
	          if(time_life < 0){
	          	  mScene.detachChild(r2);
	        	mScene.detachChild(spr_Body);
	        	//  mScene.detachChild(sprLeg);
	        	//  mScene.detachChild(sprHand1);
	        	//  mScene.detachChild(sprHand2);
	 
		        //Bulava_bd
	             mPhysicsWorld.destroyBody(body_HEAD);
	             mPhysicsWorld.destroyBody(body_HEAD_2);
		  //       mPhysicsWorld.destroyBody(dog_body);
		         //mPhysicsWorld.destroyBody(bdBody);
		        // mPhysicsWorld.destroyBody(bdLeg);
		         mScene.unregisterUpdateHandler(this);
		         Constants.getInstance().life_ctrl.PlusZombieKill();
	          }
		         }  

	        @Override  
	         public void reset() {   }  
	      });  
	     
		
	}
}
