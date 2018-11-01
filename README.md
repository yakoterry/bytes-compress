# bytes-compress
bytes compress with bz2 or gz


//compressType can be bz2 or gz or dat

private static long compress(String compressType,byte [] sourceBytes) throws Exception {

    boolean enableCompress = true;
    ICompressor compressor = Compressor.getCompressor(compressType, enableCompress);

    long start = System.currentTimeMillis();
  
    byte[] targetBytes = compressor.compress(sourceBytes);

    long costMills = System.currentTimeMillis() - start;

    LOGGER.info("compress rate:"+(((targetBytes.length*1.0)/sourceBytes.length)*100)+"%");

    return costMills;
    
    }
