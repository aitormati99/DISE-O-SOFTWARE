package servidor.gateway;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import servidorExterno.GithubRestClient;

import javax.ws.rs.core.Response;


public class Gateway implements IGateway{

    /**
     private Object HashMap;
     private Object String;
     */
    public JSONArray extraerArrayJson(String accessPoint){

        JSONArray array = null;
        try {
            GithubRestClient c1 = new GithubRestClient(accessPoint);
            Response res1 = c1.makeGetRequest("");

            // Parse the response as JsonArray
            array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());
            /** ArrayList<HashMap<String,Object>> info = new ArrayList<>();
             array = res1.readEntity(JSONArray.class);
             System.out.println(array.size());
             for(int i=0; i<array.size(); ++i)
             {
             info.add(HashMap<String, Object>) array.get(i);
             }
             */

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }

		return array;
        /**return info */
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
