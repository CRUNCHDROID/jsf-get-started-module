
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Calendar now = GregorianCalendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(new GregorianCalendar(1985, 2, 20).getTime());
        
        System.out.println("" + (now.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)));
        
    }
    
}
