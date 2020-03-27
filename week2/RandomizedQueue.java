package week2;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
 
public class RandomizedQueue<Item> implements Iterable<Item> {
	private static final Exception NoSuchElementException = null;
	private static Exception IllegalArgumentException = null;  
	Item[] queue; 

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		queue = (Item[]) new Object[0]; 
	}
	public boolean isEmpty() { 
		return queue.length==0; 
	}
	public int size() {
		return queue.length; 
	}
	@SuppressWarnings("unchecked")
	public void enqueue(Item item) { 
		if(item==null) {
			try {
				throw IllegalArgumentException;
			}catch(Exception e) { 
 			}
			
		}else {
		Item[] tempArray =(Item[]) new Object[size()+1];            
		if(isEmpty())  { 
			tempArray[0]=item;
			queue=tempArray; 
		}else { 
			Random r  = new Random(); 
			int pos = (r.nextInt(queue.length)); 
			tempArray = insertRandom(pos, item); 
			queue=tempArray; 
		}
		}

	}
	@SuppressWarnings("unchecked")
	public Item dequeue() { 
		if(isEmpty()) {
			try { 
				throw  NoSuchElementException;				
			}catch (Exception e) { 
				return (Item) e; 
			}

		}else {
			Item[] tempArray =(Item[]) new Object[size()-1]; 
			Random r  = new Random(); 
			int pos = (r.nextInt(queue.length)); 
			Item item= queue[pos];

			int n=0; 
			for(int i=0; i<size(); i++) { 	    	
				if(i==pos) continue ; 
				tempArray[n]=queue[i]; 
				n++; 
			}
			queue=tempArray;
			return item;
		}
	}
	@SuppressWarnings("unchecked")
	public Item sample() { 
		if(isEmpty()) {
			try { 
				throw  NoSuchElementException;				
			}catch (Exception e) { 
				return (Item) e; 
			}

		}else {

		Random r  = new Random(); 
		int pos = (r.nextInt(queue.length)); 
		Item item= queue[pos];
		return item; 
		}
	}
	private Item[] insertRandom(int r, Item item) { 
		@SuppressWarnings("unchecked")
		Item[] tempArray =(Item[]) new Object[size()+1]; 
		tempArray[r]=item; 
		int n=0; 
		for(int i=0; i< tempArray.length; i++) { 
			if(i== r)  {   continue; } 
			tempArray[i]=queue[n];
			n++; 
		}

		return tempArray; 
	}
	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = Arrays.stream(queue).iterator();
		while(iterator.hasNext())System.out.print(iterator.next() + " ");	       
		return iterator; 
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		RandomizedQueue Q = new RandomizedQueue() ;
 		Q.enqueue(null);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.enqueue(4);
		Q.enqueue(5);
		Q.enqueue(6); 
		Q.enqueue(7);
		Q.enqueue(8);
		Q.enqueue(9);
		Q.enqueue(10); 

		Q.iterator();
		Q.dequeue();
		Q.dequeue();

		System.out.println();
		Q.iterator();




	}



}
