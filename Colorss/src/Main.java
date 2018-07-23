import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.*;

public class Main extends JFrame {

    private Main() {
        super("RGB");
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);

        initComponents();
        this.pack(); //ogolne

        int frameWidth = 700;
        int frameHeight = 220;
        this.setSize(frameWidth, frameHeight); //ramka wielkosc

        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setLocation(((width - frameWidth) / 2), ((height - frameHeight) / 2)); //ramka centrowanie
    }
    JPanel panel = new JPanel();
    JTextField red;
    JTextField green;
    JTextField blue;
    JButton wykonaj;

    private void initComponents() {

        red = new JTextField("Red", 10);
        green = new JTextField("Green", 10);
        blue = new JTextField("Blue", 10);
        wykonaj = new JButton("Wykonaj");

        this.getContentPane().add(panel);
        panel.add(red);
        panel.add(green);
        panel.add(blue);
        panel.add(wykonaj);

        red.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!wartoscRed(e.getKeyChar()))
                    e.consume(); } });

        green.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!wartoscGreen(e.getKeyChar()))
                    e.consume();} });

        blue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!wartoscBlue(e.getKeyChar()))
                    e.consume(); } });

        wykonaj.addActionListener(new Czekaj());

    }
        private boolean wartoscRed(char redlvl) {
            return redlvl >= '0' && redlvl <= '9';}

        private boolean wartoscGreen(char greenlvl) {
            return greenlvl >= '0' && greenlvl <= '9';}

        private boolean wartoscBlue(char bluelvl) {
            return bluelvl >= '0' && bluelvl <= '9';}

    private class Czekaj implements ActionListener {

        private int redInt;
        private int greenInt;
        private int blueInt;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (Integer.parseInt(red.getText()) <= 255 && Integer.parseInt(red.getText()) >= 0) {
                redInt = Integer.parseInt(red.getText());}
                    else {
                        new Blad("Red");
                        redInt = 0;}

            if (Integer.parseInt(green.getText()) <= 255 && Integer.parseInt(green.getText()) >= 0) {
                greenInt = Integer.parseInt(green.getText());}
                    else {
                        new Blad("Green");
                        greenInt = 0;}

            if (Integer.parseInt(blue.getText()) <= 255 && Integer.parseInt(blue.getText()) >= 0) {
                blueInt = Integer.parseInt(blue.getText());}
                    else {
                        new Blad("Blue");
                        blueInt = 0;}


            panel.setBackground(new Color(redInt, greenInt, blueInt));
        }
    }

    private class Blad{
        Blad(String s) {
            JOptionPane.showMessageDialog (rootPane, "zla wartosc w polu "+ s + " -prawidlowa wartosc w zakresie 0-255");}}

    public static void main(String[] args) {
        new Main();}}