package zombie_obj;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.shape.IShape;
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
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.deen812.zombie.Constants;
import com.deen812.zombie.main;


  public abstract class Zomb {
	  
	  public int life = 100;
	  public Constants mConst;
	  public int life_step;

	  public Layer LifeLayer;
private Rectangle lr2;
public Scene mScene;
public PhysicsWorld mPhysicsWorld;
public main game;
public int time_life = 100;
public Sprite spr_Body;
public Entity ManEntity;
public float updateTime = 1;
public TimerHandler  timerh ;
public float x=0;
public float y=0;
private Body body_head;
public Body body_HEAD;
public int napX;
public Zomb() {

	this.mConst = Constants.getInstance();
	this.mScene = Constants.getInstance().CURRENT_SCENE;
	this.game = this.mConst.main_activity;
	this.mPhysicsWorld = this.mConst.mPhysicsWorld;
   
	
    timerh =    new TimerHandler(updateTime,true, new ITimerCallback(){

 			@Override
 			public void onTimePassed(TimerHandler pTimerHandler) {
 				//Log.v("Zomb","ManEntity.getX()="+ManEntity.getX() +" spr_Body.getX()="+spr_Body.getX());
 				if(ManEntity.getX()  < spr_Body.getX()){
                      to_left();
                      napX=-1;
 				}else {
 				      to_right();
 				     napX=1;
 				}   
 				 Update();
 			}
 			   
 		   });
      	mScene.registerUpdateHandler(timerh); 


}

protected Body CreateBody(IShape head_aspr, FixtureDef objectFixtureDef_HEAD) {
	Body body_head = PhysicsFactory.createBoxBody(mPhysicsWorld, head_aspr, BodyType.DynamicBody, objectFixtureDef_HEAD);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(head_aspr, body_head, true, true));
	 body_head.setUserData(this);
	 body_head.getFixtureList().get(0).setUserData("zombie");
	 return body_head;
}


public void CreateHead(){
	final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(100f, 0.1f, 1f);
	objectFixtureDef2.filter.categoryBits = 0x04;
	objectFixtureDef2.filter.maskBits = 0x0A;
	
	 Rectangle head_aspr = new Rectangle(x , y , 30,30);
		// animate1() ;
		  this.mScene.attachChild(head_aspr);   
		 body_head = PhysicsFactory.createBoxBody(mPhysicsWorld, head_aspr, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(head_aspr, body_head, true, true));
		 body_head.setUserData(this);
		 body_head.getFixtureList().get(0).setUserData("zombie");
       
}
public void createBody(Sprite body_rec){
	final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(100f, 0.1f, 1f);
	objectFixtureDef2.filter.categoryBits = 0x04;
	objectFixtureDef2.filter.maskBits = 0x0A;
	
	 Body rect_body = PhysicsFactory.createBoxBody(mPhysicsWorld, body_rec, BodyType.DynamicBody, objectFixtureDef2);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(body_rec, rect_body, true, true));
	 rect_body.setUserData(this);
	 rect_body.setFixedRotation(true);
	 rect_body.getFixtureList().get(0).setUserData("zombie");
}
abstract void to_right();
abstract void to_left();
abstract void Update();


protected RevoluteJoint createRevoluteJoint(Body bdLeg12, Body bdLeg22,
		Vector2 vector2, Vector2 vector22 ,ConfigZomb cfz) {
	//	 bdLeg.setFixedRotation(true);
	 //КРЕПИМ НОГИ К ТЕЛУ
	RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
       revoluteJointDef.bodyA =bdLeg12; //первое тело соединения
       revoluteJointDef.bodyB = bdLeg22; //второе тело соединения
       revoluteJointDef.collideConnected = false; //тела не сталкиваются
      // revoluteJointDef.motorSpeed = -5f;
      /// revoluteJointDef.maxMotorTorque=10f;
      // revoluteJointDef.enableLimit = true;
      // revoluteJointDef.upperAngle = 0.2f;
       //revoluteJointDef.lowerAngle = -0.2f;
       revoluteJointDef.localAnchorA.add( vector2 );//.obtain(0,0);
       revoluteJointDef.localAnchorB.add( vector22);

       revoluteJointDef.enableMotor = false;
       return (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);

}

protected RevoluteJoint createRevoluteJoint(Body bdLeg12, Body bdLeg22,
		Vector2 vector2, Vector2 vector22 ) {
	//	 bdLeg.setFixedRotation(true);
	 //КРЕПИМ НОГИ К ТЕЛУ
	RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
       revoluteJointDef.bodyA =bdLeg12; //первое тело соединения
       revoluteJointDef.bodyB = bdLeg22; //второе тело соединения
       revoluteJointDef.collideConnected = false; //тела не сталкиваются
      // revoluteJointDef.motorSpeed = -5f;
      /// revoluteJointDef.maxMotorTorque=10f;
      // revoluteJointDef.enableLimit = true;
      // revoluteJointDef.upperAngle = 0.2f;
       //revoluteJointDef.lowerAngle = -0.2f;
       revoluteJointDef.localAnchorA.add( vector2 );//.obtain(0,0);
       revoluteJointDef.localAnchorB.add( vector22);

       revoluteJointDef.enableMotor = false;
       return (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);

}



protected void die() {
	mScene.unregisterUpdateHandler(timerh);//registerUpdateHandler(timerh); 
	
}
protected void life_create(Entity body_rec){
	Rectangle lr1 = new Rectangle(0,0,50,10);
	lr1.setColor(0,0,1);
	
	 lr2 = new Rectangle(0,0,50,10);
	 lr2.setColor(0,1,0);

	 life_step = this.life/50;
	 LifeLayer = new Layer();
	 LifeLayer.attachChild(lr1);
	 LifeLayer.attachChild(lr2);
	 LifeLayer.setPosition(0, -80);
	 body_rec.attachChild(LifeLayer);
	 
	 
}

protected void minus_life(){
	lr2.setWidth(this.life/life_step);
}
public void Contact(int power){
	
}

public abstract void beginContact(float f);


class ConfigZomb{
	public ConfigZomb() {}
}
}

