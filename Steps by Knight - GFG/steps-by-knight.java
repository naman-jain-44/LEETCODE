//{ Driver Code Starts
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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int min =0;
        boolean[][] visited=new boolean[N][N];
        
        //changing coordinates to our 
      int ir=N-KnightPos[1];
      int ic =KnightPos[0]-1;
      
      int fr=N-TargetPos[1];
      int fc =TargetPos[0]-1;
        
        
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(ir , ic));
      visited[ir][ic]=true;
      
      int[] dx=new int[]{-2,2};
      int[] dy=new int[]{-1,1};
      
      while(q.size()>0){
          int k =q.size();
          while(k-->0){
              Pair y =q.remove();
              if(y.r==fr && y.c==fc){
                  return min;
              }
              
              for(int i =0;i<2;i++){
                  for(int j =0;j<2;j++){
                      int nr = y.r+dx[i];
                      int nc = y.c+dy[j];
                      if(valid(nr,nc,N)){
                          if(!visited[nr][nc]){
                              visited[nr][nc]=true;
                              q.add(new Pair(nr,nc));
                          }
                      }
                       nr = y.r+dy[i];
                       nc = y.c+dx[j];
                      if(valid(nr,nc,N)){
                          if(!visited[nr][nc]){
                              visited[nr][nc]=true;
                              q.add(new Pair(nr,nc));
                          }
                      }
                  }
                  
              }
              
              
              
          }
          min++;
      }
        
        
        
        
        
        
        return -1;
    }
    
    public boolean valid(int i , int j,int n ){
        if(i<0 ||j<0 ||i>=n||j>=n){
            return false;
        }
        return true;
    }
}



class Pair{
    int  r;
    int c;
    Pair(int i , int j ){
        r=i;
        c=j;
    }
}