package com.angers.project.corejava.loader;

/**
 * 加密接口
 */
public interface Cipher {

    byte encrypt(byte [] source,byte [] key);

    byte decrypt(byte [] source,byte [] key);

    int strength();

}
