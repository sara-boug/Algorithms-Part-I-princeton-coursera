package week3;

import java.util.ArrayList;

import javafx.scene.Group;

public class BruteCollinearPoints {
	Point[] point; 

	public BruteCollinearPoints(Point[] point ) {
		this.point= point; 
	}

	public Group numberSeg(){
		Group group =new Group(); 
		for(int i=0; i <point.length ; i++) { 
			for(int j=0; j<point.length; j++) { 
				point[i].slops.add(point[i].slopeTo(point[j])); 
			}

		}
		int n=0; 
		for(int i=0; i <point.length ; i++) { 
			for(int j=0; j<point[i].slops.size(); j++) { 
				n=occur(point[i].slops,point[i].slops.get(j) );
				if(n>=5) { 
					System.out.print("yesss");
					group.getChildren().add(point[i].drawTo(point[j]));
					
				}
			}
 		}
		return group; 
	}
	public int occur(ArrayList<Float> slops ,  float pointer) { 
		int n=0; 
		for(int k=0; k<slops.size(); k++ ) { 
			if(pointer==slops.get(k)) { 
				System.out.println(pointer+" "+slops.get(k));
				n++;
			}
		}		
		return n ; 
	}

}
