package com.yako.compress;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by terry.qian on 2018/11/1.
 */
public class BZip2Compressor implements ICompressor {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public byte[] compress(byte[] sourceBytes) throws Exception {

        long start = System.currentTimeMillis();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BZip2CompressorOutputStream bcos = new BZip2CompressorOutputStream(out);
        try {
            bcos.write(sourceBytes);
        } finally {
            bcos.close();
            out.close();
        }

        LOGGER.info("BZip2Compressor cost:" + (System.currentTimeMillis() - start) + " mills");

        return out.toByteArray();
    }

    @Override
    public String getSuffix() {
        return CompressType.bz2.name();
    }
}
