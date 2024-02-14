package feature;


import model.Buyers;
import java.util.Scanner;
import model.GameRecord;
import resource.SourceGame;
import resource.Style;

public class CategoryGame {
    
    static Scanner sc = new Scanner(System.in);
    static GameRecord[] data = new SourceGame().dataGame;
    static int pilih;
    
    
    
   public static void menuAdventure(String category, Buyers buyers) {
    boolean cShop = true;
    while (cShop) {
        int i = 1;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|              Discover Exciting Game Selection             |");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| No. | Game Title                | Price (IDR) | Category  |");
        System.out.println("+-----------------------------------------------------------+");

        for (GameRecord dataGame : data) {
            if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                System.out.printf("| %-3d | %-25s | %-11s | %-9s |\n" ,i, dataGame.nameGame , dataGame.priceGame , dataGame.categoryGame);
                i++;
            }
        }

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| 0,  | Kembali                                             |");
        System.out.println("+-----------------------------------------------------------+");

        System.out.print("Pilih Game yang ingin dibeli: ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 0:
                cShop = false;
                Menu.menuKategori();
                break;
            default:
                if (pilih > 0 && pilih <= i - 1) {
                    GameRecord selectedGame = null;
                    int count = 0;
                    for (GameRecord dataGame : data) {
                        if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                            count++;
                            if (count == pilih) {
                                selectedGame = dataGame;
                                break;
                            }
                        }
                    }
                    if (selectedGame != null) {
                        CartShop.addToShoppingCart(buyers, selectedGame);
                        cShop = false;
                        Menu.menuKategori();    
                    } else {
                        System.out.println("");
                        Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                    }
                } else {
                    System.out.println("");
                    Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                }
                break;
        }
    }
}

    
    public static void menuAction(String category, Buyers buyers){
       boolean cShop = true;
    while (cShop) {
        int i = 1;
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                Discover Exciting Game Selection                |");
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("| No. | Game Title                     | Price (IDR) | Category  |");
        System.out.println("+----------------------------------------------------------------+");

        for (GameRecord dataGame : data) {
            if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                System.out.printf("| %-3d | %-30s | %-11s | %-9s |\n" ,i, dataGame.nameGame , dataGame.priceGame , dataGame.categoryGame);
                i++;
            }
        }

        System.out.println("+----------------------------------------------------------------+");
        System.out.println("| 0,  | Kembali                                                  |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Pilih Game yang ingin dibeli: ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 0:
                cShop = false;
                Menu.menuKategori();
                break;
            default:
                if (pilih > 0 && pilih <= i - 1) {
                    GameRecord selectedGame = null;
                    int count = 0;
                    i++;
                    for (GameRecord dataGame : data) {
                        if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                            count++;
                            if (count == pilih) {
                                selectedGame = dataGame;
                                break;
                            }
                        }
                    }
                    if (selectedGame != null) {
                        CartShop.addToShoppingCart(buyers ,selectedGame);
                        
                        cShop = false; 
                        Menu.menuKategori();
                    } else {
                        System.out.println("");
                        Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                    }
                } else {
                    System.out.println("");
                    Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                }
                break;
        }
    }
    }

    public static void menuSimulation(String category, Buyers buyers){
       boolean cShop = true;
    while (cShop) {
        int i = 1;
        System.out.println("+------------------------------------------------------------+");
        System.out.println("|              Discover Exciting Game Selection              |");
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| No. | Game Title                 | Price (IDR) | Category  |");
        System.out.println("+------------------------------------------------------------+");

        for (GameRecord dataGame : data) {
            if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                System.out.printf("| %-3d | %-26s | %-11s | %-9s |\n" ,i, dataGame.nameGame , dataGame.priceGame , dataGame.categoryGame);
                i++;
            }
        }

        System.out.println("+------------------------------------------------------------+");
        System.out.println("| 0,  | Kembali                                              |");
        System.out.println("+------------------------------------------------------------+");

        System.out.print("Pilih Game yang ingin dibeli: ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 0:
                cShop = false;
                Menu.menuKategori();
                break;
            default:
                if (pilih > 0 && pilih <= i - 1) {
                    GameRecord selectedGame = null;
                    int count = 0;
                    i++;
                    for (GameRecord dataGame : data) {
                        if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                            count++;
                            if (count == pilih) {
                                selectedGame = dataGame;
                                break;
                            }
                        }
                    }
                    if (selectedGame != null) {
                        CartShop.addToShoppingCart(buyers,selectedGame);
                        
                        cShop = false; 
                        Menu.menuKategori();
                    } else {
                        System.out.println("");
                        Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                    }
                } else {
                    System.out.println("");
                    Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                }
                break;
        }
    }
    }
    
    public static void menuSports(String category, Buyers buyers){
boolean cShop = true;
    while (cShop) {
        int i = 1;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|              Discover Exciting Game Selection             |");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| No. | Game Title                | Price (IDR) | Category  |");
        System.out.println("+-----------------------------------------------------------+");

        for (GameRecord dataGame : data) {
            if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                System.out.printf("| %-3d | %-25s | %-11s | %-9s |\n" ,i, dataGame.nameGame , dataGame.priceGame , dataGame.categoryGame);
                i++;
            }
        }

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| 0,  | Kembali                                             |");
        System.out.println("+-----------------------------------------------------------+");

        System.out.print("Pilih Game yang ingin dibeli: ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 0:
                cShop = false;
                Menu.menuKategori();
                break;
            default:
                if (pilih > 0 && pilih <= i - 1) {
                    GameRecord selectedGame = null;
                    int count = 0;
                    i++;
                    for (GameRecord dataGame : data) {
                        if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                            count++;
                            if (count == pilih) {
                                selectedGame = dataGame;
                                break;
                            }
                        }
                    }
                    if (selectedGame != null) {
                        CartShop.addToShoppingCart(buyers, selectedGame);
                       
                        cShop = false; 
                        Menu.menuKategori();
                    } else {
                        System.out.println("");
                        Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                    }
                } else {
                    System.out.println("");
                    Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                }
                break;
        }
    }
    }
    public static void menuRpg(String category, Buyers buyers){
     boolean cShop = true;
    while (cShop) {
        int i = 1;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|              Discover Exciting Game Selection             |");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| No. | Game Title                | Price (IDR) | Category  |");
        System.out.println("+-----------------------------------------------------------+");

        for (GameRecord dataGame : data) {
            if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                System.out.printf("| %-3d | %-25s | %-11s | %-9s |\n" ,i, dataGame.nameGame , dataGame.priceGame , dataGame.categoryGame);
                i++;
            }
        }

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| 0,  | Kembali                                             |");
        System.out.println("+-----------------------------------------------------------+");

        System.out.print("Pilih Game yang ingin dibeli: ");
        pilih = sc.nextInt();
        switch (pilih) {
            case 0:
                cShop = false;
                Menu.menuKategori();
                break;
            default:
                if (pilih > 0 && pilih <= i - 1) {
                    GameRecord selectedGame = null;
                    int count = 0;
                    i++;
                    for (GameRecord dataGame : data) {
                        if (dataGame.categoryGame.equalsIgnoreCase(category)) {
                            count++;
                            if (count == pilih) {
                                selectedGame = dataGame;
                                break;
                            }
                        }
                    }
                    if (selectedGame != null) {
                        CartShop.addToShoppingCart(buyers,selectedGame);
                        
                        cShop = false; 
                        Menu.menuKategori();
                    } else {
                        System.out.println("");
                        Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                    }
                } else {
                    System.out.println("");
                    Style.sTextColorln("Pilihan tidak valid, silakan coba lagi.", Style.RED);
                }
                break;
        }
    }
    }


}
