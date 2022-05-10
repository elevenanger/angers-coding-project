package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 14:28
 * @description :
 */
public class EpicBattle {
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
    }
    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        useSuperHearing(dogPerson);
        superFind(dogPerson);
    }
}

interface SuperPower {}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero <POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
    public SuperSleuth(POWER power) {
        super(power);
    }
    void see(){power.seeThroughWalls();}
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
    public CanineHero(POWER power) {
        super(power);
    }

    void hear(){power.hearSubtleNoises();}

    void smell(){power.trackBySmell();}
}

class SuperHearSmell implements SuperHearing ,SuperSmell {
    @Override
    public void hearSubtleNoises() {}

    @Override
    public void trackBySmell() {}
}

class DogPerson extends CanineHero<SuperHearSmell> {
    public DogPerson() {
        super(new SuperHearSmell());
    }
}