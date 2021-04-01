/*
Generated using https://github.com/yafred/asn1-tool v0.0.26
AsnClasses.WeatherDataPoint ::= SEQUENCE {
   dataTimestampUTC [0] IMPLICIT DATE-TIME,
   timezone [1] IMPLICIT INTEGER OPTIONAL,
   temperatureDecKel [2] IMPLICIT INTEGER OPTIONAL,
   humidityMgm3 [3] IMPLICIT INTEGER OPTIONAL
}
*/
package generated.weatherdataprotocol;

public class WeatherDataPoint {
    private java.lang.String _dataTimestampUTC;
    private java.lang.Integer _timezone;
    private java.lang.Integer _temperatureDecKel;
    private java.lang.Integer _humidityMgm3;

    public static WeatherDataPoint readPdu(com.yafred.asn1.runtime.BERReader reader) throws Exception {
        reader.readTag();
        reader.mustMatchTag(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        reader.readLength();
        WeatherDataPoint ret = new WeatherDataPoint();
        read(ret, reader, reader.getLengthValue());
        return ret;
    }

    public static void writePdu(WeatherDataPoint pdu, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int componentLength = write(pdu, writer);
        componentLength += writer.writeLength(componentLength);
        componentLength += writer.writeOctetString(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        writer.flush();
    }

    public static int write(WeatherDataPoint instance, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int length = 0;
        if (instance.getHumidityMgm3() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getHumidityMgm3());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-125}); /* PRIMITIVE_CONTEXT_3 */
            length += componentLength;
        }
        if (instance.getTemperatureDecKel() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getTemperatureDecKel());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-126}); /* PRIMITIVE_CONTEXT_2 */
            length += componentLength;
        }
        if (instance.getTimezone() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getTimezone());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-127}); /* PRIMITIVE_CONTEXT_1 */
            length += componentLength;
        }
        if (instance.getDataTimestampUTC() != null) {
            int componentLength = 0;
            componentLength = writer.writeRestrictedCharacterString(instance.getDataTimestampUTC());
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-128}); /* PRIMITIVE_CONTEXT_0 */
            length += componentLength;
        }
        return length;
    }

    public static void read(WeatherDataPoint instance, com.yafred.asn1.runtime.BERReader reader, int length) throws Exception {
        int componentLength = 0;
        if (length == 0) return;
        reader.readTag();
        if (length != -1) length -= reader.getTagLength();
        reader.mustMatchTag(new byte[]{-128}); /* PRIMITIVE_CONTEXT_0 */
        reader.readLength();
        if (length != -1) length -= reader.getLengthLength();
        componentLength = reader.getLengthValue();
        instance.setDataTimestampUTC(reader.readRestrictedCharacterString(componentLength));
        if (length != -1) length -= componentLength;
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        if (length == -1 && reader.matchTag(new byte[]{0})) {
            reader.mustReadZeroLength();
            return;
        }
        reader.matchTag(new byte[]{-127}); /* PRIMITIVE_CONTEXT_1 */
        if (reader.isTagMatched()) {
            reader.readLength();
            if (length != -1) length -= reader.getLengthLength();
        }
        if (reader.isTagMatched()) {
            componentLength = reader.getLengthValue();
            instance.setTimezone(reader.readInteger(componentLength));
            if (length != -1) length -= componentLength;
        }
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        if (length == -1 && reader.matchTag(new byte[]{0})) {
            reader.mustReadZeroLength();
            return;
        }
        reader.matchTag(new byte[]{-126}); /* PRIMITIVE_CONTEXT_2 */
        if (reader.isTagMatched()) {
            reader.readLength();
            if (length != -1) length -= reader.getLengthLength();
        }
        if (reader.isTagMatched()) {
            componentLength = reader.getLengthValue();
            instance.setTemperatureDecKel(reader.readInteger(componentLength));
            if (length != -1) length -= componentLength;
        }
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        if (length == -1 && reader.matchTag(new byte[]{0})) {
            reader.mustReadZeroLength();
            return;
        }
        reader.matchTag(new byte[]{-125}); /* PRIMITIVE_CONTEXT_3 */
        if (reader.isTagMatched()) {
            reader.readLength();
            if (length != -1) length -= reader.getLengthLength();
        }
        if (reader.isTagMatched()) {
            componentLength = reader.getLengthValue();
            instance.setHumidityMgm3(reader.readInteger(componentLength));
            if (length != -1) length -= componentLength;
        }
        if (length == -1) {
            reader.readTag();
            reader.mustMatchTag(new byte[]{0});
            reader.mustReadZeroLength();
        } else if (length != 0) throw new Exception("length should be 0, not " + length);
        return;
    }

    public static WeatherDataPoint readPdu(com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        WeatherDataPoint ret = new WeatherDataPoint();
        read(ret, reader);
        return ret;
    }

    public static void writePdu(WeatherDataPoint pdu, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        write(pdu, writer);
    }

    public static void write(WeatherDataPoint instance, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        writer.beginSequence();
        if (instance.getDataTimestampUTC() != null) {
            writer.writeComponent("dataTimestampUTC");
            writer.writeRestrictedCharacterString(instance.getDataTimestampUTC());
        }
        if (instance.getTimezone() != null) {
            writer.writeComponent("timezone");
            writer.writeInteger(instance.getTimezone());
        }
        if (instance.getTemperatureDecKel() != null) {
            writer.writeComponent("temperatureDecKel");
            writer.writeInteger(instance.getTemperatureDecKel());
        }
        if (instance.getHumidityMgm3() != null) {
            writer.writeComponent("humidityMgm3");
            writer.writeInteger(instance.getHumidityMgm3());
        }
        writer.endSequence();
    }

    public static void read(WeatherDataPoint instance, com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        String componentName = null;
        reader.readToken(); // read '{'
        if ("}".equals(reader.lookAheadToken())) { // empty sequence
            reader.readToken();
            return;
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("dataTimestampUTC")) {
            instance.setDataTimestampUTC(reader.readRestrictedCharacterString());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        } else {
            throw new Exception("Expecting dataTimestampUTC (not OPTIONAL)");
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("timezone")) {
            instance.setTimezone(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("temperatureDecKel")) {
            instance.setTemperatureDecKel(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("humidityMgm3")) {
            instance.setHumidityMgm3(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        }
        if (componentName != null) throw new Exception("Unexpected component " + componentName);
    }

    public java.lang.String getDataTimestampUTC() {
        return _dataTimestampUTC;
    }

    public void setDataTimestampUTC(java.lang.String _dataTimestampUTC) {
        this._dataTimestampUTC = _dataTimestampUTC;
    }

    public java.lang.Integer getTimezone() {
        return _timezone;
    }

    public void setTimezone(java.lang.Integer _timezone) {
        this._timezone = _timezone;
    }

    public java.lang.Integer getTemperatureDecKel() {
        return _temperatureDecKel;
    }

    public void setTemperatureDecKel(java.lang.Integer _temperatureDecKel) {
        this._temperatureDecKel = _temperatureDecKel;
    }

    public java.lang.Integer getHumidityMgm3() {
        return _humidityMgm3;
    }

    public void setHumidityMgm3(java.lang.Integer _humidityMgm3) {
        this._humidityMgm3 = _humidityMgm3;
    }
}
