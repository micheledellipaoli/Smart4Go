package main.java.beans;

import java.util.Calendar;

public class StrumentoStampaData {

    public Calendar data;

    //Metodo di Stampa della data nel formato dd-mm-yy
    public static String getDataCastedToString(Calendar data) {
        if(data.get(Calendar.MONTH) == 11) {
            return data.get(Calendar.DAY_OF_MONTH)+"/12/"+data.get(Calendar.YEAR);
        }else {
            //data.add(data.MONTH, 1);
            return data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.YEAR);
        }
    }

    //Metodo di Stampa dell'ora nel formato hh:mm:ss
    public static String getOraCastedToString(Calendar data) {
        String result = "";
        if(String.valueOf(data.get(Calendar.HOUR_OF_DAY)).length() < 2) {
            result += "0" + String.valueOf(data.get(Calendar.HOUR_OF_DAY)) + ":";
        }else {
            result += String.valueOf(data.get(Calendar.HOUR_OF_DAY)) + ":";
        }
        if(String.valueOf(data.get(Calendar.MINUTE)).length() < 2) {
            result += "0" + String.valueOf(data.get(Calendar.MINUTE)) + ":";
        }else {
            result += String.valueOf(data.get(Calendar.MINUTE)) + ":";
        }
        if(String.valueOf(data.get(Calendar.SECOND)).length() < 2) {
            result += "0" + String.valueOf(data.get(Calendar.SECOND));
        }else {
            result += String.valueOf(data.get(Calendar.SECOND));
        }
        return result;
    }

}
