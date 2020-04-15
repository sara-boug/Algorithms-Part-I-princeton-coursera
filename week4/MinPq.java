package week4;

import java.util.ArrayList;

public class MinPq {
	ArrayList<Round> array ; 
	public MinPq() {
		 array = new ArrayList<Round>(); 
	}

	public Round removeMin() { 
		int min=0; 
		Round element ; 
		for(int i=0; i< array.size(); i++) { 
			if(array.get(i).result <array.get(min).result) { 
				min =i; 
			}
		}
		element= array.get(min); 
		array.remove(min); 
		return element; 
		
	}
	public void add(Round element) { 
		array.add(element); 
	}
}
