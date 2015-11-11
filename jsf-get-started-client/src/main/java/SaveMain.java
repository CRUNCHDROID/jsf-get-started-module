
import com.crunchdroid.beans.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@outlook.com>
 */
public class SaveMain {

    public static void main(String[] args) {
        
        Person p = new Person();
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Entrer un prenom : ");
            p.setFirstname(input.nextLine());
            System.out.println("Entrer un nom :");
            p.setLastname(input.nextLine());
            System.out.println("Entrer un age : ");
            p.setAge(input.nextInt());
            System.out.println(p);
        }
        
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/jsf-get-started-web/api/person");
        webResource.accept(MediaType.APPLICATION_XML)
                    .post(p);

    }

}
