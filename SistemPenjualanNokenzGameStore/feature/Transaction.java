package feature;



import model.Buyers;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TreeSet;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import resource.Style;
import static gamestore.PenjualanGame.buyers;
/**
 *
 * @author Asep
 */
public  class Transaction {
    
    static Scanner sc = new Scanner(System.in);
    static LocalDateTime ts = LocalDateTime.now();
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
    static String formattedDateTime = ts.format(dateTimeFormatter);
    
    public String categoryGame;
    public String nameGame;
    public int priceGame;
    public String nameBuyer;
    public int idBuyer;
    public double buyerPayment;
    
    
    public Transaction (String categoryGame, String nameGame, int priceGame, String nameBuyer, int idBuyer, double buyerPayment) {
        this.categoryGame = categoryGame;
        this.nameGame = nameGame;
        this.priceGame = priceGame;
        this.nameBuyer = nameBuyer;
        this.idBuyer = idBuyer;
       this.buyerPayment = buyerPayment;
       
    }
        public String getNameBuyer() {
        return nameBuyer;
    }

    public int getIdBuyer() {
        return idBuyer;
    }
    
    public String getNameGame(){
        return nameGame; 
    }
    public int getPriceGame(){
        return priceGame; 
    }
    public double getBuyerPayment(){
        return buyerPayment;
    }
    public void setBuyerPayment(double buyerPayment) {
        this.buyerPayment = buyerPayment;
    }
    
    
     
 //  START OF RECEIPT ==================================================================================================================>>>
public static void processTransaction() {
    
           if(buyers.isEmpty()) {
               System.out.println("Tidak ada transaksi untuk diproses saat ini.");
               System.out.println("Silahkan memilih game terlebih dahulu.");
               Menu.menuAwal();
           }
        for(Buyers currentBuyer : buyers) {
            
            System.out.println("");
            System.out.println("                        +================+");
            System.out.println("                        |Proses transaksi|");
            System.out.println("                        +================+");
            System.out.println("");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Pembeli, " + currentBuyer.nameBuyer + " (ID: " + currentBuyer.idBuyer + ")");
            System.out.println("");
            System.out.println("Items :");

            if (currentBuyer.shoppingCart.isEmpty()) {
                System.out.println("Tidak ada transaksi untuk diproses saat ini.");
                System.out.println("");
                Menu.menuAwal();
                continue; 
            }

            List<Transaction> currentTransaction = new LinkedList<>();
            TreeSet<String> uqNameGame = new TreeSet<>();
            
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            currencyFormat.setCurrency(Currency.getInstance("IDR"));
            
            double total = 0;
            int gameN = 1;
            int index = gameN;
            for (Transaction transaction : currentBuyer.shoppingCart) {
                String nameGame = transaction.getNameGame();
                System.out.println("Game " + (index++) + ": " + transaction.getNameGame() + " | Harga: " + transaction.getPriceGame() + "k");

                // Check Game yang ganda
                uqNameGame.add(nameGame);

                total += transaction.getPriceGame();
                currentTransaction.add(transaction);
            }
            
            String formattedTotal = currencyFormat.format(total);

            System.out.println("");
            System.out.println("Total Pembelian                      : " + formattedTotal);
            System.out.println("--------------------------------------------------------------------");

            double discountGame = (uqNameGame.size() >= 3) ? 0.75 : 0.5;
            double discountAmount = total * discountGame;
            double discountTotal = total - discountAmount;
            
            String formattedDTotal = currencyFormat.format(discountTotal);

            if (uqNameGame.size() >= 2) {
                Style.sTextColorln("Congratz you got Diskon              : " + (discountGame * 100) + "%", Style.GREEN);
                System.out.println("Total Setelah Diskon                 : " + formattedDTotal);
            }

            double payment = 0;
            
            do {
                System.out.println("--------------------------------------------------------------------");
                System.out.print("Masukkan jumlah uang yang dibayarkan : ");
                payment = sc.nextDouble();

                if (payment < discountTotal) {
                    System.out.println("Maaf, jumlah pembayaran kurang. Silakan masukkan jumlah yang mencukupi.");
                }
            } while (payment < discountTotal);

            double change = payment - discountTotal;
            String formattedC = currencyFormat.format(change);
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Uang kembalian                       : " + formattedC);
            System.out.println("--------------------------------------------------------------------");
            currentBuyer.setBuyerPayment(payment);

            // Menampilkan riwayat transaksi setelah loop selesai
            Transaction.addTransaction(currentTransaction, currentBuyer.nameBuyer, currentBuyer.idBuyer, currentBuyer.buyerPayment);

            // Cetak struk
            printReceipt(currentBuyer, currentTransaction, payment);
        };
           
}
//  END OF TRANSACTION ==================================================================================================================>>>


