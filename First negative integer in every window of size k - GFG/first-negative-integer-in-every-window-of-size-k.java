//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] ans =new long[A.length-K+1];
        
        
        int i =0;
        int j =0;
        int firstmin=Integer.MAX_VALUE;
        Queue<Long> q =new LinkedList<>();
        while(j<A.length){
            if(j-i+1<K){
                if(A[j]<0){
                    q.add(A[j]);
                }
                j++;
                
                
            }else if(j-i+1==K){
                if(A[j]<0){
                    q.add(A[j]);
                }
                
                if(q.size()>0){
                    ans[i]=q.peek();
                }else{
                    ans[i]=0;
                }
                
                if(q.size()>0&& A[i]==q.peek()){
                    q.remove();
                    i++;
                }else{
                    i++;
                }
                
                j++;
                
                
                
            }
            
            
        }
        return ans;
    }
}