package com.medicare.config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtil {

    private static final int BUFFER_SIZE = 8 * 1024; // Adjust as needed

    public static byte[] compressImage(byte[] data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length)) {
            Deflater deflater = new Deflater(Deflater.BEST_SPEED); // Adjust compression level
            deflater.setInput(data);
            deflater.finish();
            byte[] buffer = new byte[BUFFER_SIZE];
            while (!deflater.finished()) {
                int count = deflater.deflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Compression failed, Please check the file format", e);
        }
    }

    public static byte[] decompressImage(byte[] data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length)) {
            Inflater inflater = new Inflater();
            inflater.setInput(data);


            byte[] buffer = new byte[BUFFER_SIZE];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer,0, count);
            }
            return outputStream.toByteArray();
        } catch (DataFormatException | IOException e) {
            throw new RuntimeException("Decompression failed", e);
        }
    }
}
