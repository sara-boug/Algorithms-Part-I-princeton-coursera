 import java.util.Random;
 
public class percolationStats {
  int trials ; 
  int n ; 
  public float mean; 
  public percolation  perco; 
  public float devStd; 
  
	public percolationStats(int n , int trials ) {
		perco = new percolation(n); 
		this.n =n; 
		this.trials=trials; 
		mean=0; 
		devStd=0; 
    	Random  r = new Random(); 
    	for(int i =1; i <=trials ; i++ ) {
 			for(int num=0; num<4; num++) { 
				perco.open(r.nextInt(n), r.nextInt(n));
			}
 	    	 System.out.println( " openS :" +perco.openSite  + " mean :"+ mean(i) );
 	    	 
 	    	  System.out.println("Standard Deviation : " +devstd(i));
              System.out.println("Confidence Interval " + " [ "+confidencelo(i)+" , "+confidencehi(i) + " ]");
  	     	 System.out.println();
 	    	 if( perco.percolates()) break ; 

    	}

       
 	}
    public double mean(int i ){     	
     	mean +=  (float)((float)perco.openSite/(float)(n*n))/(float)i;     
     	System.out.println("mean" + mean);
    	return mean;  	
    }
    
    public double devstd(float i ){
    	   float x =(float)perco.openSite/ (float)(n*n); 
    	  devStd+=(float)Math.sqrt((x-mean) * (x-mean)/(float)(i>1? i-1:i)) ;
    	  return  devStd; 
    	  
    }
    
 
    public double confidencelo(int i) { 
    	float con= mean-(1.96f/ (float)i); 
    	return con ; 
    	    	
    	
    }
    public double confidencehi(int i ) { 
    	float con= mean+(1.96f/(float)i ); 
    	return con ; 

    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =10; 
		percolationStats PS = new percolationStats(n , 70); 
		  for(int i =0; i<n ; i++) { 
			 for(int j=0;j<n; j++ ) { 
				 System.out.print(PS.perco.grid[i][j].blocked + " ");
			 }
			 System.out.println(); 
		 }

	}

}
