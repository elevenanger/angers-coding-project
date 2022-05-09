package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/7 09:16
 * @description :
 */
public class SimpleHolder {
    private Object object ;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.setObject("hold");
        String s = (String) holder.getObject();
        System.out.println(s);
    }
}

class GenericHolder<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder();
        holder.setObj("String");
        String s = holder.getObj();
        System.out.println(s);
    }
}