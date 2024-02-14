package model;

import feature.Transaction;
import java.util.LinkedList;

/**
 *
 * @author Haidir
 */
public class Buyers {
    
    public String nameBuyer;
    public int idBuyer;
    public double buyerPayment;
    public static LinkedList<Transaction> shoppingCart = new LinkedList();
    
    public Buyers(String nameBuyer, int idBuyer, double buyerPayment){
        this.nameBuyer = nameBuyer;
        this.idBuyer = idBuyer;
        this.buyerPayment = buyerPayment;
    }
    
    public double getBuyerPayment(){
        return buyerPayment;
    }
    public void setBuyerPayment(double buyerPayment) {
        this.buyerPayment = buyerPayment;
    }
    
}
