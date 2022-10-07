import java.util.*;
public class Main {

	public static char[] num=new char[1200];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s="";
		while(true){
			s=sc.next();
			if(s.equals("0")) {break;}
			num=s.toCharArray();
			int result=0; int dump=0;
	
			for(int i=0; i<num.length; i++){
				result+=(int)(num[i]-'0');
			}
			while(true){
				if(result>=10){
					dump=result;result=0;
					while(true){
						result+=dump/10;
						dump%=10;	
						if(dump<10){result+=dump; break;}
					}
				}
				else{
					System.out.println(result); break;
				}
			}
			
		}
		

	}

}
