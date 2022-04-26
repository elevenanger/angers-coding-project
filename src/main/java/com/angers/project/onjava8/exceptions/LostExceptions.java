package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 19:36
 * @description : 异常-异常丢失
 */
public class LostExceptions {
    void f() throws ImportantException {
        throw  new ImportantException();
    }
    void g() throws TrivialException {
        throw  new TrivialException();
    }

    public static void main(String[] args) {
        try {
            LostExceptions le = new LostExceptions();
            try {
                le.f();
            }finally {
                /*
                在try-catch 语句中内嵌 trr-finally 语句，finally 语句必将执行
                但是会忽略外层的Exception
                 */
                le.g();
            }
        }catch (ImportantException | TrivialException e){
            System.out.println(e);
        }

        try {
            throw new RuntimeException();
        }finally {
            // 在 finally 子句中 return 会直接丢失 exception
            return;
        }
    }
}
class ImportantException extends Exception{
    @Override
    public String toString() {
        return "ImportantException{}";
    }
}

class TrivialException extends Exception {
    @Override
    public String toString() {
        return "TrivialException{}";
    }
}