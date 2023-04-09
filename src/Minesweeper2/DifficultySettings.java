package Minesweeper2;

import java.util.Map;

public class DifficultySettings {
    private static final Map<Difficulty, Double> bombToCellRatios = Map.of(
            Difficulty.EASY, 0.12,
            Difficulty.MEDIUM, 0.16,
            Difficulty.HARD, 0.205
    );

    public static double getBombToCellRatio(Difficulty difficulty) {
        return bombToCellRatios.getOrDefault(difficulty, 0.12);
    }
}
