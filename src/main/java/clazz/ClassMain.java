package clazz;

public class ClassMain {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.parent();

        Child child = (Child) parent;
        child.child();

        Parent parent2 = new Parent();
        parent2.parent();

        if (parent2 instanceof Child child2) {
            child2.child();
        }
    }
}