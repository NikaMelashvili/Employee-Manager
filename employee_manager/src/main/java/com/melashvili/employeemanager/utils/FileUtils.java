package com.melashvili.employeemanager.utils;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class FileUtils {

    public static byte[] compressFile(String sourceFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             ByteArrayOutputStream output = new ByteArrayOutputStream();
             GZIPOutputStream gzipOS = new GZIPOutputStream(output)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, bytesRead);
            }

            gzipOS.finish();
            gzipOS.flush();
            return output.toByteArray();
        }
    }
}
