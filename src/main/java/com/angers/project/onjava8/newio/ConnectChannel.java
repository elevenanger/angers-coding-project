package com.angers.project.onjava8.newio;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/6/1 08:21
 * @description : 使用 transferTo 和 transferFrom 方法连接 channel
 */
public class ConnectChannel {

    private static File file= Paths.get(CommonUtils.NIO_FILE_PATH,"transferSource.txt").toFile();
    private static File descFile = Paths.get(CommonUtils.NIO_FILE_PATH,"transferDest.txt").toFile();

    public static void main(String[] args) {
        try(FileChannel in = new FileInputStream(file).getChannel();
        FileChannel out = new FileOutputStream(descFile).getChannel()){
            in.transferTo(0,in.size(),out);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
