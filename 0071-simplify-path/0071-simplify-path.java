class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        
        Stack<String> stack = new Stack<>();
        for(String dir : directories){
            if(dir.equals(".") || dir.length() == 0){   /* for this case length of string will be zero --> // or initial / */
                continue;   
            }
            if(dir.equals("..")){
                if(!stack.isEmpty()){ 
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : stack){
            sb.append("/");
            sb.append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
