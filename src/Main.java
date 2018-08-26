import processing.core.PApplet;
/**
 * Main class where the game starts running.
 * 
 * @author GUTIBSITU
 *
 */
public class Main extends PApplet {
	Snake snake;
	Food food;
/*	float fx = floor(random(600/20))*20;
	float fy = floor(random(600/20))*20;*/
	boolean flagU;
	boolean flagD;
	boolean flagR;
	boolean flagL;
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	//how wide the window is. (600X600)
	public void settings() {
		size(600, 600);
	}
	//Where the game starts loading
	public void setup() {	
		frameRate(10);
		snake = new Snake(this);
		food = new Food(this);		
	}
	//this is a loop method... it loads every U second (I don't know the exact second so a called it U). 
	public void draw() {
		background(0);
		fill(255);
		stroke(126);
		for (int i = 0; i < 600; i+=10) {
			line(0,i,600,i);
		}
		for (int i = 0; i < 600; i+=10) {
			line(i,0,i,600);
		}
		//this is a built in collision ditection in Processing. So don't worry about it.
		food.show();
		snake.show();
		snake.update();
		coll();
	}
	public void coll(){
		float r = dist(food.getX(),food.getY(),snake.getX(),snake.getY());
		if(r<5){
			food.update();
		}
	}
	/**
	 * flagU,flagR... stuff is to prevent opposite direction movement. 
	 * some one else has written this one better
	 */
	@Override 
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP && flagU==false) {
					snake.dir(0,-1);
					flagR = false;
					flagL = false;
					flagD = true;
			} else if (keyCode == DOWN && flagD == false) {
				snake.dir(0,1);
				flagR = false;
				flagL = false;
				flagU = true;
			}else if (keyCode == RIGHT && flagR == false) {
				snake.dir(1,0);
				flagD = false;
				flagU = false;
				flagL = true;
			}
			else if (keyCode == LEFT && flagL == false) {
				snake.dir(-1,0);
				flagD = false;
				flagU = false;
				flagR = true;
			}
		}
	}
}
