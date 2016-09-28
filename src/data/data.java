package data;

/**
 * Created by blackwidow on 28/09/16.
 */
public class data {

    //#1
    private static final String SEPARADOR = "-";
    private String data;

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

        return dataDescomposadaInt;

    }
}
