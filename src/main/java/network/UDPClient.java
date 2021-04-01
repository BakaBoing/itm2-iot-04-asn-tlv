package network;

import asn.Ack;
import asn.AckState;
import asn.Coder;
import asn.IAsnClass;
import util.ByteConverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.time.LocalDateTime;

//TODO server und client müssen auf jeweils andere messages reagieren können!

public class UDPClient extends Thread {
    private static UDPClient _instance = null;

    private final InetAddress _address;
    private final int _clientPort;
    private final int _serverPort;
    private final DatagramSocket _socketSend;
    //private final DatagramSocket _socketReceive;
    private boolean _running;
    private byte[] _buf = new byte[256];
    private final Coder _coder;

    private UDPClient(int clientPort, int serverPort) throws SocketException, UnknownHostException {
        _clientPort = clientPort;
        _serverPort = serverPort;
        _socketSend = new DatagramSocket(_clientPort);
        //_socketReceive = new DatagramSocket(port);
        _coder = new Coder();
        _address = InetAddress.getByName("localhost");
    }

    public static void createInstance(int clientPort, int serverPort) throws SocketException, UnknownHostException {
        if(_instance == null)
            _instance = new UDPClient(clientPort, serverPort);
    }

    public static void send(IAsnClass data){
        if (_instance == null)
            return;

        _instance.sendInternal(data);
    }

    private void sendInternal(IAsnClass dataObj) {
        byte[] data = _coder.encode(dataObj);
        if(data != null) {
            DatagramPacket packet = new DatagramPacket(data, data.length, _address, _serverPort);
            try {
                _socketSend.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        _running = true;
        while (_running) {
//            DatagramPacket packet = new DatagramPacket(_buf, _buf.length);
//            try {
//                _socketReceive.receive(packet);
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                byte[] response = decode(packet.getData());
//
//                if(response != null) {
//                    packet = new DatagramPacket(response, response.length, address, port);
//                    _socketReceive.send(packet);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void terminate() {
        _running = false;
    }

    private byte[] decode(byte[] data){
        IAsnClass decodedData = _coder.decode(data);

        System.out.println(decodedData);

        Ack response = null;

        if(decodedData != null){
            response = new Ack();
            response.setMessageTimestampUTC(LocalDateTime.now());
            response.setTimezone(1);
            response.setState(AckState.ACK);
        }

        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(out)){
            os.writeObject(response);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
