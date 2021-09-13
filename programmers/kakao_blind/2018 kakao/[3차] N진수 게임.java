class Solution {
    public String[] code={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String rever(int n, int num){
        String nn="";
        int ns=num;
        if(ns==0){nn="0";}
        else{
        while(!(ns%n==0&&ns/n==0)){
            if(ns%n<9){nn=(ns%n)+""+nn;}
            else{nn=code[(ns%n)]+""+nn;}
            ns/=n;
        }}
        
        return nn;
    }
    public String solution(int n, int t, int m, int p) {
    String answer = "";
    int count=0;
    int numcount=1;
    int num=0;
    while(count<t){
        int temp=num;
        String r=rever(n, temp);
        for(int i=0; i<r.length(); i++){
            if(numcount==p){
                answer+=""+r.charAt(i);
                numcount++;
                count++;
            }
            else{numcount++;}
            if(numcount>m){numcount=1;}
        }
        num++;
    }
    String result="";
    for(int i=0; i<t; i++){
        result+=answer.charAt(i);
    }
    return result;
    }
}