import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.Extension;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Element;

@PersistenceCapable
public class Equipo {

    @PrimaryKey
    private int id_equipo;
    private Date fecha_ini;

    @Element(column="EQUIPO_ID")
    List <Proyecto> proyectos=new ArrayList<>();

    @Persistent(table="USUARIOS-EQUIPOS")
    @Join(column="EQUPO_ID")
    @Element(column="USUARIO_ID")
    @Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="id ASC"))
    List<Usuario> usuarios=new ArrayList<>();

    public Equipo(int id_equipo, Date fecha_ini)
    {
        this.id_equipo = id_equipo;
        this.fecha_ini=fecha_ini;

    }


    //metodos varios y get y set
    //nose si insert, delete, update y select aqui o en el main

    public int getIdEquipo()
    {
        return id_equipo;
    }

    public void setIdEquipo(int id_equipo)
    {
        this.id_equipo = id_equipo;
    }

    public void addPro (Proyecto pro)
    {
        proyectos.add(pro);
    }

    public void removePro(Proyecto pro)
    {
        proyectos.remove(pro);
    }

    public Collection<Proyecto> getPros()
    {
        return proyectos;
    }

    public int getNumberOfProyectos()
    {
        return proyectos.size();
    }


    public void addUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }

    public void removeUsuario(Usuario usuario)
    {
        usuarios.remove(usuario);
    }

    public List<Usuario> getUsuarios()
    {
        return usuarios;
    }

    public int getNumberOfUsuarios()
    {
        return usuarios.size();
    }

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

}