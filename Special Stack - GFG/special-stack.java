//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    Stack<Integer> helper=new Stack<>();
    int min =0;
    
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(helper.size()==0){
	        min=a;
	        helper.add(a);
	        s.add(a);
	    }else if(a>min){
	        
	        s.add(a);
	        
	    }else{
	        min=a;
	        helper.add(min);
	        s.add(a);
	    }
	    
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            int y =s.pop();
            if(y==min){
                helper.pop();
            }
         return y;
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return helper.peek();
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size()==n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.size()==0;
	}
}