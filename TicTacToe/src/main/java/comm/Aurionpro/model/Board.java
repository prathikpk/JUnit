package comm.Aurionpro.model;

import java.util.Arrays;

public class Board {
	Cell[] cells = new Cell[9];

	public Board() {
		super();
		for(int i=0;i<9;i++) 
			cells[i] = new Cell();
	}

	public boolean isBoardFull() {
		int count = 0;
		for (Cell c : cells) {
			if (c.getMark() == MarkType.X || c.getMark() == MarkType.O) {
				count += 1;
			}
		}

		if (count == 9)
			return true;
		return false;
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCellMark(int loc, MarkType mark){
		if(loc>8)
			throw new InvalidCellLocation("No such location is present in board");
		if (cells[loc].getMark() == MarkType.X || cells[loc].getMark() == MarkType.O)
			throw new CellAlreadyMarkException("Cell is already marked");
		
		cells[loc].setMark(mark);
	}

	@Override
	public String toString() {
		return "Board [cells=" + Arrays.toString(cells) + "]";
	}
	
}
