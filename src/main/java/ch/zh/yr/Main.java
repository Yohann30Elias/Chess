package ch.zh.yr;

import ch.zh.yr.Figuren.Bauer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Jframe und Spielfeld erstellen oder so
        JFrame frame = new JFrame();
        Spielfeld spielfeld = new Spielfeld();


        //Spielfeld Hinzufügen oder so
        frame.setLayout(new GridBagLayout());
        frame.add(spielfeld);

        frame.pack();
        frame.setSize(8 * Spielfeld.Ui_groesse, 8 * Spielfeld.Ui_groesse);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //so Bauer Auer
        //spielfeld.setLayout(null);
        for (int i = 0; i < 5; i++) {
            Bauer bauer = new Bauer(6 , i);
            bauer.setBounds(i * Spielfeld.Ui_groesse, 6 * Spielfeld.Ui_groesse, Spielfeld.Ui_groesse, Spielfeld.Ui_groesse);
        }

        spielfeld.revalidate();
        spielfeld.repaint();

    }
}