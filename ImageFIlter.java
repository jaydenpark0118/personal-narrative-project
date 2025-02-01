import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String filename) {
    super(filename);
  }

  //keeps one color based on input
  public void keepColor(String color) {
    Pixel[][] p = getImagePixels();
    for (int row = 0; row < p.length; row++) {
      for (int col = 0; col < p[0].length; col++) {
        
        Pixel x = p[row][col];

        if (color.equals("red")) {
          
          x.setBlue(0);
          x.setGreen(0);
        } else if (color.equals("blue")) {
          
          x.setRed(0);
          x.setGreen(0);
        } else if (color.equals("green")) {
          
          x.setRed(0);
          x.setBlue(0);
        }
      }
    }
  }

  //sharpens image
  public void sharpen() {
    
    Pixel[][] p = getPixelsFromImage();
    for(int i = 1; i < p.length; i++) {
      for(int j = 1; j < p[0].length; j++) {
        int r = p[i][j].getRed();
        int g = p[i][j].getGreen();
        int b = p[i][j].getBlue();
        
        int nr = r - p[i-1][j-1].getRed();
        int ng = r - p[i-1][j-1].getGreen();
        int nb = r - p[i-1][j-1].getBlue();
        
        int total = (nr + ng + nb) / 3;
        r += total;
        g += total;
        b += total;
        if(r > 255) {
          r = 255;
        } else if(g > 255) {
          g = 255;
        } else if(b > 255){
          b = 255;
        }
        p[i][j].setRed(r);
        p[i][j].setGreen(g);
        p[i][j].setBlue(b);
        
      }
    }
  }

  //mirrors it on the middle y axis
  public void mirrorVertical() {
    Pixel[][] p = getPixelsFromImage();
    for(int i = 0; i < p.length; i++) {
      for(int j = p[0].length / 2; j < p[0].length; j++) {
        int r = p[i][j].getRed();
        int g = p[i][j].getGreen();
        int b = p[i][j].getBlue();
        p[i][p[0].length - j - 1].setRed(r);
        p[i][p[0].length - j - 1].setGreen(g);
        p[i][p[0].length - j - 1].setBlue(b);
        
      }
    }
  }

  //flips image
  public void upsidedown() {
    Pixel[][] p = getPixelsFromImage();
    for(int i = 0; i < p.length / 2; i++) {
      for(int j = 0; j < p[0].length; j++) {
        int tempr = p[i][j].getRed();
        int tempg = p[i][j].getGreen();
        int tempb = p[i][j].getBlue();

        int tempr2 = p[p.length-i-1][j].getRed();
        int tempg2 = p[p.length-i-1][j].getGreen();
        int tempb2 = p[p.length-i-1][j].getBlue();

        p[i][j].setRed(tempr2);
        p[i][j].setGreen(tempg2);
        p[i][j].setBlue(tempb2);

        p[p.length-i-1][j].setRed(tempr);
        p[p.length-i-1][j].setGreen(tempg);
        p[p.length-i-1][j].setBlue(tempb);
      }
    }
  }
  
}