package com.deen812.zombie;

public class MapManager {

public	MapManager() {
	
}
	
public void initMap() {  }

	
private static final LevelDef[] AvailableLevels = new LevelDef[] {
	//--- 1 --------------------------------------------------------------------------------
	/*
	 * œŒÀ»√ŒÕ
	 */
	//new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,60)}, "bg1"),
	
	//new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,60)}, "bg1"),
	
	//new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Dog,60)}, "bg1"),
	
//new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,60)}, "bg1"),
	
	//new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,60)}, "bg1"),
	
//	new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,60)}, "bg1"),

//	new LevelDef(1,new EnemiesInLevelDef[] {new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,60)}, "bg1"),
	
	//--- 1 -----------------------------------------------------------------------------------
		new LevelDef(
		        1,
				new EnemiesInLevelDef[] {	        		
		        	new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
		        	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		        	new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
				        "bg1"),
				        
				        
//--- 2 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
    	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
    	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
    	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg2"),	
	
//--- 3 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg1"),	
		
//--- 4 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,3),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg2"),
//--- 5 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie2,7),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
	new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg1"),	
		
//--- 6 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie2,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie2,2),
		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg1"),	
		
//--- 7 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,3),
	 new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg2"),	
		
//--- 8 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg1"),	
		
//--- 9 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,10),
		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
		new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg1"),	
		
//--- 10 -----------------------------------------------------------------------------------
new LevelDef(1,new EnemiesInLevelDef[] {	
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
		new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
	    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
"bg1"),	
			

				        
	
















								        
	
	
//--- 11 -----------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {	        		
	        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
	        		new EnemiesInLevelDef(400f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),        		
	        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
	        		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
			        "bg1"),

//--- 12 -----------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,10),new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
	        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,2),new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,2),
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Dog,1),new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Dog,1),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
	        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
	        		new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,5),new EnemiesInLevelDef(400f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(400f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(500f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1)},
			        "bg1"
			),
	//--- 13 --------------------------------------------------------------------------------
		new LevelDef(
		        1,
				new EnemiesInLevelDef[] {
		        		new EnemiesInLevelDef(50f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(700f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
		        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,4),new EnemiesInLevelDef(700f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
		        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),new EnemiesInLevelDef(400f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
		        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
		        		new EnemiesInLevelDef(400f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),new EnemiesInLevelDef(750f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1)},
				        "bg_home"),
		//--- 14 --------------------------------------------------------------------------------
		new LevelDef(
		        1,
				new EnemiesInLevelDef[] {
		        		new EnemiesInLevelDef(50f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
		        		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
		        		new EnemiesInLevelDef(700f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),		        		
		        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
		        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,8),
		        		
		        		new EnemiesInLevelDef(700f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
		        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
		        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),
		        		new EnemiesInLevelDef(750f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
		        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
				        
		        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
				        new EnemiesInLevelDef(750f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
				        new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
						new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
		        		
						new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
		        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),
		        		new EnemiesInLevelDef(800f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
		        		new EnemiesInLevelDef(800f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
				        new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2)},
				        "bg_home"

				)
		,
		
	//--- 15 --------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		new EnemiesInLevelDef(50f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(700f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		
	        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
	        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,8),
	        		new EnemiesInLevelDef(700f, 400f, EnemiesInLevelDef.EnemyType.Dog,1),
	        		
	        		new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
	        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
	        		new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
	        		new EnemiesInLevelDef(400f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
	        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),
	        		
	        		new EnemiesInLevelDef(750f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
	        		new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
			        new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Zombie,1),
			        
	        		new EnemiesInLevelDef(800f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(800f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
			        new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
					new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
	        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
	        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie2,5),
	        		new EnemiesInLevelDef(500f, 300f, EnemiesInLevelDef.EnemyType.Zombie2,5),
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,5),	
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.Zombie,3),	
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.Dog,3),	
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.Zombie,3),	
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.Zombie,3)
			        }
	        ,
	        "bg_home"
			)
	
	
	/*
	 * 
	 * ---------------------------------------------------------------------------------------------------
	 * ¬“Œ–¿ﬂ ◊¿—“‹  ¿–“€
	 */
	
	
	
	
	
	
	
	,
	//--- 16 --------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.Zombie,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,3),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,4),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,1),
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,5),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		
			        }
	        ,
	        "bg_home"
			)
	
	
	
	
	,
	//--- 17 --------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,10),		        
			        
			        new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1),
			        new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1),
			        new EnemiesInLevelDef(700f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1),
			        new EnemiesInLevelDef(800f, 0f, EnemiesInLevelDef.EnemyType.Zombie,6),
			        
			        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1)}
	        ,
	        "bg_home"
			)
	
	
	
	
	,
	//--- 18 --------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,5),		        
			        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1),
			        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  10),
	        		new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  10),
	        		new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  10),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		
	        		new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  10),
	        		new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  10)}
	        ,
	        "bg_home"
			)
