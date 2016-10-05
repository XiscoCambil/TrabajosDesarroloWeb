package interfaces2;

/**
 * Created by blackwidow on 5/10/16.
 */
public class interfazMain {
    public static void main(String[] args) {
        Estudiant estudiant = new Estudiant();
        EstudiandteDAO cu = new MockEstudiant();
        cu.addStudent(estudiant);
    }
}

class Estudiant{


}


interface EstudiandteDAO {

    Estudiant getStudent(Estudiant estudiant);

    void removeStudent(Estudiant estudiant);

    void addStudent(Estudiant estudiant);

    void contractStudent(Estudiant estudiant);

}

class MockEstudiant implements EstudiandteDAO{

    @Override
    public Estudiant getStudent(Estudiant estudiant) {
        return null;
    }

    @Override
    public void removeStudent(Estudiant estudiant) {

    }

    @Override
    public void addStudent(Estudiant estudiant) {

    }

    @Override
    public void contractStudent(Estudiant estudiant) {

    }
}