   //  START OF RECEIPT ==================================================================================================================>>>
    public static  void printReceipt(Buyers buyers, List<Transaction> currentTransaction, double payment) {
        List<Transaction> currentTransactions = currentTransaction;
        TreeSet<String> uqNameGame = new TreeSet<>();
        
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setCurrency(Currency.getInstance("IDR"));
        
    System.out.println("\n================ NOKEN RECEIPT ===============");
    System.out.println("                      TODAY");
    System.out.println("ORDER FOR " + buyers.nameBuyer + " (ID: " + buyers.idBuyer + ")");
    System.out.println(formattedDateTime);
    System.out.println("-------------------------------------------------");
    
        int numberOfGames = currentTransaction.size();
            for (Transaction transaction : currentTransaction) {
                System.out.println("Game: " + transaction.getNameGame() + " | Harga: " + transaction.getPriceGame() + "k");
                System.out.println("-------------------------------------------------");
                uqNameGame.add(transaction.getNameGame());
            }
            
            double total = 0;
            for (Transaction transaction : currentTransactions) {
                total += transaction.getPriceGame();
            }
            
            String formattedTotal = currencyFormat.format(total);
            
    System.out.println("Jumlah Game yang Dibeli     : " + numberOfGames);
    System.out.println("Total Pembelian             : " + formattedTotal);
    
            double discountGame = (uqNameGame.size() >= 3) ? 0.75 : 0.5;
            double discountAmount = total * discountGame;
            double discountTotal = total - discountAmount;
            
            String formattedDTotal = currencyFormat.format(discountTotal);
            
        if (discountGame >= 0.5 ) {
    System.out.println("Diskon                      : " + (discountGame * 100) + "%");
    System.out.println("Total Setelah Diskon        : " + formattedDTotal);
        }
        
            
            String formattedPay = currencyFormat.format(payment);
            
            double change = payment - discountTotal;
            String formattedC = currencyFormat.format(change);
            

    System.out.println("-------------------------------------------------");
    System.out.println("Jumlah Uang yang Dibayarkan : " + formattedPay );
    System.out.println("Uang Kembalian              : " + formattedC );
    System.out.println("-------------------------------------------------");
    System.out.println("BANK CARD                   : **** **** **** 2231");
    System.out.println("APPROVAL CODE               : #24434");
    System.out.println("-------------------------------------------------");
    Style.sTextColorln("               THANKS FOR VISITING!", Style.GREEN);
    Style.sTextColorln("                 ENJOY YOUR GAME!", Style.GREEN);
    System.out.println("===============================================\n");
            Menu.menuAwal();
    }
    //  END OF RECEIPT ==================================================================================================================>>>
     
    
    // START OF TRANSACTION HISTORY ==================================================================================================================>>>
    public static List<List<Transaction>> transactionHistory = new ArrayList<>();
    
