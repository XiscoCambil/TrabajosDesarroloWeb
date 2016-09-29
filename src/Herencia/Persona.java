package Herencia;

/**
 * Created by blackwidow on 29/09/16.
 */
public class Persona {
    private String nom;
    private String adreça;
    private int edad;
    private String DocumentoIdentidad;
}

class Alumne extends Persona{
    private String dataAlta;

}

class Personal extends Persona{
    private String numSS;


}

class Intercanvi extends Alumne{
    private String paisOrigen;
}

class Professor extends Personal{
    private String titulacio;
    private String especialitat;

}

class PersonalGestio extends Personal{
    private String posicio;

}
