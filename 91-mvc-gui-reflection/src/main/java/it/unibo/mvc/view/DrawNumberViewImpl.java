package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

import static java.lang.System.out;

public class DrawNumberViewImpl implements DrawNumberView{


    public DrawNumberViewImpl(){
        
    }
     
    @Override
    public void setController(DrawNumberController observer) {
    }

    @Override
    public void start() {
    }

    @Override
    public void result(DrawResult res) {
        out.println(res.getDescription());
    }
}