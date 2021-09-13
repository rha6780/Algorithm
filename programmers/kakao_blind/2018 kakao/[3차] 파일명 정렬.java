import java.util.*;
import java.io.*;
class name implements Comparable<name>{
    String h, n, t;
    public name(String h, String n, String t){
        this.h=h; this.n=n; this.t=t;
    }
    @Override
    public int compareTo(name o){
        String h1=this.h.toUpperCase();
        String h2=o.h.toUpperCase();
        int res=h1.compareTo(h2);
        if(res==0){
            int a=Integer.parseInt(this.n);
            int b=Integer.parseInt(o.n);
            return a-b;
        }
        else{return res;}
    }
}
class Solution {
    public ArrayList<name> arr=new ArrayList<name>();
    public String[] solution(String[] files) {
        String[] answer = {};
        int len=files.length;
        for(int i=0; i<len; i++){
            char[] names=files[i].toCharArray();
            int ind=0; String tmp="";
            String h="", n="", t="";
            for(int j=0; j<names.length; j++){
                if(names[j]>='0'&&names[j]<='9'&&(ind==0||ind==1)){
                    if(ind==0){ind=1;}
                    n+=names[j];
                }
                else{
                    if(ind==0){
                        h+=names[j];
                    }
                    else{ind=2; t+=names[j];}
                }
            }
            System.out.println(h+" "+n+" "+t);
            arr.add(new name(h,n,t));
        }
        Collections.sort(arr);
        answer=new String[len];
        for(int i=0; i<len; i++){
            name e=arr.get(i);
            System.out.println(e.h+e.n+e.t);
            answer[i]=""+e.h+e.n+e.t;
        }
        return answer;
    }
}