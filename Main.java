
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int n= 5; 
	 percolation grid = new percolation(n);
     grid.open(1,1); 
     grid.open(2,2); 
     grid.open(0,1); 
     grid.open(2,4); 
     grid.open(2,4); 
     grid.open(4,4); 

	 /*grid.open(12, 12);
	 grid.open(13, 13);*/
	 for(int i =0; i<n ; i++) { 
		 for(int j=0;j<n; j++ ) { 
			 System.out.print(grid.grid[i][j].blocked + " ");
		 }
		 System.out.println(); 
	 }
	 
	 System.out.print(grid.percolates());
	}

}
