package com.java.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: Sui, ChengBin
 * @Date: 2020/6/18
 **/
public class BufferReaderDemo {
    public static void main(String[] args)  {
        String relativePath = System.getProperty("user.dir");
        Path file = Paths.get(relativePath+"/testout.txt");
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = Files.newInputStream(file);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("reading testout.txt: \n" + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
