//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node t =reverse(head);
        Node u =t;
        Node prev =t;
        int carry=0;
        int i=0;
        while(u!=null || carry>0){
            int digit =0;
            int ans=0;
           
            if(u==null && carry>0){
                Node s =new Node(carry);
                prev.next=s;
                return reverse(t);
            }
             prev=u;
            if(i==0){
                i++;
                digit=1+u.data+carry;
                carry=digit/10;
                ans=digit%10;
                u.data=ans;
                u=u.next;
                
            }else{
                digit=u.data+carry;
                carry=digit/10;
                ans=digit%10;
                u.data=ans;
                u=u.next;
            }
            
            
            
            
        }
        
        return reverse(t);
    }
    public static Node reverse(Node node)
    {
        
        if(node==null || node.next==null){
            return node;
        }
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
