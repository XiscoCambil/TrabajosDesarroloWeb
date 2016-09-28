package data;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by blackwidow on 28/09/16.
 */
public class Data {
    public static void main(String[] args) throws Exception {

        AnyDeTraspas a = new AnyDeTraspas();
        a.setData("01-01-1998");
        System.out.println(a.isAnyDeTraspas());
    }
    //#1
    private static final String SEPARADOR = "-";
    private String data;
    private int dia;
    private int mes;
    private int any;

    public String getData() {
        return data;
    }

    public void setData(String data) throws Exception {
        //#2
        if (!data.contains(SEPARADOR)) throw new Exception();
        this.data = data;
    }

    public int getAny(){
        return data != null ? descomposaData()[2] : 0;
    }

    private int[] descomposaData(){

        String[] dataDescomposada = data.split(SEPARADOR);
        int[] dataDescomposadaInt = new int[dataDescomposada.length];
        dataDescomposadaInt[0] = Integer.parseInt(dataDescomposada[0]);
        dataDescomposadaInt[1] = Integer.parseInt(dataDescomposada[1]);
        dataDescomposadaInt[2] = Integer.parseInt(dataDescomposada[2]);
        this.dia = dataDescomposadaInt[0];
        this.mes = dataDescomposadaInt[1];
        this.any = dataDescomposadaInt[2];
        return dataDescomposadaInt;

    }
}

class AnyDeTraspas extends Data{

        public boolean isAnyDeTraspas(){
            GregorianCalendar calendar = new GregorianCalendar();
            return calendar.isLeapYear(getAny());
        }


}
