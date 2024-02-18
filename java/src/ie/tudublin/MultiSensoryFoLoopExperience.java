<<<<<<< HEAD
package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;

    Minim minim;
    AudioOutput out;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        colorMode(HSB, 360, 255, 255);
        fill(60, 360, 360);
    }

    public void draw() {
        background(0);
        stroke(255);
        switch (mode) {
            case 0:
                background(0); 

                
                float distance = dist(mouseX, mouseY, width / 2, height / 2);

               
                float diameter = map(distance, 0, width / 2, 20, 200);

               
                fill(60,255,0); 
                ellipse(width / 2, height / 2, diameter, diameter); 
                break;

            case 1:
                for (int i = 0; i < 10; i++) {
                    float hue = map(i, 0, 9, 0, 255);
                    fill(hue, 255, 360);
                    float rectWidth = 80;
                    float rectHeight = 800;
                    float x = i * rectWidth;
                    float y = height / 2 - rectHeight / 2;

                    noStroke();
                    rect(x, y, rectWidth, rectHeight);
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    float hue = map(i, 0, 9, 85, 170);
                    float saturation = 255;
                    float brightness = map(i, 0, 9, 50, 255);
                    fill(hue, saturation, brightness);
                    float rectWidth = 80;
                    float rectHeight = 800;
                    float x = i * rectWidth;
                    float y = height / 2 - rectHeight / 2;

                    noStroke();
                    rect(x, y, rectWidth, rectHeight);
                }
                break;
            case 3:
                background(0);

                int numSquares = 10;
                float squareSize = width / numSquares;

                // color progression from red to pink
                float[] hueProgression = { 0, 30, 60, 120, 150, 180, 210, 240, 300, 330 };

                // (top-left to bottom-right)
                for (int i = 0; i < numSquares; i++) {
                    float x = i * squareSize;
                    float y = map(i, 0, numSquares, 0, height);

                    // Brightness decreases as we go down
                    float brightness = map(i, 0, numSquares, 255, 100); // Bright to Dark

                    // color based on the hue progression
                    float hue = hueProgression[i];
                    fill(hue, 255, brightness);
                    noStroke(); // Remove the border
                    rect(x, y, squareSize, squareSize);
                }

                // (top-right to bottom-left)
                for (int i = 0; i < numSquares; i++) {
                    float x = width - i * squareSize;
                    float y = map(i, 0, numSquares, 0, height);

                    // Brightness decreases as we go down
                    float brightness = map(i, 0, numSquares, 255, 100);

                    float hue = hueProgression[i];
                    fill(hue, 255, brightness);
                    noStroke(); // Remove the border
                    rect(x - squareSize, y, squareSize, squareSize);
                }
                break;
            case 4:
                background(0);

                int numCircles = 20;
                float centerX = width / 2; // Center of the screen
                float centerY = height / 2;
                float maxRadius = min(width, height) / 2;

                noStroke();

                for (int i = numCircles; i > 0; i--) {
                    float radius = map(i, 0, numCircles, 0, maxRadius);
                    float hue = map(radius, 0, maxRadius, 60, 280); // Map hue from yellow to purple
                    float saturation = 255; // Maximum saturation
                    float brightness = 255; // Maximum brightness

                    fill(hue % 360, saturation, brightness);
                    ellipse(centerX, centerY, radius * 2, radius * 2);
                }
                break;
            case 5:
                background(0);

                int numCirclesLine = 10;
                float circleSpacing = width / (numCirclesLine + 1);
                float circleDiameter = circleSpacing;
                float circleY = height / 2;

                for (int i = 1; i <= numCirclesLine; i++) {
                    // Map hue from red to blue
                    float hue = map(i, 1, numCirclesLine, 0, 240);
                    float saturation = 255; // Maximum saturation
                    float brightness = 255; // Maximum brightness

                    fill(hue, saturation, brightness);
                    noStroke();

                    float circleX = i * circleSpacing;
                    ellipse(circleX, circleY, circleDiameter, circleDiameter);
                }
                break;
            case 6:
                background(0);

                numCirclesLine = 10; // Number of circles in each horizontal line
                int numLines = 10; // Number of horizontal lines
                circleSpacing = width / (numCirclesLine + 1); // Spacing between circles
                circleDiameter = circleSpacing; // Diameter of each circle

                for (int j = 1; j <= numLines; j++) {
                    for (int i = 1; i <= numCirclesLine; i++) {
                        // Map hue from red to blue diagonally
                        float hue = map(i + j, 2, numCirclesLine + numLines + 1, 0, 240);
                        float saturation = 255; // Maximum saturation
                        float brightness = 255; // Maximum brightness

                        fill(hue, saturation, brightness);
                        noStroke(); // Remove stroke

                        float circleX = i * circleSpacing;
                        circleY = j * circleSpacing;
                        ellipse(circleX, circleY, circleDiameter, circleDiameter);
                    }
                }
                break;
            case 7:
                background(0);
                strokeWeight(1);
                stroke(300);

                // vertical lines
                for (int i = -5; i <= 5; i++) {
                    float x = map(i, -5, 5, 50, width - 50); // Adjusted mapping to limit within canvas
                    line(x, 50, x, height - 50);
                    textAlign(CENTER, CENTER);
                    fill(300);
                    text(i, x, 12); // Display label above the line
                }

                // horizontal lines
                for (int j = -5; j <= 5; j++) {
                    float y = map(j, -5, 5, 50, height - 50);
                    line(50, y, width - 50, y); // Draw horizontal line
                    textAlign(LEFT, CENTER);
                    fill(300);
                    text(j, 30, y); // Display label
                }

                break;
            case 8:
                background(0);

                int numVertices = 4;
                centerX = width / 2;
                centerY = height / 2;
                float radius = 200;

                stroke(255);

                drawRegularPolygon(centerX, centerY, radius, numVertices);
                break;

            case 9:
                background(0);

                numVertices = 5;
                centerX = width / 2;
                centerY = height / 2;
                radius = 200;

                stroke(255);

                drawRegularPolygon(centerX, centerY, radius, numVertices);
                break;

            default:

                break;
        }
    }

    void drawRegularPolygon(float x, float y, float radius, int numVertices) {
        float angleIncrement = TWO_PI / numVertices; // Calculate angle

        // Begin drawing polygon
        float xPrev = x + radius * cos(0);
        float yPrev = y + radius * sin(0);

        for (int i = 1; i <= numVertices; i++) {
            // Calculate current angle
            float angle = i * angleIncrement;

            // Calculate coordinates of the current vertex
            float xCurr = x + radius * cos(angle);
            float yCurr = y + radius * sin(angle);

            // Draw a line from the previous vertex to the current vertex
            line(xPrev, yPrev, xCurr, yCurr);

            // Update the previous vertex coordinates
            xPrev = xCurr;
            yPrev = yCurr;
        }

        // Connect last vertex to first vertex and close the polygon
        float xFirst = x + radius * cos(0);
        float yFirst = y + radius * sin(0);
        line(xPrev, yPrev, xFirst, yFirst);
    }

    public void keyPressed() {

        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
    }

}
=======
package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

	int mode = 0;

    

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	float magicMap(float a, float b, float c, float d, float e) {
		float output;
		a -= b;
		c -= b;
		e -= d;

		output = ((a / c) * e) + d;

		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

	float offset = 0;

	public void draw() {
		switch (mode) {
			case 0:
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float) bars;
				for (int i = 0; i < bars; i++) {
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break;
			case 1: {
				background(0);
				int squares = (int) (mouseX / 20.0f);
				float h = width / (float) squares;
				for (int i = 0; i < squares; i++) {
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width);
					rect(x, x, h, h);
					rect((width - h) - x, x, h, h);
				}
			}
				break;
			case 2:
				background(255);
				int circles = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float) circles;
				for (int j = 0; j < circles; j++) {
					for (int i = 0; i < circles; i++) {
						noStroke();
						float c = map((i + j + offset), 0, circles * 2, 0, 255) % 256;
						fill(c, 255, 255);
						float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						float y = map(j, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						circle(x, y, d);
					}
				}
				break;
			case 3:
				background(0);
				float border = width * 0.1f;
				for(int i = -5; i <= 5; i ++)
				{
					float x = map(i, -5, 5, border, width - border);
					stroke(0, 255, 0);
					line(x, border, x, height - border);
					line(border, x, width - border, x);
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);
				}
			case 4:
				background(0);
				stroke(255, 255, 255);	
				float cx = width / 2;
				float cy = height / 2;	
				float radius = 200;		
				int points = (int)map(mouseX, 1, width, 5, 20);
				int sides = points * 2;
				float px = cx;
				float py = cy - radius; 
				for(int i = 0 ; i <= sides ; i ++)
				{
					float r = (i % 2 == 0) ? radius : radius / 2; 
					// float r = radius;
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta) * r;
					float y = cy - cos(theta) * r;
					
					//circle(x, y, 20);
					line(px, py, x, y);
					px = x;
					py = y;
				}

				// map(a,b,c,d,e);
				// a = inputvalue
				// b - c - start and end of the first range
				// d, e 0 - start and and of the end range

				// map(-2, 10, 90, 200, 233);

		}
	}
}
>>>>>>> 2af1570ee2c65d4f62c233661c3acf77a8b4a816
