import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberedButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font font = new Font("Ink Free",Font.BOLD,30);
    double num1=0, num2=0, result=0;
    char operator;
    Calculator(){
        frame = new JFrame("Calculator");                   // Creates a window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Closes window on exit
        frame.setSize(420,550);                     // Sets window size
        frame.setLayout(null);                                  // No layout manager(manual positioning)

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i=0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numberedButtons[i] = new JButton(String.valueOf(i));
            numberedButtons[i].addActionListener(this);
            numberedButtons[i].setFont(font);
            numberedButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,15,15));
//        panel.setBackground(Color.GRAY);
        panel.add(numberedButtons[1]);
        panel.add(numberedButtons[2]);
        panel.add(numberedButtons[3]);
        panel.add(addButton);
        panel.add(numberedButtons[4]);
        panel.add(numberedButtons[5]);
        panel.add(numberedButtons[6]);
        panel.add(subButton);
        panel.add(numberedButtons[7]);
        panel.add(numberedButtons[8]);
        panel.add(numberedButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberedButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);                                 // Displays the window
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberedButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = (num2 != 0) ? num1 / num2 : Double.NaN;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String str = textField.getText();
            if(!str.isEmpty()){
                textField.setText(str.substring(0,str.length()-1));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
