package week3;

import java.util.Arrays;
import javafx.scene.Group;

public class FastCollinearPoints {
	public Point[] point; 
	 
	public FastCollinearPoints(Point[] point) {
		this.point= point; 
	}

	public Group findAllSegment() { 
		Group group = new Group() ;  	    

		Point[] pointClone = point.clone(); 
		int size= pointClone.length; 
		for(int i=0; i<size; i++) { 
			Point p= pointClone[i];
			Arrays.sort(pointClone, p.slopeOrder());//log n
			
			 group.getChildren().add(drawLine(pointClone, p)); 
			System.out.println(" "); 
		}
		return group ; 
	}
	public  Group drawLine(Point[] P , Point p ) { 	 
		int[] occurence = new int[P.length];
		int n=0; 
 		for( int i=0; i<P.length; i++) { 
 			n=0; 
			for(int j=0; j<P.length; j++) { 
				if( P[j].slopeTo(p)==P[i].slopeTo(p) ) {  
					n++; 			  
				}  
			}
			occurence[i]=n; 
			
		    System.out.println(n + "  " +P[i].slopeTo(p));
 		}
	return 	DrawLine(occurence,p); 
	}
	  public Group   DrawLine(int[] occu, Point p) { 
        Group group = new Group() ; 		 
          for(int i=0 ; i<occu.length; i++) { 
        	  if(occu[i]>3 ) { 
        		 p.collinears.add(point[i]);
        		group.getChildren().add(p.drawTo(point[i])); 
         	  
        	  }
          }
          return group;       
	   }
	  
	  public void filterPath() { 
		  for(int i=0; i<this.point.length ; i++) { 
			  for(int j=0; j<point[i].collinears.size(); j++) { 
				  System.out.print(point[i].slopeTo(point[i].collinears.get(j)) +" ");
			  }
			  System.out.println();

			  
		  }
	  }
 
   

}
