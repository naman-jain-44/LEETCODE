//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    public  ArrayList<Integer> topView(Node root)
    {
        // add your code
        //find length of list to 
        recurse(root,0);
        if(max==Integer.MIN_VALUE){
            max=0;
        }
        if(min==Integer.MAX_VALUE){
            min=0;
        }
        int[] ans =new int[max-min+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,Math.abs(min)));
        while(q.size()>0){
            int k =q.size();
            while(k-->0){
                Pair t =q.remove();
                if(ans[t.lev]==0){
                    ans[t.lev]=t.num.data;
                }
                if(t.num.left!=null){
                    q.add(new Pair(t.num.left,t.lev-1));
                }
                if(t.num.right!=null){
                    q.add(new Pair(t.num.right,t.lev+1));
                }
            }
        }
         ArrayList<Integer> a = new ArrayList<>();
         for(int y : ans){
             a.add(y);
         }
        
        return a;
         
        
    }
    public  void recurse(Node root,int l){
        if(root==null){
            return ;
        }
        max=Math.max(l,max);
        min=Math.min(min,l);
        
        recurse(root.left,l-1);
        recurse(root.right,l+1);
        return ;
    }
}
class Pair{
    Node num;
    int lev;
    Pair(Node n , int l){
        num=n;
        lev=l;
    }
}