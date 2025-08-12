import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<String>();
		int number = sc.nextInt();

        
        for (int i=0; i< number; i++) {
            String name = sc.next();
            String action = sc.next();
            
            if (action.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, Collections.reverseOrder());
        for (int i=0; i<list.size(); i ++) {
            System.out.println(list.get(i));
        }
        
	}

}
