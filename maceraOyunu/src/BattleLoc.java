import java.util.Locale;
import java.util.Random;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(int id, Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(id, player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        int obsNumber = randomObstacleNumber();

        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli ol  burada " +obsNumber + " adet " + this.obstacle.getName()+" yaşıyor ");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber)){

                System.out.println(this.getName() + "mekanındaki tüm düşmanları yendiniz");
                return true;


        }
        if(this.getPlayer().getHealth()<0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){

        for (int i = 0; i <= obsNumber; i++) {

            this.getObstacle().setHealth(Obstacle.getOriginalHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("<V>ur yada <K>aç");
                String selectCombat = scanner.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar size vurdu");

                        int obsDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

                        if(obsDamage<0){
                            obsDamage = 0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obsDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz");
                System.out.println(this.getObstacle().getAward()+ " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() +  this.getObstacle().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return false;
    }

    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " isimli canavarın canı: " + this.getObstacle().getHealth());
        System.out.println("-----------------");
    }
    public void playerStats(){
         System.out.println("Oyuncu Değerleri");
         System.out.println("--------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName() );
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i){
        System.out.println(i +"."+this.getObstacle().getName() + " Değerleri");
        System.out.println("----------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward() );
        System.out.println();

    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle() )+1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
