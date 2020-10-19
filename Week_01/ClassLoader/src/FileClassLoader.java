import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: ClassLoader
 * @description:
 * @author: Shiwp
 * @create: 2020-10-19 21:26
 **/

public class FileClassLoader extends ClassLoader {

    public Class<?> load(File file) {
        byte[] bytes = getBytes(file);
        bytesHandler(bytes);
        return defineClass(file.getName().split("\\.")[0], bytes, 0, bytes.length);
    }

    private byte[] getBytes(File file) {
        try (InputStream input = new FileInputStream(file)) {
            return input.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private void bytesHandler(byte[] bytes) {
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File(FileClassLoader.class.getResource("/files/Hello.xlass").getPath());
        Class clazz = new FileClassLoader().load(file);
        clazz.getDeclaredMethod("hello").invoke(clazz.newInstance());
    }

}
