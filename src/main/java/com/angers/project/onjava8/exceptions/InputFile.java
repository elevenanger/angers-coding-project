package com.angers.project.onjava8.exceptions;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : liuanglin
 * @date : 2022/4/25 20:08
 * @description :异常-注意发生在构造函数中的异常
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String filename) throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader(filename));
        }catch (FileNotFoundException e){
            System.out.println("couldn't open " + filename);
            // 没有打开流，所以无需关闭
            throw e;
        }catch (Exception e){
            try {
                in.close();
            }catch (IOException e2){
                System.out.println("in.close unsuccessful");
            }
            throw  e;
        }finally {

        }
    }
    public String getLine(){
        String s;
        try {
            s = in.readLine();
        }catch (IOException e){
            throw new RuntimeException("read line failed");
        }
        return s;
    }
    void dispose(){
        try {
            in.close();
            System.out.println("dispose successful");
        }catch (IOException e){
            throw new RuntimeException("in.close() failed");
        }
    }

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile(CommonUtils.FILE_PATH+"/notice.txt");
            try {
                String s ;
                int i = 1;
                while ((s = in.getLine()) != null){
                    ;
                }
            }catch (Exception e){
                System.out.println("caught exception in main()");
                e.printStackTrace(System.out);
            }finally {
                /*
                确保正确清理
                凡是需要清理的资源
                使用 try-finally 子句包裹
                 */
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construct failed");
        }
    }
}
