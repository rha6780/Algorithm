import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {

	public static void main(String[] args) {
		
		Date da=new Date();
		SimpleDateFormat date=new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(date.format(da));
		

	}

	

}
