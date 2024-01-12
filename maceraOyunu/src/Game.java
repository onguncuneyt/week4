import java.util.Scanner;
public class Game {
    private Scanner scanner = new Scanner(System.in);
    Player player;
    Location location;

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz");
        System.out.println("Lütfen bir isim giriniz");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + " " + "Hoşgeldiniz!");
        System.out.println("Lütfen bir karakter seçiniz");
        System.out.println("----------------------------------");

        player.selectChar();

        Location location= null;
        while (true){

            player.printInfo();
            Location[] gameLocations = {new SafeHouse(player),new ToolStore(player),new Cave(player),new Forest(player),new River(player)};

            System.out.println();
            System.out.println("#############Bölgeler############## ");
            System.out.println();
            for (Location loc: gameLocations){
                System.out.println("Id: " + loc.getId() + " - " + loc.getName());
            }
            System.out.println("0 - Çıkış Yap --> Oyunu Sonlandır ");

            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçin");

            int selectLoc = scanner.nextInt();

            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge girin");
            }

            if(location == null){
                System.out.println("Oyun bitti yine bekleriz ");
                 break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }

    }
}
