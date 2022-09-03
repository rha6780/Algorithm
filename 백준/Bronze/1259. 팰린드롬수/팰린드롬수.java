import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true){
			int a=sc.nextInt();
			if(a==0){break;}
			else{
				int[] num=new int[6];
				int count=0;
				while(true){
					int rest=a%10;
					num[count]=rest;
					count++; a/=10;
					if(a==0){break;}
				}
			
				if(count%2==1){
					boolean isf=true;
					for(int i=0; i<=count/2-1; i++){
						if(num[i]!=num[count-i-1]){isf=false;}
					}
					if(isf){System.out.println("yes");}
					else{System.out.println("no");}
				}
				else{
					boolean isf=true;
					for(int i=0; i<=count/2-1; i++){
						if(num[i]!=num[count-i-1]){isf=false;}
					}
					if(isf){System.out.println("yes");}
					else{System.out.println("no");}
				}
			}
		}

	}

}
