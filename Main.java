import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField result;

  JButton addButton;
  JButton subButton;
  JButton multButton;
  JButton divButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);

    //create side labels
    firstLabel = new JLabel("First Number");
    secondLabel = new JLabel("Second Number");
    thirdLabel = new JLabel("Result");

    //set the location and size
    firstLabel.setBounds(150,300,150,20);
    secondLabel.setBounds(150,330,150,20);
    thirdLabel.setBounds(150,360,150,20);

    //create text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    result = new JTextField();

    //set location and size
    firstInput.setBounds(350,300,150,20);
    secondInput.setBounds(350,330,150,20);
    result.setBounds(350,360,150,20);

    //disable the result area so user can't type in it
    result.setEnabled(false);

    //initialize buttons
    addButton = new JButton("add");
    subButton = new JButton("sub");
    multButton = new JButton("mult");
    divButton = new JButton("div");

    //set the location and size
    addButton.setBounds(150,450,100,40);
    subButton.setBounds(260,450,100,40);
    multButton.setBounds(370,450,100,40);
    divButton.setBounds(480,450,100,40);

    //add an action listener to the buttons
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    multButton.addActionListener(this);
    divButton.addActionListener(this);

    //set the action command on the buttons
    addButton.setActionCommand("add");
    subButton.setActionCommand("sub");
    multButton.setActionCommand("mult");
    divButton.setActionCommand("div");

    //add the labels to the panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);

    //add the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(result);

    //add the buttons to the panel
    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(multButton);
    mainPanel.add(divButton);

    //add the panel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //get the text from the text boxes
    String firstText = firstInput.getText();
    String secondText = secondInput.getText();

    //change the strings into integers
    int numOne = Integer.parseInt(firstText);
    int numTwo = Integer.parseInt(secondText);

    int num;

    if(command.equals("add")){
      num = numOne + numTwo;
      result.setText("" + num);
    }else if(command.equals("sub")){
      num = numOne - numTwo;
      result.setText("" + num);
    }else if(command.equals("mult")){
      num = numOne*numTwo;
      result.setText("" + num);
    }else if(command.equals("div")){
      num = numOne/numTwo;
      result.setText("" + num);
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
