package RollingTwoDice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class ImgService {
    public static JLabel loadImg(String filePath){
        BufferedImage image ;
        JLabel imageComtainer;
        try {
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            image = ImageIO.read(inputStream);
            imageComtainer = new JLabel(new ImageIcon(image));
            return imageComtainer;
        } catch (Exception e) {
            System.out.println("Error loading image");
            return null;
        }
    }
}
