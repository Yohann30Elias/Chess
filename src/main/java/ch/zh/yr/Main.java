package ch.zh.yr;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Spielfeld spielfeld = new Spielfeld();
        frame.add(spielfeld);
        frame.setSize(8 * Spielfeld.Ui_groesse, 8 * Spielfeld.Ui_groesse);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Gian dä Macher gschriebe aso nur die Line
    }
}