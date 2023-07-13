//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int h = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.countBT(h));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long[] dp=new long[1001];
   
    static long countBT(int h){
        // code here
         dp[0]=1;
         dp[1]=1;
         
        long mod =1000000007;
        
        if(dp[h]!=0){
            return dp[h];
        }
        
        
        for(int i =2;i<=h;i++){
            long sol=0;
            if(dp[i]==0){
                 for(int j =0;j<i;j++){
                
                int curr=j;
                int height =i-1;
                int counter =0;
                while(Math.max(counter,curr)<height){
                    counter++;
                }
                while(Math.max(counter,curr)==height){
                    if(Math.abs(curr-counter)<=1){
                         dp[i]=(dp[i]+dp[curr]*dp[counter])%mod;
                    }
                     
                      counter++;
                }
                
                
              
              }
            }else{
                continue;
            }
           
        }
        
        
        
        
        return dp[h]%mod;
    }
}