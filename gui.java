import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Image;

public class gui implements ActionListener {
    JTextField textField;
    //JTextField hasilTextField;
   // JTextField siklusJTextField;
    JComboBox simpul;
    JComboBox color;
    JTextArea hasilwarna;
    JTextArea siklusJTextField;
    
    public static void main(String[] args) {
        new gui();//buat instance
        

    }
    
    public gui() {
        initComponent();

    }
    private void initComponent() {
        /**
         * GUI design
         */

        //---------------------------frame--------------------------
        JFrame frame = new JFrame();//buat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//keluar dari app
        frame.setTitle("Algoritma Welch Powell");//judul frame
        frame.setSize(600,800);//ukuran frame
        frame.setVisible(true);//tampil frame
        frame.setLayout(null);//layout manual
        
      

        ImageIcon logo = new ImageIcon("src/logo/peaky_blinders.jpg");
        
        frame.setIconImage(logo.getImage());//set logo
        //ImageIcon image = new ImageIcon("src/logo/peta.jpg");

        //-----------------------------label--------------------------
        JLabel label = new JLabel("Implementasi Algoritma Welch-Powell Pada Pengaturan Lampu Lalu Lintas Pasteur Bandung");//buat label judul utama
        
        label.setBounds(200,20,600,30); //set ukuran
        ImageIcon image = new ImageIcon(new ImageIcon("src/logo/peta2.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel icon = new JLabel(image);//masukan label gambar
        icon.setBounds(400,80,500,500);
        //------------label masukan----------
        JLabel label2 = new JLabel("Input Matrix");
        label2.setBounds(20,150,150,30);
        
        frame.add(label);//add label ke frame
        frame.add(icon);
        frame.add(label2);
        
        //------textfield----- 
        textField = new JTextField();//masukan
        textField.setBounds(150,150,180,30);
        frame.add(textField);

        //-----combobox------

        //combobox banyak vertex
        JLabel comboBox = new JLabel("banyak vertex");
        comboBox.setBounds(20,200,150,30);
        frame.add(comboBox);
        String vertex[] = {"1", "2", "3", "4", "5"};//isi dari combobox
        simpul= new JComboBox(vertex);
        simpul.setBounds(150,200,50,30);

        //combobox banyak warna
        JLabel banyakwarna = new JLabel("banyak warna");
        banyakwarna.setBounds(20,250,150,30);
        frame.add(banyakwarna);
        String warna[] = {"1", "2", "3", "4","5"};
        color = new JComboBox(warna);
        color.setBounds(150,250,50,30);
        frame.add(color);
        frame.add(simpul);

        //---------------hasil pewarnaan label---------
        JLabel hasil = new JLabel("Hasil Pewarnaan");
        hasil.setBounds(20,350,150,30);
        //hasil pewarnaan textfield
        hasilwarna = new JTextArea();
        hasilwarna.setBounds(150,350,180,120);

        frame.add(hasilwarna);
        frame.add(hasil);


        //-----------hasil durasi siklus lampu------------
        JLabel siklus = new JLabel("Durasi Siklus Lampu");
        siklus.setBounds(20,500,150,30);
        //hasil durasi siklus textfield
        siklusJTextField = new JTextArea();
        siklusJTextField.setBounds(150,500,180,130);
        frame.add(siklus);
        frame.add(siklusJTextField);
        

        //--------------button---------------
        JButton button = new JButton("Run");//buat tombol
        button.setBounds(150,300,70,30);
        frame.add(button);

        //-------------block event---------------
        button.addActionListener(this);
        button.setActionCommand("start");


    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        String userfield = textField.getText();
        int verteks = Integer.parseInt(simpul.getSelectedItem().toString());  
        int banyakwarna =Integer.parseInt(color.getSelectedItem().toString());
        PewarnaanGraph gc = new PewarnaanGraph();
        

        int [][] matriks = new int [verteks][verteks];
        int k = 0;
        for(int i = 0; i < verteks; i++){
            for(int j = 0; j < verteks; j++){
                matriks[i][j] = Character.getNumericValue(userfield.charAt(k));
                k++;
            }
        }
        
       
        if (command.equals("start")){
            String[] hasil = new String [2];
            hasil = gc.pewarnaanGraph(banyakwarna, matriks);
            if(hasil[0].equals("Ada Solusi")){
                hasilwarna.setText(hasil[1]);
                JOptionPane.showMessageDialog(null, "Ada Solusi");
                
            }
            // if(userfield.equals("halo")){
                
            else{
                JOptionPane.showMessageDialog(null,"Tidak ada solusi");
                
            }
            
        }else{
            System.out.println();
        }
    }
    
    
    
}
