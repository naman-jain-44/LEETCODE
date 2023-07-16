//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st =new Stack<>();
    	for(int i =0;i<n;i++){
    	    st.add(i);
    	}
    	while(st.size()>1){
    	    int one =st.pop();
    	    int sec=st.pop();
    	    
    	    if(M[one][sec]==1){
    	        //one defiitely not celebrity 
    	        st.push(sec);
    	    }else{
    	        //it can be as it dont know but sec cant be because it should be known by one
    	        st.push(one);
    	    }
    	    
    	    
    	}
    	
    	//last check 
    	int y =st.pop();
    	for(int i =0;i<n;i++){
    	    if(i!=y){
    	         if(M[y][i]==1 || M[i][y]==0){
    	        return -1;
    	    }
    	    }
    	   
    	}
    	
    	
    	
    	return y;
    }
}