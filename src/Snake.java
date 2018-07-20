import processing.core.PApplet;

/**
 * The Player class that is a 20x20 snake
 *
 */
public class Snake {
	float x = 10;
	float y = 10; 
	float xspeed = 5;
	float yspeed = 0;
	float scl = 20;
	PApplet parrent;
	public Snake(PApplet p, float scl) {
		// TODO Auto-generated constructor stub
		this.scl = scl;
		parrent = p;
		this.x = p.width/2;
		this.y = p.height/2;
	}
	public void update(){
		x = x+ xspeed;
		y = y+yspeed;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void show(){
		parrent.fill(255);
		parrent.rect(x,y,scl,scl);
	}
	public void dir(int x, int y){
		xspeed = x;
		yspeed = y;
	}
}