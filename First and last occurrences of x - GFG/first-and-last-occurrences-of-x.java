//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> ans=new ArrayList<>();
        
        long first =recurse(arr , x);
        long last =recurse1(arr,x);
        
        ans.add(first);
        ans.add(last);
        
        return ans;
    }
    
    public long recurse(long[] arr , int t){
        long l=0;
        long h =arr.length-1;
        
        
        long ans =-1;
        while(l<=h){
            long mid =l+(h-l)/2;
            
            if(arr[(int)mid]==t){
                ans=mid;
                h=mid-1;
                
            }else if(arr[(int)mid]>t){
                h=mid-1;
                
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public long recurse1(long[] arr , int t){
        long l=0;
        long h =arr.length-1;
        
        
        long ans =-1;
        while(l<=h){
            long mid =l+(h-l)/2;
            
            if(arr[(int)mid]==t){
                ans=mid;
                l=mid+1;
                
            }else if(arr[(int)mid]>t){
                h=mid-1;
                
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends