package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 16:10
 * @description : 接口-接口嵌套
 */
public class NestingInterfaces {
    public class BImp implements  A.B {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }

    class CImp implements A.C {
        @Override
        public void f() {

        }
    }

    class EImp implements E {
        @Override
        public void g() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }

    class EGImp implements E.G {
        @Override
        public void f() {

        }
    }

    class EImp2 implements E {
        @Override
        public void g() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
        class EG implements E.G {
            @Override
            public void f() {
                System.out.println(getClass().getSimpleName() + ".f()");
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}

class A {
    interface B {
        void f();
    }
    public class BImp implements B {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }
    private class BImp2 implements B {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }
    public interface C {
        void f();
    }
    class CImp implements C {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }

    private class CImp2 implements C {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }

    private interface D {
        void f();
    }
    private class DImp implements D {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }
    public class DImp2 implements D {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() + ".f()");
        }
    }
    public D getD(){
        return new DImp2();
    }
    private D dRef;

    public void receiveD(D d){
        dRef = d;
        dRef.f();
    }
}

interface E {
    interface G {
        void f();
    }
    public interface H {
        void f();
    }
    void g();
}