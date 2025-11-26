package Paint;

import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class Canvas extends JPanel {

    private final int STROKE_SIZE = 8;
    private Color color;
    private int x, y;
    private List<ColorPoint> currentPath;
    private List<List<ColorPoint>> allPath;
    private int canvasWidth, canvasHeight;

    public Canvas(int targetWidth, int targetHeight) {
        super();
        setPreferredSize(new Dimension(targetWidth, targetHeight));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);

        allPath = new ArrayList<>(25);
        canvasWidth = targetWidth;
        canvasHeight = targetHeight;

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(x, y, STROKE_SIZE, STROKE_SIZE);
                g.dispose();

                //start current point
                currentPath = new ArrayList<>(25);
                currentPath.add(new ColorPoint(x, y, color));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
               x = e.getX();
               y = e.getY();

               Graphics2D g2d = (Graphics2D) getGraphics();
               g2d.setColor(color);
               if(!currentPath.isEmpty()){
                   ColorPoint prevPoint =  currentPath.get(currentPath.size()-1);
                   g2d.setStroke(new BasicStroke(STROKE_SIZE));
                   g2d.drawLine(prevPoint.getX(), prevPoint.getY(), x, y);
               }
               g2d.dispose();

               ColorPoint newPoint = new ColorPoint(x, y, color);
               currentPath.add(newPoint);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                allPath.add(currentPath);
                currentPath = null;
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void resetCanvas() {
        Graphics g = getGraphics();
        g.clearRect(0, 0, canvasWidth, canvasHeight);
        g.dispose();

        allPath = new ArrayList<>(25);
        currentPath = null;

        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        for(List<ColorPoint> path : allPath){
            ColorPoint from  = null;
            for(ColorPoint point : path){

                g2d.setColor(point.getColor());
                if(path.size() == 1){
                    g2d.fillRect(point.getX(), point.getY(), STROKE_SIZE, STROKE_SIZE);
                }
                if(from != null){
                    g2d.setStroke(new BasicStroke(STROKE_SIZE));
                    g2d.drawLine(from.getX(), from.getY(), point.getX(), point.getY());
                }
                from = point;
            }
        }
    }
}
