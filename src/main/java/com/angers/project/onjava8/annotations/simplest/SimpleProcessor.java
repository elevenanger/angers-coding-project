package com.angers.project.onjava8.annotations.simplest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author : liuanglin
 * @date : 2022/5/16 08:46
 * @description : 注解-Simple注解处理程序
 */
@SupportedAnnotationTypes("com.angers.project.onjava8.annotations.simplest.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleProcessor extends AbstractProcessor {

    /**
     * Simple 注解处理方法
     * @param annotations the annotation types requested to be processed
     * @param roundEnv  environment for information about the current and prior round
     * @return false
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.forEach(System.out::println);
        /*
        遍历使用 Simple 注解的元素
        执行 display() 方法
         */
        roundEnv.getElementsAnnotatedWith(Simple.class)
                .forEach(this::display);
        return false;
    }

    private void display(Element element){
        System.out.println("---" + element + "---");
        /*
        element 只拥有编译器解析的基本信息
        打印元素的基本信息
         */
        System.out.println(element.getKind() +
                " : " + element.getModifiers() +
                " : " + element.getSimpleName() +
                " : " + element.asType());
        /*
        如果元素对象的类型是 class
        将其向下转型为 TypeElement 可以获得更多的信息
        打印权限定名、超类以及该类中的元素
         */
        if (element.getKind().equals(ElementKind.CLASS)) {
            TypeElement te = (TypeElement) element;
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements());
        }
        /*
        如果元素类型为方法
        将其向下转型为 ExecutableElement
        打印返回值类型、方法名和参数
         */
        if (element.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement ex = (ExecutableElement) element;
            System.out.print(ex.getReturnType() + " ");
            System.out.print(ex.getSimpleName() + "(");
            System.out.println(ex.getParameters() + ")");
        }
    }

}