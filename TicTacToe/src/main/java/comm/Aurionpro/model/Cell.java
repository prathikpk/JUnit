package comm.Aurionpro.model;

public class Cell {
	private MarkType mark;

	public Cell() {
		super();
		this.mark = MarkType.EMPTY;
	}
	
	public boolean isCellEmpty() {
		if(this.mark==MarkType.EMPTY)
			return true;
		return false;
	}

	public MarkType getMark() {
		return mark;
	}

	public void setMark(MarkType mark) {
		if(this.mark==MarkType.X || this.mark == MarkType.O)
			throw new CellAlreadyMarkException("Cell is already marked");
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Cell [mark=" + mark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (mark != other.mark)
			return false;
		return true;
	}
	
}
