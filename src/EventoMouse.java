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
                    coloraCornice(i, k, true);
                        // Cambia il testo del pulsante con un carattere a caso preso dall'array caratteri[]
//                        matriceBottoni[i-1][k-1].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i-1][k].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i-1][k+1].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i][k-1].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i][k+1].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i+1][k-1].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i+1][k].setText(caratteri[random.nextInt(caratteri.length)]);
//                        matriceBottoni[i+1][k+1].setText(caratteri[random.nextInt(caratteri.length)]);


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

    void coloraCornice(int i, int j, boolean on)
    {
        for(int a = -1; a < 2; a++)
        {
            for (int b = -1; b < 2; b++)
            {
                if(!(i == 0 && j == 0) && i+a >= 0 && i+a < matriceBottoni.length && j+b >= 0 && j+b < matriceBottoni[0].length )
                // matriceBottoni[i+a][j+b].setBackground(on ? Color.BLUE : null);
                // on ? Color.BLUE : null
                // Se il mouse è sul pulsante allora colora di blu, altrimenti rimette a posto -> è un if

                matriceBottoni[i+a][j+b].setBackground(on ? Color.BLUE : null);
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
                    coloraCornice(i, k, false);

                }
            }
        }
    }
}