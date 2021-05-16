package servidor.gateway;

import servidor.gateway.Gateway;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public interface IGateway {


    public Response makeGetRequest(String query) throws Exception;
}
