import java.util.*;
import java.io.*;
	
public class Main {

	static int[] memo = new int[32];
	
	static int BtoN(String s) {
		int num = 0;
		for(int i=0; i<s.length(); i++) {
			num = num*2+(s.charAt(i)-'0');
		}
		return num;
	}
	static String NtoB(int N) {
		StringBuilder sb = new StringBuilder();
		int in=0;
		while(N>0) {
			sb.append(N%2);
			N/=2;
			in++;
		}
		for(int i=in; i<8; i++) {
			sb.append(0);
		}
		sb.reverse();
		return sb.toString();
	}
	
	static int cal() {
		int pc =0; int ac =0;
		while(true) {
			int code = memo[pc]/32; 
			int addr = memo[pc]%32;
			switch(code) {
			case 0 : 
				memo[addr] =ac;
				pc = (pc+1)%32;
				break;
			case 1 : 
				ac = memo[addr];
				pc = (pc+1)%32; 
				break;
			case 2 :
				if(ac == 0) {
					pc = addr;
				}
				else {
					pc = (pc+1)%32;
				}
				break;
			case 3:
				pc = (pc+1)%32; 
				break;
			case 4:
				ac = (ac+255)%256;
				pc = (pc+1)%32;
				break;
			case 5:
				ac = (ac+1)%256;
				pc = (pc+1)%32;
				break;
			case 6:
				pc = addr; break;
			case 7 :
				return ac;

			
			}
			//System.out.println(pc+" "+ac);
		}
	
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			
			for(int i=0; i<32; i++) {
				String s =sc.nextLine();
				memo[i] = BtoN(s);
			}
			int result = cal();
			System.out.println(NtoB(result));
			
		}

	}

}
