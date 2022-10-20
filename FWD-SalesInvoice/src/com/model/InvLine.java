/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author G528798
 */
public class InvLine {
    
    private String itemName;
    private Double itemPrice;
    private int itemCount;
    private InvHeader invoice;

    public InvLine(){}
    
    public InvLine(String itemName, Double itemPrice, int itemCount, InvHeader invoice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        
        this.invoice = invoice;
        this.invoice.AddInvLine(this);
        
    }
    
    public Double getItemTotalPrice() {
        return itemCount * itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public InvHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvHeader invoice) {
        this.invoice = invoice;
    }


    public int getInvoiceNo() {
        return invoice.getInvNum();
    }
    

    
}
