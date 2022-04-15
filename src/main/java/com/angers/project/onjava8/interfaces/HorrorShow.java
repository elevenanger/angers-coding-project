package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 14:26
 * @description : 接口-使用继承扩展接口
 */
public class HorrorShow {
    static void u(Monster monster){monster.menace();}
    static void v(DangerousMonster dangerousMonster){
        dangerousMonster.destroy();
        dangerousMonster.menace();
    }
    static void w(Lethal lethal){lethal.kill();}

    public static void main(String[] args) {
        DangerousMonster bar = new DragonZilla();
        u(bar);
        v(bar);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
        /* output:
        DragonZilla.menace()
        DragonZilla.destroy()
        DragonZilla.menace()
        VeryBadVampire VeryBadVampire.menace()
        VeryBadVampire VeryBadVampire.destroy()
        VeryBadVampire VeryBadVampire.menace()
        VeryBadVampire VeryBadVampire.kill()
         */
    }
}

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {
        System.out.println(getClass().getSimpleName() + ".menace()");
    }

    @Override
    public void destroy() {
        System.out.println(getClass().getSimpleName() + ".destroy()");
    }
}

// 类的继承只能继承一个类，但是接口可以继承多个接口
interface Vampire extends DangerousMonster , Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    @Override
    public void menace() {
        System.out.println("VeryBadVampire " + getClass().getSimpleName() + ".menace()");
    }

    @Override
    public void destroy() {
        System.out.println("VeryBadVampire " + getClass().getSimpleName() + ".destroy()");
    }

    @Override
    public void kill() {
        System.out.println("VeryBadVampire " + getClass().getSimpleName() + ".kill()");
    }

    @Override
    public void drinkBlood() {
        System.out.println("VeryBadVampire " + getClass().getSimpleName() + ".drinkBlood()");
    }
}