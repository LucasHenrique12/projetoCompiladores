package compiladoresProject;




import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;


public class Main {
    
    private  JFrame frame;
    private  JPanel panelBase;
    private  JPanel panelTexto;
    private  JPanel panelBotao;
    private  JButton b1;
    private  JFileChooser SelectFile;
    JTextArea areaTexto;
    
    public Main() {
    }
    
    public void BuildInterface(){
        
        frame = new JFrame("COMPILADOR");
        panelBase = new JPanel();
        panelTexto = new JPanel();
        panelBotao = new JPanel();
        b1 = new JButton("ABRIR CODIGO");
        b1.getBackground().getBlue();

        areaTexto = new JTextArea(30,60);
        areaTexto.setEditable(true);
        areaTexto.setBackground(Color.YELLOW);
        areaTexto.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        panelTexto.add(areaTexto);
        JScrollPane scroll1 = new JScrollPane(panelTexto);
       
                
        panelBotao.add(b1);
        panelBase.add(scroll1,BorderLayout.CENTER);
        panelBase.add(panelBotao,BorderLayout.SOUTH);
        
       
        
        
   
        
      
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                SelectFile = new JFileChooser();
                int ReturnSelect = SelectFile.showOpenDialog(frame);
                if (ReturnSelect == 0) {
                    
                	  File arquivo = SelectFile.getSelectedFile();
                	           	                 	       	 	           	 
                  	  try{
                  		 String filename = arquivo.toString();
                  		  areaTexto.append(arquivo.getName());
                   		  areaTexto.append("\n \n" + filename);
                   		  areaTexto.append("\n \n CODIGO FONTE \n \n");
                   		               		  
                          FileInputStream in;
                   		  in = new FileInputStream(arquivo);
                   		     
                   		  while (in.available()!= 0){
                   			  areaTexto.append((String.valueOf((char)in.read())));	
                   			                   		
                   		  }
                   		 try {
                   			 FileInputStream inputStream = new FileInputStream(arquivo);
                   			 toyParser parser = new toyParser(inputStream);
                   			toyParser.programa();
                   		 }catch(Exception ex) {
                   			 ex.printStackTrace();                
                   		 }
                   		
                  	  }catch(Exception ex){}
                  	
                    }
                            
            }

			private void systemoutprintln() {
				// TODO Auto-generated method stub
				
			}});
        
        frame.getContentPane().add(panelBase);
        frame.pack();
        
        //frame.setSize(600,400);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    
  
    
   
    /**
     * @param string the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.BuildInterface();
      
        
    }
    
}
