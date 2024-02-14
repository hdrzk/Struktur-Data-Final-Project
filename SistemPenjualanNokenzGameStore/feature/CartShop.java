package feature;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;
import model.Buyers;
import model.GameRecord;
import resource.Style;

/**
 *
 * @author Haidir
 */
public class CartShop {
    
    public static void addToShoppingCart(Buyers buyers, GameRecord game) {
        Transaction transaction = new Transaction(game.categoryGame, game.nameGame, game.priceGame, buyers.nameBuyer, buyers.idBuyer, buyers.buyerPayment);
        Buyers.shoppingCart.add(transaction);
        System.out.println("");
        Style.sTextColorln("Ditambahkan ke keranjang Anda: \n" + game.nameGame + " | " + game.priceGame + "k",Style.GREEN );
        System.out.println("");
    }
    
    
public static void showSelectedGames() {
  
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setCurrency(Currency.getInstance("IDR"));

        if (Buyers.shoppingCart.isEmpty()) {
            System.out.println("");
            Style.sTextColorln("Oops Keranjang mu kosong!!", Style.RED);
            Style.sTextColorln("Silahkan memilih game terlebih dahulu", Style.RED);
            System.out.println("");
            Menu.menuAwal();
            return;
        }
        
        System.out.println("");
        System.out.println("Keranjang Belanja mu saat ini :");
        int index = 1;
        double tGamePrice = 0;
        for (Transaction game : Buyers.shoppingCart) {
                    System.out.println("---------------------------------------------");
            System.out.println(index + ". Nama Game          : " + game.getNameGame());
                   System.out.println("   Harga Game         : " + game.getPriceGame() + "K");
            tGamePrice += game.getPriceGame();
            index++;
        }

                    System.out.println("---------------------------------------------");
                    System.out.println("Total Harga Belanjaan : " + currencyFormat.format(tGamePrice));
                    System.out.println("---------------------------------------------");
                    System.out.println("");


        System.out.println("Silakan pilih tindakan yang ingin Anda lakukan:");
        System.out.println("1. Hapus game dari keranjang");
        System.out.println("2. Tambahkan game lain");
        System.out.println("3. Proses Transaksi");
        System.out.println("0. Kembali ke menu utama");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan pilihan Anda: ");
        int choice = scanner.nextInt();
        switch (choice) {
           case 1:
                System.out.println("Masukkan nomor game yang ingin dihapus:");
                int removeChoice = scanner.nextInt();
                removeFromShoppingCart(removeChoice - 1);
                showSelectedGames();
                break;
            case 2:
                System.out.println("");
                Menu.menuKategori();
                break;
            case 3:
                System.out.println("");
                Transaction.processTransaction();
                break;
            case 0:
                System.out.println("");
                Menu.menuAwal();
                break;
            default:
                Style.sTextColorln("Pilihan tidak valid.", Style.RED);
                break;
        }
}





public static void removeFromShoppingCart(int index) {
    System.out.println("");
    if (index >= 0 && index < Buyers.shoppingCart.size()) {
        Transaction removedGame = Buyers.shoppingCart.remove(index);
        Style.sTextColorln("Game " + removedGame.getNameGame() + " dihapus dari keranjang belanja.", Style.RED);
        System.out.println("");
    } else {
        Style.sTextColorln("Nomor game tidak valid.", Style.RED);
        return; 
    }
}


}
