class Solution {
    public int solution(String s) {
        int answer = 0;
        int min=s.length();
        for(int len=1; len<=s.length()/2; len++){
            int count=0;
            String sum="";
            String tmp="";
        for(int i=0; i<s.length(); i+=len){
            String a="";
            for(int j=0; j<len&&i+j<s.length(); j++){
               a+=""+s.charAt(i+j);
            }
            //System.out.println("이전값: "+tmp+"현재값: "+a);

            
            if(i+len>=s.length()){
                //System.out.println(s.length()-len);
                if(tmp.equals(a)){count++;sum+=(""+(count+1))+tmp;count=0;}
                else{
                    if(count!=0){sum+=(""+(count+1))+tmp+a;count=0;}
                    else{sum+=tmp+a;}
                }
            }
            else {
                if(tmp.equals(a)&&i+len<s.length()){count++;}
                else{
                    if(count!=0){sum+=(""+(count+1))+tmp;count=0;}
                    else{sum+=tmp;}
                }
            }
            tmp=a;
            
        }
            //System.out.println("붙인값: "+sum+" "+sum.length());
            if(min>sum.length()){min=sum.length();}
        }
        answer=min;
        return answer;
    }
}