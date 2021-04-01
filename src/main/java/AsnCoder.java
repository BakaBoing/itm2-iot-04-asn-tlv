import com.yafred.asn1.runtime.BERReader;
import com.yafred.asn1.runtime.BERWriter;
import generated.weatherdataprotocol.Ack;
import generated.weatherdataprotocol.ReqCmd;
import generated.weatherdataprotocol.ReqData;
import generated.weatherdataprotocol.WeatherData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class AsnCoder {

    public <T> byte[] encode(T data, Class clazz) {
        byte[] berEncoded = null;
        try (ByteArrayOutputStream bufferOut = new ByteArrayOutputStream()) {
            BERWriter berWriter = new BERWriter(bufferOut);

            if (clazz == WeatherData.class) {
                WeatherData.writePdu((WeatherData) data, berWriter);
            } else if (clazz == ReqCmd.class) {
                ReqCmd.writePdu((ReqCmd) data, berWriter);
            } else if (clazz == ReqData.class) {
                ReqData.writePdu((ReqData) data, berWriter);
            } else if (clazz == Ack.class) {
                Ack.writePdu((Ack) data, berWriter);
            }

            berEncoded = bufferOut.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return berEncoded;
    }

    public <T> T decode(byte[] byteData, Class clazz) {
        T data = null;
        try (ByteArrayInputStream input = new ByteArrayInputStream(byteData)) {
            BERReader berReader = new BERReader(input);

            if (clazz == WeatherData.class) {
                data = (T)WeatherData.readPdu(berReader);
            } else if (clazz == ReqCmd.class) {
                data = (T)ReqCmd.readPdu(berReader);
            } else if (clazz == ReqData.class) {
                data = (T)ReqData.readPdu(berReader);
            } else if (clazz == Ack.class) {
                data = (T)Ack.readPdu(berReader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
