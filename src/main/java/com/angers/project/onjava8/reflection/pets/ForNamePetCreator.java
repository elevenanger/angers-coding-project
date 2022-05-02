// reflection/pets/ForNamePetCreator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package com.angers.project.onjava8.reflection.pets;
import java.util.*;

public class ForNamePetCreator extends Creator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<>();
  // Types you want randomly created:
  private static String[] typeNames = {
          "com.angers.project.onjava8.reflection.pets.Mutt",
          "com.angers.project.onjava8.reflection.pets.EgyptianMau",
          "com.angers.project.onjava8.reflection.pets.Manx",
          "com.angers.project.onjava8.reflection.pets.Cymric",
          "com.angers.project.onjava8.reflection.pets.Rat",
          "com.angers.project.onjava8.reflection.pets.Mouse",
          "com.angers.project.onjava8.reflection.pets.Hamster",
  };
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  @Override public List<Class<? extends Pet>> types() {
    return types;
  }
}
