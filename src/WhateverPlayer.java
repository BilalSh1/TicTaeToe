import java.util.Random;

public class WhateverPlayer implements Player {
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        boolean coordinateIsEmpty = false;
        while(coordinateIsEmpty == false) {
        int randomRow = random.nextInt(Board.SIZE);
        int randomCol = random.nextInt(Board.SIZE);
        coordinateIsEmpty = board.putMark(mark, randomRow, randomCol);
        }
    }
}


