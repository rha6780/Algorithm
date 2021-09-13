class Solution {
  public int solution(String str1, String str2) {
      int a=0;
      char[] st=new char[1002];
      char[] st11=new char[1002];
      char[][] st2=new char[1002][2];
      char[][] st1=new char[1002][2];
      int s1count=0, s2count=0;
      
      st11=str1.toCharArray();
      int j=0;
      for(int i=0; i<str1.length()-1; i++){
          if((('a'<=st11[i]&&st11[i]<='z')||('A'<=st11[i]&&st11[i]<='Z'))&&(('a'<=st11[i+1]&&st11[i+1]<='z')||('A'<=st11[i+1]&&st11[i+1]<='Z'))){
              st1[j][0]=st11[i];
              st1[j][1]=st11[i+1];
              s1count++;
              System.out.println(st1[j] );
              j++;
          }
      }
     
      st=str2.toCharArray();
      j=0;
      for(int i=0; i<str2.length()-1; i++){
          if((('a'<=st[i]&&st[i]<='z')||('A'<=st[i]&&st[i]<='Z'))&&(('a'<=st[i+1]&&st[i+1]<='z')||('A'<=st[i+1]&&st[i+1]<='Z'))){
              st2[j][0]=st[i];
              st2[j][1]=st[i+1];
              s2count++;
              System.out.println(st2[j]);
              j++;
  
          } 
      }
      for(int i=0; i<s1count; i++){
          for(int k=0; k<s2count; k++){
               if((((st1[i][0]-st2[k][0]==32)||(st2[k][0]-st1[i][0]==32)||(st1[i][0]==st2[k][0])))&&((st1[i][1]-st2[k][1]==32)||(st2[k][1]-st1[i][1]==32)||(st1[i][1]==st2[k][1]))){a++; st2[k][0]=' ';st2[k][1]=' '; System.out.println(i+" "); break;}
          }
      }
    
      if((s1count==0&&s2count==0)||(s1count+s2count-a==a)){a=65536;}
      else if(s1count==0||a==0||s2count==0) a=0;
      else{ int g=(s1count+s2count-a); a*=65536; a/=g; }
      
      System.out.println(a);
      int answer = a;
      return answer;
  }
}