package com.angers.project.onjava8.compare;

import java.util.PriorityQueue;

/**
 * @author : liuanglin
 * @date : 2022/6/3 18:32
 * @description : 使用 PriorityQueue 实现 ToDoList
 */
class ToDoItem implements Comparable<ToDoItem>{
    private char primary;
    private char secondary;
    private String item;

    public ToDoItem(char primary, char secondary, String item) {
        this.primary = primary;
        this.secondary = secondary;
        this.item = item;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "primary=" + primary +
                ", secondary=" + secondary +
                ", item='" + item + '\'' +
                '}';
    }

    @Override
    public int compareTo(ToDoItem o) {
        if (primary > o.primary) return +1;
        if (primary == o.primary)
            if (secondary > o.secondary)
                return +1;
            else if (secondary == o.secondary)
                return 0;
        return -1;
    }
}

public class ToDoList {
    public static void main(String[] args) {
        PriorityQueue<ToDoItem> toDoItems =
                new PriorityQueue<>();
        toDoItems.add(new ToDoItem('C', (char) 3,"C3"));
        toDoItems.add(new ToDoItem('A', (char) 4,"A4"));
        toDoItems.add(new ToDoItem('A', (char) 3,"A3"));
        toDoItems.add(new ToDoItem('B', (char) 3,"B3"));
        while (! toDoItems.isEmpty())
            System.out.println(toDoItems.remove());
    }
}