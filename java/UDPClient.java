// Client code
import java.io.*;
import java.net.*;
public class UDPClient {
public static void main(String[] args) {
try {
DatagramSocket socket = new DatagramSocket();
InetAddress address = InetAddress.getByName("localhost");
byte[] sendData = "Hello, server!".getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 1234);
socket.send(sendPacket);
byte[] receiveData = new byte[1024];
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
socket.receive(receivePacket);
String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Server response:" + response);
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}