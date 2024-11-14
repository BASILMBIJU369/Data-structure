// Server code
import java.io.*;
import java.net.*;
public class UDPServer {
public static void main(String[] args) {
try {
DatagramSocket socket = new DatagramSocket(1234);
System.out.println("Server started...");
byte[] receiveData = new byte[1024];
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
socket.receive(receivePacket);
String request = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Client request:"  + request);
InetAddress address = receivePacket.getAddress();
int port = receivePacket.getPort();
byte[] sendData ="Hello, client!".getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
socket.send(sendPacket);
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}