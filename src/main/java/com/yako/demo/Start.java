package com.yako.demo;

import com.yako.compress.Compressor;
import com.yako.compress.ICompressor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

/**
 * Created by terry.qian on 2018/11/1.
 */
public class Start
{
    private static Logger LOGGER = LoggerFactory.getLogger(Start.class);
    public static void main(String [] args) throws Exception {


        int byteSize = 10;
        byte[] sourceBytes = new byte[byteSize * 1024 * 1024];

        for (int i = 0; i < byteSize * 1024 * 1024; i++) {

            sourceBytes[i] = Byte.parseByte(String.valueOf((i + 100 + i * new Random().nextInt(8)) % 128));
            //LOGGER.info(String.valueOf(sourceBytes[i]));
        }

        testCompress(sourceBytes,"gz",15);

        testCompress(sourceBytes,"bz2",15);
    }

    private static void testCompress(byte [] sourceBytes,String compressType,int compressCount) throws Exception {

        long sumCostMills = 0;

        for (int i = 0; i < compressCount; i++) {

            long costMills = compress(compressType, sourceBytes);
            sumCostMills += costMills;
        }
        long avgCostMills = sumCostMills / compressCount;
        LOGGER.info("###############compressType:"
                + compressType + ",compressCount:" + compressCount + ",avgCostMills:" + avgCostMills);
    }

    private static long compress(String compressType,byte [] sourceBytes) throws Exception {

        boolean enableCompress = true;
        ICompressor compressor = Compressor.getCompressor(compressType, enableCompress);

        long start = System.currentTimeMillis();
        byte[] targetBytes = compressor.compress(sourceBytes);

        long costMills = System.currentTimeMillis() - start;

        //LOGGER.info("sourceBytes length:" + sourceBytes.length);
        //LOGGER.info("targetBytes length:" + targetBytes.length);
        //LOGGER.info("compress cost:" + costMills + " mills,with: " + compressor.getSuffix());
        LOGGER.info("compress rate:"+(((targetBytes.length*1.0)/sourceBytes.length)*100)+"%");

        return costMills;
    }
}
