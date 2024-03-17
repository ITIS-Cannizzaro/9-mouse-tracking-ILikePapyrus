// Import librerie
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EventoTastiera extends Timer implements KeyListener {
    // Combinazioni
    // w -> wingdings
    // c -> colors
    // m -> menu
    // r -> reset

    // Attributi
    JButton[][] matriceBottoni;
    Random random = new Random();
    // ARRAY BASICI DI CARATTERI IN WINGDINGS
    final static String[] wingdings_numeri = {
            "\uD83D\uDCC1\uFE0E", // 0
            "\uD83D\uDCC2\uFE0E", // 1
            "\uD83D\uDCC4\uFE0E", // 2
            "\uD83D\uDDCF\uFE0E", // 3
            "\uD83D\uDDD0\uFE0E", // 4
            "\uD83D\uDDC4\uFE0E", // 5
            "⌛\uFE0E", // 6
            "\uD83D\uDDAE\uFE0E", // 7
            "\uD83D\uDDB0\uFE0E", // 8
            "\uD83D\uDDB2\uFE0E"  /* 9 */
    };
    final static String[] wingdings_minuscola = {
            "♋\uFE0E", // a
            "♌\uFE0E", // b
            "♍\uFE0E", // c
            "♎\uFE0E", // d
            "♏\uFE0E", // e
            "♐\uFE0E", // f
            "♑\uFE0E", // g
            "♒\uFE0E", // h
            "♓\uFE0E", // i
            "\uD83D\uDE70", // j
            "\uD83D\uDE75", // k
            "●\uFE0E", // l
            "❍\uFE0E", // m
            "■\uFE0E", // n
            "□\uFE0E", // o
            "◻\uFE0E", // p
            "❑\uFE0E", // q
            "❒\uFE0E", // r
            "⬧\uFE0E", // s
            "⧫\uFE0E", // t
            "◆\uFE0E", // u
            "❖\uFE0E", // v
            "⬥\uFE0E", // w
            "⌧\uFE0E", // x
            "⍓\uFE0E", // y
            "⌘\uFE0E"}; // z
    final static String[] wingdings_maiuscola = {
            "✌\uFE0E", // A
            "\uD83D\uDC4C\uFE0E", // B
            "\uD83D\uDC4D\uFE0E", // C
            "\uD83D\uDC4E\uFE0E", // D
            "☜\uFE0E", // E
            "☞\uFE0E", // F
            "☝\uFE0E", // G
            "☟\uFE0E", // H
            "✋\uFE0E", // I
            "☺\uFE0E", // J
            "\uD83D\uDE10\uFE0E", // K
            "☹\uFE0E", // L
            "\uD83D\uDCA3\uFE0E", // M
            "☠\uFE0E", // N
            "⚐\uFE0E", // O
            "\uD83C\uDFF1\uFE0E", // P
            "✈\uFE0E", // Q
            "☼\uFE0E", // R
            "\uD83D\uDCA7\uFE0E", // S
            "❄\uFE0E", // T
            "\uD83D\uDD46\uFE0E", // U
            "✞\uFE0E", // V
            "\uD83D\uDD48\uFE0E", // W
            "✠\uFE0E", // X
            "✡\uFE0E", // Y
            "☪\uFE0E"}; // Z

    // Costruttore - prende in ingresso la matriceBottoni e la salva
    public EventoTastiera(JButton[][] matriceBottoni) {
        this.matriceBottoni = matriceBottoni;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int[] randArr = {0, 1, 2};
        int randArrSel = 0;

        if(e.getKeyCode() == KeyEvent.VK_W) {
            // Wingdings
            for(int i=0; i<10; i++) {
                for(int k=0; k<10; k++) {
                    matriceBottoni[i][k].setBackground(Color.BLACK);
                    matriceBottoni[i][k].setForeground(Color.WHITE);
                    randArrSel = randArr[random.nextInt(randArr.length)];
                    wingdings(i, k, randArrSel, e);
                }
            }

            // Log tasto
            System.out.println("Pressed " + e.getKeyCode() + " - " + e.getKeyChar() + " - Evento wingdings partito");
        }

        if(e.getKeyCode() == KeyEvent.VK_M) {
            // Menu
            Menu.menuWindow();

            // Log testo
            System.out.println("Pressed " + e.getKeyCode() + " - " + e.getKeyChar() + " - Evento menu partito");
        }

        if(e.getKeyCode() == KeyEvent.VK_R) {
            // Reset matrice
            reset();

            // Log testo
            System.out.println("Pressed " + e.getKeyCode() + " - " + e.getKeyChar() + " - Evento reset partito");
        }

        if(e.getKeyCode() == KeyEvent.VK_C) {
            // "Epilepsy"
            try {
                epilepsy(e);

                System.out.println("Pressed " + e.getKeyCode() + " - " + e.getKeyChar() + " - Evento epilepsy partito");
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released " + e.getKeyCode() + " - " + e.getKeyChar());
    }

    private void wingdings(int i, int k, int randArrSel, KeyEvent e) {
        // TODO fix wingdings not stopping when "r" is pressed
        // TODO after 5 seconds when the mouse is still, start the event even if "w" isn't being pressed
        // Crea timer
        Timer wingdingsTimer = new Timer();
        // Crea compito da fare mentre il timer è in azione
        TimerTask cambioCaratteri = new TimerTask() {
            @Override
            public void run() {
                for(int a = -1; a < 2; a++) {
                    for (int b = -1; b < 2; b++) {
                        if(!(i == 0 && k == 0) && i+a >= 0 && i+a < matriceBottoni.length && k+b >= 0 && k+b < matriceBottoni[0].length ) {
                            if(randArrSel == 0) {
                                // Sostituisce testo con numeri in wingdings randomicamente
                                matriceBottoni[i+a][k+b].setText(wingdings_numeri[random.nextInt(wingdings_numeri.length)]);
                            } else if(randArrSel == 1) {
                                // Sostituisce testo con lettere minuscole in wingdings randomicamente
                                matriceBottoni[i+a][k+b].setText(wingdings_minuscola[random.nextInt(wingdings_minuscola.length)]);
                            } else if(randArrSel == 2) {
                                // Sostituisce testo con lettere maiuscole in wingdings randomicamente
                                matriceBottoni[i+a][k+b].setText(wingdings_maiuscola[random.nextInt(wingdings_maiuscola.length)]);
                            }
                        }

                        // Se il mouse si muove i colori delle "caselle" rimangono sempre nero per lo sfondo e bianco per il testo
                        if(matriceBottoni[i][k].getBackground() == null || matriceBottoni[i][k].getForeground() == Color.WHITE || matriceBottoni[i][k].getText() != null) {
                            matriceBottoni[i][k].setBackground(Color.BLACK);
                        }
                    }
                }
            }
        };

        // Fa partire il timer
        wingdingsTimer.schedule(cambioCaratteri, 0, 10);

        // Se viene premuta la lettera "r" allora chiama reset() ma gli mette in ingresso il timer e l'evento
        if(e.getKeyCode() == KeyEvent.VK_R) {
            reset(wingdingsTimer, cambioCaratteri);
        }
    }

    private void epilepsy(KeyEvent e) throws InterruptedException {
        // TODO fix color/epilepsy not stopping when "r" is pressed
        // Lasciamo stare il nome... :)

        // Crea il nuovo timer
        Timer timerEpilepsy = new Timer("timerEpilepsy");
        // Crea il nuovo evento da eseguire durante il timer
        TimerTask cambioColori = new TimerTask() {
            @Override
            public void run() {
                // Array di colori da sostituire allo sfondo di ogni singola casella
                Color[] arrayColori = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.YELLOW};
                for(int i=0; i<10; i++) {
                    for(int k=0; k<10; k++) {
                        // Usando random prende ogni colore dall'array e lo sostituisce, come per i caratteri
                        matriceBottoni[i][k].setBackground(arrayColori[random.nextInt(arrayColori.length)]);
                    }
                }
            }
        };

        // Fa partire il timer
        timerEpilepsy.schedule(cambioColori, 0, 10);

        // Se viene premuta la lettera "r" allora chiama reset() ma gli mette in ingresso il timer e l'evento
        if(e.getKeyCode() == KeyEvent.VK_R) {
            reset(timerEpilepsy, cambioColori);
        }
    }

    // Reset normale
    private void reset() {
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                matriceBottoni[i][k].setText(null);         // Resetta completamente il testo
                matriceBottoni[i][k].setBackground(null);   // Resetta lo sfondo, mettendolo a quello di default di quando si avvia il programma
                matriceBottoni[i][k].setForeground(null);   // Resetta il colore delle scritte, mettendolo a quello di default di quando si avvia il programma
            }
        }
    }

    // Reset per eventi timer
    private void reset(Timer timer, TimerTask tt) {
        for(int i=0; i<10; i++) {
            for(int k=0; k<10; k++) {
                // Se il timer in ingresso è partito
                if(timer != null) {
                    tt.cancel();        // Cancella ogni istruzione presente all'interno dell'evento
                    timer.cancel();     // Resetta il timer
                    timer.purge();      // Elimina ogni evento dalla coda del timer
                }

                reset();    // Chiama il normale reset per fare le classiche eliminazioni
            }
        }
    }
}