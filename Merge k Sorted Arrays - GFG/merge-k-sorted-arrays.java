//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<pair> pq = new PriorityQueue<pair>((a,b)->{
            return a.y-b.y;
        });
        
        int end =arr[0].length;
        for(int i =0;i<arr.length;i++){
            pq.add(new pair(arr[i][0],i,0));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(pq.size()>0){
            pair y =pq.remove();
            ans.add(y.y);
            if(y.pos<end-1){
                pq.add(new pair(arr[y.idx][y.pos+1],y.idx,y.pos+1));
            }
            
            
        }
        
        return ans;
        
        
        
    }
}
class pair{
    int y ;
    int idx;
    int pos;
    pair(int u , int i,int j){
        y=u;
        idx=i;
        pos=j;
    }
}