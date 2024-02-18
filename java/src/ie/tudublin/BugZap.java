package ie.tudublin;

import javazoom.jl.player.Player;
import processing.core.PApplet;



public class BugZap extends PApplet {
	public void settings() {
		size(1000, 1000);
	}

	public void setup() {
<<<<<<< HEAD
		size(1000,1000);
		playerX = width /2;
		playerY = height /2;
		bugY = height/3;
=======
		reset();
>>>>>>> 2af1570ee2c65d4f62c233661c3acf77a8b4a816
	}

	float playerX, playerY;
	float playerSpeed = 5;
	float playerWidth = 40;
	float halfPlayerWidth = playerWidth / 2;

<<<<<<< HEAD
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
=======
	float bugX, bugY, bugWidth = 100;
	float halfBugWidth = bugWidth / 2;

	int score = 0;

	void reset() {
		resetBug();
		playerX = width / 2;
		playerY = height - 50;
	}

	void resetBug() {
		bugX = random(halfBugWidth, width - halfBugWidth);
		bugY = 50;
	}

	void drawBug(float x, float y) {
		// Draw the bug
		stroke(255);
		float saucerHeight = bugWidth * 0.7f;
		line(x, y - saucerHeight, x - halfBugWidth, y);
		line(x, y - saucerHeight, x + halfBugWidth, y);
		// line(x - halfBugWidth, y, x - halfBugWidth, y);
		line(x - halfBugWidth, y, x + halfBugWidth, y);
		float feet = bugWidth * 0.1f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		feet = bugWidth * 0.3f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		float eyes = bugWidth * 0.1f;
		line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
		line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);

	}

	void drawPlayer(float x, float y, float w) {
		stroke(255);
		float playerHeight = w / 2;
		line(x - halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight);
		line(x - halfPlayerWidth, y + playerHeight, x - halfPlayerWidth, y + playerHeight * 0.5f);
		line(x + halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight * 0.5f);

		line(x - halfPlayerWidth, y + playerHeight * 0.5f, x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x + halfPlayerWidth, y + playerHeight * 0.5f, x + (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);

		line(x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f, x + (halfPlayerWidth * 0.8f),
				y + playerHeight * 0.3f);

		line(x, y, x, y + playerHeight * 0.3f);

	}

	public void keyPressed() {
		
		if (keyCode == LEFT) {
			if (playerX > halfPlayerWidth) {
				playerX -= playerSpeed;
			}
		}
		if (keyCode == RIGHT) {
			if (playerX < width - halfPlayerWidth) {
				playerX += playerSpeed;
>>>>>>> 2af1570ee2c65d4f62c233661c3acf77a8b4a816
			}
		}
		if (keyCode == ' ')
		{
<<<<<<< HEAD
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
=======
			if (playerX > bugX - halfBugWidth && playerX < bugX + halfBugWidth)
			{
				line(playerX, playerY, playerX, bugY);
				score ++;
				resetBug();
			}
			else
			{
				line(playerX, playerY, playerX, 0);
			}
		}
	}

	void moveBug() {
		if ((frameCount % 30) == 0) {
			bugX += random(-5, 5);
			if (bugX < halfBugWidth) {
				bugX = halfBugWidth;
			}
			if (bugX > width - halfBugWidth) {
				bugX = width - halfBugWidth;
			}
			bugY += 2;
>>>>>>> 2af1570ee2c65d4f62c233661c3acf77a8b4a816
		}
	}
	
	int gameMode = 0;
	int score = 0;

<<<<<<< HEAD

	boolean laserhit(float playerX, float playerY, float bugX, float bugY, float bugwidth) {
		float halfBugWidth = bugwidth / 2;
	
		if (bugY > 0 && bugY < playerY && bugX > playerX - halfBugWidth && bugX < playerX + halfBugWidth) {
			return true; // Collision detected
		}
	
		return false; // No collision
=======
	public void draw() {
		background(0);
		fill(255);
		text("Score: " + score, 50, 100);
		if (gameMode == 0)
		{
			fill(255);
			drawPlayer(playerX, playerY, playerWidth);
			drawBug(bugX, bugY);
			moveBug();

			text("Score: " + score, 20, 20);
		}
		else
		{
			textAlign(CENTER, CENTER);
			text("GAME OVER!!!", width / 2, height / 2);
		}

		if (bugY > height - 50)
		{
			gameMode = 1;
		}

>>>>>>> 2af1570ee2c65d4f62c233661c3acf77a8b4a816
	}
	
	public void draw() {
		background(0);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugwidth);
		moveBug();
		fill(255);
		textSize(32);
		text("Frame Count: " + frameCount, 20, 20);
		text("Score: " + score, 20, 50);
	
		if (frameCount % 60 == 0) {
			text("One second has passed!", width/2, height/2);
		}
	
		// Check if the laser hits the bug and increment the score
		if (keyPressed && key == ' ') {
			if (laserhit(playerX, playerY, bugX, bugY, bugwidth)) {
				score++;
				bugX = -bugwidth / 2;
				bugY = random(height);
			}
		}
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
