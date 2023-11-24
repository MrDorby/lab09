package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("My first Java graphical interface");
        this.frame.setSize(new Dimension(900, 600));
        
        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton button = new JButton("Save");

        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.SOUTH);
        panel.add(textArea);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setFile(controller.getFile());
            }
        });

        this.frame.getContentPane().add(panel);
    }

    public void setVisibility(){
        this.frame.setVisible(true);
    }

    public Controller getController(){
        return controller;
    }

    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI();
        gui.setVisibility();
        System.out.println(gui.getController().getFile());
    }
}
