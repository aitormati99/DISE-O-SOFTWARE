package servidor.gateway;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import servidor.gateway.Gateway;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.rmi.RemoteException;

public interface IGateway {


    public JSONArray extraerArrayJson(String accessPoint);
    public JSONObject extraerJsonObject(String accessPoint);

}
