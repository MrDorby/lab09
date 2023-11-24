package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser(){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("My first File Chooser");
        this.frame.setSize(new Dimension(900, 600));

        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton buttonSave = new JButton("Save");

        panel.setLayout(new BorderLayout());
        panel.add(buttonSave, BorderLayout.SOUTH);
        panel.add(textArea);

        final JPanel panelFile = new JPanel();
        final JTextField textField = new JTextField();
        final JButton buttonBrowse = new JButton("Browse");

        panelFile.setLayout(new BorderLayout());
        panelFile.add(textField, BorderLayout.CENTER);
        panelFile.add(buttonBrowse, BorderLayout.LINE_END);
        panel.add(panelFile, BorderLayout.NORTH);

        textField.setEditable(false);

        buttonBrowse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int i = chooser.showSaveDialog(chooser);
                if(i == JFileChooser.APPROVE_OPTION){
                    controller.setFile(chooser.getSelectedFile());
                    textField.setText(controller.getFilePath());
                }
                else if(i == JFileChooser.CANCEL_OPTION){
                }
                else{
                    JOptionPane.showMessageDialog(chooser, "An error has occured");
                }
            }
            
        });

        this.frame.getContentPane().add(panel);
    }

    public void setVisibility(){
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        final SimpleGUIWithFileChooser guiFile = new SimpleGUIWithFileChooser(); 
        guiFile.setVisibility();
    }

}
