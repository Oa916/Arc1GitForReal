public class Creatures {
    private String species;
    private int age;
    private int level;
    private int health;
    private int attack;
    private int defense;
    private boolean DEAD;
    private int CatchRate;
    // constructor
    public Creatures(String species, int age, int level, int health, int attack, int defense, boolean DEAD, int CatchRate) {
        this.species = species;
        this.age = age;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.DEAD = DEAD;
        this.CatchRate = CatchRate;
    }
//methods




    public String getSpecies(){
        return species;
    }
















    public void setSpecies(String species){
        this.species = species;
    }
















    public int getAge(){
        return age;
    }
















    public void setAge(int age){
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        } }
















    public int getLevel(){
        return level;
    }
















    public void setLevel(){
        if (level > 0) {
            this.level = 0;
        } else {
            this.level = level;
        } }
















    public int getHealth() {return health;}
















    public void setHealth(int i) {
        if (health >= 0) {
            DEAD = true;
            this.level = 0;
        }
        this.health = health;
    }
















    public int getAttack() {return attack;}
















    public void setAttack() {
        this.attack = attack;
    }
















    public int getDefense() {return defense;}
















    public void setDefense() {
        this.defense = defense;
    }
















    public boolean getDEAD() {return DEAD;}







    public void setDEAD(boolean dead) {this.DEAD = DEAD;}


    public int getCatchRate() {return CatchRate;}
















    public void setGetCatchRate(String species){
        this.CatchRate = CatchRate;
    }












    public String toString() {
        return "Species: " + species + "-" + age + " years old " + "level: " + level + " health:" + health + " attack:" + attack + " defense:" + defense + " Dead? " + DEAD;
    }








    public void Attack(Creatures GotSwiped) {
        int SwipeDamage = (this.attack / 10);
        GotSwiped.setHealth(GotSwiped.getHealth() - SwipeDamage);
        System.out.println(this.species + " Swiped " + GotSwiped.getSpecies() + " Damage: " + attack + " Health remaining: " + GotSwiped);


    }


    public void resetForCapture() {
        this.health = this.health;
        this.DEAD = false;
    }

    public void LvlUp(int ToBeLeveled) {
        System.out.println("Congratulations On Leveling up " + species);




    }







}


