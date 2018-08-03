public class RatInMaze {
    public static void ratInAMaze(int maze[][]){
     int sol[][]=new int[maze.length][maze[0].length];

     helper(maze,0,0,sol);
    }

    private static void helper(int[][] maze, int i, int i1,int sol[][]) {
     if(i==maze.length-1 && i1==maze[0].length-1)
     {
         sol[i][i1]=1;
         for(int p=0;p<sol.length;p++){
             for(int j=0;j<sol[0].length;j++){
                 System.out.print(sol[p][j]+" ");
             }

         }
         System.out.println();
         return;
     }
      if(i<maze.length && i>=0 && i1<maze[0].length && i1>=0 && maze[i][i1]==1 && sol[i][i1]!=1){
         sol[i][i1]=1;
         helper(maze,i-1,i1,sol);
         helper(maze,i+1,i1,sol);
         helper(maze,i,i1-1,sol);
         helper(maze,i,i1+1,sol);
         sol[i][i1]=0;
      }
    }
    public static void main(String args[]){
        int arr[][]={{1,0,1},{1,0,1},{1,1,1}};

        ratInAMaze(arr);
    }
}
