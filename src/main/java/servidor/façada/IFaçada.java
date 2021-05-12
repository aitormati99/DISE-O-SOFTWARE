package servidor.façada;

import servidor.appService.AppService;

public interface IFaçada {

    public AppService buscar(String pais, String afiliacion);
}
