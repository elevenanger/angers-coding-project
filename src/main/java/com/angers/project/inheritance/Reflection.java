package com.angers.project.inheritance;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 利用类的反射机制检索类的信息
 */
@Slf4j
public class Reflection {

    /**
     * 输出所有的构造函数信息
     * @param cl 类
     */
    public static void printConstructors(Class cl){

        Constructor [] constructors = cl.getConstructors();

        for (Constructor c: constructors){
            String name = c.getName();
            log.info("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length()>0){
                log.info(modifiers+" ");
            }
            log.info(name + "(");
            // 打印参数类型
            Class [] parameters = c.getParameterTypes();
            for (Class parameterType : parameters){
                log.info(parameterType.getName());
            }
            log.info(")");
        }
    }

    /**
     * 输出方法信息
     * @param cl  类名
     */
    public static void printMethods(Class cl){
        Method [] methods = cl.getMethods();
        for (Method m:methods){
            Class retType = m.getReturnType();
            String name = m.getName();

            log.info("    ");
            // 打印修饰符，返回值类型以及方法名
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length()>0){
                log.info(modifiers+" ");
            }
            log.info(retType+"(");

            Class [] paramTypes  = m.getParameterTypes();
            // 打印参数类型
            for (Class c : paramTypes){
                log.info(c.getName());
            }
            log.info(")");
        }
    }

    /**
     * 输出实例域信息
     * @param cl 类
     */
    public static void printFields(Class cl){
        Field [] fields = cl.getFields();

        for (Field field: fields){
            Class type = field.getType();
            String name = field.getName();
            log.info("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length()>0){
                log.info(modifiers+" ");
            }
            log.info(type.getName()+" "+name+";");
        }
    }

    public static void main(String[] args)  throws ReflectiveOperationException  {
    // read class name from command line args or user input
        String name;
        if(args.length>0) {
            name=args[0];
        }
        else {
            Scanner in = new Scanner(System.in);
            log.info("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }
        // print class name and superclass name
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) log.info(modifiers + " ");
        log.info("class " + name);
        if (supercl != null && supercl != Object.class) log.info(" extends " + supercl.getName());
        log.info("\n{\n");
        printConstructors(cl);
        log.info("\r\n"); printMethods(cl);
        log.info("\r\n");
        printFields(cl);
        log.info("}");
    }
}
