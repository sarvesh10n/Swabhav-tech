package com.techlabs.circle;

import com.techlabs.circle.BorderStyleOption.borderStyleOption;

public class Circle {

	float radius;
	borderStyleOption circleStyle;

	private float validateRadius(float rad) {
		if (rad < 0)
			return 1;
		else if (rad > 10)
			return 10;
		else
			return rad;
	}

	public Circle() {
		circleStyle = borderStyleOption.SINGLE;
	}

	public Circle(float rad) {
		radius = validateRadius(rad);
		circleStyle = borderStyleOption.SINGLE;
	}

	public Circle(float rad, borderStyleOption style) {
		radius = rad;
		circleStyle = style;
	}

	public float getRadius() {
		return radius;
	}

	public float calculateArea()
	{
		return 3.14f*radius*radius;
	}
	public borderStyleOption getBorderStyle() {
		return circleStyle;
	}
}
