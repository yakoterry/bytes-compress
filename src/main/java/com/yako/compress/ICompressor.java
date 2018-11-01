package com.yako.compress;

/**
 * Created by terry.qian on 2018/11/1.
 */
public interface ICompressor {

    byte[] compress(byte[] sourceBytes) throws Exception;

    String getSuffix();
}
