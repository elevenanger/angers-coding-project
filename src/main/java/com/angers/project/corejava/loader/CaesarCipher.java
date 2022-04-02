package com.angers.project.corejava.loader;

import lombok.extern.slf4j.Slf4j;

import java.util.ServiceLoader;

@Slf4j
public class CaesarCipher implements Cipher{

    @Override
    public byte encrypt(byte[] source, byte[] key) {
        return 0;
    }

    @Override
    public byte decrypt(byte[] source, byte[] key) {
        return 0;
    }

    @Override
    public int strength() {
        return 0;
    }

    public static void main (String [] args){
        /*
        通过类加载器加的迭代方法查找所有实现了 Cipher 接口的类
        并对 loader 进行遍历，调用其中的
         */
        ServiceLoader<Cipher> loader = ServiceLoader.load(Cipher.class);
        for (Cipher cipher:loader){
            if (cipher instanceof CaesarCipher){
                cipher.strength();
            }
        }
    }
}
