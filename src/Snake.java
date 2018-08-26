import processing.core.PApplet;
/**
 * Snake class 
 * @author Gutama Abadig
 *
 */
public class Snake {
	float x = 0;
	float y = 0; 
	float xspeed = 10;
	float yspeed = 0;
	PApplet parrent;
	public Snake(PApplet p) {
		// TODO Auto-generated constructor stub
		this.x = 0;
		this.y = 0;
		this.xspeed = 20;
		this.yspeed = 0;
		parrent = p;
	}
	/**
	 * update the snakes location.
	 */
	public void update(){
		this.x = x+ xspeed;
		this.y = y+yspeed;	
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	/**
	 show the updated snake at its now location. 
	 */
	public void show(){
		parrent.fill(204, 102, 0);
		parrent.rect(x,y,20,20);
	}
	public void dir(float x, float y){
		//if((x<0 && xspeed>0) || (y<0 && yspeed > 0))
			xspeed = x*20;
			yspeed = y*20;
	}
}
