package com.yako.compress;

import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by terry.qian on 2018/11/1.
 */
public class GZipCompressor implements ICompressor {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public byte[] compress(byte[] sourceBytes) throws Exception {

        long start = System.currentTimeMillis();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GzipCompressorOutputStream bcos = new GzipCompressorOutputStream(out);
        try {
            bcos.write(sourceBytes);
        } finally {
            bcos.close();
            out.close();
        }

        LOGGER.info("GZipCompressor cost:" + (System.currentTimeMillis() - start) + " mills");

        return out.toByteArray();
    }

    @Override
    public String getSuffix() {
        return CompressType.gz.name();
    }
}
