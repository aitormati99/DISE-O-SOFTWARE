package servidor.gateway;

import servidor.gateway.Gateway;

import javax.xml.ws.Response;

public interface IGateway {

    public void extraer();
    public Response makeGetRequest(String query) throws Exception;
}
