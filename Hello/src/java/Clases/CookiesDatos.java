/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.servlet.http.Cookie;



/**
 *
 * @author rayalam
 */
public class CookiesDatos {
    
     public static String DevuelveValorCookie(Cookie[] cookies,String nombre){
      String value="sin valor";
      
      if(cookies!=null){
          for(int i=0;i<cookies.length;i++){
              Cookie cookie=cookies[i];
              if (nombre.equals(cookie.getName())){
                  return cookie.getValue();
              }
          }
      }
     return value;
    }
     
     
     
     
     

}
