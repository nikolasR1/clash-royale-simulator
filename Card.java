public class Card {
    private String name;
    private int elixirCost;
    private int hitPoints;
    private int damagePerSecond;
    private CardType type;
    private AttackType attackType;

    public enum CardType { TROOP, BUILDING, SPELL }
    public enum AttackType { MELEE, RANGED, SPLASH }

    public Card(String name, int elixirCost, int hitPoints, int damagePerSecond, CardType type, AttackType attackType) {
        this.name = name;
        this.elixirCost = elixirCost;
        this.hitPoints = hitPoints;
        this.damagePerSecond = damagePerSecond;
        this.type = type;
        this.attackType = attackType;
    }
    public String getName() {
        return name;
    }
    public int getElixirCost() {
        return elixirCost;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public int getDamagePerSecond() {
        return damagePerSecond;
    }
    public CardType getType() {
        return type;
    }
    public AttackType getAttackType(){
        return attackType;
    }

    public String toString() {
        return name + " (Elixir: " + elixirCost + ", HP: " + hitPoints +
                ", DPS: " + damagePerSecond + ", Type: " + type +
                ", Attack: " + attackType + ")";
    }
}