,
	//--- 19 --------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,15),	new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,5),new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.Boss2,5),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.Boss2,5), new EnemiesInLevelDef(600, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1)}
	        ,
	        "bg_home"
			),
			/*
			 * ÕŒ¬€… –¿«ƒ≈À
			 */
			
	
			
			
			
			
			
			
			
			
			
//--- 20 --------------------------------------------------------------------------------
			new LevelDef(
			        1,
					new EnemiesInLevelDef[] {
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,15),	
			        		
			        		
					        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1)}
			        ,
			        "bg_home"
					)
	
	,
	//--- 21 --------------------------------------------------------------------------------
	new LevelDef(
	        1,
			new EnemiesInLevelDef[] {
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
	        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
	        		
	        		
			        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1)}
	        ,
	        "bg_home"
			),
			
			
			
			
			//--- 22 --------------------------------------------------------------------------------
			new LevelDef(
			        1,
					new EnemiesInLevelDef[] {
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,15),	
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.Boss2,10),
			        		
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
			        		
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.Boss2,10),
			        		
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
			        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
			        		
			        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
			        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
			        		
			        		
					        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1)}
			        ,
			        "bg_home"
					),
					
					
					
					
					
					//--- 23 --------------------------------------------------------------------------------
					new LevelDef(
					        1,
							new EnemiesInLevelDef[] {
					        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,15),	
					        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
					        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,10),
					        		
					        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
					        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
					        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
					        		
					        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
					        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
					        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
					        		
					        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
					        		
					        		new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
					        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
					        		
					        		
							        new EnemiesInLevelDef(300, 0f, EnemiesInLevelDef.EnemyType.ZBoss1,  1)}
					        ,
					        "bg_home"
							),

/*
 * 
 */
							//--- 24 -----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
								new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
				        		new EnemiesInLevelDef(200f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
				        		new EnemiesInLevelDef(300f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
				        		new EnemiesInLevelDef(400f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
				        		new EnemiesInLevelDef(500f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,10),
				        		
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
							"bg1"),	
									
							
							//--- 25 -----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
							"bg1"),	
									
							
							
							//--- 26 -----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
								new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
								new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
								new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
							"bg1"),	
									
							
							
							
							//--- 27-----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Dog,5),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
								  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
								  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
								  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
								  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
							"bg1"),	
									
							
							
							
							//--- 28 -----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),

									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.ZomieHead,1)},
							"bg1"),	
									
							
							
							
							//--- 29 -----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,3),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Dog,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,5),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,5),
								  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZomieHead,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.ZBoss1,2),
								  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Zombie,1)},
							"bg1"),	
									
							
							
							
							//--- 30-----------------------------------------------------------------------------------
							new LevelDef(1,new EnemiesInLevelDef[] {	
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
								new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
								new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,5),
								new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Zombie,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Boss2,3),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,2),
							  	new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Boss2,2),
							  	new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
							  	new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,2),
									new EnemiesInLevelDef(100f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
									new EnemiesInLevelDef(200f, 400f, EnemiesInLevelDef.EnemyType.Boss2,2),
									new EnemiesInLevelDef(300f, 400f, EnemiesInLevelDef.EnemyType.Boss2,5),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,2),
									new EnemiesInLevelDef(600f, 400f, EnemiesInLevelDef.EnemyType.Boss2,2),
								    new EnemiesInLevelDef(100f, 0f, EnemiesInLevelDef.EnemyType.Boss2,1)},
							"bg1"),	
									
							
							
		
	
	
};


































// ====================================================
// CLASSES
// ====================================================
public static class EnemiesInLevelDef {
	public enum EnemyType {
		Normal,Zombie,ZBoss1, Zombie2, Zombie3, Dog, Boss2, ZomieHead
	}
	public final float mX;
	public final float mY;
	public final EnemyType mEnemyType;
	public float time = 1;
	
	public EnemiesInLevelDef(final float pX, 
			                 final float pY, 
			                 final EnemyType pEnemyType,
			                 final float nextsecond) {
		mX = pX;
		mY = pY;
		mEnemyType = pEnemyType;
		this.time = nextsecond;
	}
}
public static class LevelDef {
public final EnemiesInLevelDef[] Enemies;
public final String bg;
	
	public LevelDef(final float pWidth, 
			        final EnemiesInLevelDef[] pEnemies,
			        final String bg) 
	{
		this.Enemies = pEnemies;
		this.bg = bg;

	}
	

}
public LevelDef GetLevel(int i) {
	
	return this.AvailableLevels[i];
	
}






}


