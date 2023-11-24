package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */ 
public final class SimpleController implements Controller {

    private String currentString;
    private String nextString;
    private List<String> historyList;

    public SimpleController(){
        this.currentString = null;
        this.nextString = null;
        this.historyList = new ArrayList<>();
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public String getCurrentString() {
        return Objects.requireNonNull(this.currentString);
    }

    public String getNextString() {
        return nextString;
    }

    public void setNextString(String nextString) {
        this.currentString = this.nextString;
        this.nextString = Objects.requireNonNull(nextString);
        this.historyList.add(nextString);
    }

    public List<String> getHistoryList() {
        return new ArrayList<>(List.copyOf(this.historyList));
    }
}
