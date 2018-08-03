

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Scanner;

public class LCS {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> sample=longestSubsequence(arr);
        System.out.println(sample.size());
    }
    public static ArrayList<Integer> longestSubsequence(int[] arr){
        HashSet<Integer> has=new HashSet<>();
        int count=0;
        int start=0;
        for(int i=0;i<arr.length;i++){
            has.add(arr[i]);
        }
      for(int i=0;i<arr.length;i++){
            if(!has.contains(arr[i]-1)){
               int temp_count=1;
                int temp=arr[i];
                temp++;
                while(has.contains(temp)){
                    temp_count++;
                    temp++;
                }
                if(temp_count>count)
                {
                    count=temp_count;
                    start=temp;
                }
            }

      }
      ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<count;i++){
            arrayList.add(start);
            start++;
        }
        return arrayList;
    }
}
