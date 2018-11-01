package com.yako.compress;

/**
 * Created by terry.qian on 2018/11/1.
 */
public class TextCompressor implements ICompressor {
    @Override
    public byte[] compress(byte[] sourceBytes) throws Exception {
        return sourceBytes;
    }

    @Override
    public String getSuffix() {

        return CompressType.dat.name();
    }
}
