package test;

public class Test {

	public static void main(String[] args) {
		Blocks bParent = new Blocks();
		Blocks b2Parent = new Blocks();
		
		bParent.row = 1;
		bParent.col = 2;
		
		b2Parent.row = 2;
		b2Parent.col = 1;
		
		Blocks b = new Blocks();
		Blocks b2 = new Blocks();
		
		b.row = 2;
		b.col = 2;
		
		b.insolation = 2;
		b2.insolation = 2;
		
		b.currSum = 10;
		b2.currSum = 11;
		
		
		b.elapsed = 4;
		b2.elapsed = 6;
		
		
		
		
	}

}

class Blocks implements Comparable<Blocks>{
	int row = 0;
	int col = 0;
	int insolation = 0;
	boolean isVisit = false;
	int currSum = 0;
	int elapsed = 0;
	Blocks parent = null;
	
	public Blocks(){
		
	}
	
	public Blocks(int row, int col, int insolation, int currSum, int elapsed, Blocks parent){
		this.row = row;
		this.col = col;
		this.insolation = insolation;
		this.currSum = currSum;
		this.elapsed = elapsed;
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{(");
		sb.append(row).append(",").append(col).append("},").append(insolation)
		  .append(",").append("s:").append(currSum).append(",t:").append(elapsed);
		sb.append("}");
		return sb.toString();
	}

	@Override
	public int compareTo(Blocks o) {
		return Integer.compare(currSum, o.currSum);
	}
}