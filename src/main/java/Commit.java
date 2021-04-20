import java.util.List;
import java.util.ArrayList;


import javax.jdo.annotations.*;

@PersistenceCapable
public class Commit {

    @PrimaryKey
    private int id_commit;
    private int addition_lines;
    private int deletion_lines;

    @Column(name="USER_ID")
    Usuario user = new Usuario();


    public Commit(int id_commit, int addition_lines, int deletion_lines)
    {
        this.id_commit=id_commit;
        this.addition_lines=addition_lines;
        this.deletion_lines=deletion_lines;

    }


    //metodos varios y get y set

    public int getId_commit()
    {
        return id_commit;
    }

    public void setIdcommit(int id_commit)
    {
        this.id_commit = id_commit;
    }
    public int getAdditionlines()
    {
        return addition_lines;
    }

    public void setAdditionlines(int addition_lines)
    {
        this.addition_lines = addition_lines;
    }

    public int getDeletionlines()
    {
        return deletion_lines;
    }

    public void setDeletionlines(int deletion_lines)
    {
        this.deletion_lines = deletion_lines;
    }

}