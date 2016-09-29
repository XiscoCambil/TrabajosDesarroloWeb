package Herencia;

/**
 * Created by blackwidow on 29/09/16.
 */
public class Persona {
    private String nom;
    private String adreça;
}

class Alumne extends Persona{
    private String dataAlta;
    private int edat;
}

class Personal extends Persona{
    private String numSS;

}

class Estudiant extends Alumne{
    private String nif;
}

class Intercanvi extends Alumne{
    private String paisOrigen;
    private String nie;
}

class Professor extends Personal{
    private String titulacio;
    private String especialitat;

}

class PersonalGestio extends Personal{
    private String posicio;

}
