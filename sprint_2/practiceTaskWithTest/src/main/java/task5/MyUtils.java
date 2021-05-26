package task5;

import java.util.List;

//Create classes Square and Rectang with method (double getPerimeter()) for calculating of perimeter.
//Find solution for avoiding of duplicate code.
//Create a double sumPerimeter(List<?> firures) method of the MyUtils class to return a sum perimeters of all figures.
//For example, for a given list
//[[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
//you should get 46
//
//Answer:(penalty regime: 0 %)

class Rectang {
    private double width;
    private double height;
    private double perimeter;

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getPerimeter() {
        return width * 2 + height * 2;
    }

}

class Square extends Rectang {

    public Square(double width) {
        super(width, width);
    }

    public double getPerimeter() {
        return super.getPerimeter();
    }

}

public class MyUtils {
    public double sumPerimeter(List<?> figures) {

        double sumPerimeter = 0.0;

        for(Object figure : figures) {
            if(figure instanceof Rectang){
                sumPerimeter += ((Rectang) figure).getPerimeter();
            }

        }

        return sumPerimeter;
    }
}

