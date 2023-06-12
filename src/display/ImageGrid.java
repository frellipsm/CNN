package display;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImageGrid extends JPanel {
    private BufferedImage grid;

    public ImageGrid(int width, int height){
        grid = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public ImageGrid() {
        grid = new BufferedImage(28, 28, BufferedImage.TYPE_BYTE_BINARY);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    public void createAndShowGUI() {
        JFrame f = new JFrame("Datum Display");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ImageGrid());
        f.pack();
        f.setSize(250, 250);
        f.setVisible(true);
    }

    public void toggleBlock(int color, int x1, int y1, int x2, int y2){
        if (color == 0){
            color = Color.BLACK.getRGB();
        }
        else {
            color = Color.WHITE.getRGB();
        }
        for (int x = x1; x <= x2; x++){
            for (int y = y1; y <= y2; y++){
                grid.setRGB(x, y, color);
            }
        }
    }


    public void clear() {
        toggleBlock (0, 0, 0, grid.getWidth() - 1, grid.getHeight() - 1);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(grid, 0, 0, this);
    }

}
