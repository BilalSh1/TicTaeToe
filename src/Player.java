import java.util.Scanner;

public class Player {
    public Player(){}

    public void playTurn(Board board, Mark mark) {
        Scanner scanner = new Scanner(System.in);
        int coods = Integer.parseInt(scanner.nextLine());
        int row = ((coods - (coods % 10)) / 10) - 1;
        int col = (coods % 10) - 1;
        board.putMark(mark, row, col);
    }
}
