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
