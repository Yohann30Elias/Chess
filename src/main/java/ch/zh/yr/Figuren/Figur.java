package ch.zh.yr.Figuren;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Figur extends JPanel {

    protected Point location;
    private Point mouseOffset;
    private boolean dragging = false;
    protected BufferedImage figurImage;

    public Figur(String imagePath, int startX, int startY) throws IOException {
        this.location = new Point(startX, startY);

        figurImage = ImageIO.read(new File(imagePath));

        setPreferredSize(new Dimension(figurImage.getWidth(null), figurImage.getHeight(null)));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (new Rectangle(location.x, location.y, 80, 80).contains(e.getPoint())) {
                    dragging = true;
                    mouseOffset = new Point(e.getX() - location.x, e.getY() - location.y);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    location = new Point(e.getX() - mouseOffset.x, e.getY() - mouseOffset.y);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(figurImage, location.x, location.y, this);
    }

    public abstract boolean movement(int targetX, int targetY, boolean isOpponentPiece);
}
