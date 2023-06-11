//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here 
        
        int count =R*C/2;
        PriorityQueue<Pair> pq = new PriorityQueue<>( new StudentComparator());
        
        for(int i =0;i<R;i++){
            pq.add(new Pair(matrix[i][0],i,0));
        }
        int j =0;
        while(count>0){
           
            Pair y =pq.remove();
            int nr=y.r;
            int nc=y.c+1;
            if(nc<C){
                pq.add(new Pair(matrix[nr][nc],nr,nc));
            }
             count--;
            
        }
        
        
        return pq.remove().num;
        
        
        
        
        
    }
}
class Pair{
    int num ;
    int r;
    int c ;
    
    Pair(int n , int i,int j ){
        num=n;
        r=i;
        c=j;
    }
}

class StudentComparator implements Comparator<Pair>{
             
            // Overriding compare()method of Comparator
                        // for descending order of cgpa
            public int compare(Pair s1, Pair s2) {
                if (s1.num > s2.num)
                    return 1;
                else{
                    return -1;
                }
                    
                            
                }
        }