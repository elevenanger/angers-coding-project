package com.angers.project.onjava8.reflection;

import java.util.Optional;

/**
 * @author : liuanglin
 * @date : 2022/5/5 09:39
 * @description :反射-在通常的类中使用 Optional
 */
public class Person {
    public final Optional<String> firstName;
    public final Optional<String> lastName;
    public final Optional<String> city;
    public final boolean empty;
    Person(String firstName, String lastName, String city) {
        /*
        使用 Optional 可以避免空指针异常
        在更接近数据的场景使用 Optional 来表示对象
         */
        this.firstName = Optional.ofNullable(firstName);
        this.lastName = Optional.ofNullable(lastName);
        this.city = Optional.ofNullable(city);
        empty = !this.firstName.isPresent() &&
                !this.lastName.isPresent() &&
                !this.city.isPresent();
    }
    Person(String first ,String last){
        this(first,last,null);
    }
    Person(String last){
        this(null,last,null);
    }
    Person(){
        this(null,null,null);
    }

    @Override
    public String toString() {
        if (empty) return "empty";
        return "Person{" +
                "firstName=" + firstName.orElse("") +
                ", lastName=" + lastName.orElse("") +
                ", city=" + city.orElse("") +
                ", empty=" + empty +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Person());
        System.out.println(new Person("zhao"));
        System.out.println(new Person("si","zhao"));
        System.out.println(new Person("si","zhao","don"));
    }
}
