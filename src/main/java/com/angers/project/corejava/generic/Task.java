package com.angers.project.corejava.generic;

public interface Task {

    void run() throws Exception;

    @SuppressWarnings("unchecked")
    static <T extends Throwable> void throwAs(Throwable t) throws T{
        throw (T) t;
    }

    static Runnable asRunable(Task task){
        return () ->
        {
            try{
                task.run();
            }
            catch (Exception e){
                Task.<RuntimeException>throwAs(e);
            }
        };
    }

    public static void main(String [] args){
        Thread thread = new Thread(Task.asRunable(() ->
        {
            Thread.sleep(1000);
            throw new Exception("check");
        }));
        thread.start();
    }
}
