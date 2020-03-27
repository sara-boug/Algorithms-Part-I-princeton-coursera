package week2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
// double-ended queue
public class Dequeue< Item> implements Iterable<Item>{
	private static final Exception IllegalArgumentException = null;
	private static final Exception NoSuchElementException = null;
	Item[] queue;
	@SuppressWarnings("unchecked")
	public Dequeue() {

		queue=  (Item[]) new Object[0];

	}
	public boolean isEmpty() { 
		return queue.length==0;  

	}
	public int size() { 
		return queue.length; 
	}
	@SuppressWarnings("unchecked")
	public void addFirst(Item item) { 
		if(item==null) {
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				System.out.print("Exception null rejected"  );
			}
		}else {
			Item[] tempArray =(Item[]) new Object[1]; 
			tempArray[0]=item; 

			if(queue.length<1) {
				queue=tempArray;
				return; 
			}  
			Item[] tempArray2  =  concat(tempArray , queue); 		
			queue=tempArray2; 
		}

	} 
	public  void addLast(Item item) { 
		if(item==null) {
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				System.out.print("Exception null rejected"  );
			}
		}else {
			@SuppressWarnings("unchecked")
			Item[] tempArray=  (Item[]) new Object[1];	    
			tempArray[0] = item;
			if(queue.length<1) {
				queue= tempArray; 
				return;
			}  
			Item[]  tempArray2=concat(queue, tempArray); 
			queue=tempArray2;
		}
	}
	public Item removefirst() {
		if(isEmpty()) {
			try {
				throw NoSuchElementException;
			} catch (Exception e) {
				System.out.print(" Exception! can not remove in an empty collection"  );
				return null;  

			}
		}else {
			@SuppressWarnings("unchecked")
			Item[] tempArray=  (Item[]) new Object[queue.length-1];	    
			int j=0; 
			for(int i=1; i<queue.length; i++) { 
				tempArray[j]= queue[i]; 
				j++;
			}
			queue=tempArray; 
			return queue[0]; 
		}
	}
	public  Item  removeLast() { 
		if(isEmpty()) {
			try {
				throw NoSuchElementException;
			} catch (Exception e) {
				System.out.print(" Exception! can not remove in an empty collection"  );
				return null;  

			}
		}else {
			@SuppressWarnings("unchecked")
			Item[] tempArray=  (Item[]) new Object[queue.length-1];	    

			for(int i=0; i<queue.length-1; i++) { 
				tempArray[i]= queue[i]; 

			}
			queue=tempArray; 
			return queue[queue.length-1]; 
		}
	}



	public Iterator<Item> iterator() throws NoSuchElementException, UnsupportedOperationException{
		Iterator<Item> iterator = Arrays.stream(queue).iterator();
		while(iterator.hasNext())System.out.print(iterator.next());	       
		return iterator; 
	}
	private Item[] concat(Item[]array1 , Item[] array2) { 
		int i=0;
		@SuppressWarnings("unchecked")
		Item[] result=  (Item[]) new Object[array1.length + array2.length];
		for(i=0; i<array1.length ; i++  ) { 
			result[i]=array1[i]; 
		}
		i=array1.length;
		for(int j=0; j<array2.length; j++) { 
			result[j+i] = array2[j];

		}

		return result; 
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Dequeue sample = new Dequeue();
		/*sample.removefirst(); 
	    sample.removeLast();*/

		sample.addFirst(1);
		sample.addFirst(2);
		sample.addFirst(3);
		sample.addFirst(2);
		sample.addFirst(3);
		sample.addFirst(null);
		sample.addLast(null);
		System.out.println();
		sample.iterator(); 

	}





}
