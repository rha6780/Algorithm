public class Main {

		public static boolean Check(int n) {
			int x=0, y=0, z=0;
			for(x=0; x<10; x++) {
				int r=n-1001*x;
				if(r<0) break;
				if(r>1026) continue;
				for(y=0; y<10;y++) {
					int u=r-101*y;
					if(u<0)break;
					if(u>117)continue;
					for(z=0; z<10; z++) {
						int t=u-11*z;
						if(t<0) break;
						if(t>18) continue;
						if(t%2==0) return false;
					}
				}
			}
			return true;
		}
	
	public static void main(String[] args) {
		for(int i=1; i<=10000; i++) {
			if(Check(i)==true)System.out.println(i);
		}
	}
}