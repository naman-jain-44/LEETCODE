//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        Set<String> s = new HashSet<>();
        for(String h :B){
            s.add(h);
        }
        int[] dp =new int[A.length()+1];
        Arrays.fill(dp,-1);
        
        return recurse(A,s,0,dp);
    }
    public static  int recurse(String A , Set<String> s , int idx,int[] dp){
        if(idx==A.length()){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        int sum=0;
        for(int i =idx+1;i<=A.length();i++){
            if(s.contains(A.substring(idx,i))){
                int u=recurse(A,s,i,dp);
                sum=sum+u;
            }
        }
        
        return dp[idx]=sum;
    }
}