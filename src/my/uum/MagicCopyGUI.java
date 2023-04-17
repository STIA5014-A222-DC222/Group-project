package my.uum;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**

 The PayrollGUI class provides a graphical user interface for calculating payroll for different types of workers.
 */
class PayrollGUI extends JFrame implements ActionListener {
    public JLabel labelPayCode, labelNumWorkers, labelNumHours;
    public JTextField fieldPayCode, fieldNumWorkers, fieldNumHours;
    public JButton buttonCalculate;

    /**

     Constructs a PayrollGUI object.

     Initializes the JFrame and its components.
     */
    public PayrollGUI() {
        setTitle("Payroll Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create components
        labelPayCode = new JLabel("Pay Code:");
        labelNumWorkers = new JLabel("Number of Workers:");
        labelNumHours = new JLabel("Number of Hours:");
        fieldPayCode = new JTextField(10);
        fieldNumWorkers = new JTextField(10);
        fieldNumHours = new JTextField(10);
        buttonCalculate = new JButton("Calculate");
        buttonCalculate.addActionListener(this);

        // set layout and add components to content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 2));
        contentPane.add(labelPayCode);
        contentPane.add(fieldPayCode);
        contentPane.add(labelNumWorkers);
        contentPane.add(fieldNumWorkers);
        contentPane.add(labelNumHours);
        contentPane.add(fieldNumHours);
        contentPane.add(new JLabel(""));
        contentPane.add(buttonCalculate);

        setVisible(true);
    }
    /**

     This method is called when the "Calculate" button is clicked.

     It calculates the payroll based on user input and displays the result in a message dialog box.

     @param event the action event that occurred
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == buttonCalculate) {
            try {
                // validate input
                int payCode = Integer.parseInt(fieldPayCode.getText());
                int numWorkers = Integer.parseInt(fieldNumWorkers.getText());
                int numHours = Integer.parseInt(fieldNumHours.getText());

                if (payCode < 1 || payCode > 3) {
                    JOptionPane.showMessageDialog(this, "Invalid Pay Code.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (numWorkers < 1 || numHours < 1) {
                    JOptionPane.showMessageDialog(this, "Number of Workers and Number of Hours must be positive.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double pay = 0.0;

                if (payCode == 1) {
                    // calculate pay for hourly worker
                    pay = numWorkers * 30.0 * numHours;
                } else if (payCode == 2) {
                    // calculate pay for salaried worker
                    pay = numWorkers * 2000.0;
                } else if (payCode == 3) {
                    // calculate pay for commissioned worker
                    pay = numWorkers * numHours * 25.0;
                }

                JOptionPane.showMessageDialog(this, "Pay: $" + pay, "Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**

     The main method creates a PayrollGUI object and displays it.
     @param args the command line arguments
     */
    public static void main(String[] args) {
        PayrollGUI payrollGUI = new PayrollGUI();
    }
}
