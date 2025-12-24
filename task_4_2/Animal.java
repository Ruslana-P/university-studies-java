import java.io.Serializable;

abstract class Animal implements Serializable {
    private String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
}

class Mammal extends Animal { public Mammal(String name) { super(name); } }
class Bird extends Animal { public Bird(String name) { super(name); } }

class Lion extends Mammal { public Lion(String name) { super(name); } }
class Ungulate extends Mammal { public Ungulate(String name) { super(name); } }

class Zebra extends Ungulate { public Zebra(String name) { super(name); } }
class Giraffe extends Ungulate { public Giraffe(String name) { super(name); } }
class Eagle extends Bird { public Eagle(String name) { super(name); } }