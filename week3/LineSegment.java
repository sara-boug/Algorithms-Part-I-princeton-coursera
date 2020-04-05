package week3;

import javafx.scene.shape.Line;

public class LineSegment {
 public Point p1 ; 
 public Point p2; 
	public LineSegment(Point p1 , Point p2) {
		// TODO Auto-generated constructor stub
		if(p1==null || p2==null) { 
			throw new NullPointerException("Argument is null"); 
		}
	}
	public Line  draw() { 
		Line l =   this.p1.drawTo(this.p2); 
		return l ; 
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
