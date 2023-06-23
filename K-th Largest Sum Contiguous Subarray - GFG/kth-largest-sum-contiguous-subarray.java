//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int K; 
            K = Integer.parseInt(br.readLine());
            
            
            int[] Arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.kthLargest(N, K, Arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        if(N==1){
            return Arr[0];
        }
        for(int i =1;i<Arr.length;i++){
            Arr[i]=Arr[i]+Arr[i-1];
        }
        
        for(int i=N-1;i>0;i--){
            for(int j =i-1;j>=-1;j--){
                if(j!=-1){
                   
                pq.add(Arr[i]-Arr[j]);
                if(pq.size()>K){
                    pq.remove();
                    
                }
                }else{
                   
                 pq.add(Arr[i]);
                 if(pq.size()>K){
                    pq.poll();
                }
            }
                
            }
        }
        pq.add(Arr[0]);
         if(pq.size()>K){
                    pq.poll();
         }
        
        return pq.remove();
    }
}
        
