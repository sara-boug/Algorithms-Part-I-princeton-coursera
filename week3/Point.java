package week3;

 import java.util.ArrayList;
import java.util.Comparator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Point  implements Comparable<Point>{
	public int x; 
	public int y; 	
	public ArrayList<Point>  collinears;
	public Point(int x, int y ) {
		//System.out.print("x"+ x +" y" + y);
		this.x= x; 
		this.y= y; 
		 collinears= new ArrayList<Point>();;

	}	
	public Circle  draw() { 
		Circle c= new Circle(); 
		c.setCenterX(this.x);
		c.setCenterY(this.y); 
		c.setRadius(3);
		c.setFill(Color.ORANGE);
		return c; 
	}
	public Line drawTo(Point p) { 
		Line l = new Line(); 
		l.setStartX(this.x); 
		l.setStartY(this.y); 
		l.setEndX(p.x);
		l.setEndY(p.y);
		l.setFill(Color.BLACK);
		return l; 
	}
	public int compareTo(Point p) { 	
		if(this.y>p.y) {
			return 1; 
		}else if(this.y==p.y && this.x>p.x) { 
			return 1; 
		}else { 
			return 0 ; 

		}
	}
	public float slopeTo(Point  p)  { //formula slope= (y1-y2)/(x1-x2)
		
		float slope=(float) (p.y-this.y)/(p.x-this.x); 
         slope=Math.round(slope*100); 
         slope=slope/100;
 		return slope; 

	}
	public Comparator<Point> slopeOrder() {
   	 final Point p = this; 

      return new Comparator<Point> () {
		@Override
		public int compare(Point p1, Point p2) {
            return  (int) (p2.slopeTo(p)-p1.slopeTo(p));
 			 
		} 
   	  
      };
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
