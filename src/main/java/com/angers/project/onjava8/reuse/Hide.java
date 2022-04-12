package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 15:19
 * @description : 在派生类中重载基类的方法名，基类的方法不会被隐藏
 */
public class Hide {
    public static void main(String[] args) {
        Bart bart = new Bart();
        bart.doh(1);
        bart.doh(1.0f);
        bart.doh('c');
        bart.doh(new Milhouse());
        /* output
        Home.doh( float 1.0)
        Home.doh( float 1.0)
        Homer.dor( char c)
        Bart.dor(Milhouse)
         */
    }

}

class Homer {
    char doh(char c){
        System.out.println("Homer.dor( char " + c +")");
        return 'd';
    }
    float doh(float f){
        System.out.println("Home.doh( float " + f +")");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends Homer {
    void doh(Milhouse milhouse){
        System.out.println("Bart.dor(Milhouse)");
    }
}
