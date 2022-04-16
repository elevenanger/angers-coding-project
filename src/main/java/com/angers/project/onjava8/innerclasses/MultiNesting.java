package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 15:37
 * @description : 内部类-多层内部类嵌套
 */
public class MultiNesting {
    public static void main(String[] args) {
        Earth earth = new Earth();
        Earth.Continent continent = earth.new Continent();
        Earth.Continent.Country country = continent.new Country();
        country.printAll();
        /* output:
        China
        Continent
        Earth
         */
    }

}

class Earth {
    private String getName() {
        return getClass().getSimpleName();
    }
    class Continent {
        private String getContinentName() {
            return getClass().getSimpleName();
        }
        class Country {
            private String getCountryName() {
                return "China";
            }
            public void printAll(){
                /*
                无论多少层嵌套，内部类可以访问外层所有的成员
                 */
                System.out.println(getCountryName());
                System.out.println(getContinentName());
                System.out.println(getName());
            }
        }
    }
}
