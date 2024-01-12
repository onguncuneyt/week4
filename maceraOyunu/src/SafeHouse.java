public class SafeHouse extends NormalLoc{
     public SafeHouse(Player player) {
        super(1,player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
         System.out.println("-----Güvenli evdesiniz------");
         this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
         System.out.println("Canınız yenilendi");
        return true;
    }
}
