package jcimagenaccess;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.sql.*;
import java.awt.Image;
import java.util.Iterator;

/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class Access_Foto {
  Access_connection con;
  private Image data;

  public Access_Foto (){
    con = new Access_connection();
  }

    public void Cerrar(){
        con.desconectar();
    }

  /* Guarda la imagen JPG en el campo OLE de Access */
   public boolean guardarfoto(String foto) {
        boolean ok=false;
            FileInputStream fis = null;
            try {
                File file = new File(foto);
                fis = new FileInputStream(file);

                PreparedStatement pstm =  con.getConnection().prepareStatement("insert into " +
                        " tImagenes(foto) " + " values(?)");                
                pstm.setBinaryStream(1, fis,(int) file.length());
                pstm.execute();
                pstm.close();
                ok=true;
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        return ok;
   }

   //metodo  que dado un parametro "id" realiza una consulta y devuelve como resultado
// una imagen
 public Image getfoto(String id){
      try{
         PreparedStatement pstm =  con.getConnection().prepareStatement("SELECT " +
            " Foto " +
            " FROM tImagenes " +
            " where id = ? ");
         pstm.setString(1, id);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            //se lee la cadena de bytes de la base de datos
            byte[] b = res.getBytes("Foto");
            // esta cadena de bytes sera convertida en una imagen
            data = ConvertirImagen(b);
            i++;
         }
         res.close();
          } catch (IOException ex) {
              System.out.println(ex);
        }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }

  //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
 private Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis;
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 }

}
