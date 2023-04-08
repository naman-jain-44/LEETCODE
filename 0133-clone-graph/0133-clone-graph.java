/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> nodesM = new HashMap<>();

public Node cloneGraph(Node node) {
    
    if(node == null){
        return node;
    }
    
   return clone(node);
    
}

public Node clone(Node node){
    
    if(nodesM.containsKey(node.val)){
        return nodesM.get(node.val);
    }
    
   
    Node co= new Node(node.val);
    nodesM.put(node.val, co);
    
    for(Node neighbor : node.neighbors){
       
        
        
        co.neighbors.add(clone(neighbor));
    }
    
    return co; 
}
}