// Import Librerie
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class EventoMouse implements MouseListener {
    // Attributi
    Random random = new Random();
    JButton[][] matriceBottoni;

    public EventoMouse(JButton[][] matriceBottoni) {
        this.matriceBottoni = matriceBottoni;
    }
    // Metodi astratti da sovrascrivere
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Cicla nei pulsanti della matrice
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                // Controlla da dove viene l'evento
                if(e.getSource() == matriceBottoni[i][k]) {
                    // Cambia il testo del pulsante con un carattere a caso preso dall'array caratteri[]
                    if(e.getButton() == MouseEvent.BUTTON3) {
                        matriceBottoni[i][k].setBackground(null);
                    } else if (e.getButton() == MouseEvent.BUTTON1){
                        matriceBottoni[i][k].setBackground(Color.BLUE);
                    } else {
                        matriceBottoni[i][k].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // Cosa succede quando il mouse passa su un pulsante
    @Override
    public void mouseEntered(MouseEvent e) {
        // Cicla nei pulsanti della matrice
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                // Controlla da dove viene l'evento
                if(e.getSource() == matriceBottoni[i][k]) {
                    coloraCornice(i, k, true);
                    cambiaCarattere(i, k, true);
                }
            }
        }
    }

    void coloraCornice(int i, int j, boolean on) {
        for(int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                if(!(i == 0 && j == 0) && i+a >= 0 && i+a < matriceBottoni.length && j+b >= 0 && j+b < matriceBottoni[0].length ) {
                // matriceBottoni[i+a][j+b].setBackground(on ? Color.BLUE : null);
                // on ? Color.BLUE : null
                // Se il mouse è sul pulsante (on) allora (?) colora di blu (Color.BLUE), altrimenti (:) rimette a posto (null) -> è un if

                    matriceBottoni[i+a][j+b].setBackground(on ? Color.BLUE : null);
                    matriceBottoni[i+a][j+b].setForeground(on ? Color.WHITE : null);
                }

                // Sostituisce i colori nel caso particolare in cui il mouse si trova in [0][0]
                if(i == 0 && j == 0) {
                    // [0][0]
                    matriceBottoni[0][0].setBackground(on ? Color.BLUE : null);
                    matriceBottoni[0][0].setForeground(on ? Color.WHITE : null);
                    // [0][1]
                    matriceBottoni[0][1].setBackground(on ? Color.BLUE : null);
                    matriceBottoni[0][1].setForeground(on ? Color.WHITE : null);
                    // [1][0]
                    matriceBottoni[1][0].setBackground(on ? Color.BLUE : null);
                    matriceBottoni[1][0].setForeground(on ? Color.WHITE : null);
                    // [1][1]
                    matriceBottoni[1][1].setBackground(on ? Color.BLUE : null);
                    matriceBottoni[1][1].setForeground(on ? Color.WHITE : null);
                }
            }
        }
    }

    void cambiaCarattere(int i, int j, boolean on) {
        // Array di stringhe
        String caratteri[] = {"a", "b", "c", "d", "e", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "A", "B", "C", "D", "E"};
        for(int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                // Sostituisce il testo randomicamente
                if(!(i == 0 && j == 0) && i+a >= 0 && i+a < matriceBottoni.length && j+b >= 0 && j+b < matriceBottoni[0].length ) {
                    matriceBottoni[i+a][j+b].setText(caratteri[random.nextInt(caratteri.length)]);
                }

                // Sostituisce il testo nelle caselle affette dal caso particolare del mouse in [0][0]
                if(i==0 && j == 0) {
                    // [0][0]
                    matriceBottoni[0][0].setText(caratteri[random.nextInt(caratteri.length)]);
                    // [0][1]
                    matriceBottoni[0][1].setText(caratteri[random.nextInt(caratteri.length)]);
                    // [1][0]
                    matriceBottoni[1][0].setText(caratteri[random.nextInt(caratteri.length)]);
                    // [1][1]
                    matriceBottoni[1][1].setText(caratteri[random.nextInt(caratteri.length)]);
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Cicla nei pulsanti della matrice
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                // Controlla da dove viene l'evento
                if(e.getSource() == matriceBottoni[i][k]) {
                    for(int a = -1; a < 2; a++) {
                        for (int b = -1; b < 2; b++) {
                            if(!(i == 0 && k == 0) && i+a >= 0 && i+a < matriceBottoni.length && k+b >= 0 && k+b < matriceBottoni[0].length ) {
                                matriceBottoni[i+a][k+b].setText(null);
                                matriceBottoni[i+a][k+b].setBackground(null);
                            }
                        }
                    }
                }
            }
        }
    }
}