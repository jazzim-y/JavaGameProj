package Main;

import java.util.ArrayList;
import java.util.List;
 //Stats management (HP, Speed, Mana)
public class Beast {
    private String name;
    private String element;
    private String henshin;
    private int hp;
    private int speed;
    private int mana;
    private int manaRegen;
    private List<Skills> skills;

    public beast(String name, String element, String henshin, int hp, int speed, int mana, int manaRegen){
        this.name = name;
        this.element = element;
        this.henshin = henshin;
        this.hp = hp;
        this.speed = speed;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skillName, String skillElement, int minPower, int maxPower, int manaCost, int cooldown){
        skills.add(new Skill(skillName, skillElement, minPower, maxPower, manaCost, cooldown));
    }

    public String getName() {return name;}
    public String getElement() {return element;}
    public String getHenshin() {return henshin;}
    public int getHp() {return hp;}
    public int getSpeed() {return speed;}
    public int getMana() {return mana;}
    public int getManaRegen() {return manaRegen};
    public List<Skill> getSkills() {return Skills;}

    //Skill system
    public static class Skill{
        private String skillName;
        private String skillElement;
        private int minPower;
        private int maxPower;
        private int manaCost;
        private int cooldown;

        public Skill(String skillName, String skillElement, int minPower, int maxPower, int manaCost, int cooldown){
            this.skillName = skillName;
            this.skillElement = skillElement;
            this.minPower = minPower;
            this.maxPower = maxPower;
            this.manaCost = manaCost;
            this.cooldown = cooldown;
        }
        public String skillName() {return skillName;}
        public String skillElement() {return skillElement;}
        public int minPower() {return minPower;}
        public int maxPower() {return maxPower;}
        public int manaCost() {return manaCost;}
        public int cooldown() {return cooldown;}
    }

    //Beast.Beast selection
    public static List<Beast> createBeast(){
        List<Beast> beasts = new ArrayList<>();

        Beast kyoflare = new Beast("Kyoflare", "Fire", "Kyoryuger", 820, 105, 300, 25);
        kyoflare.addSkill("Kyoryu Tail", "Neutral", 28, 35, 0,0);
        kyoflare.addSkill("Blaze Fangs", "Fire", 65, 80, 50, 1);
        kyoflare.addSkill("Solar Burst", "Fire", 110, 130, 90, 3);
        beast.add(kyoflare);

        Beast nokami = new Beast("Nokami", "Water", "Shurikenger", 770, 115, 280, 20);
        nokami.addSkill("Swift Strike", "Neutral", 28, 35, 0, 0);
        nokami.addSkill("Aqua Slice", "Water", 60, 70, 45, 1);
        nokami.addSkill("Shuriken Wave", "Water", 85, 105, 70, 2);
        beast.add(nokami);

        Beast vineratops = new Beast("Vineratops", "Grass", "Zyuuranger", 940, 85, 260, 30);
        vineratops.addSkill("Horn Charge", "Neutral", 22, 28, 0, 0);
        vineratops.addSkill("Horn Vines", "Grass", 70, 80, 55, 1);
        vineratops.addSkill("Horn Bloom", "Grass", 100, 120, 80, 3);
        beast.add(vineratops);

        Beast voltchu = new Beast("Voltchu", "Electric", "Shinkenger", 760, 120, 270, 18);
        voltchu.addSkill("Quick Draw", "Neutral", 28, 35, 0, 0);
        voltchu.addSkill("Electric Slash","Electric", 65, 75, 50, 1);
        voltchu.addSkill("Lightning Wrath", "Electric", 95, 110, 85, 3);
        beast.add(voltchu);

        Beast zyuugor = new Beast("Zyuugor", "Earth", "Zyuohger", 1000, 75, 320, 35);
        zyuugor.addSkill("Kong Fist", "Neutral", 22, 28, 0, 0);
        zyuugor.addSkill("Mineral Bomb", "Earth", 75, 85, 60, 1);
        zyuugor.addSkill("Colossus Breaker", 120, 140, 100, 4);
        beast.add(zyuugor);

        Beast pirrot = new Beast("Pirrot", "Wind", "Gokaiger", 780, 118, 260, 20);
        pirrot.addSkill("Feather Bullet", "Neutral", 28, 35, 0, 0);
        pirrot.addSkill("Wing Blade", "Wind", 65, 75, 50, 1);
        pirrot.addSkill("Tempest Slash", "Wind", 95, 115, 80, 2);
        beast.add(pirrot);

        Beast gekuma = new Beast("Gekuma", "Fighting", "Gekiranger", 860, 95, 290, 28);
        gekuma.addSkill("Bear Claw", "Neutral", 28, 35, 0, 0);
        gekuma.addSkill("Power Jab", "Fighting", 65, 75, 50, 1);
        gekuma.addSkill("Primal Strike", "Fighting", 90, 110, 75, 3);
        beast.add(gekuma);

        Beast shadefox = new Beast("Shadefox", "Dark", "Lupinranger", 750, 119, 280, 20);
        shadefox.addSkill("Sneak Bite", "Neutral", 28, 35, 0, 0);
        shadefox.addSkill("Crescent Claw", "Dark", 65, 75, 50, 1);
        shadefox.addSkill("Phantom Slash", "Dark", 90, 100, 80, 2);
        beast.add(shadefox);

        //OP character
        Beast kingmantis = new Beast("Kingmantis", "Steel", "KingOgher", 1200, 110, 400, 50);
        kingmantis.addSkill("Iron Jab", "Neutral", 40, 75, 0, 0);
        kingmantis.addSkill("Twin Dagger", "Steel", 90, 100, 55, 1);
        kingmantis.addSkill("Sovereign Blade", "Steel", 130, 200, 100, 3);
        beast.add(kingmantis);

        //Final Boss
        Beast woltrix = new Beast("Woltrix", "Electric", "Dekaranger", 1350, 110, 520, 50);
        woltrix.addSkill("Iron Fang", "Neutral", 40, 50, 0, 0);
        woltrix.addSkill("Volt Saber", "Electric", 95, 115, 75, 2);
        woltrix.addSkill("Thunder Barrage", "Electric", 150, 190, 120, 4);
        beast.add(woltrix);
    }

    
   
}
