package week1;
class site { 
	      public  int root ;
	      public   int  blocked=1; 
	      public   int  full = 0; 
	    }


public class percolation {
    public site[][] grid ; 
	quick_weightedUnion QU ;
	private int length; 
	public  int openSite; 
	public  int virtualTopNode;  
	public int  virtualBottomNode; 
 
 	public percolation(int n){
 		length=n; 
 		openSite=0;
 		QU = new quick_weightedUnion(n*n+2); 
		int num=0; 
		grid= new  site[n][n];
		for(int row=0; row<n; row++) { 
			for(int column=0; column<n; column++) { 
				site  element= new site() ; 
				element.root= num;
				grid[row][column]=element;
				QU.id[num] = num; 
				QU.sz[num] =1;
				num++;
 			}
			
		}
		virtualTopNode= n*n; 
		virtualBottomNode= n*n+1 ; 
		QU.id[virtualTopNode]= num;
		QU.id[virtualBottomNode]=num+1; 
	}

 	public void open(int row , int column) { //linking each node to the other
		 if(row ==0) {
  			 QU.unite(grid[row][column].root ,virtualTopNode);
 			 //System.out.println("node top "+QU.root( grid[row][column].root));

 		 }
 		 if( row==length-1) { 

 			 QU.unite(grid[row][column].root ,virtualBottomNode);
 			 //System.out.println("node bottom "+ QU.root (grid[row][column].root));


 		 }

 	 		QU.unite( grid[row][column-1>=0 ?column-1:column].root,grid[row][column].root);
	 		QU.unite(grid[row][column+1<=length-1? column+1:column].root,grid[row][column].root);
	 		QU.unite( grid[row+1<=length-1?row+1:row][column].root,grid[row][column].root);
	 		QU.unite( grid[row-1>=0?row-1:row][column].root,grid[row][column].root);

	 		 if (grid[row][column].blocked!=0) { //checkking whether the column is blocked or not 
	 			grid[row][column].blocked=0; 
		 		openSite+=1; 
	 		 }
	 		 if (grid[row][column-1>=0 ?column-1:column].blocked != 0) { 
	 			grid[row][column-1>=0 ?column-1:column].blocked= 0	;		 
	 					openSite+=1; 
		 		 } 
	 		 if (grid[row][column+1<=length-1? column+1:column].blocked!=0) { 
	 	 		grid[row][column+1<=length-1? column+1:column].blocked=0; 
				 		openSite+=1; 
			 		 }	 
	 		 
	 		 if (grid[row+1<=length-1?row+1:row][column].blocked!=0) { 
	 			grid[row+1<=length-1?row+1:row][column].blocked=0;			
	 			openSite+=1; 
		 		 } 
	 		 
	 		 if (grid[row-1>=0?row-1:row][column].blocked!=0) { 
	 			grid[row-1>=0?row-1:row][column].blocked=0;			
	 			openSite+=1; 
		 		 } 

	 		 
  		
  	}
 	public boolean isOpen(int row ,int column) { 
 		return grid[row][column].blocked==0;
 	}
 	
 	public boolean isFull(int row , int column) { 
 		 return grid[row][column].full==0;
 	}
 	
 	public int numberOfOpenSites() { 
 		
 		return openSite; 
 	}
 	
 	public boolean percolates() { 
 		// System.out.println(QU.root(virtualTopNode) + "  "+QU.root(virtualBottomNode));
 		 //System.out.print(Arrays.toString( QU.id));
  		  return 	 QU.root(virtualTopNode)==QU.root(virtualBottomNode); 
  	 
 	}

 	}
 	

 
