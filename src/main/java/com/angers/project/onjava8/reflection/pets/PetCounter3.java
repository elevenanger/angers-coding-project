package com.angers.project.onjava8.reflection.pets;

/**
 * @author : liuanglin
 * @date : 2022/5/2 11:23
 */
public class PetCounter3 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        new PetCreator()
                .stream().skip(10)
                .limit(20)
                .peek(counter::count)
                .forEach( pet ->
                        System.out.print(pet.getClass().getSimpleName() + " ")
                );
        System.out.println("\n" + counter);
    }
}
