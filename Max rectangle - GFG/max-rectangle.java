//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        
        int[] dp= new int[M[0].length];
        Arrays.fill(dp,0);
        
        int max =Integer.MIN_VALUE;
        for(int i =0;i<M.length;i++){
            //int[] dp= new int[m];
            
            
            for(int  j =0;j<M[0].length;j++){
                
                if(M[i][j]==0){
                    dp[j]=0;
                }else if(M[i][j]==1){
                   
                        dp[j]=dp[j]+1;
                    
                }
            }
           // dp2=dp;
            
            
            // for(int k =0;k<dp.length;k++){
            //     System.out.print(dp[k]+"  ");
            // }
            //  System.out.println();
            
            int y =calculate(dp);
            
            max=Math.max(max,y);
        }
        
        return max;
    }
    
    int calculate(int[] dp){
        
        int max=Integer.MIN_VALUE;
        //  for(int k =0;k<dp.length;k++){
        //         System.out.print(dp[k]+"  ");
        //     }
        //      System.out.println();
        
        
        int[] leftsmall= lsmall(dp);
        int[] rightsmall=rsmall(dp);
        //  for(int k =0;k<dp.length;k++){
        //         System.out.print(leftsmall[k]+"  "+rightsmall[k]);
        //     }
        //      System.out.println();
        
        
        for(int i =0;i<dp.length;i++){
            max=Math.max(max,(rightsmall[i]-leftsmall[i]-1)*dp[i]);
            
        }
        
        return max;
        
        
        
    }
    
    int[] lsmall(int[] dp){
        int[] l =new int[dp.length];
        //  for(int k =0;k<dp.length;k++){
        //         System.out.print(dp[k]+"  ");
        //     }
        //      System.out.println();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<dp.length;i++){
            while((st.size()>0)&& (dp[i]<=dp[st.peek()])){
                st.pop();
            }
            if(st.size()==0){
                l[i]=0;
            }else{
                l[i]=st.peek()+1;
            }
            st.push(i);
            
        }
        
        
        return l;
        
    }
    int[] rsmall(int[] dp){
        int[] l =new int[dp.length];
        //  for(int k =0;k<dp.length;k++){
        //         System.out.print(dp[k]+"  ");
        //     }
        //      System.out.println();
        
        Stack<Integer> st = new Stack<>();
        for(int i =dp.length-1;i>=0;i--){
            while((st.size()>0) && (dp[i]<=dp[st.peek()])){
                st.pop();
            }
            if(st.size()==0){
                l[i]=dp.length+1;
            }else{
                l[i]=st.peek()+1;
            }
            st.push(i);
            
        }
        
        
        return l;
        
    }
}