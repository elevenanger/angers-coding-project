package com.angers.project.exception;

public abstract class ReadDataBasement {
    public abstract void readData(String in);
    public abstract void readDataAndThrowsExceptions(String in) throws FileFormatException;
}
