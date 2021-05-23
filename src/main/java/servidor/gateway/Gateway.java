package servidor.gateway;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import servidorExterno.GithubRestClient;

import javax.ws.rs.core.Response;


public class Gateway implements IGateway{

    public JSONArray extraerArrayJson(String accessPoint){

        JSONArray array = null;
        try {
            GithubRestClient c1 = new GithubRestClient(accessPoint);
            Response res1 = c1.makeGetRequest("");

            // Parse the response as JsonArray
            array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }

		return array;
    }

    public JSONObject extraerJsonObject(String accessPoint){

        JSONObject object=null;
        try {

            GithubRestClient c1 = new GithubRestClient("users");
            Response res1 = c1.makeGetRequest("");

            // Parse the response as JsonObject
            object = res1.readEntity(JSONObject.class);

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }

        return object;
    }

}
