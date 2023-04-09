package Minesweeper2;


import java.util.Random;

public class Gameboard {
    public int rows;
    public int cols;
    private Difficulty difficulty;
    private int totalMines;
    public Cell[][] cells;
    private GamePanel panel;

    public Gameboard(int rows, int cols, Difficulty difficulty, GamePanel panel) {
        this.rows = rows;
        this.cols = cols;
        this.difficulty = difficulty;
        this.panel = panel;
//        createBoard();
    }

    public enum GameState {
        ONGOING, WON, LOST
    }

    public GameState checkGameState(int clickedRow, int clickedCol) {
        if (cells[clickedRow][clickedCol].hasMine()) {
            return GameState.LOST;
        }

        int flaggedBombs = 0;
        int revealedNonBombs = 0;
        int totalSafeCells = rows * cols - totalMines;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = cells[row][col];
                if (cell.hasMine() && cell.isFlagged()) {
                    flaggedBombs++;
                } else if (!cell.hasMine() && cell.isRevealed()) {
                    revealedNonBombs++;
                }
            }
        }

        if (flaggedBombs == totalMines || revealedNonBombs == totalSafeCells) {
            return GameState.WON;
        }

        return GameState.ONGOING;
    }


    public void revealCell(int row, int col) {
        if (!isValidCell(row, col) || cells[row][col].isRevealed()) {
            return;
        }

        cells[row][col].setRevealed(true);

        if (cells[row][col].getAdjacentMines() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    revealCell(row + i, col + j);
                }
            }
        }
    }

    private void createBoard() {
        cells = new Cell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col);
                panel.add(cells[row][col]);
            }
        }
    }

    public void placeMines(int firstRow, int firstCol) {
        double bombRatio = DifficultySettings.getBombToCellRatio(difficulty);
        Random random = new Random();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (random.nextDouble() < bombRatio) {
                    cells[row][col].setMine(true);
                    totalMines++;
                }
            }
        }
        if (cells[firstRow][firstCol].hasMine()) {
            cells[firstRow][firstCol].setMine(false);
            totalMines--;
        }
        setAllAjacentMines();
    }

    private void setAllAjacentMines() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].setAdjacentMines(getCellAjacentMines(row, col));
            }
        }
    }

    private int getCellAjacentMines(int row, int col) {
        int adjacentMines = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;

                if (isValidCell(newRow, newCol) && cells[newRow][newCol].hasMine()) {
                    adjacentMines++;
                }
            }
        }
        return adjacentMines;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < cells.length && col >= 0 && col < cells[row].length;
    }
}
