import asn.*;
import network.UDPClient;
import network.UDPServer;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RunMe {
    static LocalDateTime dat = LocalDateTime.now();

    public static void main(String[] args) throws SocketException, UnknownHostException {

        if(args[0].equals("--server")) {
            UDPServer server = new UDPServer(25565);
            server.run();
        }

        else if(args[0].equals("--client")){
            UDPClient.createInstance(25564, 25565);
            UDPClient.send(WeatherData.testData());
        }

//        byte[] values1 = generatedWeatherData();
//        byte[] values2 = ownWeatherData();

//        byte[] values1 = generatedAck();
//        byte[] values2 = ownAck();

//        for (int i = 0; i < values1.length; ++i) {
//            if (values1[i] == values2[i])
//                System.out.println(i + " : [" + values1[i] + " | " + values2[i] + "]");
//            else
//                System.out.println(i + " : [" + values1[i] + " | " + values2[i] + "] --- !!");
//        }
    }

    private static byte[] generatedWeatherData() {
        ArrayList<generated.weatherdataprotocol.WeatherDataPoint> listOfPoints = new ArrayList<>();
        generated.weatherdataprotocol.WeatherDataPoint point = new generated.weatherdataprotocol.WeatherDataPoint();
        point.setDataTimestampUTC(dat.toString());
        point.setTimezone(1);
        point.setHumidityMgm3(50);
        point.setTemperatureDecKel(287); // 14° Celsius

        listOfPoints.add(point);

        generated.weatherdataprotocol.WeatherData data = new generated.weatherdataprotocol.WeatherData();
        data.setVersion(1);
        data.setStationId(1);
        data.setWeatherData(listOfPoints);

        AsnCoder coder = new AsnCoder();

        byte[] values = coder.encode(data, generated.weatherdataprotocol.WeatherData.class);
//        System.out.println(Arrays.toString(values));

        generated.weatherdataprotocol.WeatherData decodedData = coder.decode(values, generated.weatherdataprotocol.WeatherData.class);

        return values;
    }

    private static byte[] generatedAck() {
        generated.weatherdataprotocol.Ack data = new generated.weatherdataprotocol.Ack();
        data.setVersion(1);
        data.setMessageTimestamp(dat.toString());
        data.setMsgNum(1);
        data.setState(generated.weatherdataprotocol.AckState.Enum.ACK);

        AsnCoder coder = new AsnCoder();

        byte[] values = coder.encode(data, generated.weatherdataprotocol.Ack.class);
//        System.out.println(Arrays.toString(values));

        generated.weatherdataprotocol.Ack decodedData = coder.decode(values, generated.weatherdataprotocol.Ack.class);

        return values;
    }

    private static byte[] ownWeatherData() {
        List<WeatherDataPoint> listOfPoints = new ArrayList<>();
        WeatherDataPoint point = new WeatherDataPoint(
                dat,
                1,
                287,
                50
        );

        listOfPoints.add(point);

        WeatherData data = new WeatherData(1, listOfPoints);

        Coder coder = new Coder();
        byte[] values = coder.encode(data);

//        System.out.println(Arrays.toString(values));

        IAsnClass decodedData = coder.decode(values);
        if(decodedData instanceof WeatherData)
            System.out.println(decodedData.toString());
        return values;
    }

    private static byte[] ownAck() {
        Ack data = new Ack();
        data.setMessageTimestampUTC(dat);
        data.setTimezone(1);
        data.setMsgNum(1);
        data.setState(AckState.ACK);

        Coder coder = new Coder();

        byte[] values = coder.encode(data);
//        System.out.println(Arrays.toString(values));

        IAsnClass decodedData = coder.decode(values);
        if(decodedData instanceof Ack)
            System.out.println(decodedData.toString());
        return values;
    }
}
