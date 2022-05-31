package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author : liuanglin
 * @date : 2022/5/31 15:56
 * @description : 使用 RandomAccessFile
 */
public class UsingRandomAccessFile {
    static Path path = Paths.get(CommonUtils.IO_FILE_PATH, "random.txt");
    public static void display() {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(),"r")){
            for (int i = 0; i < 7; i++) {
                System.out.println(
                    "Value " + i + " : " + raf.readDouble());
            }
            System.out.println(raf.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try (RandomAccessFile ra = new RandomAccessFile(path.toFile(),"rw")){
            for (int i = 0; i < 7; i++) {
                ra.writeDouble(i * 1.44);
            }
            ra.writeUTF("THE END .");
            ra.close();
            display();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (RandomAccessFile ra = new RandomAccessFile(path.toFile(),"rw")){
            ra.seek(5*8);
            ra.writeDouble(93.0001);
            ra.close();
            display();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
