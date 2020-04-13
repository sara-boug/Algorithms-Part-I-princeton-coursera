package week3;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args) ; 
	}

	@Override
	public void start(Stage stage) throws Exception {
		int n=100; 
		Point[] points= new Point[n]; 
		Group group = new Group() ;  	
  int x = 0,y=0; 
		for(int i=0; i < n; i++) {
			 x= (int)(Math.random()*400);
		     y=(int)(Math.random()*400);


			Point p=new Point(x,y);
			points[i]= p ; 
			group.getChildren().add(p.draw());
		}
		FastCollinearPoints fcp = new FastCollinearPoints(points); 
		BruteCollinearPoints bcp = new BruteCollinearPoints(points);
		group.getChildren().add(bcp.numberSeg());
		group.getChildren().add(fcp.findAllSegment());

		//fcp.filterPath();
		Scene scene= new Scene(group, 400, 400,Color.AZURE);
		stage.setScene(scene);
		stage.show();
	} 

}
