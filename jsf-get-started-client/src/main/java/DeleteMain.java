
import com.crunchdroid.beans.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@outlook.com>
 */
public class DeleteMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Entrer un id : ");
        String id = input.nextLine();

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/jsf-get-started-web/api/person");
        Person p = webResource.path(id).accept(MediaType.APPLICATION_XML).get(Person.class);
        System.out.println(p);

        System.out.println("Supprimer OUI(o) | NON(n) ");
        String res = input.nextLine();

        if (res.equalsIgnoreCase("o")) {
            webResource.path(id).accept(MediaType.APPLICATION_XML).delete();
        }

    }

}
