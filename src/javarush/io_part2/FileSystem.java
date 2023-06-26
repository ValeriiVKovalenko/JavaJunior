package javarush.io_part2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private static final FileSystem fileSystem = new FileSystem();
    private static final Map<String, byte[]> files = new HashMap<>();

    private FileSystem(){}

    public static FileSystem getFileSystem() {
        return fileSystem;
    }

    public void create(String path) {
        validateNotExists(path);
        files.put(path, new byte[0]);
    }

    public void delete(String path) {
        validateExists(path);
        files.remove(path);
    }

    public boolean isExists(String path) {
        return files.containsKey(path);
    }

    public InputStream newInputStream(String path) {
        validateExists(path);
        return new ByteArrayInputStream(files.get(path));
    }

    public OutputStream newOutputStream(String path) {
        validateExists(path);
        return new ByteArrayOutputStream() {
            @Override
            public void flush() throws IOException {
                final byte[] bytes = toByteArray();
                files.put(path, bytes);
                super.flush();
            }

            @Override
            public void close() throws IOException {
                final byte[] bytes = toByteArray();
                files.put(path, bytes);
                super.close();
            }
        };
    }

    private void validateNotExists(String path) {
        if (files.containsKey(path)) {
            throw new RuntimeException("File exists");
        }
    }

    private void validateExists(String path) {
        if (!files.containsKey(path)) {
            throw new RuntimeException("File not found");
        }
    }
}
