package asn;

import com.github.alturkovic.asn.annotation.AsnCollection;
import com.github.alturkovic.asn.annotation.AsnPrimitive;
import com.github.alturkovic.asn.annotation.AsnStructure;
import com.github.alturkovic.asn.annotation.AsnTag;
import com.github.alturkovic.asn.tag.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
    WeatherData ::= SEQUENCE {
        version INTEGER (1 .. 16) DEFAULT 1,
        stationId INTEGER DEFAULT -1,
        weatherData SEQUENCE (SIZE (1..10)) OF WeatherDataPoint
    }
 */

@AsnStructure(@AsnTag(0))//@AsnTag(value = 16, type = Type.UNIVERSAL))
public class WeatherData implements IAsnClass {
    @AsnPrimitive(@AsnTag(0))
    private final int _version = 1;
    @AsnPrimitive(@AsnTag(1))
    private int _stationId;
    @AsnCollection(value = @AsnTag(2), type = WeatherDataPoint.class)
    private List<WeatherDataPoint> _weatherData;

    public WeatherData() {
    }

    public WeatherData(int stationId, List<WeatherDataPoint> weatherData) {
        setStationId(stationId);
        setWeatherData(weatherData);
    }

    public int getVersion() {
        return _version;
    }

    public int getStationId() {
        return _stationId;
    }

    public void setStationId(int stationId) {
        _stationId = stationId;
    }

    public List<WeatherDataPoint> getWeatherData() {
        return _weatherData;
    }

    public void setWeatherData(List<WeatherDataPoint> weatherData) {
        _weatherData = weatherData;
    }

    @Override
    public String toString() {
        return "AsnClasses.WeatherData{" +
                "_version=" + _version +
                ", _stationId=" + _stationId +
                ", _weatherData=" + _weatherData +
                '}';
    }

    public static WeatherData testData(){
        List<WeatherDataPoint> listOfPoints = new ArrayList<>();
        WeatherDataPoint point = new WeatherDataPoint(
                LocalDateTime.now(),
                1,
                287,
                50
        );

        listOfPoints.add(point);

        return new WeatherData(1, listOfPoints);
    }
}
