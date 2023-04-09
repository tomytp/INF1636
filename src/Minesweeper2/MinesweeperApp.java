package Minesweeper2;

import javax.swing.*;
import java.awt.*;

public class MinesweeperApp {
    public static MenuPanel menuPanel;
    public static JFrame frame;
    public static int MENU_WIDTH = 420, MENU_HEIGHT = 290, GAME_WIDTH = 900, GAME_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MinesweeperApp.frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setMinimumSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
            frame.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));

            MenuPanel menuPanel = new MenuPanel(
                    MinesweeperApp::startGame,
                    MinesweeperApp::quitGame
            );
            frame.setContentPane(menuPanel);
            MinesweeperApp.menuPanel = menuPanel;

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static void startGame(MenuPanel menuPanel) {
        frame.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        frame.setTitle("MINESWEEPER");
        GamePanel minesweeperPanel = new GamePanel(
                MinesweeperApp::returnToMenu,
                menuPanel.getRows(),
                menuPanel.getCols(),
                menuPanel.getSelectedDifficulty()
        );

        frame.setContentPane(minesweeperPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public static void returnToMenu(GamePanel minesweeperPanel) {
        frame.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
        frame.setTitle("MENU");

        System.out.println("coe");
        MenuPanel menuPanel = new MenuPanel(MinesweeperApp::startGame, MinesweeperApp::quitGame);
        frame.setContentPane(menuPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public static void quitGame(MenuPanel menuPanel) {
        System.exit(0);
    }
}
