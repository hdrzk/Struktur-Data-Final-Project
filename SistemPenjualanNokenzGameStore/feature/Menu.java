
package feature;

import model.Buyers;
import java.util.Scanner;
import resource.Style;
public class Menu {
    
    
    static CategoryGame cg = new CategoryGame();
    static String name;
    static int choose;
    static double buyerPayment;
    static boolean exitMenu = false;
    
public static void menuAwal() {
    Scanner sc = new Scanner(System.in);
    while(!exitMenu) {
        System.out.println("+----------------------------------------------+");
        Style.sTextColorln("|                 Nokenz Game                  |", Style.CYAN);
        System.out.println("+----------------------------------------------+");
        System.out.println("| 1. Buy the Game!                             |");
        System.out.println("| 2. Check Cart                                |");
        System.out.println("| 3. View Transaction History                  |");
        System.out.println("| 4. Search Game Sold                          |");
        System.out.println("+----------------------------------------------+");
        System.out.println("| 0. Exit                                      |");
        System.out.println("+----------------------------------------------+");
        Style.sTextColorln(" Notes* Pastikan anda membeli game yang \nsesuai dengan spec PC atau Laptop kamu ya!    ", Style.YELLOW);
        System.out.println("");

        System.out.print("Choose option: ");
        int option = sc.nextInt();
        
        switch (option) {
            case 1:
                Menu.menuKategori();
                break;
            case 2:
                CartShop.showSelectedGames();
                break;
            case 3:
                Transaction.History();
                break;
            case 4:
                Transaction.SearchGameSoldMenu();
                break;
            case 0:
                System.out.println("");
                Style.sTextColorln("Terima kasih atas pembelian Anda!\nSampai jumpa dan terima kasih atas kunjungannya!", Style.GREEN);
                exitMenu = true;
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
                break;
        }
    }
}




    
    public static void menuKategori() {
        Scanner sc = new Scanner(System.in);
        Buyers by = new Buyers(name, choose, buyerPayment);
        System.out.println("+----------------------------------------------+");
        System.out.println("|                Game Categories               |");
        System.out.println("+----------------------------------------------+");
        System.out.println("| 1. Adventure                                 |");
        System.out.println("| 2. Action                                    |");
        System.out.println("| 3. Simulation                                |");
        System.out.println("| 4. Sports                                    |");
        System.out.println("| 5. RPG                                       |");
        System.out.println("+----------------------------------------------+");  
        System.out.println("| 0. Kembali                                   |");
        System.out.println("+----------------------------------------------+");

        System.out.print("Choose Option : ");
        choose = sc.nextInt();

        System.out.println("");
        
        switch (choose) {
            case 1 : 
                cg.menuAdventure("Adventure", by);
                break;
            case 2 : 
                cg.menuAction("Action", by);
                break;
            case 3 : 
                cg.menuSimulation("Simulation", by);
                break;
            case 4 : 
                cg.menuSports("Sports", by);
                break;
            case 5 : 
                cg.menuRpg("RPG", by);
                break;
            case 0 :
                Menu.menuAwal();
                break;
            default :
                Style.sTextColorln("Maaf Kategori yang anda pilih tidak ada\n, silahkan coba lagi",Style.RED);
                break;
        }
    }
    }



