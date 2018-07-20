import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends PApplet {
	Snake s;
	Food f;
	float scl = 20;
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		// fill(120,50,240);
		background(0);
		s = new Snake(this,scl);
		f = new Food(this,10,scl);
		frameRate(10);
	}

	public void draw() {
		background(51);
		s.update();
		s.show();
		f.show();
		if(collision()){
			
		}
	}
	public boolean collision(){
		//if(Snake.)
		return true;
	}
	/*
	 * @Override public void keyPressed() { // TODO Auto-generated method stub
	 * super.keyPressed(); if(keyCode == UP_ARROW){
	 * 
	 * } }
	 */
	@Override 
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				s.dir(0,-5);
			} else if (keyCode == DOWN) {
				s.dir(0,5);
			}else if (keyCode == RIGHT) {
				s.dir(5,0);
			}
			else if (keyCode == LEFT) {
				s.dir(-5,0);
			} 
		}

	}
}