package DesignPattern.CreationalPattern.BuilderPattern;


/*The Builder pattern is used when you want to create complex objects step by step or piece by piece, allowing for a more flexible and readable construction process. It separates the construction of an object from its representation, enabling the same construction process to create different representations. The Builder pattern is useful in the following scenarios:
        Construction of Complex Objects: When you need to create objects that have many optional parameters or configurations, the Builder pattern provides a convenient way to construct them by specifying only the required parameters and setting the optional ones as needed.
        Readability and Maintainability: The Builder pattern enhances code readability by providing clear and expressive method calls for setting different attributes or parameters of an object. It also simplifies the maintenance of the codebase by isolating the construction logic within the builder, making it easier to modify or extend the construction process.
        Immutable Objects: If you want to create immutable objects, the Builder pattern is a good choice. The builder can enforce immutability by ensuring that all necessary attributes are set during construction and that the object's state cannot be modified after construction.
        Object Configuration: The Builder pattern is suitable when you need to configure an object with a combination of default and custom values. The builder can provide sensible default values for attributes and allow customization as needed.*/
public class Car {
    private String make;
    private String model;
    private int year;

    private Car(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public static class Builder {
        private String make;
        private String model;
        private int year;

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
