import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Panel extends JPanel {
    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD,18);
    private Font fontS = new Font("SanSerif", Font.BOLD,11);
    public JTextField output = new JTextField();
    private JButton backspace = new JButton("<"), equ = new JButton("C");
    private JButton plus = new JButton("+"),munis = new JButton("-"),multiply = new JButton("*"),devite = new JButton("/"),result = new JButton("=");
    private JButton point = new JButton("."),skobka = new JButton("("),skobkaTwo = new JButton(")");
    public Panel(){
        setLayout(null);
        setFocusable(true);
        grabFocus();

        backspace.setBounds(190,70,50,50);
        backspace.setFont(font);
        add(backspace);

        equ.setBounds(10,70,50,50);
        equ.setFont(font);
        add(equ);

        plus.setBounds(190,190,50,50);
        plus.setFont(font);
        add(plus);

        munis.setBounds(190,130,50,50);
        munis.setFont(font);
        add(munis);

        multiply.setBounds(130,70,50,50);
        multiply.setFont(font);
        add(multiply);

        devite.setBounds(70,70,50,50);
        devite.setFont(font);
        add(devite);

        result.setBounds(190,250,50,110);
        result.setFont(font);
        add(result);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(10,310,45,50);
        numbers[0].setFont(fontS);

        point.setBounds(58,310,40,50);
        point.setFont(fontS);
        add(point);

        skobka.setBounds(101,310,40,50);
        skobka.setFont(fontS);
        add(skobka);

        skobkaTwo.setBounds(140,310,40,50);
        skobkaTwo.setFont(fontS);
        add(skobkaTwo);

        add(numbers[0]);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                numbers[i * 3 + j + 1] = new JButton((j*3+i+1)+"");
                numbers[i * 3 + j + 1].setBounds(i*(50+10)+10,j*(50+10)+130,50,50);
                numbers[i * 3 + j + 1].setFont(font);
                add(numbers[i * 3 + j + 1]);
            }
        }
        output.setBounds(10,10,230,50);
        output.setEditable(false);
        output.setFont(font);
        add(output);

        ActionListener addButtonText = (ActionEvent e)->{
            JButton b = (JButton) e.getSource();
            output.setText(output.getText()+b.getText());
        };

        ActionListener equClear = (ActionEvent e)->{
            output.setText("");
        };
        ActionListener back = (ActionEvent e)->{
            if(output.getText().length()>0){
                output.setText(String.valueOf(output.getText().substring(0, output.getText().length() - 1)));
            }
        };

        ActionListener res = (ActionEvent e)->{
            RigthExpression exp = new RigthExpression();
            Calculat calculat = new Calculat(exp.Expression(output.getText()));
            output.setText(String.valueOf(calculat.calc()));
        };

        for(JButton b : numbers){
            b.addActionListener(addButtonText);
        }

        plus.addActionListener(addButtonText);
        munis.addActionListener(addButtonText);
        multiply.addActionListener(addButtonText);
        devite.addActionListener(addButtonText);

        point.addActionListener(addButtonText);
        skobka.addActionListener(addButtonText);
        skobkaTwo.addActionListener(addButtonText);

        equ.addActionListener(equClear);
        backspace.addActionListener(back);
        result.addActionListener(res);
    }
}
