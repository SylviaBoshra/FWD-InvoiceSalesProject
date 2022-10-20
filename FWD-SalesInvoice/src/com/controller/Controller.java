/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.model.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G528798
 */
public class Controller {
    private final ArrayList<InvHeader> invHeaders;
    private final ArrayList<InvLine> invLines;
      
    
    public Controller() {
        
        invHeaders = new ArrayList<>();
        invLines = new ArrayList<>();
    }
    
    //Read invoices header invoices from the file and save them in header array list
    public boolean readCSVHeader(String FilePath) throws IOException
    {   
        InvHeader inv;
        SimpleDateFormat Dformat = new SimpleDateFormat("dd-MM-yyyy");
        String line;  
        String splitBy = ",";
        boolean isCorrectFormat = false;
       
        //parsing a CSV file into BufferedReader class constructor
        BufferedReader br = new BufferedReader(new FileReader(FilePath));
        
        
        while ((line = br.readLine()) != null)  
        {  
            String[] invoice = line.split(splitBy);    // use comma as separator
            try {
                inv = new InvHeader(Integer.parseInt(invoice[0]),Dformat.parse(invoice[1]),invoice[2]);
                invHeaders.add(inv);
                isCorrectFormat =  true;
            } catch (ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
             
        }
        System.out.println("\nInvoice Details after reading Header CSV File");
        printHeaders();
        return isCorrectFormat;
    }
    
    
    //Read invoices lines from the file and save them in header array list
    public void readCSVLines(String FilePath) throws IOException
    {
        
        InvLine invL;
        String line;  
        String splitBy = ",";
        
       
        //parsing a CSV file into BufferedReader class constructor
        BufferedReader br = new BufferedReader(new FileReader(FilePath));
        
        
        while ((line = br.readLine()) != null)  
        {  
            String[] invDetail = line.split(splitBy);    // use comma as separator
            invL = new InvLine(invDetail[1],Double.parseDouble(invDetail[2]),Integer.parseInt(invDetail[3]),invHeaders.get((Integer.parseInt(invDetail[0]))-1));
            invLines.add(invL);
        }
        
        System.out.println("\nInvoice Details after reading Lines CSV File");
        printLines();
       
    }
    
    //Write invoices header in a file
    public void writeCSVHeader(File file)  {
        
        try (FileWriter fw = new FileWriter(file)) {
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat Dformat = new SimpleDateFormat("dd-MM-yyyy");
            
            for(int i=0;i<invHeaders.size();i++)
            {
                bw.write(invHeaders.get(i).getInvNum() + "," + Dformat.format(invHeaders.get(i).getInvDate()) + "," + invHeaders.get(i).getCustomerName());
                bw.newLine();
            }
            bw.close();
            
            System.out.println("\nInvoice Details saved in the Header CSV File");
            printHeaders();
            printLines();
            
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Write invoices lines in a file
    public void writeCSVLines(File file) {
        
        try (FileWriter fw = new FileWriter(file)) {
            BufferedWriter bw = new BufferedWriter(fw);
            
            
            for(int i=0;i<invLines.size();i++)
            {
                bw.write(invLines.get(i).getInvoiceNo() + "," + invLines.get(i).getItemName() + "," + invLines.get(i).getItemPrice() + "," + invLines.get(i).getItemCount());
                bw.newLine();
            }
            bw.close();
            
            System.out.println("\nInvoice Details saved in Lines CSV File");
            printLines();
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //get all headers in the header arraylist
    public ArrayList<InvHeader> getInvHeaders() {
     
        return invHeaders;
    }

    //return all invoices lines from lines arraylist
    public ArrayList<InvLine> getInvLines() {
        
        return invLines;
    }
    
    
    //Delete an invoice line from lines arraylist
    public Double DeleteInvLine(int index) {
        InvLine line =  invLines.get(index);
        int InvNo = line.getInvoiceNo();
        Double total = 0.0;
        //Get the header of the invoice line to re calculate the header total amount
        for(int i=0; i<invHeaders.size(); i++) {
            if(invHeaders.get(i).getInvNum() == InvNo) {
                invHeaders.get(i).updateHeader(line);
                total = invHeaders.get(i).getInvTotalPrice();
            }
        }
        invLines.remove(index);
        
        System.out.println("\nInvoice Details after delete invoice line");
        printHeaders();
        printLines();
        
        return total;
    }
    
    //Get header for specefic invoice number
    public InvHeader getHeader(int invoiceNo)
    {
        
        InvHeader header = new InvHeader();
        for(int i=0; i<invHeaders.size(); i++) {
            if(invHeaders.get(i).getInvNum()== invoiceNo){
                return invHeaders.get(i);
            }
        }
        return header;
    }
    
    //Delete a header with specefic invoice number
    public void DeleteInvHeader(int invoiceNo) {
        
        
        //Search for all invoice lines with specefic invoice number to be deleted
        for(int i=0; i<invLines.size(); i++) {
            if(invLines.get(i).getInvoiceNo() == invoiceNo){
                invLines.remove(i);
                i--;
            }
        }
        
        //Search for the invoice header with specefic invoice number to be deleted
        for(int i=0; i<invHeaders.size(); i++) {
            if(invHeaders.get(i).getInvNum()== invoiceNo){
                invHeaders.remove(i);
                i--;
            }
        }
        
        System.out.println("\nInvoice Details after delete invoice header");
        printHeaders();
        printLines();
      }
    
    //Get the next invoice number to be added
    public int getnextInvNum() {
        
        if(invHeaders.isEmpty())
            return 1;
        return invHeaders.get(invHeaders.size()-1).getInvNum() + 1;
    }
    
    //add new header with specefic data to the header array list
    // return true if the date format is correct
    // return false if the date format in incorrect
    public boolean addHeader(int number, String date, String customer){
        
        SimpleDateFormat Dformat = new SimpleDateFormat("dd-MM-yyyy");
        InvHeader newHeader;
        boolean correctDateFormat;
        try {
            newHeader = new InvHeader(number,Dformat.parse(date),customer);
            invHeaders.add(newHeader);
            correctDateFormat = true;
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            correctDateFormat = false;
        }  
        
        
        System.out.println("\nInvoice Details after add new invoice header");
        printHeaders();
        printLines();
        
        return correctDateFormat;
    }
    
    //add new invoice line
    public void addLine (InvLine line) {
        invLines.add(line);
        
        System.out.println("\nInvoice Details after add invoice line");
        printHeaders();
        printLines();
    }
    
    public Double GetHeaderTotal(int InvNo) {
        //Get the total amount for a header with specefic invoice number
        Double total = 0.0;
        for(int i=0; i<invHeaders.size(); i++) {
            if(invHeaders.get(i).getInvNum() == InvNo) {
                total = invHeaders.get(i).getInvTotalPrice();
                break;
            }
        }
        return total;
    }
   
    
    //Get array of all invoice numnbers
    public String[] getInvoiceNo () {
        String[] InvNumbers = new String[invHeaders.size()];
        
        for(int i=0; i<invHeaders.size(); i++) {
            InvNumbers[i] = String.valueOf(invHeaders.get(i).getInvNum());
        }
        return InvNumbers;
    }
    
    //Print the data of the headers saved in the array list
    public void printHeaders() {
        System.out.println("Invoice Headers Details:");
             
        for(int i=0; i<invHeaders.size(); i++) {
            System.out.println("Invoice No " + invHeaders.get(i).getInvNum() + " Customer no " + invHeaders.get(i).getCustomerName() + " Date "
            + invHeaders.get(i).getInvDate() + " total " + invHeaders.get(i).getInvTotalPrice());
        }
    }
        //Print the data of the lines saved in the array lis
        public void printLines() {
        System.out.println("Invoice Lines Details:");
        
        for(int i=0; i<invLines.size(); i++) {
            System.out.println("Invoice No " + invLines.get(i).getInvoiceNo() + " item name " + invLines.get(i).getItemName()
            + " item price " + invLines.get(i).getItemPrice() + " item count " + invLines.get(i).getItemCount()
            + " item total " + invLines.get(i).getItemTotalPrice());
        }
        
        }
    
    
    
    }
