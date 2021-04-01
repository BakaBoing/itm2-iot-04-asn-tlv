/*
Generated using https://github.com/yafred/asn1-tool v0.0.26
ReqCmd ::= SEQUENCE {
   version [0] IMPLICIT INTEGER OPTIONAL,
   messageTimestamp [1] IMPLICIT DATE-TIME,
   msgNum [2] IMPLICIT INTEGER,
   commandNumber [3] IMPLICIT INTEGER
}
*/
package generated.weatherdataprotocol;

public class ReqCmd {
    private java.lang.Integer _version;
    private java.lang.String _messageTimestamp;
    private java.lang.Integer _msgNum;
    private java.lang.Integer _commandNumber;

    public static ReqCmd readPdu(com.yafred.asn1.runtime.BERReader reader) throws Exception {
        reader.readTag();
        reader.mustMatchTag(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        reader.readLength();
        ReqCmd ret = new ReqCmd();
        read(ret, reader, reader.getLengthValue());
        return ret;
    }

    public static void writePdu(ReqCmd pdu, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int componentLength = write(pdu, writer);
        componentLength += writer.writeLength(componentLength);
        componentLength += writer.writeOctetString(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        writer.flush();
    }

    public static int write(ReqCmd instance, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int length = 0;
        if (instance.getCommandNumber() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getCommandNumber());
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

    public static void read(ReqCmd instance, com.yafred.asn1.runtime.BERReader reader, int length) throws Exception {
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
        instance.setCommandNumber(reader.readInteger(componentLength));
        if (length != -1) length -= componentLength;
        if (length == -1) {
            reader.readTag();
            reader.mustMatchTag(new byte[]{0});
            reader.mustReadZeroLength();
        } else if (length != 0) throw new Exception("length should be 0, not " + length);
        return;
    }

    public static ReqCmd readPdu(com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        ReqCmd ret = new ReqCmd();
        read(ret, reader);
        return ret;
    }

    public static void writePdu(ReqCmd pdu, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        write(pdu, writer);
    }

    public static void write(ReqCmd instance, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
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
        if (instance.getCommandNumber() != null) {
            writer.writeComponent("commandNumber");
            writer.writeInteger(instance.getCommandNumber());
        }
        writer.endSequence();
    }

    public static void read(ReqCmd instance, com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
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
        if (componentName.equals("commandNumber")) {
            instance.setCommandNumber(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        } else {
            throw new Exception("Expecting commandNumber (not OPTIONAL)");
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

    public java.lang.Integer getCommandNumber() {
        return _commandNumber;
    }

    public void setCommandNumber(java.lang.Integer _commandNumber) {
        this._commandNumber = _commandNumber;
    }
}
