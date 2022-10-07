import java.util.Scanner;
public class Main {

	public static void save(int h, int w, int p) {
		int nb=0, nf=0;
		for(int i=1; i<=p; i++) {
			nf=(i%h);
			nb=(i/h)+1;
			if(nf==0) { nf=h; nb--;}
			
		}
		if(nb<10)
		System.out.println(nf+"0"+nb);
		else System.out.println(nf+""+nb);
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int rp=0, rh=0, rw=0;
		for(int i=0; i<N; i++) {
			rh=sc.nextInt();
			rw=sc.nextInt();
			rp=sc.nextInt();
			save(rh, rw, rp);
			
		}
		sc.close();
	}

}
