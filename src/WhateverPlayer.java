import java.util.Random;

public class WhateverPlayer implements Player {
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        boolean coordinateIsEmpty = false;
        while(coordinateIsEmpty == false) {
        int randomRow = random.nextInt(Board.Size);
        int randomCol = random.nextInt(Board.Size);
        coordinateIsEmpty = board.putMark(mark, randomRow, randomCol);
        }
    }
}


