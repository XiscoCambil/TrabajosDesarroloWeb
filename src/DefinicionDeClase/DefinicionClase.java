package DefinicionDeClase;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by blackwidow on 23/09/16.
 */

public class DefinicionClase {
    public static void main(String[] args) {
        //Generar agenda
        Agenda a = new Agenda(2016);
        int dia = 20;
        int mes = 2;
        //Ir a una pagina en concreto con el dia y el mes para escribir una cita.
        a.VerPagina(dia, mes).EscribirCita("Ir al medico a que me miren un bulto", "12:00", "14:00","Medico");
        a.VerPagina(dia, mes).EscribirCita("Hola mundo, hoy estoy de buen humor", "00:00", "24:00","Humor");
        //Ver las citas que hay dentro de la pagina en concreto.
        a.PaginaActual().VerCitas();
        //Borrar citas
        a.PaginaActual().BorrarCita("Humor");
        a.PaginaActual().VerCitas();
        //Ir a la pagina siguiente y ver las citas.
        a.PaginaSiguiente();
        //Escribir una Cita en la pagina actual
        a.PaginaActual().EscribirCita("prueba", "08:00", "24:00","prueba");
        //Ver citas pagina actual
        a.PaginaActual().VerCitas();
        //Ir a una pagina anterior y ver sus citas.
        a.PaginaAnterior();
        //ir al dia en el que nos encontramos
        a.IrDiaActual();

    }
}

class Agenda {
    private int any;
    private List<Pagina> paginas = new ArrayList<Pagina>();
    private int nPagina = 1;

    //Constructor que genera la agenda.
    public Agenda(int any) {
        this.any = any;
        GregorianCalendar calendario = new GregorianCalendar();
        int dia = 1;
        for (int i = 1, mes = 1; i < 366; i++) {
            if ((mes == 7 || mes == 8) && dia == 32) {
                dia = 1;
                mes++;
            } else if (mes > 8 && dia >= 31) {
                if (mes % 2 != 0 && dia == 31) {
                    dia = 1;
                    mes++;
                } else if (mes % 2 == 0 && dia == 32) {
                    dia = 1;
                    mes++;
                }
            } else if (mes % 2 != 0 && dia == 32) {
                dia = 1;
                mes++;
            } else if (mes % 2 == 0 && dia == 31) {
                dia = 1;
                mes++;
            } else if (mes == 2 && dia == 29) {
                if (!calendario.isLeapYear(this.any)) {
                    dia = 1;
                    mes++;
                } else {
                    Pagina p2 = new Pagina(i + 1, dia, mes, false);
                    paginas.add(p2);
                    dia = 1;
                    mes++;
                    continue;
                }
            }
            Pagina p = new Pagina(i, dia, mes, false);
            paginas.add(p);
            dia++;
        }
    }

    public int getnPagina() {
        return nPagina;
    }

    public void setnPagina(int nPagina) {
        this.nPagina = nPagina;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    //Ver pagina filtrada por dia y mes
    public Pagina VerPagina(int dia, int mes) {
        return paginas.get(EncontrarPaginaDia(dia, mes));
    }

    //Metodo utilizado para encontrar el numero de pagina en relacion al dia y mes
    private int EncontrarPaginaDia(int dia, int mes) {
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getDia() == dia && paginas.get(i).getMes() == mes) {
                this.nPagina = paginas.get(i).getNum();
            }
        }
        return this.nPagina;
    }

    //Ver toda la agenda.
    public void VerAgenda() {
        for (int i = 0; i < 365; i++) {
            System.out.println("num : " + paginas.get(i).getNum() + "  dia: " + paginas.get(i).getDia() + "   mes: " + paginas.get(i).getMes() + "\n");
            paginas.get(i).VerCitas();
        }
    }

    //Ir al dia en el que nos encontramos.
    public void IrDiaActual() {
        Date fecha = new Date();
        paginas.get(EncontrarPaginaDia(fecha.getDay(), fecha.getMonth())).VerCitas();
    }

    //Metodo que utilizamos para trbajar con la pagina en la que nos encontramos
    public Pagina PaginaActual() {
        return paginas.get(this.nPagina);
    }

    //Ir a la siguiente pagina
    public void PaginaSiguiente() {
        if (nPagina != 365) {
            nPagina++;
            paginas.get(nPagina).VerCitas();
        } else {
            System.out.println("accion erronea");
        }
    }

    //Ir a la pagina anterior
    public void PaginaAnterior() {
        if (nPagina != 1) {
            nPagina--;
            paginas.get(nPagina).VerCitas();
        } else {
            System.out.println("accion erronea");
        }
    }
}


class Pagina {
    private int num;
    private int dia;
    private int mes;
    private boolean festivo;
    List<Cita> citas = new ArrayList<>();

    public Pagina(int num, int dia, int mes, boolean festivo) {
        this.num = num;
        this.dia = dia;
        this.mes = mes;
        this.festivo = festivo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public boolean isFestivo() {
        return festivo;
    }

    public void setFestivo(boolean festivo) {
        this.festivo = festivo;
    }

    //Escribir las citas dentro de una pagina
    public void EscribirCita(String mensaje, String horaInicio, String horaFinal,String asunto) {
        Cita cita = new Cita(horaInicio, horaFinal, mensaje,asunto);
        citas.add(cita);
    }

    //Ver citas dentro de una pagina
    public void VerCitas() {
        if (!HayCita()) {
            System.out.println("no hay ninguna cita");
            System.out.println("\n");
        } else {
            for (int i = 0; i < citas.size(); i++) {
                System.out.println(
                        "asunto: " + citas.get(i).getAsunto() + "\n" +
                                "hora de inicio: " + citas.get(i).getHoraInici() + "      hora final: " + citas.get(i).getHoraFinal() + "\n" +
                                "cita: " + citas.get(i).getDescripcion()
                );
                System.out.println("\n");
            }
        }
    }

    //Saber si hay citas en una pagina
    public boolean HayCita() {
        if (citas.size() == 0) {
            return false;
        }
        return true;
    }

    //Borrar una cita dentro de una pagina
    public void BorrarCita(String asunto) {
        if (HayCita()) {
            for(int i = 0; i < citas.size(); i++){
                if(citas.get(i).getAsunto() == asunto){
                    citas.remove(i);
                }
            }
        } else {
            System.out.println("No hay ninguna cita para borrar");
        }

    }
}

class Cita {
    String horaInici;
    String horaFinal;
    String descripcion;
    String asunto;

    public Cita(String horaInici, String horaFinal, String descripcion, String asunto) {
        this.descripcion = descripcion;
        this.horaInici = horaInici;
        this.horaFinal = horaFinal;
        this.asunto = asunto;
    }

    public String getAsunto() {return asunto;}

    public void setAsunto(String asunto) {this.asunto = asunto;}

    public String getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(String horaInici) {
        this.horaInici = horaInici;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String motivo) {
        this.descripcion = motivo;
    }

}


    class mundo{

    }

