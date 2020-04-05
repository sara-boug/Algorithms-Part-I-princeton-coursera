package week3;

import java.util.Comparator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Point  implements Comparable<Point>{
	public float x; 
	public float y; 

	public Point(float x, float y ) {
		this.x= x; 
		this.y= y; 

	}	
	public Circle  draw() { 
		Circle c= new Circle(); 
		c.setCenterX(this.x);
		c.setCenterY(this.y); 
		c.setRadius(2);
		c.setFill(Color.BLACK);
		return c; 
	}
	public Line drawTo(Point p) { 
		Line l = new Line(); 
		l.setStartX(this.x); 
		l.setStartY(this.y); 
		l.setEndX(p.x);
		l.setEndY(p.y);
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
	public double slopeTo(Point  p)  { //formula slope= (y1-y2)/(x1-x2)
		double slope= (p.y-this.y)/(p.x-this.x); 
		slope=   Math.sqrt(slope*slope); 
		return slope; 

	}
	public Comparator<Point> slopeOrder() {
   	 final Point p = this; 

      return new Comparator<Point> () {
		@Override
		public int compare(Point p1, Point p2) {
            return  Double.compare(p1.slopeTo(p), (  p2.slopeTo(p)));
 			 
		} 
   	  
      };
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
