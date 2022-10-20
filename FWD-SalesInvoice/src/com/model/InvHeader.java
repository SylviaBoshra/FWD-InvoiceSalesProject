/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author G528798
 */
public class InvHeader {
    
    private int invNum;
    private Date invDate;
    private String customerName;
    private ArrayList<InvLine> invLines;
    private Double invTotal; 

    public InvHeader(){}
    public InvHeader(int invNum, Date invDate, String customerName) {
        this.invNum = invNum;
        this.invDate = invDate;
        this.customerName = customerName;
        invLines = new ArrayList<>();
    }
    
    public Double getInvTotalPrice() {
        Double total = 0.0;
        for (int i = 0; i < invLines.size(); i++) {
            InvLine line = invLines.get(i);
            total += line.getItemTotalPrice();
        }
        return total;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvLine> getInvLines() {
        return invLines;
    }
    
    public void AddInvLine(InvLine L) {
        invLines.add(L);
    }
    
    public void updateHeader(InvLine line) {
        invLines.remove(line);
    }
    



}
    
