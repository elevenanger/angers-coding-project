package com.angers.project.onjava8.reflection;

import java.util.Optional;

/**
 * @author : liuanglin
 * @date : 2022/5/5 09:57
 * @description :反射-使用 Optional 保护对实例域的修改操作
 */
public class Position {
    private String title;
    private Person person;

    public Position(String title, Person person) {
        setPerson(person);
        setTitle(title);
    }

    public Position(String title) {
        setPerson(null);
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    /**
     * 使用 Optional 确保职位被正常的赋值
     * 如果没有值则抛出异常
     * @param title 职位
     */
    public void setTitle(String title) {
        this.title = Optional.ofNullable(title)
                .orElseThrow(EmptyTitleException::new);
    }

    public Person getPerson() {
        return person;
    }

    /**
     * 使用 Optional 作为占位符
     * 当没有传入 person 对象创建一个新的 Person 对象
     * @param person 人选
     */
    public void setPerson(Person person) {
        this.person = Optional.ofNullable(person)
                .orElse(new Person());
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Position("CTO"));
        System.out.println(new Position("CEO",new Person("Si","Zhao")));
        try {
            new Position(null);
        }catch (EmptyTitleException e){
            System.out.println("get " + e);
        }
    }
}
class EmptyTitleException extends RuntimeException{}