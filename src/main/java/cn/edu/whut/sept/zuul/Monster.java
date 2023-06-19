package cn.edu.whut.sept.zuul;

public class Monster {
    private int health;  // 血量
    private int attack;  // 攻击力
    private int defense; // 防御力

    /**
     * 构造函数，创建怪物实例
     * @param health    怪物血量
     * @param attack    怪物攻击力
     * @param defense   怪物防御力
     */
    public Monster(int health,int attack,int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * 设置怪物血量
     * @param health 怪物血量
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * 获取怪物血量
     * @return health 怪物血量
     */
    public int getHealth() {
        return health;
    }

    /**
     * 获取怪物攻击力
     * @return attack 怪物攻击力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * 获取怪物防御力
     * @return defense 怪物防御力
     */
    public int getDefense() {
        return defense;
    }

    public void display(){
        System.out.println("怪物属性——当前血量："+this.health+" 攻击力："+this.attack+" 防御力："+this.defense);
    }

    public void displayHealth(){
        if(this.health<0){
            this.health=0;
        }
        System.out.print("普通怪物-当前血量："+health);
    }

}
