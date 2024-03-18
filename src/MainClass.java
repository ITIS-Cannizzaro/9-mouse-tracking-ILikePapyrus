// Import librerie
import javax.swing.*;
import java.awt.*;

public class MainClass {
    // Matrice dei pulsanti
    static JButton[][] matriceBottoni = new JButton[10][10];
    public static void main(String[] args) {
        // Crea finestra
        JFrame frame = new JFrame("Grid Layout");
        // Crea container
        JPanel panel = new JPanel();

        // Imposta il layout del panel
        panel.setLayout(new GridLayout(10,10));
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                // Assegna ad ogni casella un pulsante della matrice
                panel.add(matriceBottoni[i][k] = new JButton());
                matriceBottoni[i][k].setFont( new Font("Serif", Font.BOLD, 24));
            }
        }

        // Aggiungi Eventi
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                EventoMouse mouse = new EventoMouse(matriceBottoni);
                EventoTastiera tastiera = new EventoTastiera(matriceBottoni);
                matriceBottoni[i][k].addMouseListener(mouse);
                matriceBottoni[i][k].addKeyListener(tastiera);
            }
        }

        // Impostazioni finestra
        frame.add(panel); // Aggiungi tutta la matrice alla tabella
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}