package asn;

import asn.*;
import com.github.alturkovic.asn.decoder.AsnDecoder;
import com.github.alturkovic.asn.decoder.BerDecoder;
import com.github.alturkovic.asn.encoder.AsnEncoder;
import com.github.alturkovic.asn.encoder.BerEncoder;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Coder {
    private final AsnEncoder<byte[]> _encoder = new BerEncoder();
    private final AsnDecoder<byte[]> _decoder = new BerDecoder();

    private final List<Class> _tryDecode = new LinkedList<>() {{
        add(WeatherData.class);
        add(Ack.class);
        add(ReqCmd.class);
        add(ReqData.class);
    }};
    private ListIterator<Class> _actClass = _tryDecode.listIterator();

    public byte[] encode(IAsnClass data) {
        return _encoder.encode(data);
    }

    public IAsnClass decode(byte[] data) {
        return decode(data, _actClass.next());
    }

    private IAsnClass decode(byte[] data, Class clazz) {
        IAsnClass result;

        try {
            result = (IAsnClass) _decoder.decode(clazz, data);
        } catch (Exception e) {
            if (_actClass.hasNext())
                result = decode(data, _actClass.next());
            else
                result = null;
        }

        return result;
    }
}
