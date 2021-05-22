package servidor.ld;
import java.util.List;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import javax.jdo.annotations.*;

@Data
//@Getter @Setter
@PersistenceCapable
public class Commit {

    @PrimaryKey
    private String id_commit;
    private int addition_lines;
    private int deletion_lines;

    @Column(name="USER_ID")
    Usuario user = new Usuario();

    @Column(name="PROJECT_ID")
    Proyecto project = new Proyecto();


    public Commit(String id_commit, int addition_lines, int deletion_lines)
    {
        this.id_commit=id_commit;
        this.addition_lines=addition_lines;
        this.deletion_lines=deletion_lines;

    }
    public Commit(){

    }



    public Usuario getUser()
    {
        return this.user;
    }

    public void setUser (Usuario usuario)
    {
        this.user =usuario;
    }

    public Proyecto getPro()
    {
        return this.project;
    }

    public void setPro (Proyecto pro)
    {
        this.project=pro;
    }

    
    //metodos getters y setters que ya no necesitamos
    /*
    public void setIdcommit(int id_commit)
    {
        this.id_commit = id_commit;
    }

    public int getId_commit()
    {
        return id_commit;
    }

    public int getAdditionlines()
    {
        return addition_lines;
    }

    public int getDeletionlines()
    {
        return deletion_lines;
    }

    public void setAdditionlines(int addition_lines)
    {
        this.addition_lines = addition_lines;
    }

    public void setDeletionlines(int deletion_lines)
    {
        this.deletion_lines = deletion_lines;
    }

    */
}
