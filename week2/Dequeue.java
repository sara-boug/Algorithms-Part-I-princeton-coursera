package week2;

import java.util.Arrays;
import java.util.Iterator;
 
// double-ended queue
public class Dequeue< Item> implements Iterable<Item>{
     public int size; 
     Item[] array;
	 public Dequeue() {
		 size=0; 
    	 array=  (Item[]) new Object[size];
		
 	}
	public boolean isEmpty() { 
		return size==0;  

	}
	public int size() { 
		return size; 
	}
	public void addFirst(Item item) { 
		 size++;
	     Item[] tempArray=  (Item[]) new Object[size];
	     tempArray[0] = item; 
		 if(size>1) {
	  	 for(int i=0; i<array.length; i ++) { 
	 			  tempArray[i+1]= array[i] ; 
	 		}
		}
		 array=tempArray;		
	}
 
	public  void addLast(Item item) { 
		 size++;
	     Item[] tempArray=  (Item[]) new Object[size];
	     if(size<=1) {
	     tempArray[0] = item; 
	     }else {
		  
	  	 for(int i=0; i<array.length; i ++) { 
	 			  tempArray[i]= array[i] ; 
	 		}
	  	 tempArray[size-1]= item; 
	  	}
		 array=tempArray;		
	}
	/*public Item removefirst() { 
 	}
	 Item  removeLast( ) { 
		
	 
	}
*/
 	@SuppressWarnings("unchecked")
	public Iterator<Item> iterator(){
 	      Iterator<Item> iterator = Arrays.stream(array).iterator();
 	      while(iterator.hasNext())System.out.print(iterator.next());	       
 	      return iterator; 
	 	}
  	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Dequeue sample = new Dequeue(); 
	 	sample.addLast(1);
		sample.addLast(2); 
	 	sample.addLast(3);
		sample.addLast(4); 
	 	sample.addLast(5);
 


  		sample.iterator(); 
  		System.out.println();
 		sample.iterator(); 

	}
 
	 



}
