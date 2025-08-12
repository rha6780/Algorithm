import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int number = sc.nextInt();
        int count = number / 4; 
        String result = "";

        for(int i=0; i< count; i++) {
            result += "long ";
        }
        System.out.println(result+"int");
	}

}