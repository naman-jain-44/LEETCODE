//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.size()==0){
		    return new Stack<Integer>();
		}
		int y =s.pop();
		Stack<Integer> h =sort(s);
		if(h.size()==0){
		    h.push(y);
		}else{
		    	Stack<Integer> aux = new Stack<>();
		while(h.size()>0 && h.peek()>y){
		    aux.push(h.pop());
		}
		h.push(y);
		while(aux.size()>0){
		    h.push(aux.pop());
		}
		}
	
		
		return h;
	}
}