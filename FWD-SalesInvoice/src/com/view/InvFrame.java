/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;
import com.controller.*;
import com.model.InvHeader;
import com.model.InvLine;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author G528798
 */
public class InvFrame extends javax.swing.JFrame {
    Controller c;
    DefaultTableModel headerModel;
    DefaultTableModel linesModel;
    /**
     * Creates new form InvFrame
     */
    public InvFrame() {
        c = new Controller();
        initComponents();
        
        //All buttons are enables except Save and delete, they will be enabled after any change in the tables
        CreateInvBtn.setEnabled(true);
        DeleteInvBtn.setEnabled(true); 
        AddInvLineBtn.setEnabled(true); 
        DeleteInvLineBtn.setEnabled(true); 
        SaveInvBtn.setEnabled(false);    
        CancelInvBtn.setEnabled(false);
        
        //Header Table model
        headerModel = (DefaultTableModel) InvHeaderTable.getModel();
        //Lines Table Model
        linesModel = (DefaultTableModel) InvLinesTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreateInvBtn = new javax.swing.JButton();
        DeleteInvBtn = new javax.swing.JButton();
        AddInvLineBtn = new javax.swing.JButton();
        DeleteInvLineBtn = new javax.swing.JButton();
        SaveInvBtn = new javax.swing.JButton();
        CancelInvBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvHeaderTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invNoTxt = new javax.swing.JTextField();
        invDateTxt = new javax.swing.JTextField();
        invCustNameTxt = new javax.swing.JTextField();
        invTotalTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvLinesTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadItem = new javax.swing.JMenuItem();
        SaveItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        CreateInvBtn.setText("Create new Invoice");
        CreateInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateInvBtnActionPerformed(evt);
            }
        });

        DeleteInvBtn.setText("Delete Invoice");
        DeleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteInvBtnActionPerformed(evt);
            }
        });

        AddInvLineBtn.setText("Add");
        AddInvLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInvLineBtnActionPerformed(evt);
            }
        });

        DeleteInvLineBtn.setText("Delete");
        DeleteInvLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteInvLineBtnActionPerformed(evt);
            }
        });

        SaveInvBtn.setText("Save");
        SaveInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveInvBtnActionPerformed(evt);
            }
        });

        CancelInvBtn.setText("Cancel");
        CancelInvBtn.setPreferredSize(new java.awt.Dimension(75, 23));
        CancelInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelInvBtnActionPerformed(evt);
            }
        });

        InvHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Date", "Customer", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvHeaderTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                InvHeaderTableComponentRemoved(evt);
            }
        });
        jScrollPane1.setViewportView(InvHeaderTable);
        if (InvHeaderTable.getColumnModel().getColumnCount() > 0) {
            InvHeaderTable.getColumnModel().getColumn(0).setResizable(false);
            InvHeaderTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Invoice Number ");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("InvoiceTotal");

        invNoTxt.setEditable(false);
        invNoTxt.setEnabled(false);
        invNoTxt.setOpaque(false);

        invDateTxt.setEditable(false);
        invDateTxt.setEnabled(false);
        invDateTxt.setOpaque(false);
        invDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invDateTxtActionPerformed(evt);
            }
        });

        invCustNameTxt.setEditable(false);
        invCustNameTxt.setEnabled(false);

        invTotalTxt.setEditable(false);
        invTotalTxt.setEnabled(false);
        invTotalTxt.setOpaque(false);

        InvLinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvLinesTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                InvLinesTableComponentRemoved(evt);
            }
        });
        InvLinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvLinesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(InvLinesTable);
        if (InvLinesTable.getColumnModel().getColumnCount() > 0) {
            InvLinesTable.getColumnModel().getColumn(0).setResizable(false);
            InvLinesTable.getColumnModel().getColumn(1).setResizable(false);
            InvLinesTable.getColumnModel().getColumn(2).setResizable(false);
            InvLinesTable.getColumnModel().getColumn(3).setResizable(false);
            InvLinesTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel5.setText("Invoice Header");

        jLabel6.setText("Invoice Lines");

        jMenu1.setText("File");

        LoadItem.setText("Load");
        LoadItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadItemActionPerformed(evt);
            }
        });
        jMenu1.add(LoadItem);

        SaveItem.setText("Save");
        SaveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveItemActionPerformed(evt);
            }
        });
        jMenu1.add(SaveItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(CreateInvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SaveInvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeleteInvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(invNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(invCustNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CancelInvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(AddInvLineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DeleteInvLineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invCustNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddInvLineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteInvLineBtn))
                    .addComponent(DeleteInvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreateInvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveInvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelInvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invDateTxtActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_invDateTxtActionPerformed

    private void LoadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadItemActionPerformed
        System.out.println("USer click on Load");
        c = new Controller();
        boolean correctFile = chooseFile(c,true);
        //Id data in the header file in correct format, system open dialog to choose the lines csv file
        if (correctFile)
            chooseFile(c,false);
        
       //load invoice header data
       LoadInvHeader(c.getInvHeaders());
       //Load invoice Lines data
       LoadInvLines(c.getInvLines());
    }//GEN-LAST:event_LoadItemActionPerformed

    private void InvLinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvLinesTableMouseClicked
        //Get the row index
         int index = InvLinesTable.getSelectedRow();
         TableModel model = InvLinesTable.getModel();
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         
         System.out.println("User click on Invoice Lines table, row number:" + index);
     
         //Get invoice number of the selected line
         int invNo = Integer.parseInt(model.getValueAt(index, 0).toString());
         //Get the header of the invoice line
         InvHeader header = c.getHeader(invNo);
         //Get data for the header
         String date =  dateFormat.format(header.getInvDate());
         String Cust = header.getCustomerName();
         Double total = header.getInvTotalPrice();
         
         //Display the data in the text fields
         invNoTxt.setText(Integer.toString(invNo));
         invDateTxt.setText(date);
         invCustNameTxt.setText(Cust);
         invTotalTxt.setText(Double.toString(total));
    }//GEN-LAST:event_InvLinesTableMouseClicked

    private void DeleteInvLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteInvLineBtnActionPerformed
        //Get index of the selected row
        int index = InvLinesTable.getSelectedRow();
        if(index == -1)
        {
            JOptionPane.showMessageDialog(null, "please select invoice line to delete","Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        System.out.println("User click on Delete Invoice Line button");
        //Get invopice number of the selected invoice line
        int invoiceNo = (Integer) linesModel.getValueAt(index, 0);
        //remove the line from the table
        linesModel.removeRow(index);
        //Delete the invoice line from the array list and calculate the total amount for the invoice header
        Double total = c.DeleteInvLine(index);
        //update the header total amout
        updateHeaderTotalTable(invoiceNo,total);
        
        //Clear data displayed in the text field for the deleted line
        invNoTxt.setText("");
        invDateTxt.setText("");
        invCustNameTxt.setText("");
        invTotalTxt.setText("");
    }//GEN-LAST:event_DeleteInvLineBtnActionPerformed

    
    
    public void updateHeaderTotalTable (int invoiceNo, Double total){
        //update the header total amount 
        for(int i=0; i<headerModel.getRowCount(); i++)
        {
            if((Integer) headerModel.getValueAt(i, 0) == invoiceNo)
            {
                headerModel.setValueAt(total, i , 3);
                break;
            }
        }
    }
    private void DeleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteInvBtnActionPerformed
        // Get selected row fromk the invoice header table
        int row_index = InvHeaderTable.getSelectedRow();
        if(row_index == -1) {
            JOptionPane.showMessageDialog(null, "please select invoice header to delete","Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        System.out.println("User click on delete invoice header button");    
        //Get invoice number for the selected header row
        int invNo = (Integer) headerModel.getValueAt(row_index, 0);
        //Delete the selected header from the arraylist
        c.DeleteInvHeader(invNo);
        //Delete the selected header from the table
        headerModel.removeRow(row_index);
        //Delete all invoice lines related to the deleted invoice header
        for(int i=0; i< linesModel.getRowCount();i++) {
            if((Integer) linesModel.getValueAt(i,0) == invNo) {
                linesModel.removeRow(i);
                i--;
            }   
        }
        
    
    }//GEN-LAST:event_DeleteInvBtnActionPerformed

    private void SaveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveItemActionPerformed
        // Call save file function for invoice header
        System.out.println("USer click on Save button to save the file in csv file");
        saveFile(true);
        // Call save file function for invoice lines
        saveFile(false);
    }//GEN-LAST:event_SaveItemActionPerformed

    private void CreateInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateInvBtnActionPerformed
        // New frame will be opened to add new invoice header
        System.out.println("USer click on Create invoice button");
        NewInvFrame Addinv = new NewInvFrame(this,c);
        //Set the frame visible
        Addinv.setVisible(true);
        
    }//GEN-LAST:event_CreateInvBtnActionPerformed

    private void AddInvLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInvLineBtnActionPerformed
        // New frame will be opened to add new invoice lines
        
        System.out.println("USer click on create invoice line button");
        NewLineFrame AddLine = new NewLineFrame (this,c);
        //Set the frame visible
        AddLine.setVisible(true);
    }//GEN-LAST:event_AddInvLineBtnActionPerformed

    private void CancelInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelInvBtnActionPerformed
        // Cancel any edit done in the invoice lines and invoice header table
        
        System.out.println("USer click on cancel button");
        //Load the invoice header again from the array list
        LoadInvHeader(c.getInvHeaders());
        //Load the invoice lines  again from the array list
        LoadInvLines(c.getInvLines());
        
        //All buttons are enables except Save and delete, they will be enabled after any change in the tables
        CreateInvBtn.setEnabled(true);
        DeleteInvBtn.setEnabled(true); 
        AddInvLineBtn.setEnabled(true); 
        DeleteInvLineBtn.setEnabled(true); 
        SaveInvBtn.setEnabled(false);    
        CancelInvBtn.setEnabled(false);
        
    }//GEN-LAST:event_CancelInvBtnActionPerformed

    private void SaveInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveInvBtnActionPerformed
        // Save all changes done in the uinvoice header and invoice lines table
        System.out.println("USer click on Save button to save changes");
        Controller tempController = new Controller();
        
        //Save Invoice Header
        for(int i=0; i< headerModel.getRowCount();i++) {
            tempController.addHeader(Integer.parseInt(headerModel.getValueAt(i, 0).toString()), headerModel.getValueAt(i, 1).toString(), headerModel.getValueAt(i, 2).toString());
            
        }
        //Save invoice Lines
        for(int i=0; i< linesModel.getRowCount();i++) {
            int invNo = Integer.parseInt(linesModel.getValueAt(i, 0).toString());
            InvHeader header = tempController.getHeader(invNo);
            InvLine line = new InvLine (linesModel.getValueAt(i, 1).toString() , Double.parseDouble(linesModel.getValueAt(i, 2).toString()) , Integer.parseInt(linesModel.getValueAt(i, 3).toString()) ,header);
            tempController.addLine(line);
            
            //All buttons are enables except Save and delete, they will be enabled after any change in the tables
            CreateInvBtn.setEnabled(true);
            DeleteInvBtn.setEnabled(true); 
            AddInvLineBtn.setEnabled(true); 
            DeleteInvLineBtn.setEnabled(true); 
            SaveInvBtn.setEnabled(false);    
            CancelInvBtn.setEnabled(false);            
        }
        //Set Controller to temp controller to save all changes
        c = tempController;
        
    }//GEN-LAST:event_SaveInvBtnActionPerformed

    private void InvLinesTableComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_InvLinesTableComponentRemoved
        // When any change done in invoice lines table
        Double totalLine;
        int invNo;
        Double HeaderTotal;
        int SelectedRow = InvLinesTable.getSelectedRow();
        int SelectedColumn = InvLinesTable.getSelectedColumn();
        System.out.println("User make changes in invoice lines table");
        //When any change done in item price and count, it will affect invoice line total amount and invoice header total amount
        if(SelectedColumn == 2 || InvLinesTable.getSelectedColumn() == 3)
        {
            totalLine = Double.parseDouble(linesModel.getValueAt(SelectedRow, 2).toString()) * Integer.parseInt(linesModel.getValueAt(SelectedRow, 3).toString());
            linesModel.setValueAt(totalLine, SelectedRow, 4);
            invNo = Integer.parseInt(linesModel.getValueAt(SelectedRow, 0).toString());
            HeaderTotal = calcTotal(invNo);
            //total = c.GetHeaderTotal(InvLinesTable.getValueAt(SelectedRow, total));
            updateHeaderTotalTable(invNo, HeaderTotal);
        }
        
        CreateInvBtn.setEnabled(false);
        DeleteInvBtn.setEnabled(false); 
        AddInvLineBtn.setEnabled(false); 
        DeleteInvLineBtn.setEnabled(false); 
        SaveInvBtn.setEnabled(true);    
        CancelInvBtn.setEnabled(true); 
            
    }//GEN-LAST:event_InvLinesTableComponentRemoved

    private void InvHeaderTableComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_InvHeaderTableComponentRemoved
        // User make changes in Invoice header table
        
        System.out.println("User make changes in invoice header table");
        CreateInvBtn.setEnabled(false);
        DeleteInvBtn.setEnabled(false); 
        AddInvLineBtn.setEnabled(false); 
        DeleteInvLineBtn.setEnabled(false); 
        SaveInvBtn.setEnabled(true);    
        CancelInvBtn.setEnabled(true); 
    }//GEN-LAST:event_InvHeaderTableComponentRemoved

    private Double calcTotal(int invNo) {
        Double total = 0.0;
        //Calculate the total amount for invoice by calculating the total for each item for specefic invoice number
        
        for(int i=0; i<InvLinesTable.getRowCount(); i++)
        {
            if( Integer.parseInt(linesModel.getValueAt(i, 0).toString()) == invNo)
            {
                total += Double.parseDouble(linesModel.getValueAt(i, 4).toString());
            }
        }
        
        return total;
    }
    private boolean chooseFile(Controller c, Boolean isHeader){
        
        java.io.File f;
        //Pop up for choose a file
        JFileChooser InvFile = new JFileChooser();
        //Option for all files will not be displyed
        InvFile.setAcceptAllFileFilterUsed(false);
        //USer can select only CSV Files
        InvFile.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
        //Load headers file
        if(isHeader)
        {
            InvFile.setDialogTitle("Load invoice header file");
        }
        //Load lines file
        else
        {
            InvFile.setDialogTitle("Load invoice lines file"); 
        }
        //User cannot select more than 1 file
        InvFile.setMultiSelectionEnabled(false);
        InvFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        InvFile.setFileHidingEnabled(false);
        if (InvFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            f = InvFile.getSelectedFile();
            
            try {
                //Read the selected CSV file
                if(isHeader) {
                    if (!c.readCSVHeader(f.getPath()))
                    {
                        
                        System.out.println("After checking elected header file: Date format is not dd-mm-yyyy ");
                        JOptionPane.showMessageDialog(null, "Date Format is not correct, it should be dd-mm-yyyy","Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    System.out.println("System read the header CSV file successfully");
                }
                else{
                    c.readCSVLines(f.getPath());
                    System.out.println("System read the Lines CSV file successfully");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(InvFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return true;
    }
    
    //Function to save changes done in the invoice header table and invoice lines table
    private void saveFile(Boolean isHeader) {
        
        JFrame parentFrame = new JFrame();
        //file chooser pop up to save the file
        JFileChooser fileChooser = new JFileChooser();
        //Option for all files will not be displyed
        fileChooser.setAcceptAllFileFilterUsed(false);
        //USer can save only CSV Files
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
        //to save the header file
        if(isHeader)
        {
            fileChooser.setDialogTitle("Save invoice header file");
        }
        //to save the lines file
        else
        {
            fileChooser.setDialogTitle("Save invoice lines file"); 
        }
        
        int userSelection = fileChooser.showSaveDialog(parentFrame);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if(isHeader)
            {
                //Start writing the invoice header data in the file
                c.writeCSVHeader(fileToSave);
            }
            else
            {      
                //Start writing the invoice lines data in the file
                c.writeCSVLines(fileToSave);
            }
        }
        
    }
    
    public void LoadInvHeader(ArrayList<InvHeader> Headers) {
        //Load the invlice header table from the arraylist
        headerModel.setRowCount(0);
        Object rowData[] = new Object[4];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (int i=0; i< Headers.size(); i++) {
            rowData[0] = Headers.get(i).getInvNum();
            rowData[1] = dateFormat.format(Headers.get(i).getInvDate());
            rowData[2] = Headers.get(i).getCustomerName();
            rowData[3] = Headers.get(i).getInvTotalPrice();
            headerModel.addRow(rowData);
        }
    }
    
    public void LoadInvLines(ArrayList<InvLine> Lines) {
        //Load the invlice lines table from the arraylist
        linesModel.setRowCount(0);
        Object rowData[] = new Object[5];
        for (int i=0; i< Lines.size(); i++) {
            rowData[0] = Lines.get(i).getInvoiceNo();
            rowData[1] = Lines.get(i).getItemName();
            rowData[2] = Lines.get(i).getItemPrice();
            rowData[3] = Lines.get(i).getItemCount();
            rowData[4] = Lines.get(i).getItemTotalPrice();
            linesModel.addRow(rowData);
        }
        
    }
    
    
    
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
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddInvLineBtn;
    private javax.swing.JButton CancelInvBtn;
    private javax.swing.JButton CreateInvBtn;
    private javax.swing.JButton DeleteInvBtn;
    private javax.swing.JButton DeleteInvLineBtn;
    private javax.swing.JTable InvHeaderTable;
    private javax.swing.JTable InvLinesTable;
    private javax.swing.JMenuItem LoadItem;
    private javax.swing.JButton SaveInvBtn;
    private javax.swing.JMenuItem SaveItem;
    private javax.swing.JTextField invCustNameTxt;
    private javax.swing.JTextField invDateTxt;
    private javax.swing.JTextField invNoTxt;
    private javax.swing.JTextField invTotalTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
