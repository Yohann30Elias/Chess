package ch.zh.yr;

import javax.swing.*;
import java.awt.*;

public class Spielfeld extends JPanel{
    public static final int Ui_groesse = 80;
    public static final int felder_groesse = 8;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int reihe = 0; reihe < felder_groesse; reihe++) {
            for (int spalte = 0; spalte < felder_groesse; spalte++) {
                if ((reihe + spalte) % 2 == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.gray);
                }
                g.fillRect(reihe * Ui_groesse, spalte * Ui_groesse, Ui_groesse, Ui_groesse);
            }
        }
    }
}