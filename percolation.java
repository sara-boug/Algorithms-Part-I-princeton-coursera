import java.util.Arrays;

class site { 
	      public  int root ;
	      public   int  blocked=1; 
	      public   int  full = 0; 
	    }


public class percolation {
    public site[][] grid ; 
	quick_union QC ;
	private int length; 

 	public percolation(int n){
 		length=n; 
 		QC = new quick_union(n*n); 
		int num=0; 
		grid= new  site[n][n];
		for(int row=0; row<n; row++) { 
			for(int column=0; column<n; column++) { 
				site  element= new site() ; 
				element.root= num;
				grid[row][column]=element;
				QC.id[num] = num; 
				QC.sz[num] =1;
				num++;
 			}
			
		}
	}

 	public void open(int row , int column) { //linking each node to the other
 	 		QC.unite( grid[row][column-1>=0 ?column-1:column].root,grid[row][column].root);
	 		QC.unite(grid[row][column+1<=length-1? column+1:column].root,grid[row][column].root);
	 		QC.unite( grid[row+1<=length-1?row+1:row][column].root,grid[row][column].root);
	 		grid[row][column].blocked=0; 
	 		grid[row][column-1>=0 ?column-1:column].blocked=0; 
	 		grid[row][column+1<=length-1? column+1:column].blocked=0; 
	 		grid[row+1<=length-1?row+1:row][column].blocked=0;
	 		System.out.println( Arrays.toString(QC.id));
 		
  	}
 	public boolean isOpen(int row ,int column) { 
 		return grid[row][column].blocked==0;
 	}
 	
 	public boolean isFull(int row , int column) { 
 		 return grid[row][column].full==0;
 	}
 	
 	public int numberOfOpenSites() { 
 		
 		return 0; 
 	}
 	
 	public boolean percolates() { 
 		for(int i=0 ; i< (length); i++) { 
 			  System.out.println( QC.root(grid[i][0].root) + "  "+QC.root(grid[i][length-1].root));
 			 if(  QC.root(grid[i][0].root)== QC.root(grid[i][length-1].root)) return true;
 			 
 		}
 		return false; 
 	}

}
