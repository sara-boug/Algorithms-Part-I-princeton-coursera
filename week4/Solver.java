package week4;
import java.util.ArrayList;
import java.util.Iterator;

class Round{ 
	Board b; 
	int manhattan ; 
	int move; 
	int result; 
	public Round(Board b, int move) { 
		this.b= b; 
		this.manhattan=b.manhattan(); 
		this.move=move; 
		this.result=this.manhattan+this.move; 
	}
}
public class Solver {

	int attemp =0; 
	Round board; 
	Board initial; 
	int move; 		 

	ArrayList<Board> boards = new ArrayList<Board>(); 
	public Solver(Board initial) {
		this.initial=initial ; 
		if(Solvable()) {

			MinPq minpq = new MinPq(); 
			Round r; 
			move=0; 
			r=new Round(initial, move); 
			board =r; 
			while(!board.b.isGoal()) { 
				Iterator<Board> i = board.b.neighbours().iterator(); 
				move++;			
				while(i.hasNext()) {
					r=new Round(i.next(),move); 
					minpq.add(r);
				}
				board= minpq.removeMin();
 				boards.add(board.b);  

			}
		}else { 
			System.out.print("not Solvable");
		}
 	  		 
	}
	public boolean Solvable()  {
		int moves= 0; 
		Iterator<Board> i= initial.neighbours().iterator();
		while(i.hasNext()) { 
	     	 i.next();
			moves++; 
		}
		if(moves%2==0) return false; 
		else return true; 
	}
	public int numMoves() { 
		return move; 

	}

	public Iterable<Board> solution() {
		return new Iterable<Board>() {
			@Override
			public Iterator<Board> iterator() {
				Iterator<Board> i =boards.iterator(); 
				return i;
			} 

		};

	}
}
