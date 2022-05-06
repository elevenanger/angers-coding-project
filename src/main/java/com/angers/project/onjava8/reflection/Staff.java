package com.angers.project.onjava8.reflection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/5 10:14
 * @description : 反射-职员
 */
public class Staff extends ArrayList<Position> {
    public void add(String title,Person person){
        add(new Position(title,person));
    }
    public void add(String ... titles){
        Arrays.stream(titles)
                .map(Position::new)
                .peek(System.out::println)
                .forEach(this::add);
    }
    Staff(String ... tiles){
        add(tiles);
    }
    public boolean positionAvailable(String title){
        for (Position position :this)
            if (position.getTitle().equals(title)&&
            position.getPerson().empty)
                return true;
        return false;
    }
    public void fillPosition(String title,Person hire){
        this.stream()
                .filter(position -> position.getTitle().equals(title))
                .filter(position -> position.getPerson().empty)
                .limit(1)
                .forEach(position -> position.setPerson(hire));
    }

    public static void main(String[] args) {
        Staff staff = new Staff(
                "CIO",
                "CEO",
                "CFO",
                "COO"
        );
        staff.fillPosition("CIO",new Person("Zhao","Si","gala"));
        staff.fillPosition("CEO",new Person("Zhang","San","Hebei"));
        if (staff.positionAvailable("COO"))
            staff.fillPosition("COO",new Person("Wang","Wu","Shijiazhuang"));
        System.out.println(staff);
    }
}
