package com.angers.project.onjava8.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/6/7 08:45
 * @description : 多个对象之间互相关联关系的序列化过程
 */
class House implements Serializable {}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    public Animal(String name, House preferredHouse) {
        this.name = name;
        this.preferredHouse = preferredHouse;
    }

    @Override
    public String toString() {
        return "Animal{" +
            "name='" + super.toString() + '\'' +
            ", preferredHouse=" + preferredHouse +
            '}';
    }
}
public class MultiAssociateSerialization {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("老黄",house));
        animals.add(new Animal("老黑",house));
        animals.add(new Animal("老白",house));
        System.out.println("before serialize : ");
        animals.forEach(System.out::println);
        try (
            ByteArrayOutputStream bos =
            new ByteArrayOutputStream();
             ObjectOutputStream out =
                new ObjectOutputStream(bos);
            ByteArrayOutputStream bos2 =
                new ByteArrayOutputStream();
            ObjectOutputStream out2 =
                new ObjectOutputStream(bos2);

        ){
            out.writeObject(animals);
            out.writeObject(animals);
            out2.writeObject(animals);
            try (
                ObjectInputStream in1 =
                new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
                ObjectInputStream in2 =
                    new ObjectInputStream(
                        new ByteArrayInputStream(bos2.toByteArray()));
            ){
                List<Animal> animals1 = (List<Animal>) in1.readObject();
                List<Animal> animals2 = (List<Animal>) in1.readObject();
                List<Animal> animals3 = (List<Animal>) in2.readObject();
                System.out.println("deserialized : ");
                System.out.println("animals1 \n" + animals1);
                System.out.println("animals2 \n" + animals2);
                System.out.println("animals3 \n" + animals3);
            }
        }
        /*
        使用对象序列化实际是对对象进行深拷贝
        意味着拷贝整个对象中所有的属性
        而不仅仅是基础对象以及其引用
         */
    }

}
