public class ReturnParentheses {
    static String[] strings=new String[0];
    public static String[] findParenthesis(int n){
     helper(n,n,n,"");
        return strings;
    }

    private static void helper(int n, int n1, int n2,String path) {
        if(n1==0 && n2==0){
            String arr[]=new String[strings.length+1];
            int i=0;
            for(i=0;i<strings.length;i++){
                arr[i]=strings[i];
            }
//            System.out.println(path);
            arr[i]=path;
            strings=arr;
            return;
        }
        if(n1>0){
            helper(n,n1-1,n2,path+"(");
        }
        if(n1!=n && n2>n1){
            helper(n,n1,n2-1,path+")");
        }
    }
    public static void main(String args[]){
        String ans[]=findParenthesis(3);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
