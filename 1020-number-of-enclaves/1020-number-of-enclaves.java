class Solution {
    public int numEnclaves(int[][] grid) {
        
    for(int i=0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            if(i==0 || j==0 ||( i==grid.length-1 )|| (j==grid[0].length-1)){
                if(grid[i][j]==1){
                     dfs(grid,i,j);
                }
               
            }
        }
    }
        
        int result =0;
         for(int i=0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            
                if(grid[i][j]==1){
                     result++;
                }
               
            
        }
    }
      
        return result ;
    }
    
    public void dfs(int[][] grid , int i , int j ){
        if(i<0|| j<0 || i>=grid.length||j>=grid[0].length|| grid[i][j]==0 ||grid[i][j]==2){
            return ;
        }
        
        grid[i][j] =2;
        
        
        
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return; 
        
    }
}