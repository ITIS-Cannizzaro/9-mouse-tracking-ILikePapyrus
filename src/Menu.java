// Import librerie
import javax.swing.*;
import java.awt.*;

public class Menu {
    public static void menuWindow() {
        // Crea finestra
        JFrame menuFrame = new JFrame("Combinazioni da tastiera");

        // Crea panel
        JPanel menuPanel = new JPanel();
        // Come ordinare elementi nel panel (layout)
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // Descrizioni keybind
        JLabel m = new JLabel("m -> Apri questo menu"); // Funziona
        JLabel w = new JLabel("w -> Wingdings instantaneo"); // Funziona (?)
        JLabel r = new JLabel("r -> Reset dell'intera matrice"); // Funziona
        JLabel c = new JLabel("c -> Cambia periodicamente i colori di tutta la matrice"); // Da aggiungere
        JLabel credits = new JLabel("Software di Marco Vanoni - 2024");

        // Aggiunge i label al panel
        menuPanel.add(m);
        menuPanel.add(w);
        menuPanel.add(r);
        menuPanel.add(c);
        menuPanel.add(credits);

        // Impostazioni finestra
        menuFrame.add(menuPanel); // Aggiunge il panel alla finestra
        menuFrame.setVisible(true);
        menuFrame.setSize(380,120);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);
    }
}