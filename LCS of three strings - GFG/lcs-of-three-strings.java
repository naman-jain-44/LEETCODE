//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int[][][] dp =new int[n1+1][n2+1][n3+1];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return recurse(A,B,C,n1-1,n2-1,n3-1,dp);
    }
    public int recurse(String A, String B, String C, int i, int j, int k,int[][][] dp){
        if(i<0 ||j<0||k<0){
            return 0;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        if(A.charAt(i)==B.charAt(j)&&B.charAt(j)==C.charAt(k)){
            return dp[i][j][k]= 1+recurse(A,B,C,i-1,j-1,k-1,dp);
        }else{
            return dp[i][j][k]=Math.max(recurse(A,B,C,i-1,j-1,k,dp),Math.max(recurse(A,B,C,i,j-1,k-1,dp),Math.max(recurse(A,B,C,i-1,j,k-1,dp),Math.max(recurse(A,B,C,i,j-1,k,dp),Math.max(recurse(A,B,C,i,j,k-1,dp),recurse(A,B,C,i-1,j,k,dp))))));
        }
    }
} 