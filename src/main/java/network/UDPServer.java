package network;

import asn.Ack;
import asn.AckState;
import asn.Coder;
import asn.IAsnClass;
import util.ByteConverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDateTime;

public class UDPServer {//extends Thread {
    private final DatagramSocket _socket;
    private boolean _running;
    private byte[] _buf = new byte[256];
    private final Coder _coder;

    public UDPServer(int port) throws SocketException {
        _socket = new DatagramSocket(port);
        _coder = new Coder();
    }

    public void run() {
        _running = true;
        while (_running) {
            DatagramPacket packet = new DatagramPacket(_buf, _buf.length);
            try {
                _socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] response = decode(packet.getData());

                if(response != null) {
                    packet = new DatagramPacket(response, response.length, address, port);
                    _socket.send(packet);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        return ByteConverter.toByteArray(response);
    }
}
