//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        HashMap<Character , Integer > hm = new HashMap<>();
        int[] fr =new int[26];
        Arrays.fill(fr,-1);
        Queue<Character> q =new LinkedList<>();
        
        
        StringBuilder sb= new StringBuilder();
        for(int i =0;i<A.length();i++){
            fr[A.charAt(i)-'a']++;
            if(fr[A.charAt(i)-'a']==0){
                q.add(A.charAt(i));
                sb=sb.append(""+q.peek());
                
            }else{
                 Queue<Character> temp =new LinkedList<>();
                 while(q.size()>0){
                     if(fr[q.peek()-'a']>0){
                         q.remove();
                     }else{
                         temp.add(q.remove());
                     }
                 }
                 q=temp;
                 if(q.size()==0){
                     sb=sb.append("#");
                 }else{
                     sb=sb.append(""+q.peek());
                 }
                
            }
           
        }
        return sb+"";
        
        
    }
}