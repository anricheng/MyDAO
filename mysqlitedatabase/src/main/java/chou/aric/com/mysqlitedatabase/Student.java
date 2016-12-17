package chou.aric.com.mysqlitedatabase;

/**
 * Created by aric on 16/12/17.
 */

public class Student {
    private int _id;
    private String name;
    private int age;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
