package com.angers.project.corejava.exception;

public abstract class ReadDataBasement {
    public abstract void readData(String in);
    public abstract void readDataAndThrowsExceptions(String in) throws FileFormatException;
}
