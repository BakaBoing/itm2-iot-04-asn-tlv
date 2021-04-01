/*
Generated using https://github.com/yafred/asn1-tool v0.0.26
AckState ::= ENUMERATED { ack(0), nak(1) }
*/
package generated.weatherdataprotocol;

public class AckState {
    private Enum _value;

    public static AckState readPdu(com.yafred.asn1.runtime.BERReader reader) throws Exception {
        reader.readTag();
        reader.mustMatchTag(new byte[]{10}); /* PRIMITIVE_UNIVERSAL_10 */
        reader.readLength();
        AckState ret = new AckState();
        read(ret, reader, reader.getLengthValue());
        return ret;
    }

    public static void writePdu(AckState pdu, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int componentLength = write(pdu, writer);
        componentLength += writer.writeLength(componentLength);
        componentLength += writer.writeOctetString(new byte[]{10}); /* PRIMITIVE_UNIVERSAL_10 */
        writer.flush();
    }

    public static void read(AckState instance, com.yafred.asn1.runtime.BERReader reader, int componentLength) throws Exception {
        {
            int intValue = reader.readInteger(componentLength);
            if (intValue == 0) {
                instance.setValue(AckState.Enum.ACK);
            }
            if (intValue == 1) {
                instance.setValue(AckState.Enum.NAK);
            }
            if (instance.getValue() == null) {
                throw new Exception("Invalid enumeration value: " + intValue);
            }
        }
        return;
    }

    public static int write(AckState instance, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int componentLength = 0;
        int intValue = -1;
        switch (instance.getValue()) {
            case ACK:
                intValue = 0;
                break;
            case NAK:
                intValue = 1;
                break;
        }
        componentLength = writer.writeInteger(intValue);
        return componentLength;
    }

    public static AckState readPdu(com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        AckState ret = new AckState();
        read(ret, reader);
        return ret;
    }

    public static void writePdu(AckState pdu, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        write(pdu, writer);
    }

    public static void read(AckState instance, com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        {
            String identifier = reader.readIdentifier();
            if (identifier.equals("ack")) {
                instance.setValue(AckState.Enum.ACK);
            }
            if (identifier.equals("nak")) {
                instance.setValue(AckState.Enum.NAK);
            }
            if (instance.getValue() == null) {
                throw new Exception("Invalid enumeration value: " + identifier);
            }
        }
        return;
    }

    public static void write(AckState instance, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        switch (instance.getValue()) {
            case ACK:
                writer.writeIdentifier("ack");
                break;
            case NAK:
                writer.writeIdentifier("nak");
                break;
        }
    }

    public Enum getValue() {
        return _value;
    }

    public void setValue(Enum _value) {
        this._value = _value;
    }

    static public enum Enum {
        ACK, NAK
    }
}
