
import com.crunchdroid.beans.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;




/**
 *
 * @author Riad YOUSFI <riad.yousfi@outlook.com>
 */
public class FindAllMain {


    public static void main(String[] args) {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/jsf-get-started-web/api/person");
        List<Person> poeple = webResource.accept(MediaType.APPLICATION_XML).get(new GenericType<List<Person>>(){});
        
        for (Person p : poeple) {
            System.out.println(p);
        }
        
        
        
    }
    
}
