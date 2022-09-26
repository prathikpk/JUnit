package comm.Aurionpro.model;

public class Game {

	private Player currentPlayer;
	Player[] players;
	Board board;
	ResultAnalyzer analyzer;
	ResultType result = ResultType.PROGRESS;

	public Game(Player[] players) {
		super();
		this.players = players;
		this.currentPlayer = players[0];
		this.analyzer = new ResultAnalyzer();
		this.board = analyzer.getBoard();
		players[0].setMark(MarkType.X);
		players[1].setMark(MarkType.O);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public ResultAnalyzer getAnalyzer() {
		return analyzer;
	}

	public ResultType getResult() {
		return result;
	}

	public void play(int loc) throws CellAlreadyMarkException, InvalidCellLocation {
		board.setCellMark(loc, currentPlayer.getMark());
		result = analyzer.analyzeResult();
		if (result == ResultType.PROGRESS) {
			switchCurrentPlayer();
		}
		if (result == ResultType.WIN) {
			System.out.println(currentPlayer.getName() + " Wins");
		}
		if (result == ResultType.DRAW) {
			System.out.println("Draw!!");
		}

	}

	private void switchCurrentPlayer() {
		if (currentPlayer == players[0])
			currentPlayer = players[1];
		else
			currentPlayer = players[0];
	}

	public Player getcurrentPlayer() {
		return currentPlayer;
	}

}