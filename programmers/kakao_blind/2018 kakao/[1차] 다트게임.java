class Solution {
  public int solution(String dartResult) {
      int answer = 0;
      int coin=0;
      int[] process=new int[10];
      char[] score=new char[10];
      String str=dartResult;
      String resu="";
      score=str.toCharArray();
      for(int i=0; i<score.length; i++){
          if(i!=0&&score[i]=='S'){ int a=Integer.parseInt(resu); coin=a; process[i]=coin; resu=""; }
          else if(i!=0&&score[i]=='D'){ int a=Integer.parseInt(resu); coin=(a*a);process[i]=coin; resu=""; }
          else if(i!=0&&score[i]=='T'){ int a=Integer.parseInt(resu); coin=(a*a*a); process[i]=coin; resu="";  }
          else if(i!=0&&score[i]=='*'){ coin*=2; process[i]=coin; answer+=coin; if(i>=3){answer+=process[i-3];}  coin=0; resu="";}
          else if(i!=0&&score[i]=='#'){ coin*=-1; process[i]=coin;resu="";}
          else {  answer+=coin;   coin=0;  resu+=score[i];}
          
         
      }
      answer+=coin;
      return answer;
  }
}