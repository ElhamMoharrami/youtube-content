package tutorials.inheritanceAndPolymorphism;

class Cat extends Animal {
    void meow() {
        System.out.println(name + " is meowing!");
    }

    @Override
    void eat() {
        System.out.println(name + " is eating fish...");
    }
}
