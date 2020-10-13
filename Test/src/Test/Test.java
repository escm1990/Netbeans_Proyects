/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.*;;

/**
 *
 * @author USUARIO
 */
public class Test extends JFrame{
private BufferedImage image1;
	private BufferedImage image2;
	private FrameGrabber vision1;
	private int threshold = 200;
	private Color on = Color.white;
	private Color off = Color.black;

    @Override
	public void paint(Graphics g) {
		if (image1 != null)
			g.drawImage(image1, 10, 30, this);
		if (image2 != null)
			g.drawImage(image2, 180, 30, this);
	}

    @Override
	public void update(Graphics g) {
		paint(g);
	}

	class WindowListener extends WindowAdapter {
        @Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public Test() {
		addWindowListener(new WindowListener());
		setTitle("JMF Camera Test");
		try {
			vision1 = new FrameGrabber();
			vision1.start();
		}
		catch(FrameGrabberException fge) {
			System.out.println(fge.getMessage());
		}
		image1 = vision1.getBufferedImage();
		image2 = proces(image1);
		setSize(image1.getWidth(this) + image2.getWidth(this) + 30, image1.getHeight(this) + 40);
		setVisible(true);
		setBackground(Color.black);

		while(true) {
			image1 = vision1.getBufferedImage();
			image2 = proces(image1);
			repaint();
			try {
				Thread.sleep(1);
			} catch(Exception e) {
				System.out.println("Doh");
			}
		}
	}

	// Function To create the Black and Wite Image
	private BufferedImage proces(BufferedImage x) {
		BufferedImage temp = new BufferedImage(x.getWidth(this), x.getHeight(this), BufferedImage.TYPE_INT_ARGB);
		for(int loop1 = 0; loop1 < x.getWidth(this); loop1++) {
			for(int loop2 = 0; loop2 < x.getHeight(this); loop2++) {
				Color pixel = new Color(x.getRGB(loop1,loop2));
				if(pixel.getRed() > threshold || pixel.getGreen() > threshold || pixel.getBlue() > threshold) {
					temp.setRGB(loop1,loop2,on.getRGB());
				}
				else {
					temp.setRGB(loop1,loop2,off.getRGB());
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		new Test();
	}
}
