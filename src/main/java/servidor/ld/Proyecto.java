package servidor.ld;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable
public class Proyecto {

    @PrimaryKey
    private int id_pro;
    private String nombrepro;
    private Date proy_fecha_ini;
    private Date proy_fecha_fin;


    @Persistent(mappedBy="project")
    @Order(extensions = @Extension(vendorName="datanucleus",key="list-ordering", value="id_commit ASC"))
    List <Commit> commits =new ArrayList<>();


    public Proyecto(int id_pro,String nombrepro,Date proy_fecha_ini, Date proy_fecha_fin)
    {
        this.nombrepro = nombrepro;
        this.id_pro = id_pro;
        this.proy_fecha_fin=proy_fecha_fin;
        this.proy_fecha_ini=proy_fecha_ini;

    }

    public Proyecto() {

    }


    //metodos varios y get y set
    //nose si insert, delete, update y select aqui o en el main

    public int getIdpro()
    {
        return id_pro;
    }

    public void setIdpro(int id_pro)
    {
        this.id_pro = id_pro;
    }

    public String getnombrepro()
    {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro)
    {
        this.nombrepro = nombrepro;
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

    public Date getProy_fecha_ini() {
        return proy_fecha_ini;
    }

    public void setProy_fecha_ini(Date proy_fecha_ini) {
        this.proy_fecha_ini = proy_fecha_ini;
    }

    public Date getProy_fecha_fin() {
        return proy_fecha_fin;
    }

    public void setProy_fecha_fin(Date proy_fecha_fin) {
        this.proy_fecha_fin = proy_fecha_fin;
    }
}