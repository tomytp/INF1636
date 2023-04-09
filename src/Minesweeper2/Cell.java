package Minesweeper2;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    private int row;
    private int col;
    private boolean hasMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;

    public Cell(int row, int col) {
        hasMine = false;
        isRevealed = false;
        adjacentMines = 0;
        setMargin(new Insets(0, 0, 0, 0));
        this.row = row;
        this.col = col;

        updateAppearance();
    }

    public void updateAppearance() {
        if (isRevealed) {
            setBackground(Color.LIGHT_GRAY);
            setText("");
        } else if (hasMine) {
            setBackground(Color.RED);
            setText("⚠");
            setForeground(Color.BLACK);
        } else if (adjacentMines > 0) {
            setBackground(Color.WHITE);
            setText(String.valueOf(adjacentMines));
            setForeground(getNumberColor(adjacentMines));
        }
    }

    private Color getNumberColor(int number) {
        return switch (number) {
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            case 3 -> Color.RED;
            case 4 -> new Color(0, 0, 128);
            case 5 -> new Color(178, 34, 34);
            case 6 -> new Color(72, 209, 204);
            case 7 -> Color.BLACK;
            case 8 -> Color.DARK_GRAY;
            default -> throw new IllegalArgumentException("Invalid Amount of Neighbours");
        };
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }
}