package week1;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int n= 5; 
  	Random  r = new Random(); 

	 percolation perco = new percolation(n);
		for(int num=0; num<7; num++) { 
			perco.open(r.nextInt(n), r.nextInt(n));
		} 


	 for(int i =0; i<n ; i++) { 
		 for(int j=0;j<n; j++ ) { 
			 System.out.print(perco.grid[i][j].blocked + " ");
		 }
		 System.out.println(); 
	 }
	 
	 System.out.print(perco.percolates());
	}

}
