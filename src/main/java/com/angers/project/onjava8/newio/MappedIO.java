package com.angers.project.onjava8.newio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/6/1 14:36
 * @description : 性能比较
 */
public class MappedIO {
    private static int numOfInts = 4_000_000;
    private static int numOfUbuffInts = 100_000;
    static Path path = Paths.get("/Users/liuanglin/data/test.dat");
    private abstract static class Tester {
        private String name;
        Tester(String name){
            this.name = name;
        }
        public void runTest(){
            System.out.println(name + " : ");
            long start = System.nanoTime();
            test();
            double duration = System.nanoTime() - start;
            System.out.printf("%.3f%n",duration/1.0e9);
        }
        public abstract void test();
    }
    private static Tester [] tests = {
            new Tester("Stream Write") {
                @Override
                public void test() {
                    try (DataOutputStream dos =
                            new DataOutputStream(
                                    new BufferedOutputStream(
                                            Files.newOutputStream(path)))){
                        for (int i = 0; i < numOfInts; i++) {
                            dos.write(i);
                        }
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() {
                    try (FileChannel fc =
                            new RandomAccessFile(path.toString(),"rw")
                                    .getChannel()){
                        IntBuffer intBuffer =
                                fc.map(FileChannel.MapMode.READ_WRITE,
                                        0,fc.size()).asIntBuffer();
                        for (int i = 0; i < numOfInts; i++) {
                            intBuffer.put(i);
                        }
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() {
                    try (DataInputStream dis =
                            new DataInputStream(
                                    new BufferedInputStream(
                                            Files.newInputStream(path)))){
                        for (int i = 0; i < numOfInts; i++) {
                            dis.readInt();
                        }
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() {
                    try (FileChannel fc = new FileInputStream(path.toString()).getChannel()){
                        IntBuffer intBuffer =
                                fc.map(FileChannel.MapMode.READ_ONLY
                                ,0, fc.size()).asIntBuffer();
                        while (intBuffer.hasRemaining()) intBuffer.get();
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() {
                    try (RandomAccessFile raf =
                            new RandomAccessFile(path.toString(),"rw")){
                        raf.writeInt(1);
                        for (int i = 0; i < numOfUbuffInts; i++) {
                            raf.seek(raf.length() - 4);
                            raf.writeInt(i);
                        }
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                public void test() {
                    try (FileChannel fc = new RandomAccessFile(
                            new File(path.toString()),"rw").getChannel()){
                        IntBuffer intBuffer =
                                fc.map(FileChannel.MapMode.READ_WRITE,
                                        0,fc.size()).asIntBuffer();
                        intBuffer.put(0);
                        for (int i = 1; i < numOfUbuffInts; i++) {
                            intBuffer.put(intBuffer.get(i - 1));
                        }
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            }
    };

    public static void main(String[] args) {
        Arrays.stream(tests).forEach(Tester::runTest);
    }
}