    public static void addTransaction(List<Transaction> transaction, String nameBuyer, int idBuyer, double buyerPayment) {
        // Buat objek Transaction baru untuk menyimpan informasi pembeli
        Transaction buyerInfo = new Transaction("", "", 0, nameBuyer, idBuyer, buyerPayment);
        
        // Tambahkan informasi pembeli sebagai transaksi pertama dalam daftar transaksi
        List<Transaction> fullTransaction = new ArrayList<>();
        fullTransaction.add(buyerInfo);
        fullTransaction.addAll(transaction);

        // Tambahkan transaksi ke dalam riwayat transaksi
        transactionHistory.add(fullTransaction);
    }
    
public static void History() {
    if (!transactionHistory.isEmpty()) {
        System.out.println("\n===== RIWAYAT TRANSAKSI =====");
        
        List<Transaction> currentTransactions = transactionHistory.get(0);
        TreeSet<String> uqNameGame = new TreeSet<>();

        if (currentTransactions.isEmpty()) {
            System.out.println("");
            Style.sTextColorln("Tidak ada transaksi saat sini.", Style.RED);
            System.out.println("");
        } else {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            currencyFormat.setCurrency(Currency.getInstance("IDR"));

            Transaction firstTransaction = currentTransactions.get(0);
            String nameBuyer = firstTransaction.getNameBuyer();
            int idBuyer = firstTransaction.getIdBuyer();
            System.out.println("Buyer: " + nameBuyer + " (ID: " + idBuyer + ")");
            System.out.println(formattedDateTime);
            System.out.println("-------------------------------------------------");

            double total = 0;
            for (int j = 1; j < currentTransactions.size(); j++) {
                Transaction transaction = currentTransactions.get(j);
                String nameGame = transaction.getNameGame();
                if (nameGame != null && !nameGame.isEmpty()) {
                    System.out.println("Game " + (j) + ": " + nameGame + " | Price: " + transaction.getPriceGame() + "k");
                    uqNameGame.add(transaction.getNameGame());
                }
                total += transaction.getPriceGame();
            }

            int numberOfGames = currentTransactions.size() - 1;
            System.out.println("Number of Games Purchased: " + numberOfGames);
            System.out.println("-------------------------------------------------");
            System.out.println("Total Pembelian: " + currencyFormat.format(total) + "k");

            double discountGame = (uqNameGame.size() >= 3) ? 0.75 : 0.5;
            double discountAmount = total * discountGame;
            double discountTotal = total - discountAmount;

            if (discountGame >= 0.5) {
                System.out.println("Diskon: " + (discountGame * 100) + "%");
                System.out.println("Total Setelah Diskon: " + currencyFormat.format(discountTotal) + "k");
            }

            double payment = firstTransaction.getBuyerPayment();
            System.out.println("Jumlah Uang yang Dibayarkan: " + currencyFormat.format(payment) + "k");

            double change = payment - discountTotal;
            System.out.println("Uang Kembalian: " + currencyFormat.format(change) + "k");
            System.out.println("===============================");
            System.out.println("");
        } 
        
        System.out.println("Ketik angka apapun untuk kembali ke main menu.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            Menu.menuAwal();
            return;
        } else {
//            System.out.println("Pilihan anda tidak valid.");
            Menu.menuAwal();
            return;
        }
    } else {
        System.out.println("Tidak riwayat transaksi saat ini.");

    }
}
//     END OF TRANSACTION HISTORY ==================================================================================================================>>>

// ==================================================================================
public static void SearchGameSoldMenu() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("+----------------------------------------------+");
        System.out.println("|            Game Sold by Categories           |");
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
        int choose = sc.nextInt();

        System.out.println("");
        
        switch (choose) {
            case 1 : 
                GameSoldResultByCategory("Adventure");
                break;
            case 2 : 
                GameSoldResultByCategory("Action");
                break;
            case 3 : 
                GameSoldResultByCategory("Simulation");
                break;
            case 4 : 
                GameSoldResultByCategory("Sports");
                break;
            case 5 : 
                GameSoldResultByCategory("RPG");
                break;
            case 0 :
                Menu.menuAwal();
                break;
            default :
                Style.sTextColorln("Pilihan tidak valid\n, silahkan coba lagi",Style.RED);
                break;
        }
    }
    
 public static void GameSoldResultByCategory(String category) {
     List<Transaction> currentTransactions = transactionHistory.get(0);
    int i = 1;
    boolean find = false;
    System.out.println("+-----------------------------------------------------------+");
    System.out.println("|                          Sold Game                        |");
    System.out.println("+-----------------------------------------------------------+");
    System.out.println("| No. | Game Title                | Price (IDR) | Buyer     |");
    System.out.println("+-----------------------------------------------------------+");
    
    Transaction firstTransaction = currentTransactions.get(0);
    String nameBuyer = firstTransaction.getNameBuyer();
    for (List<Transaction> listTrans : transactionHistory) {
        for (Transaction dataTrans : listTrans) {
            if (dataTrans.categoryGame.equalsIgnoreCase(category)) {
                System.out.printf("| %-3d | %-25s | %-11s | %-9s |\n", i, dataTrans.nameGame, dataTrans.priceGame, nameBuyer);
                i++;
                find = true;
            }
        }
    }

    if (!find) {
        System.out.println("|        Game dengan kategori tersebut belum terjual.       |");
    }

    System.out.println("+-----------------------------------------------------------+");
    System.out.println("| 0.  | Kembali                                             |");
    System.out.println("+-----------------------------------------------------------+");

    System.out.print("Ketik 0 untuk kembali: ");
    int choose = sc.nextInt();
    System.out.println("");

    switch (choose) {
        case 0:
            System.out.println("");
            SearchGameSoldMenu();
            break;
        default:
            System.out.println("");
            Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
            break;
    }
}

// ==================================================================================

   
}



