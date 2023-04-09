package Minesweeper2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.function.Consumer;

public class GamePanel extends JPanel {
    Consumer<GamePanel> returnToMenu;
    private int rows;
    private int cols;
    private Difficulty difficulty;
    private boolean isFirstClick = true;

    private Gameboard board;

    public GamePanel(Consumer<GamePanel> onReturnToMenu, int rows, int cols, Difficulty difficulty) {
        setBackground(Color.DARK_GRAY);
        returnToMenu = onReturnToMenu;
        this.rows = rows;
        this.cols = cols;
        this.difficulty = difficulty;

        setLayout(new GridLayout(rows, cols));


        board = new Gameboard(rows, cols, difficulty, this);
        setUpGame();
    }

    private void setUpGame() {
        setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                board.cells[board.rows][board.cols] = new Cell(i, j);
                cell.addActionListener(e -> onCellClick(cell));
                add(cell);
            }
        }

        revalidate();
        repaint();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateCellButtonTextSize();
            }
        });
    }

    private void onCellClick(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if (isFirstClick) {
            board.placeMines(row, col);
            isFirstClick = false;
        }

        board.revealCell(row, col);

        Gameboard.GameState gameState = board.checkGameState(row, col);

        updateCellButtonTextSize();
        for (Component component : getComponents()) {
            if (component instanceof Cell) {
                ((Cell) component).updateAppearance();
            }
        }

        if (gameState != Gameboard.GameState.ONGOING) {
            returnToMenu();
        }
    }

    private void updateCellButtonTextSize() {
        if (getComponentCount() == 0) {
            return;
        }

        Component firstCell = getComponent(0);
        int buttonSize = Math.min(firstCell.getWidth(), firstCell.getHeight());
        int fontSize = Math.max(8, buttonSize / 2);
        Font font = new Font("Arial", Font.BOLD, fontSize);

        for (Component component : getComponents()) {
            if (component instanceof Cell cell) {
                cell.setFont(font);
                cell.updateAppearance();
            }
        }
    }


    private void returnToMenu() {
        returnToMenu.accept(this);
    }
}