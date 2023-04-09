package Minesweeper2;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class MenuPanel extends JPanel {
    private final JTextField rowsField;
    private final JTextField colsField;
    private final JComboBox<Difficulty> difficultyComboBox;

    public MenuPanel() {
        this(null, null);
    }

    public MenuPanel(Consumer<MenuPanel> onStartGame, Consumer<MenuPanel> onQuitGame) {
        UIManager.put("OptionPane.background", Color.DARK_GRAY);
        UIManager.put("Panel.background", Color.DARK_GRAY);
        UIManager.put("Button.background", Color.GRAY);
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("TextField.background", Color.GRAY);
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.caretForeground", Color.WHITE);
        UIManager.put("ComboBox.background", Color.GRAY);
        UIManager.put("ComboBox.foreground", Color.WHITE);
        setBackground(Color.DARK_GRAY);


        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Minesweeper");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, gbc);
        gbc.gridy++;

        rowsField = new JTextField("10", 5);
        add(rowsField, gbc);
        gbc.gridy++;

        colsField = new JTextField("10", 5);
        add(colsField, gbc);
        gbc.gridy++;

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        difficultyComboBox = new JComboBox<>(Difficulty.values());
        difficultyComboBox.setSelectedItem(Difficulty.EASY);
        add(difficultyComboBox, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            if (onStartGame != null) {
                onStartGame.accept(MenuPanel.this);
            }
        });
        add(startButton, gbc);

        gbc.gridy++;
        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(e -> {
            if (onQuitGame != null) {
                onQuitGame.accept(MenuPanel.this);
            }
        });
        add(quitButton, gbc);
    }

    public int getRows() {
        return Integer.parseInt(rowsField.getText());
    }

    public int getCols() {
        return Integer.parseInt(colsField.getText());
    }

    public Difficulty getSelectedDifficulty() {
        return (Difficulty) difficultyComboBox.getSelectedItem();
    }
}
