
class Solution {
    static boolean sosu(long a) {
        boolean issosu=true;
        if(a==1||a==0){return false;}
        else if(a==2&&a==3){return true;}
        else {
            for(int i=2; i<=(int)Math.sqrt(a); i++) {
                if(a%i==0) {
                    issosu=false;
                    //System.out.println("isnotsosu "+a);
                    break;
                }
            }
            return issosu;
        }
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        long nn = n;
        String numarr = "";
        while(nn>=k) {
            if(nn>=0&&nn<k){
                 break;
            }
            else {
                long rest = nn%(long)k;
                if(k!=0&&nn!=0) {
                    nn=(long)(nn/k);
                    
                }
                numarr = rest+""+numarr;
                if(rest == 0){
                    if(sosu(Long.parseLong(numarr))) {
                        answer++;
                    }
                    numarr = "";
                }
            }
        }
        numarr=nn+""+numarr;
        if(!numarr.equals("")){
            if(sosu(Long.parseLong(numarr))) {
                    System.out.println(numarr);
                    answer++;
            }
        }

        return answer;
    }
}
