
public class quick_union {
	public int[] id; 
     public int[] sz; 
	public quick_union(int n) {
		id=new int[n];
		sz= new int[n];
		
	} 

	
	public  int root(int i ) { 
		while(i != id[i] ) { 
		 id[i] = id[id[i]];
		 i=id[i];
		}
		return i ; 
	}
	
    public boolean find(int q , int p )  {
    	return id[q] ==id[p]; 
    }
    
    public void unite(int q , int p ) { 
    	int i = root(q); 
    	int j = root(p); 
         id[i]=j;

    	if(sz[i]<sz[j]) { 
            id[i]= j; 
            
            sz[j]+=sz[i];

    	}else { 
    	
            id[j]= i; 
            sz[i]+=sz[j];

    	}
    	
    }
}
