package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ByteConverter {
    public static byte[] toByteArray(Object obj) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ObjectOutputStream os = new ObjectOutputStream(out)) {
            os.writeObject(obj);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
