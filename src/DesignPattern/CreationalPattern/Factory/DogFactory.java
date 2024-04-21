package DesignPattern.CreationalPattern.Factory;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
