// Import Librerie
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class EventoMouse implements MouseListener {
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
        // Array di stringhe
        String caratteri[] = {"a", "b", "c", "d", "e", "1", "2", "3", "4", "5", "A", "B", "C", "D", "E"};
        
        // Cicla nei pulsanti della matrice
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                // Controlla da dove viene l'evento
                if(e.getSource() == matriceBottoni[i][k]) {

                        // Cambia il testo del pulsante con un carattere a caso preso dall'array caratteri[]
                        matriceBottoni[i-1][k-1].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i-1][k].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i-1][k+1].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i][k-1].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i][k+1].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i+1][k-1].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i+1][k].setText(caratteri[random.nextInt(caratteri.length)]);
                        matriceBottoni[i+1][k+1].setText(caratteri[random.nextInt(caratteri.length)]);


                    // Colori
                    /*
                    if(matriceBottoni[i][k].getBackground() == Color.BLUE) {
                        matriceBottoni[i][k].setForeground(Color.WHITE);
                    } else if(matriceBottoni[i][k].getBackground() == null || matriceBottoni[i][k].getBackground() == Color.GREEN) {
                        matriceBottoni[i][k].setForeground(Color.BLACK);
                    }*/
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
                    // Cambia il testo del pulsante con un carattere a caso preso dall'array caratteri[]
                    matriceBottoni[i-1][k-1].setText("");
                    matriceBottoni[i-1][k].setText("");
                    matriceBottoni[i-1][k+1].setText("");
                    matriceBottoni[i][k-1].setText("");
                    matriceBottoni[i][k+1].setText("");
                    matriceBottoni[i+1][k-1].setText("");
                    matriceBottoni[i+1][k].setText("");
                    matriceBottoni[i+1][k+1].setText("");
                }
            }
        }
    }
}