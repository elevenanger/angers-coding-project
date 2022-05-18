package com.angers.project.onjava8.annotations.ifx;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/16 10:59
 * @description : 注解-接口注解处理器
 */
@SupportedAnnotationTypes("com.angers.project.onjava8.annotations.ifx.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IfaceExtractorProcessor extends AbstractProcessor {
    private ArrayList<Element> interfaceMethods = new ArrayList<>();
    Elements elementUtils;
    private ProcessingEnvironment processingEnv;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
            String interfaceName = element.getAnnotation(ExtractInterface.class).interfaceName();
            for (Element enclosed : element.getEnclosedElements()) {
                if (enclosed.getKind().equals(ElementKind.METHOD) &&
                enclosed.getModifiers().contains(Modifier.PUBLIC) &&
                !enclosed.getModifiers().contains(Modifier.STATIC)){
                    interfaceMethods.add(enclosed);
                }
            }
            if (!interfaceMethods.isEmpty() ) writeInterfaceFile(interfaceName);
        }
        return false;
    }

    private void writeInterfaceFile(String interfaceName){
        try (Writer writer = processingEnv.getFiler()
                .createSourceFile(interfaceName)
                .openWriter()){
            String packageName = elementUtils.getPackageOf(interfaceMethods.get(0)).toString();
            writer.write("package " + packageName + ":\n");
            writer.write("public interface " + interfaceName + "{\n");
            for (Element element : interfaceMethods) {
                ExecutableElement method = (ExecutableElement) element;
                String signature = " public " ;
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(method.getParameters());
                System.out.println(signature);
                writer.write(signature + ";\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createArgList(List<? extends VariableElement> parameters){
        String args = parameters.stream()
                .map(p -> p.asType() + " " + p.getSimpleName())
                .collect(Collectors.joining(" , "));
        return "(" + args + ")";
    }
}