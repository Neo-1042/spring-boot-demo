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

### A Step Closer into Polymorphism:

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