# The Spring Framework

## Dependency Injection (Inversion)

If object A is dependent of object B, the idea of dependency
inversion is to de-couple this dependency.

e.g. a Drawing Application:

Circle class -> draw()  
Triangle class -> draw()

File = ShapesApp.java
```java
Triangle myTriangle = new Triangle();
myTriangle.draw();

Circle myCircle = new Circle();
myCircle.draw();
```

If I don't want my application class to be TIED to these objects,
I want to use polymorphism by having a
parent class (abstract class or interface), using it to execute
the methods of the class.
Then, at runtime I supply different children of the parent
class.

## Using Polymorphism

### One Step Closer into Polymorphism:

```java
// This parent object can be an abstract class or an interface
public class Shape {
    public void draw() {

    }
}

public class Circle extends Shape {

    @Override
    public void draw() { }
}

public class Triangle extends Shape {

    @Override
    public void draw() { }
}

// Application class:

public class DemoShapes {

    Shape shape1 = new Triangle();
    shape1.draw(); // calls the Triangle method

    Shape shape2 = new Cirlce();
    shape2.draw(); // calls the Circle method
}
```

Depending on the instance, it will execute its correspondent
draw() method. However, in the next snippet, we still
have a dependency to the `Triangle` class in the same
Application class:
```java
public class DemoShapes {

    public void myDrawMethod(Shape shape) {
        shape.draw()
    }

    // Somewhere else in the class, you are still coupled
    // to a Triangle object:
    Shape shape = new Triangle();
    myDrawMethod(shape);
}
```

Therefore, in the application class we need to have only a
`Shape` object, and then, we need to ask another class
to provide us with the especific shape: Triangle or Circle.

### Drawing Class

```java
protected class Drawing {

    private Shape shape;

    // Can accept any child class of Shape:
    public setShape(Shape shape) {
        this.shape = shape;
    }

    // Calls the draw() method specific to the shape
    public drawShape() {
        this.shape.draw();
    }
}
```