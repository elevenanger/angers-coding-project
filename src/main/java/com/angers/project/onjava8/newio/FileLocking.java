package com.angers.project.onjava8.newio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @author : liuanglin
 * @date : 2022/6/1 15:15
 * @description : 给文件加锁
 */
public class FileLocking {
    private static Path path = Paths.get("/Users/liuanglin/data/lock.dat");
    public static void main(String[] args) {
        try (FileOutputStream fos =
                new FileOutputStream(path.toFile());
                FileLock fileLock = fos.getChannel().tryLock()){
            if (fileLock != null) {
                System.out.println("Locked File");
                TimeUnit.MICROSECONDS.sleep(100);
                fileLock.release();
                System.out.println("release lock");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
