package servidor.dao;

import java.util.List;

public interface Idao {

    public List buscarUsuarios(String pais, String afiliacion);
    public List buscarEquipos(String pais, String afiliacion);
    public List buscarProyectos(String pais, String afiliacion);
    public List buscarCommits(String pais, String afiliacion);
    public <T> boolean guardar(List<T> objeto);


}
