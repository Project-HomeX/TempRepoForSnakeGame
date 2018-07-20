import processing.core.PApplet;

/**
 * Food class that has a scale of 20
 *
 */
public class Food {
	float x;
	float y;
	float scl = 20;
	PApplet p;
	public Food(PApplet p, float x, float y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.p = p;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void show(){
		p.fill(255);
		p.rect(x, y, scl, scl);
	}
	public void clear(){
		
	}
}