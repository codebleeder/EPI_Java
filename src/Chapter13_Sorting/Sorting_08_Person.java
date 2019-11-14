package Chapter13_Sorting;

public class Sorting_08_Person {
    public int age;
    public String name;
    public Sorting_08_Person(int a, String n){
        age = a;
        name = n;
    }
    public String toString(){
        return String.format("(%s, %d)", name, age);
    }
}
