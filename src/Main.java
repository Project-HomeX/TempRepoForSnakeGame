import processing.core.PApplet;
/**
 * Main class where the game starts running.
 *
 */
public class Main extends PApplet {
	Snake snake;
	Food food;
	boolean flagU;
	boolean flagD;
	boolean flagR = true;
	boolean flagL;
	//
	float scl = 20;
	int speed = 5;
	//I'm unable to use this. (gutama)
	/*
	// keeping track of which direction the snake is going
	// it starts going to the right
	//[up,down,right,left]
	boolean[] direc = {false,false,true,false};
	*/
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	//how wide the window is. (600X600)
	public void settings() {
		size(600, 600);
	}
	//Where the game starts loading
	public void setup() {	
		frameRate(speed);
		snake = new Snake(this);
		food = new Food(this);		
	}
	//this is a loop method... it loads every U second (I don't know the exact second so a called it U). 
	public void draw() {
		background(0);
		fill(255);
		stroke(126);
		//un comment this to see a grid.
		/*
		for (int i = 0; i < 600; i+=20) {
			line(0,i,600,i);
		}
		for (int i = 0; i < 600; i+=20) {
			line(i,0,i,600);
		}
		*/
		food.show();
		snake.show();
		snake.update();
		//this is a built in collision ditection in Processing. So don't worry about it.
		collision();
	}
	public void collision(){
		float r = dist(food.getX(),food.getY(),snake.getX(),snake.getY());
		if(r<5){
			food.update();
		}
	}
	/**
	 * flagU,flagR... stuff is to prevent opposite direction movement. 
	 * some one else has written this one better
	 *
	 **/
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
	
	//while this is much more beautiful it does not work properly for me. (gutama)
	/*
	@Override 
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP && !direc[1]) {
				up();
			} else if (keyCode == DOWN && !direc[0]) {
				down();
			}else if (keyCode == RIGHT && !direc[3]) {
				right();
			}
			else if (keyCode == LEFT && !direc[2]){
				left();
			} 
		}

	}
	private void up() {
		snake.dir(0,-20);
		boolean[] temp = {true,false,false,false};
		direc = temp;
	}
	private void down() {
		snake.dir(0,20);
		boolean[] temp = {false,true,false,false};
		direc = temp;

	}
	private void right() {
		snake.dir(20,0);
		boolean[] temp = {false,false,true,false};
		direc = temp;

	}
	private void left() {
		snake.dir(-20,0);
		boolean[] temp = {false,false,false,true};
		direc = temp;
}
*/
}
