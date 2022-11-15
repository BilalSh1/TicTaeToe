import java.util.Scanner;

public class HumanPlayer implements Player {
    public HumanPlayer(){}

    public void playTurn(Board board, Mark mark) {
        Scanner scanner = new Scanner(System.in);
        int coordinates = Integer.parseInt(scanner.nextLine());
        int row = ((coordinates - (coordinates % 10)) / 10) - 1;
        int col = (coordinates % 10) - 1;
        board.putMark(mark, row, col);
    }
}
