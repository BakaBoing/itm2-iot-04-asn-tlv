/*
Generated using https://github.com/yafred/asn1-tool v0.0.26
Ack ::= SEQUENCE {
   version [0] IMPLICIT INTEGER OPTIONAL,
   messageTimestamp [1] IMPLICIT DATE-TIME,
   msgNum [2] IMPLICIT INTEGER,
   state [3] IMPLICIT AckState
}
*/
package generated.weatherdataprotocol;

public class Ack {
    private java.lang.Integer _version;
    private java.lang.String _messageTimestamp;
    private java.lang.Integer _msgNum;
    private AckState.Enum _state;

    public static Ack readPdu(com.yafred.asn1.runtime.BERReader reader) throws Exception {
        reader.readTag();
        reader.mustMatchTag(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        reader.readLength();
        Ack ret = new Ack();
        read(ret, reader, reader.getLengthValue());
        return ret;
    }

    public static void writePdu(Ack pdu, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int componentLength = write(pdu, writer);
        componentLength += writer.writeLength(componentLength);
        componentLength += writer.writeOctetString(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        writer.flush();
    }

    public static int write(Ack instance, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int length = 0;
        if (instance.getState() != null) {
            int componentLength = 0;
            int intValue = -1;
            switch (instance.getState()) {
                case ACK:
                    intValue = 0;
                    break;
                case NAK:
                    intValue = 1;
                    break;
            }
            componentLength = writer.writeInteger(intValue);
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-125}); /* PRIMITIVE_CONTEXT_3 */
            length += componentLength;
        }
        if (instance.getMsgNum() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getMsgNum());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-126}); /* PRIMITIVE_CONTEXT_2 */
            length += componentLength;
        }
        if (instance.getMessageTimestamp() != null) {
            int componentLength = 0;
            componentLength = writer.writeRestrictedCharacterString(instance.getMessageTimestamp());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-127}); /* PRIMITIVE_CONTEXT_1 */
            length += componentLength;
        }
        if (instance.getVersion() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getVersion());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-128}); /* PRIMITIVE_CONTEXT_0 */
            length += componentLength;
        }
        return length;
    }

    public static void read(Ack instance, com.yafred.asn1.runtime.BERReader reader, int length) throws Exception {
        int componentLength = 0;
        if (length == 0) return;
        reader.readTag();
        if (length != -1) length -= reader.getTagLength();
        if (length == -1 && reader.matchTag(new byte[]{0})) {
            reader.mustReadZeroLength();
            return;
        }
        reader.matchTag(new byte[]{-128}); /* PRIMITIVE_CONTEXT_0 */
        if (reader.isTagMatched()) {
            reader.readLength();
            if (length != -1) length -= reader.getLengthLength();
        }
        if (reader.isTagMatched()) {
            componentLength = reader.getLengthValue();
            instance.setVersion(reader.readInteger(componentLength));
            if (length != -1) length -= componentLength;
        }
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        reader.mustMatchTag(new byte[]{-127}); /* PRIMITIVE_CONTEXT_1 */
        reader.readLength();
        if (length != -1) length -= reader.getLengthLength();
        componentLength = reader.getLengthValue();
        instance.setMessageTimestamp(reader.readRestrictedCharacterString(componentLength));
        if (length != -1) length -= componentLength;
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        reader.mustMatchTag(new byte[]{-126}); /* PRIMITIVE_CONTEXT_2 */
        reader.readLength();
        if (length != -1) length -= reader.getLengthLength();
        componentLength = reader.getLengthValue();
        instance.setMsgNum(reader.readInteger(componentLength));
        if (length != -1) length -= componentLength;
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        reader.mustMatchTag(new byte[]{-125}); /* PRIMITIVE_CONTEXT_3 */
        reader.readLength();
        if (length != -1) length -= reader.getLengthLength();
        componentLength = reader.getLengthValue();
        {
            int intValue = reader.readInteger(componentLength);
            if (intValue == 0) {
                instance.setState(AckState.Enum.ACK);
            }
            if (intValue == 1) {
                instance.setState(AckState.Enum.NAK);
            }
            if (instance.getState() == null) {
                throw new Exception("Invalid enumeration value: " + intValue);
            }
        }
        if (length != -1) length -= componentLength;
        if (length == -1) {
            reader.readTag();
            reader.mustMatchTag(new byte[]{0});
            reader.mustReadZeroLength();
        } else if (length != 0) throw new Exception("length should be 0, not " + length);
        return;
    }

    public static Ack readPdu(com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        Ack ret = new Ack();
        read(ret, reader);
        return ret;
    }

    public static void writePdu(Ack pdu, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        write(pdu, writer);
    }

    public static void write(Ack instance, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        writer.beginSequence();
        if (instance.getVersion() != null) {
            writer.writeComponent("version");
            writer.writeInteger(instance.getVersion());
        }
        if (instance.getMessageTimestamp() != null) {
            writer.writeComponent("messageTimestamp");
            writer.writeRestrictedCharacterString(instance.getMessageTimestamp());
        }
        if (instance.getMsgNum() != null) {
            writer.writeComponent("msgNum");
            writer.writeInteger(instance.getMsgNum());
        }
        if (instance.getState() != null) {
            writer.writeComponent("state");
            switch (instance.getState()) {
                case ACK:
                    writer.writeIdentifier("ack");
                    break;
                case NAK:
                    writer.writeIdentifier("nak");
                    break;
            }
        }
        writer.endSequence();
    }

    public static void read(Ack instance, com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        String componentName = null;
        reader.readToken(); // read '{'
        if ("}".equals(reader.lookAheadToken())) { // empty sequence
            reader.readToken();
            return;
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("version")) {
            instance.setVersion(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("messageTimestamp")) {
            instance.setMessageTimestamp(reader.readRestrictedCharacterString());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        } else {
            throw new Exception("Expecting messageTimestamp (not OPTIONAL)");
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("msgNum")) {
            instance.setMsgNum(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        } else {
            throw new Exception("Expecting msgNum (not OPTIONAL)");
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("state")) {
            {
                String identifier = reader.readIdentifier();
                if (identifier.equals("ack")) {
                    instance.setState(AckState.Enum.ACK);
                }
                if (identifier.equals("nak")) {
                    instance.setState(AckState.Enum.NAK);
                }
                if (instance.getState() == null) {
                    throw new Exception("Invalid enumeration value: " + identifier);
                }
            }
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        } else {
            throw new Exception("Expecting state (not OPTIONAL)");
        }
        if (componentName != null) throw new Exception("Unexpected component " + componentName);
    }

    public java.lang.Integer getVersion() {
        return _version;
    }

    public void setVersion(java.lang.Integer _version) {
        this._version = _version;
    }

    public java.lang.String getMessageTimestamp() {
        return _messageTimestamp;
    }

    public void setMessageTimestamp(java.lang.String _messageTimestamp) {
        this._messageTimestamp = _messageTimestamp;
    }

    public java.lang.Integer getMsgNum() {
        return _msgNum;
    }

    public void setMsgNum(java.lang.Integer _msgNum) {
        this._msgNum = _msgNum;
    }

    public AckState.Enum getState() {
        return this._state;
    }

    public void setState(AckState.Enum _state) {
        this._state = _state;
    }
}
