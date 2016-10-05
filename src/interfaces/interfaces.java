package interfaces;



/**
 * Created by blackwidow on 4/10/16.
 */
public class interfaces {
}

class Persona{

}

interface Traballador {
     void pagaAlTreballador(Traballador treballador);
     String ggCCC();
}

class Alumne extends Persona{

}

class Docent extends Persona implements Traballador{

    private String ccc;

    @Override
    public void pagaAlTreballador(Traballador treballador) {

    }

    @Override
    public String ggCCC() {
        return null;
    }
}

class Estudiant extends Alumne{

}

class Becari extends Alumne implements Traballador{

    @Override
    public void pagaAlTreballador(Traballador treballador) {

    }

    @Override
    public String ggCCC() {
        return null;
    }
}

class Primaria extends Docent{

}

class Secundaria extends Docent{

}

