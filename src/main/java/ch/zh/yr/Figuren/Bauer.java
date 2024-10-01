package ch.zh.yr.Figuren;
import ch.zh.yr.Figuren.Figur;

import java.awt.*;
import java.io.IOException;

public class Bauer extends Figur{

    private boolean firstMove = true;
    private boolean isAlive = false;
    private int x, y;

    public Bauer(int startX, int startY) throws IOException {
        super("src/main/java/ch/zh/yr/Bilder/Bauer.png", startX, startY);
        this.x = startX;
        this.y = startY;
        setPreferredSize(new Dimension(80, 80));
    }

    public boolean movement(int targetX, int targetY, boolean isOpponentPeace) {
        int direction = 1;

        if (firstMove) {
            if (targetY == y + 2 * direction && targetX == x && !isOpponentPeace) {
                firstMove = false;
                this.y = targetY;
                return true;
            } else if (targetY == y + 1 * direction && targetX == x && !isOpponentPeace) {
                firstMove = false;
                this.y = targetY;
                return true;
            }
        } else {
            if (targetY == y + 1 * direction && targetX == x && !isOpponentPeace) {
                this.y = targetY;
                return true;
            } else if (targetY == y + 1 * direction && targetX == x + 1 * direction && isOpponentPeace) {
                this.y = targetY;
                this.x = targetX;
                return true;
            }
        }
        return false;
    }

    public void setAlive(boolean Alive) {
        isAlive = Alive;
    }


}
