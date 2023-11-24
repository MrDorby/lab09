package it.unibo.mvc;

import java.util.List;
/**
 *
 */
public interface Controller {

    void print(String str);

    public String getCurrentString();

    public String getNextString();

    public void setNextString(String nextString);

    public List<String> getHistoryList();

}
