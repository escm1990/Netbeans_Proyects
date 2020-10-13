
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.sound.sampled.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.Timer;

/**
 *
 * @author Fam Olmedo
 */
public class AudioSender extends Thread {

    private MediaLocator ml = new MediaLocator("javasound://44100");
    private DatagramSocket socket;
    private boolean transmitting;
    private Player player;
//TargetDataLine mic;
    byte[] buffer;
//private AudioFormat format;
    private Timer timer;
    private Buffer buff;

    private DatagramSocket datagramSocket() {
        try {
            return new DatagramSocket();
        } catch (SocketException ex) {
            return null;
        }
    }

    public AudioFormat getformat() {
        float SampleRate = 8000;
        int SampleSizeInBist = 8;
        int Channels = 1;
        boolean signed = true, bigEndian = true;
        return new AudioFormat(SampleRate, SampleSizeInBist, Channels, signed, bigEndian);
    }

//private void startMic() {
//    try {
//        System.out.println("salida de audio: " );
//        float ft = 8000;
//        final AudioFormat format = getformat();
////        final AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000.0F, 16, 2, 4, 8000.0F, true);
////        DataLine.Info info = new DataLine.Info("javax.sound.sampled.TargetLine", format);
//        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
//        final TargetDataLine mic = (TargetDataLine) AudioSystem.getLine(info);
//        mic.open(format);
//        mic.start();
//        buffer = new byte[1024];
//        int count = 0;
//        while(true){
//            mic.read(buffer, 0, buffer.length);
//            this.send();
//        }
////        System.out.println("salida incial: "+ buffer);
//    } catch (LineUnavailableException ex) {
//        Logger.getLogger(AudioSender.class.getName()).log(Level.SEVERE, null, ex);
//    }
//}
    private void captureAudio() {
        try {
            final AudioFormat format = getformat();
            DataLine.Info info = new DataLine.Info( TargetDataLine.class, format);
            final TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
//      final ByteArrayOutputStream out ;
            Runnable runner = new Runnable() {

                int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
                byte buffer[] = new byte[bufferSize];

                public void run() {
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();
                    boolean running = true;
                    try {
                        while (running) {
                            int count =
                                    line.read(buffer, 0, buffer.length);
                            if (count > 0) {
                                out.write(buffer, 0, count);
                            }
                        }
                        out.close();
                    } catch (IOException e) {
                        System.err.println("I/O problems: " + e);
                        System.exit(-1);
                    }
                }
            };
            Thread captureThread = new Thread(runner);
            captureThread.start();
        } catch (LineUnavailableException e) {
            System.err.println("Line unavailable: " + e);
            System.exit(-2);
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
            System.out.println("salida del metodo");
//        mic.read(buffer, 0, 1024);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 91);
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
        captureAudio();
//    startMic();
//    timer.start();
        while (transmitting) {
            send();
        }
    }

    public static void main(String[] args) {
        AudioSender as = new AudioSender();
        as.start();
//    as.send();
    }
}
