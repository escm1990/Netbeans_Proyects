
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fam Olmedo
 */
public class video1 {
//  DatagramSocket server;
//    Scanner inFromUser = new Scanner(System.in);
//    int port = 1234;
//    DatagramSocket server = new DatagramSocket(port);
//    DatagramSocket server = new DatagramSocket(port);
  // Read name of file supplied by client (must be a line of text):
//    Scanner in = new Scanner(new DataInputStream(server.getInputStream()));
//    String filename = in.nextLine();
//    DatagramSocket request = server.accept();


    // Create buffer, then we're ready to go:
    // Puts file into binary form
//        BufferedInputStream inbinary =
//                new BufferedInputStream(new FileInputStream("poop.txt"));
   // Outputs the binary form
//        BufferedOutputStream outbinary =
//                new BufferedOutputStream(request.getOutputStream());

//    int numbytes;
//    int countblocks = 0;
//    int countbytes = 0;
//    byte[] buf = new byte[1024];
//    DatagramPacket packet = new DatagramPacket(buf, buf.length, port);
//    server.receive(packet);
//
//    while ((numbytes = inbinary.read(buf,0,1024)) >= 0)
//    {
//        try {
//            // receive packet from client, telling it to send the video file
//            server.receive(packet);
//        } catch (IOException ex) {
//            Logger.getLogger(video1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     InetAddress address = packet.getAddress();
//     packet = new DatagramPacket(buf, buf.length, address, port);
//        try {
//            server.send(packet);
//        } catch (IOException ex) {
//            Logger.getLogger(video1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     countblocks++;          // keep statistics on file size
//     countbytes += numbytes;
//        try {
//            outbinary.write(buf, 0, numbytes); // write buffer to socket
//        } catch (IOException ex) {
//            Logger.getLogger(video1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//      outbinary.flush(); // FLUSH THE BUFFER
//      server.close(); // done with the socket
//      System.out.println(countblocks + " were read; " + countbytes + " bytes");
    }



