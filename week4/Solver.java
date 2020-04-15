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

ArrayList<Round> boards = new ArrayList<Round>(); 
	public Solver(Board initial) {
		this.initial=initial ; 
		MinPq minpq = new MinPq(); 
		Round r; 
		move=0; 
		r=new Round(initial, move); 
		boards.add(r); 
		board =r; 
		minpq.add(r);

		while(!board.b.isGoal()) { 
		   Iterator<Board> i = board.b.neighbours().iterator(); 
			while(i.hasNext()) {
				r=new Round(i.next(),move); 
				 minpq.add(r);
			}
			move++;			
		  board= minpq.removeMin();
		  boards.add(board);  
		}
		System.out.print(boards);
		 
 	}
	public boolean Solvable()  {
		int moves= 0; 
	    Iterator<Board> i= initial.neighbours().iterator();
	    while(i.hasNext()) { 
	    	moves++; 
	    }
	    if(moves%2==0) return true; 
	    else return false; 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
