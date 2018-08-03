public class SubsetSumK {
    public static void main(String args[]){
       int arr[]={ 5 ,12 ,3 ,17 ,1 ,18 ,15 ,3 ,17};

        int ans[][]=subsetsSumK(arr,6);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
        }
    }
    public static int[][] subsetsSumK(int input[], int k) {
     return helper(input,k,0);
    }

    private static int[][] helper(int[] input, int k, int i) {
       if(i==input.length){
           if(k==0){
               return new int[1][0];
           }
           return new int[0][0];
       }

        int small1[][]=helper(input,k-input[i],i+1);
        int small2[][]=helper(input,k,i+1);
        int myans[][]=new int[small1.length+small2.length][];
        int j=0;
        for(int m=0;m<small1.length;m++){
            myans[j]=new int[small1[m].length+1];
            int puthere=0;
            myans[j][puthere]=input[i];
            puthere++;
            for(int n=0;n<small1[m].length;n++){
                myans[j][puthere]=small1[m][n];
                puthere++;
            }
            j++;
        }
        for(int m=0;m<small2.length;m++){
            myans[j]=new int[small2[m].length];
//            int puthere=0;
            myans[j]=small2[m];
//            puthere++;
//            for(int n=0;n<small2[m].length;n++){
//                myans[j][puthere]=small2[m][n];
//                puthere++;
//            }
            j++;
        }
        return myans;

    }
}
