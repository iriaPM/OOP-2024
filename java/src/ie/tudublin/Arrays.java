
package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
	String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	float[] rainfall = { 200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420 };
	int mode = 0;

	public float map1(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize() {
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(500);
		}
	}

	public void settings() {
		size(640, 640);

		String[] m1 = months;
		months[0] = "JAN";
		print(m1[0]);
		for (int i = 0; i < months.length; i++) {
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for (int i = 0; i < rainfall.length; i++) {
			if (rainfall[i] < rainfall[minIndex]) {
				minIndex = i;
			}
		}

		int maxIndex = 0;
		for (int i = 0; i < rainfall.length; i++) {
			if (rainfall[i] > rainfall[maxIndex]) {
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");

		float tot = 0;
		for (float f : rainfall) {
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10

	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();

	}

	public void draw() {
		float padding = 50;
		float chartWidth = width - 2 * padding; // Width of chart area
		float chartHeight = height - 2 * padding; // Height of the chart area
		float w = chartWidth / (float) months.length;
		float x, h;

		background(0);

		switch (mode) {
			case 0:
				// y-axis
				stroke(255);
				line(padding, padding, padding, height - padding); // Vertical line

				// horizontal line with months
				for (int i = 0; i < months.length; i++) {
					x = map1(i, 0, months.length, padding, width - padding - w);
					textAlign(CENTER, CENTER);
					fill(255);
					text(months[i], x + w / 2, height - padding + 20);
				}

				// vertical lines
				for (int i = 0; i <= 120; i += 10) {
					float y = map1(i, 0, 120, height - padding, padding);
					textAlign(RIGHT);
					fill(255);
					text(Integer.toString(i), padding - 5, y);
					stroke(255);
					line(padding - 5, y, padding, y);
				}

				// bars
				for (int i = 0; i < months.length; i++) {
					x = map1(i, 0, months.length, padding, width - padding - w);
					h = -map1(rainfall[i], 0, max(rainfall), 0, chartHeight);
					fill(map(i, 0, months.length - 1, 0, 255), 255, 255);
					rect(x, height - padding, w, h);
				}
				line(padding, padding, padding, height - padding); // Vertical line
				// horizontal line at the bottom
				line(padding, height - padding, width - padding, height - padding);

				// Title
				textAlign(CENTER);
				fill(255);
				textSize(20);
				text("Rainfall Chart", width / 2, padding - 10);
				break;

			case 1:

				// horizontal line with months
				for (int i = 0; i < months.length; i++) {
					x = map1(i, 0, months.length, padding, width - padding - w);
					textAlign(CENTER, CENTER);
					fill(255);
					text(months[i], x + w / 2, height - padding + 20);
				}
				// vertical lines
				for (int i = 0; i <= 120; i += 10) {
					float y = map1(i, 0, 120, height - padding, padding);
					textAlign(RIGHT);
					fill(255);
					text(Integer.toString(i), padding - 5, y);
					stroke(255);
					line(padding - 5, y, padding, y);
				}
				for (int i = 1; i < months.length; i++) {
					float startX = map1(i - 1, 0, months.length, padding, width - padding - w);
					float startY = map1(rainfall[i - 1], 0, max(rainfall), height - padding, padding);

					float endX = map1(i, 0, months.length, padding, width - padding - w);
					float endY = map1(rainfall[i], 0, max(rainfall), height - padding, padding);

					line(startX, startY, endX, endY);
				}

				// vertical line to mark border of graph
				stroke(255);
				line(padding, padding, padding, height - padding); // Vertical line

				line(padding, height - padding, width - padding, height - padding);// bottom line
				// Title
				textAlign(CENTER);
				fill(255);
				textSize(20);
				text("Rainfall Trend Chart", width / 2, padding - 10);
				break;
			case 2:
				// sum of all rainfall
				float sum = 0;
				for (float value : rainfall) {
					sum += value;
				}

				float startAngle = 0;
				float radius = min(width, height) / 3; // radius of pie chart

				// each segment of the pie chart
				for (int i = 0; i < months.length; i++) {
					float angle = map(rainfall[i], 0, sum, 0, TWO_PI); // angle for segment
					float endAngle = startAngle + angle; // end angle

					// color for segment based on the month index
					float hue = map(i, 0, months.length, 0, 255);
					fill(hue, 255, 255);

					// segment of pie chart
					arc(width / 2, height / 2, radius * 2, radius * 2, startAngle, endAngle);

					// Calculate coordinates for text label
					float labelX = width / 2 + cos(startAngle + angle / 2) * (radius + 20);
					float labelY = height / 2 + sin(startAngle + angle / 2) * (radius + 20);

					// month name
					textAlign(CENTER, CENTER);
					fill(255);
					text(months[i], labelX, labelY);

					// Update start angle for next segment
					startAngle += angle;
				}
				// Title
				textAlign(CENTER);
				fill(255);
				textSize(20);
				text("Rainfall Pie Chart", width / 2, padding - 10);
				break;

			default:
				break;
		}
	}

	public void keyPressed() {

		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
	}
}