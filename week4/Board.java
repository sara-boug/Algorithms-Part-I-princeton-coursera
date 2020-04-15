package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Board {
	public final int[][] board; 

	public Board(int[][]  board) {
		this.board =board; 
	}
	public String toString() { 
		String string=""; 
		for(int row=0; row<dimension(); row++) { 
		 string+=	Arrays.toString(board[row]);
		 string+="\n";
		}
		return string;  
	}
	public int dimension() { 
		return board[0].length; 
	}
	public int hamming() { 
		int hamming=0; 
		int n=1; 
		for(int row=0; row<dimension(); row++) { 
			for(int column=0; column<dimension(); column++) { 
				if(n==dimension()*dimension()) {
					return hamming;  
				}
				if(board[row][column]!=n) {
					hamming++; 
				} 
				n++; 
			}
		}	
		return hamming ;    	
	}
	private int countManhattan(int row , int column){ 
		int number = board[row][column]; 
		int d=0; 
		int destRow=0;
		int destColumn=0; 
		int rest =number % dimension(); 
		if(rest==0) { 
			destRow=(number/dimension())-1; 
		}else { 
			destRow=(number/dimension());
		}    	
		destColumn=number-(destRow*dimension())-1;
		d=(int) Math.sqrt(((destRow-row )+(destColumn-column))*((destRow-row )+(destColumn-column))); 
		return d; 
	}
	public int manhattan(){ 
		int manhattan =0; 
		for(int row=0; row<dimension(); row++) { 
			for(int column=0; column<dimension(); column++) { 
				manhattan+=countManhattan(row,column);
			}
		}
		return manhattan; 
	}

	public boolean isGoal() { 
		if(hamming()==0) { 
			return true; 
		}else { 
			return false; 
		}
	}
	public Board swip(int row, int column , int row1 , int column1 ) { 
		
		int[][] b= new int[dimension()][dimension()]; 
		for(int i=0; i<dimension(); i++) {   // the most suitable way to coppy an array , it allow not modifying the global array 
			for(int j=0; j<dimension(); j++) { 
                b[i][j]=board[i][j];
			}
		}
		
		int val= b[row][column]; 
		int val1=  b[row1][column1] ;
		b[row1][column1]=val; 
		b[row][column] = val1; 
		Board brd = new Board(b);
		System.out.println(brd.toString());

		return brd; 
	}
	public ArrayList<Board> generateNeighbours(int row , int column) { 
		ArrayList<Board> boards= new ArrayList<Board>();
		 if(row+1<dimension() && countManhattan(row+1,column)!=0) { 
			 boards.add(swip(row , column, row+1, column)); 
		 }
		 if(row-1>=0 && countManhattan(row-1,column)!=0) { 
			 boards.add(swip(row , column, row-1, column)); 
		 }
		 if(column+1<dimension() && countManhattan(row,column+1)!=0) { 
			 boards.add(swip(row , column, row, column+1)); 
		 }
		 if(column-1>=0 && countManhattan(row,column-1)!=0) { 
			 boards.add(swip(row , column, row, column-1)); 
		 }
 		return boards ;
	}
	public  Iterable<Board> neighbours(){ 
		return new  Iterable<Board>(){
		  Iterator<Board> iterator;
			@Override
			public Iterator<Board> iterator() {
				boolean found= false; 
				int Row=0; 
				int Column=0;
				for(int row=0; row<dimension(); row++) { 
					for(int column=0; column<dimension(); column++) { 
						if(board[row][column]==0) { 
							Row=row; 
							Column=column; 
							found=true; 
						}
					}
					if(found==true) break; 		        	
				}
				 
			iterator= generateNeighbours(Row,Column).iterator();	
 				return iterator; 
			} 
		};
	}
	public static void main(String[] args) {
      int[][] board = {{0,1,3}, {4,2,5} ,{7,8,6}}; 
      Board b= new Board(board);
      System.out.println(b.toString());
      System.out.println(b.manhattan());
       Iterator<Board> i= b.neighbours().iterator();
       Solver solver = new Solver(b); 
 
        
	}

}
