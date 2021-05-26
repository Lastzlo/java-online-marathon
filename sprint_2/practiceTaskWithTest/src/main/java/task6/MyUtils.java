package task6;

import java.util.*;

//task 6
//Please create class Shape with abstract method to calculate area of figure and field name. Replace code in method getArea() according to principles of polymorphism i.e. Circle and Rectangle classes extends Shape class and override double getArea() method. Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.
//The original list must be unchanged.
//For example, for a given list
//[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Circle [radius=1.00], Rectangle [height=3.00, width=2.00],  Circle [radius=0.50], Rectangle [height=1.00, width=2.00]]
//you should get
//[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Rectangle [height=3.00, width=2.00]]

abstract class Shape {
    private String name;

    public Shape(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    abstract double getArea();
}

class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public boolean equals(Object o) {
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(rectangle.height, height) == 0)
                    && (Double.compare(rectangle.width, width) == 0)
                    && (rectangle.getName().equals(this.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, getName());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        Circle circle = (Circle) o;
        return (Double.compare(circle.radius, radius) == 0)
                && (circle.getName().equals(this.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, getName());
    }
}

public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {

        List<Rectangle> rectangleList = new ArrayList<>();
        Set<Rectangle> rectangleSet = new HashSet<>();
        List<Circle> circleList = new ArrayList<>();
        Set<Circle> circleSet = new HashSet<>();

        for (Shape shape : shapes) {

            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;

                if (circleList.isEmpty()) {
                    circleSet = new HashSet<>(){{add(circle);}};
                    circleList = new ArrayList<>(){{add(circle);}};
                } else if (circle.getArea() > circleList.get(0).getArea()) {
                    circleSet = new HashSet<>(){{add(circle);}};
                    circleList = new ArrayList<>(){{add(circle);}};
                } else if (circle.getArea() == circleList.get(0).getArea()) {
                    if (!circleSet.contains(circle)) {
                        circleSet.add(circle);
                        circleList.add(circle);
                    }
                }
            }

            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;

                if (rectangleList.isEmpty()) {
                    rectangleSet = new HashSet<>(){{add(rectangle);}};
                    rectangleList = new ArrayList<>(){{add(rectangle);}};
                } else if (rectangle.getArea() > rectangleList.get(0).getArea()) {
                    rectangleSet = new HashSet<>(){{add(rectangle);}};
                    rectangleList = new ArrayList<>(){{add(rectangle);}};
                } else if ((rectangle.getArea() == rectangleList.get(0).getArea())) {
                    if (!rectangleSet.contains(rectangle)) {
                        rectangleSet.add(rectangle);
                        rectangleList.add(rectangle);
                    }
                }
            }

        }

        List<Shape> resultList = new ArrayList<>();
        resultList.addAll(rectangleList);
        resultList.addAll(circleList);

        return resultList;
    }

}
