/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author USUARIO
 */
public class FrameGrab JPanel implements ActionListener{



	public FrameGrab() {
		// Create capture device
		Vector devices = CaptureDeviceManager.getDeviceList(null);
		CaptureDeviceInfo cdi = null;
		for (Iterator i = devices.iterator(); i.hasNext();) {
			cdi = (CaptureDeviceInfo) i.next();
			/* Get the first Video For Windows (VFW) capture device.
			 * Use the JMF registry tool in the bin directory of the JMF
			 * distribution to detect available capture devices on your
			 * computer.
			 */
			if (cdi.getName().startsWith("vfw:"))
				break;
		}
		// start the Timer with 3s intervals
		new Timer(3000, (ActionListener) this).start();
		try {
			player = Manager.createRealizedPlayer(cdi.getLocator());
			player.start();
		} catch (NoPlayerException e) {
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Grab a frame from the capture device
		frameGrabber = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (buffImg != null) {
			g.drawImage(buffImg, 0, 0, this);
		}
	}

	private void grab() {
		Buffer buf = frameGrabber.grabFrame();
		// Convert frame to an buffered image so it can be processed and saved
		Image img = (new BufferToImage((VideoFormat) buf.getFormat())
				.createImage(buf));
		buffImg = new BufferedImage(img.getWidth(this), img.getHeight(this),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		g.drawImage(img, null, null);
		g.setColor(Color.darkGray);
		g.setFont(new Font("Tahoma", Font.PLAIN, 12)
				.deriveFont(AffineTransform.getRotateInstance(1.57)));
		g.drawString((new Date()).toString(), 5, 5);
	}

	public static void createAndShowGui() {
		JFrame frame = new JFrame("Frame Grabber");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new FrameGrab());
		frame.setSize(328, 270);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		grab();
		repaint();
	}
}
