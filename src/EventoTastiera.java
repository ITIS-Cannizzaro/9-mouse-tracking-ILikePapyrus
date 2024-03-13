// Import librerie
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class EventoTastiera implements KeyListener {
    // Combinazioni
    // w -> wingdings
    // c -> colors
    // m -> menu
    
    // Attributi
    JButton[][] matriceBottoni;

    // Costruttore
    public EventoTastiera(JButton[][] matriceBottoni) {
        this.matriceBottoni = matriceBottoni;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}