package com.yako.compress;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by terry.qian on 2018/11/1.
 */
public class Compressor {
    static Logger LOGGER = LoggerFactory.getLogger(Compressor.class);

    public static ICompressor getCompressor(String compressType, boolean enableCompress) {

        ICompressor compressor = null;

        if (!enableCompress) {
            compressor = new TextCompressor();
        } else {

            if (!StringUtils.isEmpty(compressType)) {

                if (compressType.equals(CompressType.dat.name())) {

                    compressor = new TextCompressor();
                } else if (compressType.equals(CompressType.bz2.name())) {

                    compressor = new BZip2Compressor();
                } else if (compressType.equals(CompressType.gz.name())) {

                    compressor = new GZipCompressor();
                }
            }

            if (compressor == null) {
                compressor = new TextCompressor();
            }
        }

        LOGGER.info("compressor: " + compressor.getSuffix() + ",compressType:" + compressType);

        return compressor;
    }
}
