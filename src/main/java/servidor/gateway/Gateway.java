package servidor.gateway;


import servidor.ld.Usuario;
import servidor.ld.Commit;
import servidor.ld.Equipo;
import servidor.ld.Proyecto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Gateway implements IGateway{

    private final String url = "https://api.github.com";
    private Client client;
    private WebTarget webTarget;

    public Gateway(String accessPoint)
    {
        client = ClientBuilder.newClient();
        webTarget = client.target(String.format(this.url + "/" + accessPoint ));
    }

    public Response makeGetRequest(String query) throws Exception
    {
        WebTarget getRequestController = this.webTarget.path(query);
        Invocation.Builder invocationBuilder = getRequestController.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        if (response.getStatus() == Status.OK.getStatusCode())
        {
            return response;
        }
        else
        {
            throw new Exception("BadAss error");
        }
    }


    public void extraer(){

        // Example 1 -> List all users (one call retrieves 100 maximum)
        // https://docs.github.com/en/rest/reference/users#list-users

        try {
            Gateway c1 = new Gateway("users");
            Response res1 = c1.makeGetRequest("");

            // Print the response, as it is
            System.out.println(res1);

            // Print the response as String
            // System.out.println(res1.readEntity(String.class));

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
            System.out.println(array.size());

            HashMap<String, String> object1 = (HashMap<String, String>)array.get(0);
            System.out.println(object1);
            System.out.println(object1.get("login"));

            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }



		/*



		RestClient c2 = new RestClient(hostname, port);
		RestClient c3 = new RestClient(hostname, port);
		RestClient c4 = new RestClient(hostname, port);

			c1.makeGetRequest();
			c1.makePostRequest("This is a client super complex message to send to server");

		}


	*/

    }
}
