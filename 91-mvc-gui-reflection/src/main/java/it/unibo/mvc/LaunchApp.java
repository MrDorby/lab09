package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
import it.unibo.mvc.view.DrawNumberViewImpl;

import java.lang.Class;
import java.lang.reflect.InvocationTargetException;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws SecurityException
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        //app.addView(new DrawNumberViewImpl());
        //app.addView(new DrawNumberSwingView());
        //app.addView(new DrawNumberSwingView());

        /*Reflection Loading */
        for(int i = 0; i<3; i++){
            app.addView((DrawNumberSwingView)Class.forName("it.unibo.mvc.view.DrawNumberSwingView").getConstructor().newInstance());
        }
        for(int j = 0; j<3; j++){
            app.addView((DrawNumberViewImpl)Class.forName("it.unibo.mvc.view.DrawNumberViewImpl").getConstructor().newInstance());
        }
    }
}
