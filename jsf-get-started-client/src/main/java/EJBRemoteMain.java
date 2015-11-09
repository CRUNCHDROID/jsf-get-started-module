
import com.crunchdroid.entities.Person;
import com.crunchdroid.services.impl.IPersonServiceImp;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
public class EJBRemoteMain {

    private static String personServiceName = "";
    public static void main(String[] args) throws NamingException {

        InitialContext context = new InitialContext();
        IPersonServiceImp personService = (IPersonServiceImp) context.lookup(personServiceName);
        Person p = new Person();
        p.setFirstname("Firstname Remote");
        p.setLastname("Lastname Remote");
        p.setAge(20);
        personService.save(p);
    }

}
