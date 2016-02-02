/***********************************************************
 // Assignment :  Guessatron Final
 // by: Kyle Gray
 // Date: 1 / 29 / 2016
 // Description: Guesses your number between 1 - 100 and puts into GUI
 //  Notes: Working on a MAC in IDEA by jetbrains - hopefully mine wasn't the one having compile problems for you!
 //***********************************************************
 //************************************************************

 */
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class _CustomFrame extends JFrame implements ActionListener{

    private JLabel quesLabel;
    private JLabel numberLabel;
    private JLabel introLabel1;
    private JLabel introlabel2;
    private JLabel itsComplete;
    private JButton butLower;
    private JButton butHihger;
    private JButton butYes;
    private JButton butReset;
    private boolean complete;

    private FlowLayout layout;
    private Container container;

    int minvalue;
    int maxvalue;
    int guessNum;

    public _CustomFrame() {

        super("GuessATron Final Project");
        setLayout(new FlowLayout());
        minvalue = 1;
        maxvalue = 100;
        guessNum = 50;
        complete = false;


        introLabel1 = new JLabel("Welcome to Guessatron! I will guess your number");
        introLabel1.setAlignmentX(CENTER_ALIGNMENT);

        introlabel2 = new JLabel("Between 1 - 100");
        introlabel2.setAlignmentX(CENTER_ALIGNMENT);


        numberLabel = new JLabel("> " + guessNum + " <");
        numberLabel.setAlignmentX(CENTER_ALIGNMENT);
        Font myFont = new Font("Serif", Font.BOLD, 17);
        numberLabel.setFont(myFont);
        numberLabel.setForeground(Color.RED);

        quesLabel = new JLabel("Is your Number Higher or Lower Than?");
        quesLabel.setAlignmentX(CENTER_ALIGNMENT);

        itsComplete = new JLabel("I Told you I would get the anser Ha Ha");
        itsComplete.setFont(myFont);
        itsComplete.setForeground(Color.RED);

        JButton button1 = new JButton("Higher");
        JButton button2 = new JButton("Lower");
        JButton button3 = new JButton("Yes");
        JButton button4 = new JButton("Reset");

        add(introLabel1);
        add(introlabel2);
        add(quesLabel);
        add(numberLabel);
        add(button1);
        button1.addActionListener(this);
        add(button2,BorderLayout.SOUTH);
        button2.addActionListener(this);
        add(button3,BorderLayout.SOUTH);
        button3.addActionListener(this);
        add(button4,BorderLayout.SOUTH);
        button4.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        String name = e.getActionCommand();
        if (name.equals("Higher")) {

            minvalue = guessNum;
            guessNum = ((maxvalue - minvalue) / 2) + minvalue;
            numberLabel.setText("> " + guessNum + " <");
        } else if (name.equals("Lower")) {
            System.out.println("you clicked lower");
            maxvalue = guessNum;
            guessNum = ((maxvalue - minvalue) / 2) + minvalue;
            numberLabel.setText("> " + guessNum + " <");
        } else if (name.equals("Yes")) {
            System.out.println("you clicked yes");
            add(itsComplete);
            revalidate();
            complete = true;
        } else if (name.equals("Reset")) {
            System.out.println("you clicked reset");
            minvalue = 1;
            maxvalue = 100;
            guessNum = 50;
            numberLabel.setText("> " + guessNum + " <");
            this.remove(itsComplete);
            this.revalidate();
        }
    }
}

///////////////////////////////////////////////////////////////////
///   End Of File
///////////////////////////////////////////////////////////////////

