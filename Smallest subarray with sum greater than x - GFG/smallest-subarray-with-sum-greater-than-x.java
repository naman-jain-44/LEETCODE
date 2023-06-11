//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        
        
        int res =Integer.MAX_VALUE;
        
        int sum =0;
        int j=0;
        int i =0;
        while(j<n){
            sum=sum+a[j];
            
            if(sum>x){
                res=Math.min(res,j-i+1);
                while(i<n && sum>x){
                    sum=sum-a[i];
                    i++;
                    
                }
                res=Math.min(res,j-i+2);
                
                
            }
            j++;
            
        }
        
        return res;
       
            
            
            
        
    }
}

