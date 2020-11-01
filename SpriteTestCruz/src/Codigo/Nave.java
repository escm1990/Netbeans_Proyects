package Codigo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Nave {
 private String nave = "nave_pequena.png";
 private int dx;
 private int dy;
 private int x;
 private int y;
 private Image image;

 public Nave()
 {        
 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(nave));
 image = image_icon.getImage();
 x = 40;
 y = 60;
 }

 public void move()
 {
 if (dx > 0 && x <= 640 - 55)
 x += dx;
 else
 if (dx < 0 && x >= 2)
 x += dx;

 if (dy > 0 && y <= 480 - 70)
 y += dy;
 else
 if (dy < 0 && y >= 2)
 y += dy;

 }
 public int getX()
 {
 return x;
 }
 public int getY()
 {
 return y;
 }
 public Image getImage()
 {
 return image;
 }
 public void keyPressed(KeyEvent e)
 {
 int key = e.getKeyCode();

 if (key == KeyEvent.VK_RIGHT)
 {
 dx = 2;
 }
 if (key == KeyEvent.VK_LEFT)
 {
 dx = -2;
 }
 if (key == KeyEvent.VK_UP)
 {
 dy = -2;
 }
 if (key == KeyEvent.VK_DOWN)
 {
 dy = 2;
 }        
 }

 public void keyReleased(KeyEvent e)
 {
 int key = e.getKeyCode();

 if (key == KeyEvent.VK_RIGHT)
 {
 dx = 0;
 }
 if (key == KeyEvent.VK_LEFT)
 {
 dx = 0;
 }
 if (key == KeyEvent.VK_UP)
 {
 dy = 0;
 }
 if (key == KeyEvent.VK_DOWN)
 {
 dy = 0;
 }      
 }

}
