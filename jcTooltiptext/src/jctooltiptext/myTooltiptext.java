package jctooltiptext;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class myTooltiptext{
  
    public myTooltiptext(){}

    public String getTextComplejo(){
      //URL f = getClass().getResource("mouse.png");
      String text3="<html><body bgcolor=\"#FFFFFF\" style=\"text-align:center\">"+
                    "<img src=\""+getClass().getResource("mouse.jpg")+"\">"+
                    "<p>Hola!, soy <h1>jcMouse</h1> de <h2>" +
                    "<span style=\"color:#FF0000\">Bol</span><span style=\"color:#FFFF00\">iv</span><span style=\"color:#006600\">ia</span></h2> "+
                    "</body>"+
                    "</html>";
        return text3;
    }

    
}
