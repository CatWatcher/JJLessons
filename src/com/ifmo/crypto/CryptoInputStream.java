package com.ifmo.crypto;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {

    private byte[] key;
    private int currentKeyPosition;

    public CryptoInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int data = super.read(b);
        //тут дешифровка данных
        return data;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {

        int data = super.read(b, off, len);
        // дешифровка
        return data;
    }
}
