package servidor.dao;

import java.util.List;

public interface Idao {

    public List buscar(String pais, String afiliacion);
    public boolean guardar();
}
