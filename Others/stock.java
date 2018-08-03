import java.util.Stack;

public class stock {
public static void main(String args[]){
    int arr[]={60, 70, 80, 100, 90, 75, 80, 120};
    int ans[]=stockSpan(arr);
    for(int i=0;i<ans.length;i++){
        System.out.println(ans[i]);
    }
}
    public static int[] stockSpan(int[] price) {
        Stack<Integer> st= new Stack<>();
        int ans[]=new int[price.length];
        ans[0]=1;
        st.push(0);
        for(int i=1;i<price.length;i++){
            while(!st.isEmpty() && price[st.peek()]<price[i])
                st.pop();
            if(st.isEmpty()){
                ans[i]=i+1;
            }else{
                ans[i]=i-st.peek();
            }
           st.push(i);
        }
        return ans;
    }
}
