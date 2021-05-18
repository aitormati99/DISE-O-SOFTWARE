package servidor.dao;

import java.util.List;

public interface Idao {

    public boolean buscarUsuarios(String pais, String afiliacion);
    public boolean buscarEquipos(String pais, String afiliacion);
    public boolean buscarProyectos(String pais, String afiliacion);
    public boolean buscarCommits(String pais, String afiliacion);
    public <T> boolean guardar(List<T> objeto);


}
