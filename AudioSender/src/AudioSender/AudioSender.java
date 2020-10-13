/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AudioSender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.format.AudioFormat;
import javax.rmi.CORBA.Util;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author USUARIO
 */
public class AudioSender extends Thread {
private MediaLocator ml = new MediaLocator("javasound://44100");
private DatagramSocket socket;
private boolean transmitting;
private Player player;
TargetDataLine mic;
byte[] buffer;
private AudioFormat format;

private DatagramSocket datagramSocket(){
    try {
        return new DatagramSocket();
    } catch (SocketException ex) {
        return null;
    }
}

private void startMic() {
    try {
        format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000.0F, 16, 2, 4, 8000.0F, true);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        mic = (TargetDataLine) AudioSystem.getLine(info);
        mic.open(format);
        mic.start();
        buffer = new byte[1024];
    } catch (LineUnavailableException ex) {
        Logger.getLogger(AudioSender.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private Player createPlayer() {
    try {
        return Manager.createRealizedPlayer(ml);
    } catch (IOException ex) {
        return null;
    } catch (NoPlayerException ex) {
        return null;
    } catch (CannotRealizeException ex) {
        return null;
    }
}

private void send() {
    try {
        mic.read(buffer, 0, 1024);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(Util.getRemoteIP()), 91);
        socket.send(packet);
    } catch (IOException ex) {
        Logger.getLogger(AudioSender.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@Override
public void run() {
    player = createPlayer();
    player.start();
    socket = datagramSocket();
    transmitting = true;
    startMic();
    while (transmitting) {
        send();
    }
}

public static void main(String[] args) {
    AudioSender as = new AudioSender();
    as.start();
}

}
