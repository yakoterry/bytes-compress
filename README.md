# bytes-compress
bytes compress with bz2 or gz


//compressType can be bz2 or gz or dat
private static long compress(String compressType,byte [] sourceBytes) throws Exception {

    boolean enableCompress = true;
    ICompressor compressor = Compressor.getCompressor(compressType, enableCompress);
  
    byte[] targetBytes = compressor.compress(sourceBytes);

    return costMills;
    
    }
