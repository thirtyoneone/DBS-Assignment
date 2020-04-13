/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBSAssign;

import java.util.*;

/**
 *
 * @author rushi
 */
public class Ques1 extends javax.swing.JFrame {
    
    static Set<String> attribute_set = new HashSet<String>();
    static ArrayList<String> lhs = new ArrayList();
    static ArrayList<String> rhs = new ArrayList();
    Set<String> keys = new HashSet<String>();
    static int maxnfindi[] = new int[20];

    /**
     * Creates new form Ques1
     */
    public Ques1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_Label = new javax.swing.JLabel();
        att_label = new javax.swing.JLabel();
        fd_label = new javax.swing.JLabel();
        att_names = new javax.swing.JTextField();
        fds = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        output_area = new javax.swing.JTextArea();
        solve_button = new javax.swing.JButton();
        decompose_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_Label.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        title_Label.setText("Normalisation Solver");

        att_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        att_label.setText("Enter the attribute names:");

        fd_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fd_label.setText("Enter the Functional Dependencies:");

        output_area.setColumns(20);
        output_area.setRows(5);
        jScrollPane1.setViewportView(output_area);

        solve_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        solve_button.setText("Solve");
        solve_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solve_buttonActionPerformed(evt);
            }
        });

        decompose_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        decompose_button.setText("Decompose");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(solve_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(decompose_button, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(att_label)
                        .addGap(18, 18, 18)
                        .addComponent(att_names, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fd_label, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fds, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(title_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(att_label)
                    .addComponent(att_names, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fd_label)
                    .addComponent(fds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(solve_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(decompose_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solve_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solve_buttonActionPerformed

        String attributes = att_names.getText();
        String att_temp_split[] = attributes.split(",");
        Collections.addAll(attribute_set, att_temp_split);
        String fds_1 = fds.getText();
        String fds_2[] = fds_1.split(";");
        int size = fds_2.length;
        for(int i=0; i<size; i++)
        {
            String fds_3[] = fds_2[i].split("->");
            lhs.add(fds_3[0]);
            rhs.add(fds_3[1]);
        }
        String output = "";
        //output_area.setText(output);
        LinkedHashMap<String , Integer> ggma = new LinkedHashMap<String , Integer>();

        int pp = 0;

        for( String s : attribute_set)
        {
            ggma.put(s , pp);   // Mapping the attributes
            pp++;
        }


        ArrayList<String> lhsss = new ArrayList();
        ArrayList<String> rhsss = new ArrayList();

        for( String ll : lhs)
        {
            String ll_split[] = ll.split(",");
            int ll_sp_size = ll_split.length;
            String tt = new String();
            tt="";
            for(int iii=0; iii<ll_sp_size; iii++)
            {
                tt+=ggma.get(ll_split[iii]);
                if(iii != ll_sp_size-1)
                {
                    tt+=",";
                }
            }
            lhsss.add(tt);
        }

        for( String ll : rhs)
        {
            String ll_split[] = ll.split(",");
            int ll_sp_size = ll_split.length;
            String tt = new String();
            tt="";
            for(int iii=0; iii<ll_sp_size; iii++)
            {
                tt+=ggma.get(ll_split[iii]);
                if(iii != ll_sp_size-1)
                {
                    tt+=",";
                }
            }
            rhsss.add(tt);
        }

        int keyyy = getkey(ggma , attribute_set , pp , lhsss , rhsss);
//        Set<String> checkkey = new HashSet<String>();
        System.out.println(keyyy);
        
        int iiiii=0;
        while(keyyy!=0)
        {
            if((keyyy&1)==1)
            {
                for(String test : attribute_set)
                {
                    if(ggma.get(test) == iiiii)
                    {
                        keys.add(test);
                    }
                }
            }
            iiiii++;
            keyyy/=2;
        }
        output += "\n";
        output += "The key is - \n";
        for(String lol : keys)
        {
            output += lol;
            output += ",";
        }
        System.out.println(keys);
        output = output.replaceFirst(".$","");
        output += "\n\nThe FDs you entered and the corresponding Normal Forms are \n\n";
        int te = 4;
        for(int i=0; i<size; i++)
        {
            output += fds_2[i];
            output += "  is in ";
            if(maxnfindi[i] == 1)
            {
                output += "1NF";
            }
            else if(maxnfindi[i] == 2)
            {
                output += "2NF";
            }
            else if(maxnfindi[i] == 3)
            {
                output += "3NF";
            }
            else if(maxnfindi[i] == 4)
            {
                output += "BCNF";
            }
            if(maxnfindi[i] < te)
            {
                te = maxnfindi[i];
            }
            output += "\n";
        }
        
        output += "The relation is in ";
        if(te <= 3)
        {
            output += String.valueOf(te)+"NF";
        }
        else
        {
            output += "BCNF";
        }
        output_area.setText(output);
        // TODO add your handling code here:
    }//GEN-LAST:event_solve_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ques1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ques1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ques1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ques1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ques1().setVisible(true);
            }
        });
    }
    
    public static void twonf(int temparr[], Set<String> key)
    {
//        int flag = 0;
        for(int i=0; i<lhs.size(); i++) {
            String temp = lhs.get(i);
            String lhs_temp_split[] = temp.split(",");
            Set<String> lhs_split = new HashSet<String>();
            Collections.addAll(lhs_split, lhs_temp_split);
            if(key.containsAll(lhs_split) == true && lhs_split.size() != key.size())
            {
                // NOT IN 2NF CODE
            }
            else
            {
                System.out.println("2NF");
                temparr[i] = 2;
                System.out.println(key);
                System.out.println(lhs_split);
                //System.out.println(rhs_split);
            }
        }
    }
    
    public static void bcnf(int temparr[] , Set<String> key)
	{
//		int flag = 0;
		for(int i=0; i<lhs.size() ; i++)
		{
			String temp = lhs.get(i);
			String lhs_temp_split[] = temp.split(",");
			Set<String> lhs_split = new HashSet<String>();
			Collections.addAll(lhs_split, lhs_temp_split);

			String temp2 = rhs.get(i);
			String rhs_temp_split[] = temp2.split(",");
			Set<String> rhs_split = new HashSet<String>();
			Collections.addAll(rhs_split, rhs_temp_split);

		//	if(key.containsAll(lhs_split) == true && lhs_split.size() != key.size())
		//	{
		//		flag = 1;
		//	}

			if(lhs_split.containsAll(key) == false) // && key.containsAll(rhs_split) == false )
			{
				// NOT IN BCNF CODE
			}
                        else
                        {
                            temparr[i] = 4;
                        }
		}
//		return flag;
	}

    public static void threenf(int temparr[], Set<String> key)
	{
            System.out.println("Key in 3nf");
            System.out.println(key);
//		int flag = 0;
		for(int i=0; i<lhs.size(); i++)
		{
			String temp = lhs.get(i);
			String lhs_temp_split[] = temp.split(",");
			Set<String> lhs_split = new HashSet<String>();
			Collections.addAll(lhs_split, lhs_temp_split);

			String temp2 = rhs.get(i);
			String rhs_temp_split[] = temp2.split(",");
			Set<String> rhs_split = new HashSet<String>();
			Collections.addAll(rhs_split, rhs_temp_split);
                        //System.out.println(lhs_split);

		//	if(key.containsAll(lhs_split) == true && lhs_split.size() != key.size())
		//	{
		//		flag = 1;
		//	}
                          
			if(lhs_split.containsAll(key) == true || key.containsAll(rhs_split) == true)
			{
			     if(temparr[i] == 2)
                             {
                                System.out.println(lhs_split.containsAll(key));
                                System.out.println(key.containsAll(rhs_split));
                                temparr[i] = 3;
                                System.out.println("3nf");
                                System.out.println(key);
                                System.out.println(lhs_split);
                                System.out.println(rhs_split);
                             }

                        }
                        
		}
                
//		return flag;
	}
    public static int getkey(LinkedHashMap<String , Integer> ggma , Set<String> attribute_set , int sizz , ArrayList<String> lhss , ArrayList<String> rhss)// ,Set<String> key)
        {               //getkey(keys , ggma , attribute_set , pp , lhsss , rhsss);
        int x=1;
        int ssss = lhss.size();
        int maxx = sizz+1 , aa =-1 , maxnf =0;
        for(int i=0;i<sizz;i++)
        {
            x*=2;
        }
                        for(int j=0;j<x;j++)
                        {
                            int arr[] = new int[sizz+5];
                            int y=j , k=0 , mm=0;
                            while(y!=0)
                            {
                                if((y&1)==1)
                                {
                                    arr[k]=1;
                                    mm++;
                                }
                                k++;
                                y/=2;
                            }
                            int fl=1;
                            while(fl==1)
                            {
                                fl=0;
                                int Ga=0;
                                for(int i=0; i<ssss; i++)
                                {
                                    String temp = lhss.get(i);
                                    for(int ii=0;ii<temp.length();ii+=2)
                                    {
                                        int xx=temp.charAt(ii)-'0';
                                        if(arr[xx]==0)
                                        {
                                            Ga=1;
                                            break;
                                        }
                                    }
                                    if(Ga==0)
                                    {
                                        String ee = rhss.get(i);
                                        for(int iii=0;iii<ee.length();iii+=2)
                                        {
                                            int xx=ee.charAt(iii)-'0';
                                            if(arr[xx]==0)
                                            {
                                                arr[xx]=1;
                                                fl=1;
                                            }
                                        }
                                    }
                                }
                            }
                            int Ga=0;
                            for(int i=0;i<sizz;i++)
                            {
                                if(arr[i]==0)
                                {
                                    Ga=1;
                                    break;
                                }
                            }
                            if(Ga==0)// && mm<maxx)
                            {
                                System.out.println(j);
    //                            maxx=mm;
    //                            aa=j;
            int kee = j;
            Set<String> checkkey = new HashSet<String>();
            System.out.println(kee);
            int iiiii=0;
            while(kee!=0)
            {
                if((kee&1)==1)
                {
                    for(String test : attribute_set)
                    {
                        if(ggma.get(test) == iiiii)
                        {
                            checkkey.add(test);
                        }
                    }
                }
                iiiii++;
                kee/=2;
            }
            int temparr[] = new int[20];
            for(int i=0;i<ssss ;i++)
            {
                temparr[i] = 1;
            }
            // Checker 
            twonf(temparr, checkkey);
            threenf(temparr ,checkkey);
            bcnf(temparr , checkkey);
            int ma = 4;
            for(int i=0;i<ssss ; i++)
            {
                if(temparr[i] < ma)
                {
                    ma = temparr[i];
                }
            }
            if(ma > maxnf)
            {
                maxx = mm;
                aa = j;
                maxnf = ma;
                for(int i=0;i<ssss ; i++)
                {
                    maxnfindi[i] = temparr[i];
                }
            }
            else if(ma == maxnf)
            {
                if(mm<maxx)
                {
                    maxx = mm;
                    aa = j;
                    for(int i=0;i<ssss ; i++)
                    {
                        maxnfindi[i] = temparr[i];
                    }
                }
            }

                            }
                        } // Main loop ends here

      // Assignmnet idhar karna hai


        System.out.println(maxnf);
        return aa;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel att_label;
    private javax.swing.JTextField att_names;
    private javax.swing.JButton decompose_button;
    private javax.swing.JLabel fd_label;
    private javax.swing.JTextField fds;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output_area;
    private javax.swing.JButton solve_button;
    private javax.swing.JLabel title_Label;
    // End of variables declaration//GEN-END:variables
}
