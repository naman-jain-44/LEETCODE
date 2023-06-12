//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        int max=0;
        int smax=0;
        HashMap<String , Integer> hm = new HashMap<>();
        
        for(String h : arr){
            hm.put(h,hm.getOrDefault(h,0)+1);
        }
        for(String j : hm.keySet()){
            if(hm.get(j)>max){
                 smax=max;
                max=hm.get(j);
               
            }else if(hm.get(j)>smax){
                smax=hm.get(j);
            }
        }
        for(String j : hm.keySet()){
            if(hm.get(j)==smax){
                return j;
            }
        }
        
        return "";
        
    }
}