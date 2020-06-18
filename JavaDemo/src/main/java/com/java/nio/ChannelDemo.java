package com.java.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Description:
 * @Author: Sui, ChengBin
 * @Date: 2020/6/18
 **/
public class ChannelDemo {

    public static void main(String[] args) throws IOException {
        String relativePath = System.getProperty("user.dir");
        System.out.println(relativePath);
        FileInputStream fis = new FileInputStream(relativePath+"/testin.txt");
        ReadableByteChannel rChannel = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(relativePath+"/testout.txt");
        WritableByteChannel wChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(20*2014);
        while (rChannel.read(buffer)!=-1){
            buffer.flip();
            while(buffer.hasRemaining()){
                wChannel.write(buffer);
                System.out.println(buffer);
            }
            buffer.clear();
        }
        rChannel.close();
        wChannel.close();
    }

}
