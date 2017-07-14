package com.Misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by 212561694 on 4/21/2017.
 */
public class KeyEncryption {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));


    }

    public boolean compareStream(File _File1, File _File2) throws IOException {
        int i = 0;
        int step = 4096;
        boolean equal = false;

        FileInputStream fi1 = new FileInputStream(_File1);
        FileInputStream fi2 = new FileInputStream(_File2);

        byte[] fi1Content = new byte[step];
        byte[] fi2Content = new byte[step];

        if (_File1.length() == _File2.length()) { //Assumption 1
            while (i * step < _File1.length()) {

                fi1.read(fi1Content, 0, step); //Assumption 2
                fi2.read(fi2Content, 0, step); //Assumption 2

                //equal = BLAKE512.isEqual(fi1Content, fi2Content); //Assumption 2

                if (!equal) { //Assumption 3
                    break;
                }

                ++i;
            }
        }

        fi1.close();
        fi2.close();
        return equal;
    }

    /*Algorithm:-
    ============
    Since you are comparing two files byte-by-byte, the hashing will make no difference. If the two files were on different machines, and you have a slow network between them, and
    if you could run the hashing algorithm remotely, then it probably makes sense to hash the two files on each side, and then just compare the small, and easy to transfer, hash result.
    Something like SHA-256. So, there's no need to hash, just do byte-by-byte comparisons.
    For large files like yours, why have such a small step size? Use something much larger like 4MB, not 4KB. It will make it much faster.
    Alternatives:-
    ============
    File IO is always slower than you want. Java has the NIO framework for higher-performance IO using Channels and Buffers. This would be a great time to learn how to use them,
    because, a 4MB Memory-Mapped IO operation on the two files will likely give you the best performance.*/

    /*public static final boolean compareFiles(final Path filea, final Path fileb) throws IOException {
        if (Files.size(filea) != Files.size(fileb)) {
            return false;
        }

        final long size = Files.size(filea);
        final int mapspan = 4 * 1024 * 1024;

        try (FileChannel chana = (FileChannel) Files.newByteChannel(filea);
             FileChannel chanb = (FileChannel)Files.newByteChannel(fileb)) {

            for (long position = 0; position < size; position += mapspan) {
                MappedByteBuffer mba = mapChannel(chana, position, size, mapspan);
                MappedByteBuffer mbb = mapChannel(chanb, position, size, mapspan);

                if (mba.compareTo(mbb) != 0) {
                    return false;
                }

            }

        }
        return true;
    }

    private static MappedByteBuffer mapChannel(FileChannel channel, long position, long size, int mapspan) throws IOException {
        final long end = Math.min(size, position + mapspan);
        final long maplen = (int)(end - position);
        return channel.map(FileChannel.MapMode.READ_ONLY, position, maplen);
    }*/
}
