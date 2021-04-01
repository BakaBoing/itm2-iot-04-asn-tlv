package asn;

import com.github.alturkovic.asn.annotation.AsnPostProcessMethod;
import com.github.alturkovic.asn.annotation.AsnPrimitive;
import com.github.alturkovic.asn.annotation.AsnTag;

import java.time.LocalDateTime;

/*
    WeatherDataPoint ::= SEQUENCE {
        dataTimestampUTC DATE-TIME,
        timezone INTEGER (-12 .. 12) DEFAULT 1,
        -- deci kelvin
        temperatureDecKel INTEGER DEFAULT 0,
        -- mgm3 (milligrams per cubic meter)
        humidityMgm3 INTEGER DEFAULT 0
    }
 */

@AsnPostProcessMethod("postProcess")
public class WeatherDataPoint {
    @AsnPrimitive(@AsnTag(0))
    private String _dataTimestampUTCString;
    private LocalDateTime _dataTimestampUTC;
    @AsnPrimitive(@AsnTag(1))
    private int _timezone;
    @AsnPrimitive(@AsnTag(2))
    private int _temperatureDecKel;
    @AsnPrimitive(@AsnTag(3))
    private int _humidityMgm3;

    public WeatherDataPoint() {
    }

    public WeatherDataPoint(LocalDateTime dataTimestampUTC, int timezone, int temperatureDecKel, int humidityMgm3) {
        setDataTimestampUTC(dataTimestampUTC);
        setTimezone(timezone);
        setTemperatureDecKel(temperatureDecKel);
        setHumidityMgm3(humidityMgm3);
    }

    private void postProcess() {
        setDataTimestampUTC(LocalDateTime.parse(_dataTimestampUTCString));
    }

    public LocalDateTime getDataTimestampUTC() {
        return _dataTimestampUTC;
    }

    public void setDataTimestampUTC(LocalDateTime dataTimestampUTC) {
        _dataTimestampUTC = dataTimestampUTC;
        _dataTimestampUTCString = dataTimestampUTC.toString();
    }

    public int getTimezone() {
        return _timezone;
    }

    public void setTimezone(int timezone) {
        _timezone = timezone;
    }

    public int getTemperatureDecKel() {
        return _temperatureDecKel;
    }

    public void setTemperatureDecKel(int temperatureDecKel) {
        _temperatureDecKel = temperatureDecKel;
    }

    public int getHumidityMgm3() {
        return _humidityMgm3;
    }

    public void setHumidityMgm3(int humidityMgm3) {
        _humidityMgm3 = humidityMgm3;
    }

    @Override
    public String toString() {
        return "AsnClasses.WeatherDataPoint{" +
                "_dataTimestampUTCString='" + _dataTimestampUTCString + '\'' +
                ", _dataTimestampUTC=" + _dataTimestampUTC +
                ", _timezone=" + _timezone +
                ", _temperatureDecKel=" + _temperatureDecKel +
                ", _humidityMgm3=" + _humidityMgm3 +
                '}';
    }
}
