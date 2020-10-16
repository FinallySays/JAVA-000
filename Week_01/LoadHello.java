import java.io.*;
import java.lang.reflect.Method;

/**
 * @program: TryLoaderSequence
 * @description:
 * @author: Shiwp
 * @create: 2020-10-16 07:39
 **/

public class LoadHello extends ClassLoader {

    public Class<?> load(File file) throws IOException {
        byte[] bytes = getBytes(file);
        bytesHandler(bytes);
        return defineClass(file.getName().split("\\.")[0], bytes, 0, bytes.length);
    }

    private byte[] getBytes(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        return input.readAllBytes();
    }

    private void bytesHandler(byte[] bytes) {
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/swp/desktop/Hello.xlass");
        Class clazz = new LoadHello().load(file);
        Method hello = clazz.getDeclaredMethod("hello");
        hello.setAccessible(true);
        hello.invoke(clazz.newInstance());
    }
}
