package tutorials.inheritanceAndPolymorphism;

public class InheritanceAndPolymorphismMain {
    public static void main(String[] args) {
 /*       Dog dog = new Dog();
        dog.name = "Buddy";
        dog.eat();   // inherited method
        dog.sleep(); // inherited method
        dog.bark();  // unique to Dog

        Cat cat = new Cat();
        cat.name = "Whiskers";
        cat.eat();   // overridden method
        cat.meow();  // unique to Cat*/

        Animal animal = new Dog();
        animal.name = "Charlie";
        animal.eat();

        Animal animal2 = new Cat();
        animal2.name = "Bob";
        animal2.eat();
    }

}
