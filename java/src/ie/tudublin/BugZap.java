package ie.tudublin;

import javazoom.jl.player.Player;
import processing.core.PApplet;



public class BugZap extends PApplet {
	public void settings() {
		size(1000, 1000);
	}

	public void setup() {
		size(1000,1000);
		playerX = width /2;
		playerY = height /2;
		bugY = height/3;
	}


	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			//System.out.println("Left arrow pressed");
		
			if  (playerX >playerWidth/2){
				playerX -= 10;
			}
		}
		if (keyCode == RIGHT)
		{
			//System.out.println("Right arrow pressed");
			if (playerX <width- playerWidth/2){
				playerX +=10;
			}
		}
		if (key == ' ')
		{
			//System.out.println("SPACE key pressed");
			drawLaser(playerX,playerY);
		}
		
	}
	public  void drawLaser(float x, float y){
		stroke(255,0,0);
		line(x,y,x,0);

	}
	
	void moveBug() {
		bugX += bugSpeed;
		if (bugX > width + bugwidth / 2) {
			bugX = -bugwidth / 2;
			bugY = random(height);
		}
	}
	
	int gameMode = 0;
	int score = 0;


	public void draw() {
		background(0);
		drawPlayer(playerX, playerY,playerWidth);
		drawBug(bugX,bugY, bugwidth);
		moveBug();
		fill(255);
		textSize(32);
		text("Frame Count: " + frameCount, 20, 20);
		text("Score: " + score, 20, 50);

		if (frameCount % 60 == 0) {
			text("One second has passed!", width/2, height/2);
		}

		if (laserhit(playerX, playerY,bugX,bugY,bugwidth)){
			score++;
			bugX = -bugwidth/2;
			bugY = random(height);
		}

	}
	boolean laserhit(float playerX,float playerY,float bugX,float bugY, float bugwidth){
		float halfBugWidth = bugwidth / 2;
		
		if (bugY > 0 && bugY < playerY && bugY > playerY - playerWidth / 8 && bugX > playerX - halfBugWidth && bugX < playerX + halfBugWidth) {
			return true; // Collision detected
		}
		
		return false; // No collision
	}
	
	public void drawPlayer(float x, float y, float w) {
		rectMode(CENTER);
		noFill(); 
		stroke(255);
		rect(x, y, w, w / 4); 
	}
	
	public void drawBug(float x, float y, float w){
		float halfWidth = w / 2;
		float halfHeight = w / 4;
		
		fill(0, 255, 0);
		triangle(x, y - halfHeight, x - halfWidth, y + halfHeight, x + halfWidth, y + halfHeight);
		
	}

	float playerX;
	float playerY;
	float playerWidth = 40;
	float bugX = 0;
	float bugY = 0;
	float bugwidth = 30;
	float bugSpeed = 2;

	
}
