package week3;

import java.util.Comparator;

public class Point {
	public int x; 
	public int y; 

	public Point(int x, int y ) {
		this.x= x; 
		this.y= y; 
		
	}	
	public int compareTo() { 			
		return 0 ; 
	}
    public double slopeTo()  {
		return x; 
    	
    }
    public Comparator<Point> slopeOrder() {
		return null; 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
