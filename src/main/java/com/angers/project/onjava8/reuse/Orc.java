package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 16:33
 * @description : protected 关键字
 */
public class Orc extends Villain{
    private int orcNumber;
    public Orc(String name,int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name,int orcNumber){
        setName(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc{" +
                "orcNumber=" + orcNumber +
                super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger",12);
        System.out.println(orc);
        orc.change("Dust",100);
        System.out.println(orc);
    }
}

class Villain {
    private String name;
    protected void setName(String name){
        this.name = name;
    }

    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Villain{" +
                "name='" + name + '\'' +
                '}';
    }
}
