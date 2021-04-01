/*
Generated using https://github.com/yafred/asn1-tool v0.0.26
AsnClasses.WeatherData ::= SEQUENCE {
   version [0] IMPLICIT INTEGER OPTIONAL,
   stationId [1] IMPLICIT INTEGER OPTIONAL,
   weatherData [2] IMPLICIT SEQUENCE OF AsnClasses.WeatherDataPoint
}
*/
package generated.weatherdataprotocol;

public class WeatherData {
    private java.lang.Integer _version;
    private java.lang.Integer _stationId;
    private java.util.ArrayList<WeatherDataPoint> _weatherData;

    public static WeatherData readPdu(com.yafred.asn1.runtime.BERReader reader) throws Exception {
        reader.readTag();
        reader.mustMatchTag(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        reader.readLength();
        WeatherData ret = new WeatherData();
        read(ret, reader, reader.getLengthValue());
        return ret;
    }

    public static void writePdu(WeatherData pdu, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int componentLength = write(pdu, writer);
        componentLength += writer.writeLength(componentLength);
        componentLength += writer.writeOctetString(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
        writer.flush();
    }

    public static int write(WeatherData instance, com.yafred.asn1.runtime.BERWriter writer) throws Exception {
        int length = 0;
        if (instance.getWeatherData() != null) {
            int componentLength = 0;
            int listLength = 0;
            if (instance.getWeatherData() != null) {
                for (int i = instance.getWeatherData().size() - 1; i >= 0; i--) {
                    componentLength = 0;
                    componentLength += WeatherDataPoint.write(instance.getWeatherData().get(i), writer);
                    componentLength += writer.writeLength(componentLength);
                    componentLength += writer.writeOctetString(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
                    listLength += componentLength;
                }
            }
            componentLength = listLength;
            componentLength += writer.writeLength(componentLength);
            componentLength += writer.writeOctetString(new byte[]{-94}); /* CONSTRUCTED_CONTEXT_2 */
            length += componentLength;
        }
        if (instance.getStationId() != null) {
            int componentLength = 0;
            componentLength = writer.writeInteger(instance.getStationId());
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

    public static void read(WeatherData instance, com.yafred.asn1.runtime.BERReader reader, int length) throws Exception {
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
            instance.setStationId(reader.readInteger(componentLength));
            if (length != -1) length -= componentLength;
        }
        if (length == 0) return;
        if (reader.isTagMatched()) {
            reader.readTag();
            if (length != -1) length -= reader.getTagLength();
        }
        reader.mustMatchTag(new byte[]{-94}); /* CONSTRUCTED_CONTEXT_2 */
        reader.readLength();
        if (length != -1) length -= reader.getLengthLength();
        componentLength = reader.getLengthValue();
        instance.setWeatherData(new java.util.ArrayList<WeatherDataPoint>());
        {
            int listLength = componentLength;
            int keepComponentLength = componentLength;
            while (listLength > 0 || listLength == -1) {
                reader.readTag();
                if (listLength != -1) listLength -= reader.getTagLength();
                if (listLength == -1 && reader.matchTag(new byte[]{0})) {
                    reader.mustReadZeroLength();
                    break;
                }
                reader.mustMatchTag(new byte[]{48}); /* CONSTRUCTED_UNIVERSAL_16 */
                reader.readLength();
                if (listLength != -1) listLength -= reader.getLengthLength();
                componentLength = reader.getLengthValue();
                instance.getWeatherData().add(new WeatherDataPoint());
                WeatherDataPoint.read(instance.getWeatherData().get(instance.getWeatherData().size() - 1), reader, componentLength);
                if (listLength != -1) listLength -= componentLength;
            }
            componentLength = keepComponentLength;
        }
        if (length != -1) length -= componentLength;
        if (length == -1) {
            reader.readTag();
            reader.mustMatchTag(new byte[]{0});
            reader.mustReadZeroLength();
        } else if (length != 0) throw new Exception("length should be 0, not " + length);
        return;
    }

    public static WeatherData readPdu(com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
        WeatherData ret = new WeatherData();
        read(ret, reader);
        return ret;
    }

    public static void writePdu(WeatherData pdu, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        write(pdu, writer);
    }

    public static void write(WeatherData instance, com.yafred.asn1.runtime.ASNValueWriter writer) throws Exception {
        writer.beginSequence();
        if (instance.getVersion() != null) {
            writer.writeComponent("version");
            writer.writeInteger(instance.getVersion());
        }
        if (instance.getStationId() != null) {
            writer.writeComponent("stationId");
            writer.writeInteger(instance.getStationId());
        }
        if (instance.getWeatherData() != null) {
            writer.writeComponent("weatherData");
            writer.beginArray("");
            if (instance.getWeatherData() != null) {
                for (int i = 0; i < instance.getWeatherData().size(); i++) {
                    WeatherDataPoint.write(instance.getWeatherData().get(i), writer);
                }
            }
            writer.endArray();
        }
        writer.endSequence();
    }

    public static void read(WeatherData instance, com.yafred.asn1.runtime.ASNValueReader reader) throws Exception {
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
        if (componentName.equals("stationId")) {
            instance.setStationId(reader.readInteger());
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        }
        if (componentName == null) componentName = reader.readIdentifier();
        if (componentName.equals("weatherData")) {
            instance.setWeatherData(new java.util.ArrayList<WeatherDataPoint>());
            reader.readToken(); // read '{'
            if ("}".equals(reader.lookAheadToken())) { // empty list
                reader.readToken();
                return;
            }
            do {
                instance.getWeatherData().add(new WeatherDataPoint());
                WeatherDataPoint.read(instance.getWeatherData().get(instance.getWeatherData().size() - 1), reader);
            } while (",".equals(reader.readToken()));
            if ("}".equals(reader.readToken())) { // read ',' or '}'
                return;
            }
            componentName = null;
        } else {
            throw new Exception("Expecting weatherData (not OPTIONAL)");
        }
        if (componentName != null) throw new Exception("Unexpected component " + componentName);
    }

    public java.lang.Integer getVersion() {
        return _version;
    }

    public void setVersion(java.lang.Integer _version) {
        this._version = _version;
    }

    public java.lang.Integer getStationId() {
        return _stationId;
    }

    public void setStationId(java.lang.Integer _stationId) {
        this._stationId = _stationId;
    }

    public java.util.ArrayList<WeatherDataPoint> getWeatherData() {
        return _weatherData;
    }

    public void setWeatherData(java.util.ArrayList<WeatherDataPoint> _weatherData) {
        this._weatherData = _weatherData;
    }
}
