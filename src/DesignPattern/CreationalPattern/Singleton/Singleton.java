package DesignPattern.CreationalPattern.Singleton;

public class Singleton {

/*    The Singleton pattern is used when you want to ensure that only one instance of a class is created throughout the entire application, and you need a global point of access to that instance. There are several reasons why you might use a Singleton class:

            1. Global Access: The Singleton provides a single point of access to its instance, allowing other parts of the code to access and use it easily.

            2. Resource Sharing: If a class needs to manage a shared resource, such as a database connection or a file system, the Singleton pattern ensures that only one instance of the class is responsible for managing and providing access to that resource.

3. Stateful Objects: Singleton is useful when you have an object that maintains state, and you want to ensure that all parts of the code operate on the same instance of that object.

4. Performance Optimization: In some cases, creating multiple instances of a class can be resource-intensive or unnecessary. By using a Singleton, you can avoid unnecessary object creation and reduce memory consumption.

5. Centralized Configuration: Singleton can be used to create a centralized configuration object that holds application-wide settings. This ensures that all parts of the code access and use the same configuration settings.

            However, it's important to use the Singleton pattern judiciously and consider potential drawbacks, such as:

            1. Global State: Singleton introduces global state, which can make code harder to test, understand, and maintain. Changes made to the Singleton instance affect all parts of the code that depend on it.

            2. Dependency and Tight Coupling: Code that relies on a Singleton class becomes tightly coupled to that class, making it harder to replace or substitute the Singleton instance with another implementation.

3. Thread Safety: If multiple threads access and modify a Singleton instance concurrently, proper synchronization mechanisms must be implemented to ensure thread safety.

    In summary, use the Singleton pattern when you need a single, globally accessible instance of a class, and make sure to weigh the benefits against the potential drawbacks in your specific use case.*/

    public static Singleton singleton;

    private Singleton() {

        //I am making the constructor private to prevent external classes
        // from accessing it. This ensures that the constructor is
        // only accessible within the class itself and cannot be called from outside.

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
