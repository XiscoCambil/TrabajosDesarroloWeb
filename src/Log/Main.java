package Log;

import java.util.List;

/**
 * Created by blackwidow on 14/10/16.
 */
public class Main {
    public static Log Log= new LogFile();
        public static void main(String[] args) {

            //Delegam les responsabilitats del log
            // en una entitat externa --> Log
            LogFile.getInstance();
            LogFile.getInstance().setLogError(true);
            LogFile.getInstance().setLogInfo(true);
            LogFile.getInstance().setLogWarn(true);

            List<String> list = null;

            if (list == null) LogFile.getInstance().logWarn("LLista nula");

            try {
                LogFile.getInstance().logInfo("Anem a afegir un element.");
                list.add("Element");
            } catch (NullPointerException npe){
                LogFile.getInstance().logError(" excepcio:" + npe.getMessage());
            }

        }
    }

