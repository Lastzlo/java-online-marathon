package task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Review {
    String reviewer();
    String date() default "today";
}

class Util {
    @SuppressWarnings("unchecked")
    static void review(String className){
        try {
            Class c = Class.forName(className);
            if(c.isAnnotationPresent(Review.class)) {
                Review review = (Review)c.getAnnotation(Review.class);
                String reviewDate = review.date().equals("today") ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : review.date();
                System.out.printf("Class %s was reviewed %s by %s.\n", className, reviewDate, review.reviewer());
            } else {
                System.out.printf("Class %s isn't marked as Reviewed\n", className);
            }
        } catch (ClassNotFoundException e) {
            System.out.printf("Class %s was not found\n", className);
        }
    }
}


@Review(reviewer = "Dima", date = "2020-07-05")
class NormalMethod{
}
