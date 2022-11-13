/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pp843
 */
public class view  extends JFrame implements ActionListener{
   JButton  CompressButton;
   JButton DecompressButton;
    view(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        CompressButton =new JButton("Select file to compress");
        CompressButton.addActionListener(this);
        CompressButton.setBounds(20,100,200,30);
        
        DecompressButton =new JButton("Select file to Decompress");
        DecompressButton.addActionListener(this);
        DecompressButton.setBounds(250,100,200,30);
        this.add(CompressButton);
        this.add(DecompressButton);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setSize(500,200);
        
        this.setSize(500,200);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== CompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        if(e.getSource()== DecompressButton){
             JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
    public static void main(String[] args){
        view View =new view();
        View.setVisible(true);
    }
    
}
