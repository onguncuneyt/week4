public class ToolStore extends NormalLoc{
    public ToolStore(Player player ) {
        super(2,player, "Mağaza ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------Mağazaya hoşgeldiniz------ ");
        boolean showMenu = true;

        while (showMenu){

            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Çıkış Yap");
            System.out.println("Seçiminiz: ");

            int selectCase = Location.scanner.nextInt();

            while (selectCase<1 || selectCase>3){
                System.out.println("Lütfen yeni seçim yapın");
                selectCase = scanner.nextInt();
            }

            switch (selectCase){

                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Yine bekleriz!");
                    showMenu = false;
                    break;
            }

        }
        return true;

    }
    public void printWeapon(){
        System.out.println("-----Silahlar-----");
        for (Weapon w:Weapon.weapons()){
            System.out.println("Id: " + w.getId()+
                    "\tAdı: " + w.getName()+
                    "\tHasar: "+w.getDamage()+
                    "\tFiyat: " + w.getPrice());
        }
        System.out.println("0 - Çıkış Yap ");


    }

    public void buyWeapon(){

        System.out.println("Bir silah seçin");
        int selectWeapon = scanner.nextInt();
        while (selectWeapon<0  || selectWeapon>Weapon.weapons().length){
            System.out.println("Lütfen yeni seçim yapın");
            selectWeapon = scanner.nextInt();
        }

        if( selectWeapon !=0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
            if(selectedWeapon != null){

                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }else{
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName() );
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }

    public void printArmor(){
        System.out.println("-----Zırhlar----- ");

        System.out.println("-----zırhlar-----");
        for (Armor a:Armor.armors()){
            System.out.println("Id: " + a.getId()+
                    "\tAdı: " + a.getName()+
                    "\tSavunma: "+a.getBlock()+
                    "\tFiyat: " + a.getPrice());
        }
        System.out.println("0 - Çıkış Yap ");
    }

    public void buyArmor(){
        System.out.println("Bir zırh seçin");
        int selectArmor = scanner.nextInt();
        while (selectArmor<0 || selectArmor>Weapon.weapons().length){
            System.out.println("Lütfen yeni seçim yapın");
            selectArmor = scanner.nextInt();
        }

        if (selectArmor != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
            if(selectedArmor != null){

                if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }else{
                    System.out.println(selectedArmor.getName() + " silahını satın aldınız ");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName() );
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }

    }
}
