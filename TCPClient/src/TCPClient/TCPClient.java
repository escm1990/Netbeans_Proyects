/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCPClient;

import java.io.*;
import java.net.*;

/**
 *
 * @author USUARIO
 */
public class TCPClient {
    public static  void main(String args[]) throws Exception{
    
        Socket clientSocket;
        PrintStream out = null;
        BufferedReader in = null;
        
        try {
            clientSocket = new Socket("localhost", 1001);
            out = new PrintStream(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host Indefinido");
            System.exit(1);
        }catch(IOException e){
            System.err.println("No se puedo obtener fluos E/S");
            System.exit(1);
        }
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        System.out.println(str);
        
        while((str = stdin.readLine()) != null){
            out.println(str);
            if(str.equals("bye")) break;
        }
        out.close();
        in.close();
        stdin.close();
    }
}
