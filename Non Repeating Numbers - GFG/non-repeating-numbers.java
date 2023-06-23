//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int[] ans=new int[2];
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        //index where bits changed for once 
        int idx=0;
        int a =0;
        int b=0;
        
        while(xor>0){
            if((xor&1)==1){
                break;
            }else{
                xor=xor>>1;
                idx++;
            }
        }
        for(int i:nums){
            if((i&(1<<idx))==0){
                a=a^i;
            }else{
                b=b^i;
            }
        }
        
        
        ans[0]=a;
        ans[1]=b;
        
        
        
        
        Arrays.sort(ans);
        
        return ans;
    }
}