package ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Nyu on 03/07/2015.
 */
@Path("/sendEmail")
public class SendEmail {

    @GET
    public void getSomeBeans() {
        System.out.println("Email sent");
    }
}
