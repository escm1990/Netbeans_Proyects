/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPClient;

import java.io.*;
import java.net.*;

/**
 *
 * @author USUARIO
 */
public class UDPClient {

    static DatagramSocket socket;
    static InetAddress address;
    static byte[] buffer;
    static DatagramPacket packet;
    static String str1, str2;
    static BufferedReader br;

    public static void main(String args[]) throws Exception {
        /*Creando el stream de entrada que leerá desde consola*/
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            /*Creando el objeto DatagramSocket y enlaza el puerto por dafault*/
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
            buffer = new byte[256];
            packet = new DatagramPacket(buffer, buffer.length, address, 1501);
            /*Enviando el paquete hacia el servidor*/
            socket.send(packet);
            System.out.println("Enviando la petición");

            /*Extrayendo datos del Paquete*/
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            str1 = new String(packet.getData());
            System.out.println("Mensaje recibido: " + str1);
            System.out.println("¿Desea continuar? (si/no)");
            str2 = br.readLine();

            if(str2.equals("no")) break;
        }
        socket.close();
    }
}
