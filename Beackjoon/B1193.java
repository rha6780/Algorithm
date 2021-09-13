import java.util.*;
import java.io.*;
public class B1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int count=1;
		while(true) {
			if(N>count) {
				N-=count;
				count++;
			}
			else {
				break;
			}
		}
		int mo=0;
		if(count%2==0) {
			mo=N;
		}
		else {mo=(count+1)-N;}
		int so=count+1-mo;
		System.out.println(mo+"/"+so);

	}

}
