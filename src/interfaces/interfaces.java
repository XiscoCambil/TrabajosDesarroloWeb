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
}

class Alumne extends Persona{

}

class Docent extends Persona implements Traballador{


    @Override
    public void pagaAlTreballador(Traballador treballador) {

    }
}

class Estudiant extends Alumne{

}

class Becari extends Alumne implements Traballador{

    @Override
    public void pagaAlTreballador(Traballador treballador) {

    }
}

class Primaria extends Docent{

}

class Secundaria extends Docent{

}

