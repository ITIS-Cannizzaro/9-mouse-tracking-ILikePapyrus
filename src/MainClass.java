import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class MainClass {
    static JButton[][] matriceBottoni = new JButton[10][10];
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Layout");
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(10,10));
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                panel.add(matriceBottoni[i][k] = new JButton());
            }
        }

        // Aggiungi Eventi
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                EventoMouse mouse = new EventoMouse(matriceBottoni);
                EventoTastiera tastiera = new EventoTastiera(matriceBottoni);
                matriceBottoni[i][k].addMouseListener(mouse);
                //matriceBottoni[i][k].addKeyListener((KeyListener) tastiera);
            }
        }

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
