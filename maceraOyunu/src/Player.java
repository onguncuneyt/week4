import java.util.Scanner;

public class Player {


    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private Scanner scanner = new Scanner(System.in);

    public Player(String playerName){
        this.name = playerName;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(),new Knight(),new Archer()};

        System.out.println("Karakterler");
        System.out.println("--------------------------------------");

        for (GameChar gameChar:charList){
            System.out.println(
                    "Id: " + gameChar.getId() +
                    "\tKarakter: " + gameChar.getName() +
                    "\tHasar: " + gameChar.getDamage() +
                    "\tSağlık: " + gameChar.getHealth() +
                    "\tPara: " + gameChar.getMoney());
        }

        System.out.println("--------------------------------------");
        System.out.println("Lütfen bir karakter giriniz");
        int selectChar = scanner.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Knight());
                break;
            case 3:
                initPlayer(new Knight() );
            default:
                initPlayer(new Samurai() );
        }

        System.out.println("Seçilen karakter: " + this.charName);

    }

    public void initPlayer(GameChar gameChar ){

        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        setOriginalHealth(gameChar.getHealth() );
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){

        System.out.println(
                        "\tSilahınız: " + this.getInventory().getWeapon().getName() +
                        "\tZırhınız: " + this.getInventory().getArmor().getName() +
                        "\tHasarınız: " + this.getTotalDamage() +
                        "\tSavunmanız: " + this.inventory.getArmor().getBlock()  +
                        "\tSağlığınız: " + this.getHealth() +
                        "\tParanız: " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.inventory.getWeapon().getDamage();
    }
    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
