package com.designpatterns;


interface ShapePrototype {
	ShapePrototype createCopy(String color); // Make a copy of itself

	void draw(); // Draw the shape
}

/**
 * This is a specific shape, a circle, implementing the Shape interface. It can
 * create a copy of itself (clone) and draw in its own way.
 */
class Circle implements ShapePrototype {
	private String color;
	private Integer radius;
	
	// When you create a circle, you give it a color.
	public Circle(String color, Integer radius) {
		this.color = color;
		this.radius = radius;
	}

	// This creates a copy of the circle.
	@Override
	public ShapePrototype createCopy(String color) {
		return new Circle(color, this.radius);
	}

	// This is how a circle draws itself.
	@Override
	public void draw() {
		System.out.println("Drawing a " + color + " circle.");
	}
}

class Client {
    private ShapePrototype shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public Client(ShapePrototype shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using the prototype.
    public ShapePrototype createShape(String color) {
        return shapePrototype.createCopy(color);
    }
}

public class PrototypeDP {
    public static void main(String[] args) {
        // Create a concrete prototype (a red circle).
    	ShapePrototype circlePrototype = new Circle("red", 5);

        // Create a client and give it the prototype.
        Client client = new Client(circlePrototype);

        // Use the prototype to create a new shape (a red circle).
        ShapePrototype redCircle = client.createShape("green");

        // Draw the newly created green circle.
        redCircle.draw();
    }
}
