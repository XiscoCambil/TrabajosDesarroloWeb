package Log;

/**
 * Created by blackwidow on 14/10/16.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Xavi Torrens
 */
public class LogFile extends LogAbstract {
    //private static  log = null;
/*
    private synchronized static void createInstance(){
        if (LOG == null){
            LOG = new LogFile();
        }
    }
    */

/*

    public static Log getInstance(){
        if (LOG == null){createInstance();}
        System.out.println("Ya esta creada, solo te devuelve el valor");
        return LOG;
    }
*/

    private synchronized static void createInstance(Log log){
        if (LogAbstract.getInstance() == null){

        }
    }

    public void logInfo(String textToLog) {
        if (isLogInfo()) {
            writeFile(INFO_PREFIX + textToLog);
        }
    }

    public void logWarn(String textToLog) {
        if (isLogWarn()) {
            writeFile(WARN_PREFIX + textToLog);
        }

    }

    public void logError(String textToLog) {
        if (isLogError()) {
            writeFile(ERROR_PREFIX + textToLog);
        }


    }

    private void writeFile(String text) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("log.log", "UTF-8");
            writer.println(text);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
