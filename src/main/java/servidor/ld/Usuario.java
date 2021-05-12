package servidor.ld;

import servidor.ld.Equipo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.Extension;

@PersistenceCapable
public class Usuario {

    @PrimaryKey
    private String user_name;
    private String afiliacion;
    private String pais;
    private String email;

    @Persistent(mappedBy="user")
    @Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="id_commit ASC"))
    List <Commit> commits =new ArrayList<>();

    @Persistent
    @Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="id_equipo ASC"))
    List<Equipo> equipos=new ArrayList<>();


    public Usuario(String user_name, String afiliacion, String pais, String email)
    {
        this.user_name=user_name;
        this.afiliacion=afiliacion;
        this.pais=pais;
        this.email=email;

    }

    public Usuario() {

    }

    //metodos varios y get y set
    //nose si insert, delete, update y select aqui o en el main

    public String getUserName()
    {
        return user_name;
    }

    public void setUserName(String user_name)
    {
        this.user_name = user_name;
    }

    public String getAfiliacion()
    {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion)
    {
        this.afiliacion = afiliacion;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void addCommit(Commit commit)
    {
        commits.add(commit);
    }

    public void removeCommit(Commit commit)
    {
        commits.remove(commit);
    }

    public Collection<Commit> getCommits()
    {
        return commits;
    }

    public int getNumberOfCommits()
    {
        return commits.size();
    }


    public void addEquipo(Equipo equipo)
    {
        equipos.add(equipo);
    }

    public void removeEquipo(Equipo equipo)
    {
        equipos.remove(equipo);
    }

    public void removeEquipos()
    {
        equipos.removeAll(this.equipos);
    }

    public List<Equipo> getEquipos()
    {
        return equipos;
    }

    public int getNumberOfEquipos()
    {
        return equipos.size();
    }
}