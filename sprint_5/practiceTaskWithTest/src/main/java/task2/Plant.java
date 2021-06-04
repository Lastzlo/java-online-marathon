package task2;

/**
 * Task 2 (First part of task2)
 *
 * Create a class Plant, which includes private fields:
 *  String name, Color color and Type type, and constructor with three String parameters
 *  (String type, String color, String name) where these fields are initialized.
 *  Create getters for all fields.
 *  Color and Type are Enum.
 *  Color contains White, Red, Blue entries.
 *  Type contains Rare and Ordinary entries.
 *  Override the method toString( ) for Plant class which returns result formatted like following:
     *  {type: Rare, color: Red, name: MyPlant}
 *  Create classes ColorException and TypeException as derived from Exception.
 *  Both classes should have a constructor with one String parameter
 *  and pass this parameter to the base class.
 *   The constructor of Plant should throw a corresponding exception whenever
 *   an inappropriate parameter is passed.*/
public class Plant {
    private Type type;
    private Color color;
    private String name;


    public Plant(String type, String color, String name) throws TypeException,ColorException  {
        this.type = Type.getEnum(type);
        this.color = Color.getEnum(color);
        this.name = name;

        //второй вариант без getEnum
//        try {
//            this.type = Type.valueOf(type.toUpperCase());
//        } catch (IllegalArgumentException e) {
//            throw new TypeException("Invalid value " + type + " for field type");
//        }
//
//        try {
//            this.color = Color.valueOf(color.toUpperCase());
//        } catch (IllegalArgumentException e) {
//            throw new ColorException("Invalid value " + color + " for field color");
//        }

    }


    /**
     * Task 3 (Second part of task2)
     *
     * The constructor of Plant throws a corresponding exception whenever
     * an inappropriate parameter is passed: String type, String color, String name.
     * Write a static tryCreatePlant method that takes 3 string parameters
     * - type, color and name and returns an instance of Plant, created based on passed params.
     * (Don't create any classes, write as if you are already inside a class.)
     * The tryCreatePlant method should catch exceptions that can be thrown by Plant constructor.
     * If inappropriate type passed as a parameter, a Plant object should be returned anyway,
     * with Ordinary type. If an inappropriate color is passed, set Red color for created instance.*/
    public static Plant tryCreatePlant(String type, String color, String name) {
        for (;;) {
            try {
                return new Plant(type, color, name);
            } catch (TypeException e) {
                type = "Ordinary";
            } catch (ColorException e) {
                color = "Red";
            }
        }
    }


    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{type: %s, color: %s, name: %s}", type, color, name);
    }

}

enum Color {
    WHITE, RED, BLUE;

    public static Color getEnum(String value) throws ColorException {
        for(Color color : values()) {
            if(color.toString().equalsIgnoreCase(value)) return color;

        }
        throw new ColorException("Invalid value " + value + " for field color");
    }
}

enum Type {
    RARE, ORDINARY, rare, rArE;

    public static Type getEnum(String value) throws TypeException {
        for(Type type : values()) {
            if(type.toString().equalsIgnoreCase(value)) return type;
        }
        throw new TypeException("Invalid value " + value + " for field type");
    }
}

class ColorException extends Exception {
    public ColorException(String s) {
        super(s);
    }
}

class TypeException extends Exception {
    public TypeException(String s) {
        super(s);
    }
}


