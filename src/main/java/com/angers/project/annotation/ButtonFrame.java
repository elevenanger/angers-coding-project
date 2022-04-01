package com.angers.project.annotation;

import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private final JPanel panel;
    private JButton yellowButton;
    private JButton blueButton;
    private JButton redButton;

    public ButtonFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        panel = new JPanel();
        add(panel);
        yellowButton = new JButton("Yellow");
        blueButton  = new JButton("Blue");
        redButton = new JButton("Red");
        ActionListenerInstaller.processAnnotations(this);
    }

    /**
     * 使用注解省去了每次都要调用 yellowButton.addActionListener(() -> doSomething());
     * 使用注解的格式 @AnnotationName(elementName1=value1,elementName2=value2,...)
     * 元素的顺序不重要，如果没有为元素赋值就会使用默认值
     * 如果没有默认值就必须赋值
     */
    @ActionListenerFor(source="yellowButton")
    public void yellowBackground(){
        panel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source="blueButton")
    public void blueBackground(){
        panel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source="redButton")
    public void redBackground(){
        panel.setBackground(Color.RED);
    }

}
