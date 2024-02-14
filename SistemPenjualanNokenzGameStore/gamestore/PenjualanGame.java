package gamestore;

import model.Buyers;
import feature.Menu;
import java.util.LinkedList;
import resource.Style;
import java.util.Scanner;
public class PenjualanGame {
    
    static Scanner sc = new Scanner(System.in);
    public  static LinkedList<Buyers> buyers = new LinkedList<>();
    double buyerPayment;
    
    public static void main(String[] args) {
        PenjualanGame pg = new PenjualanGame();
        pg.Registration();
    }
    
    private void Registration() {
        Style.sTextColor("=== Selamat Datang di NokenzGame, Portal Penuh Petualangan! ===",Style.BOLD, Style.CYAN);
        System.out.println("");
      System.out.println("       Masukkan Nama dan ID, Untuk memulai Petualangan!!");
        System.out.println("");
        
        String nameBuyer;
        int idBuyer = 0;

        do {
            System.out.print("Masukkan Nama Anda: ");
            nameBuyer = sc.nextLine().trim();

            
            if (nameBuyer.matches(".*\\d.*")) {
                System.out.println("\nNama tidak boleh mengandung angka. Silakan masukkan nama tanpa angka.\n");
                continue;
            }

            System.out.print("Masukkan ID Anda: ");
            while (!sc.hasNextInt()) {
                System.out.println("\nID harus berupa angka. Silakan masukkan ID dengan benar.\n");
                System.out.print("Masukkan ID Anda: ");
                sc.next();
            }
            idBuyer = sc.nextInt();

            
            if (idBuyer <= 0) {
                System.out.println("\nID harus lebih besar dari 0.");
            }
            sc.nextLine(); 
        } while (nameBuyer.matches(".*\\d.*") || idBuyer <= 0);
        System.out.println("");

        System.out.println("--------------------------------------");
        System.out.println("\nNama dan ID :");
        System.out.println("Nama: " + nameBuyer);
        System.out.println("ID: " + idBuyer);
   
    Buyers newBuyers = new Buyers(nameBuyer, idBuyer, buyerPayment);
    buyers.add(newBuyers);
        
        System.out.println("");
        Style.sTextColor("=====================> Herzlich willkommen <===================", Style.CYAN, Style.BOLD);
        System.out.println("");
      System.out.println("     === Berhasil Masuk! Selamat berpetualang, " + nameBuyer + " ===");
      Style.sTextColorln("                         HAPPY SHOPPING!!", Style.GREEN); 
        System.out.println("");
        Menu.menuAwal();
    }    
}


        