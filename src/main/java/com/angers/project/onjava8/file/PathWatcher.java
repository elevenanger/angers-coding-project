package com.angers.project.onjava8.file;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.util.concurrent.*;

/**
 * @author : liuanglin
 * @date : 2022/4/29 15:06
 * @description : 文件-监测文件夹的变化，做出相应的操作
 */
public class PathWatcher {
    static Path path = Paths.get("/Users/liuanglin/data/test");
    static void delTxtFiles(){
        try {
            Files.walk(path)
                    .filter(file -> file.toString().endsWith("txt"))
                    .forEach(file -> System.out.println("deleting " + file));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(path.resolve("Hello.txt"));
        WatchService watcher = FileSystems.getDefault().newWatchService();
        path.register(watcher,ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor()
                .schedule(
                        PathWatcher::delTxtFiles,
                        250,TimeUnit.MILLISECONDS
                );
        WatchKey key = watcher.take();
        key.pollEvents().forEach(
                watchEvent -> System.out.println(
                        "event.context(): " +watchEvent.context() +
                                "\nevent.count(): " + watchEvent.count() +
                                "\nevent.kind(): " + watchEvent.kind()
                )
        );
        System.exit(0);
    }
}
