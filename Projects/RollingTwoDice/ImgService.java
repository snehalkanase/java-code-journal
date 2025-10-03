package RollingTwoDice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class ImgService {
    public static JLabel loadImg(String filePath){
        BufferedImage image ;
        JLabel imageContainer;
        try {
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            image = ImageIO.read(inputStream);
            imageContainer = new JLabel(new ImageIcon(image));
            return imageContainer;
        } catch (Exception e) {
            System.out.println("Error loading image");
            return null;
        }
    }
    public static void updateImg(JLabel imageContainer, String filePath){
        BufferedImage image ;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            image = ImageIO.read(inputStream);
            imageContainer.setIcon(new ImageIcon(image));
        } catch(Exception e){
            System.out.println("Error loading image: " + e);
        }
    }
}
