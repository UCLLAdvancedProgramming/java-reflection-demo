package be.ucll.apr.reflection;

@Animal(numberOfFeet = 4)
public class Cat {
    private String name;

    public Cat() {
        this("Kitty");
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
