package com.ifmo.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


// шифрующие потоки
public class CryptoOutputStream extends FilterOutputStream {

    private byte[] key;
    private int currentKeyPosition;

    public CryptoOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {

        // тут реализация шифрования
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {

        // шифрование
        super.write(b, off, len);
    }

}
