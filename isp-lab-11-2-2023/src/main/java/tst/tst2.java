//Fire de executie

public class Counter extends Thread {

    Counter(String name){
        super(name);
    }

    public void run(){
        for(int i=0;i<20;i++){
            System.out.println(getName() + " i = "+i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " job finalised.");
    }

    public static void main(String[] args) {
        Counter c1 = new Counter("counter1");
        Counter c2 = new Counter("counter2");
        Counter c3 = new Counter("counter3");

        c1.start();
        c2.start();
        c3.start();
    }
}

public class CounterRunnable implements Runnable {

    public void run(){
        Thread t = Thread.currentThread();
        for(int i=0;i<20;i++){
            System.out.println(t.getName() + " i = "+i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.getName() + " job finalised.");
    }

    public static void main(String[] args) {
        CounterRunnable c1 = new CounterRunnable();
        CounterRunnable c2 = new CounterRunnable();
        CounterRunnable c3 = new CounterRunnable();

        Thread t1 = new Thread(c1,"conuter1");
        Thread t2 = new Thread(c2,"conuter2");
        Thread t3 = new Thread(c3,"conuter3");

        t1.start();
        t2.start();
        t3.start();
    }
}

//Metoda JOIN

    lass JoinTest extends Thread
        {
        String n;
        Thread t;
        JoinTest(String n, Thread t){this.n = n;this.t=t;}

public void run()
        {
        System.out.println("Firul "+n+" a intrat in metoda run()");
        try
        {
        if (t!=null) t.join();
        System.out.println("Firul "+n+" executa operatie.");
        Thread.sleep(3000);
        System.out.println("Firul "+n+" a terminat operatia.");
        }
        catch(Exception e){e.printStackTrace();}

        }

public static void main(String[] args)
        {
        JoinTest w1 = new JoinTest("Proces 1",null);
        JoinTest w2 = new JoinTest("Proces 2",w1);
        w1.start();
        w2.start();
        }
        }

//Interfete grafice

        import javax.swing.JFrame;

public class SimpleApp extends JFrame{

    SimpleApp(){
        setTitle("Titlul ferestrei");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleApp a = new SimpleApp();
    }

}

//Butoane si casute de text

import java.awt.FlowLayout;

        import javax.swing.*;
        import java.util.*;

public class ButtonAndTextField extends JFrame{

    HashMap accounts = new HashMap();

    JLabel user,pwd;
    JTextField tUser,tPwd;
    JButton bLoghin;

    ButtonAndTextField(){

        accounts.put("user1", "pwd1");
        accounts.put("user2", "pwd2");
        accounts.put("user3", "pwd3");

        setTitle("Test login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setSize(200,250);
        setVisible(true);
    }

    public void init(){

        this.setLayout(null);
        int width=80;int height = 20;

        user = new JLabel("User ");
        user.setBounds(10, 50, width, height);

        pwd = new JLabel("Pasword ");
        pwd.setBounds(10, 100,width, height);

        tUser = new JTextField();
        tUser.setBounds(70,50,width, height);

        tPwd = new JTextField();
        tPwd.setBounds(70,100,width, height);

        bLoghin = new JButton("Loghin");
        bLoghin.setBounds(10,150,width, height);

        add(user);add(pwd);add(tUser);add(tPwd);add(bLoghin);

    }

    public static void main(String[] args) {
        new ButtonAndTextField();
    }
}

//Exemplu creare login cu mai multe pagini

import java.awt.*;
        import javax.swing.*;

public class JTabbedPaneExample
        extends     JFrame
{
    private           JTabbedPane tabbedPane;
    private           JPanel            panel1;
    private           JPanel            panel2;
    private           JPanel            panel3;


    public JTabbedPaneExample()
    {

        setTitle( "Tabbed Pane Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );

        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create the tab pages
        createPage1();
        createPage2();
        createPage3();

        // Create a tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab( "Page 1", panel1 );
        tabbedPane.addTab( "Page 2", panel2 );
        tabbedPane.addTab( "Page 3", panel3 );
        topPanel.add( tabbedPane, BorderLayout.CENTER );
    }

    public void createPage1()
    {
        panel1 = new JPanel();
        panel1.setLayout( null );

        JLabel label1 = new JLabel( "Username:" );
        label1.setBounds( 10, 15, 150, 20 );
        panel1.add( label1 );

        JTextField field = new JTextField();
        field.setBounds( 10, 35, 150, 20 );
        panel1.add( field );

        JLabel label2 = new JLabel( "Password:" );
        label2.setBounds( 10, 60, 150, 20 );
        panel1.add( label2 );

        JPasswordField fieldPass = new JPasswordField();
        fieldPass.setBounds( 10, 80, 150, 20 );
        panel1.add( fieldPass );
    }

    public void createPage2()
    {
        panel2 = new JPanel();
        panel2.setLayout( new BorderLayout() );

        panel2.add( new JButton( "North" ), BorderLayout.NORTH );
        panel2.add( new JButton( "South" ), BorderLayout.SOUTH );
        panel2.add( new JButton( "East" ), BorderLayout.EAST );
        panel2.add( new JButton( "West" ), BorderLayout.WEST );
        panel2.add( new JButton( "Center" ), BorderLayout.CENTER );
    }

    public void createPage3()
    {
        panel3 = new JPanel();
        panel3.setLayout( new GridLayout( 3, 2 ) );

        panel3.add( new JLabel( "Field 1:" ) );
        panel3.add( new TextArea() );
        panel3.add( new JLabel( "Field 2:" ) );
        panel3.add( new TextArea() );
        panel3.add( new JLabel( "Field 3:" ) );
        panel3.add( new TextArea() );
    }

    // Main method to get things started
    public static void main( String args[] )
    {
        // Create an instance of the test application
        JTabbedPaneExample mainFrame  = new JTabbedPaneExample();
        mainFrame.setVisible( true );
    }
}