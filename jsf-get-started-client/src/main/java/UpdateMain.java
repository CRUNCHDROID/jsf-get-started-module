
import com.crunchdroid.beans.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@outlook.com>
 */
public class UpdateMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Entrer un id : ");

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/jsf-get-started-web/api/person");
        Person p = webResource.path(input.nextLine()).accept(MediaType.APPLICATION_XML).get(Person.class);
        System.out.println(p);

        System.out.println("Entrer un age (" + p.getAge() +  ") : ");
        p.setAge(input.nextInt());

        System.out.println(p);

        webResource.accept(MediaType.APPLICATION_XML).put(p);

    }

}
