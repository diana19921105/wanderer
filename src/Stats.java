import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Stats {
    private int heroLevel;
    private int hp;
    private int dp;
    private int sp;
    private int maxHp;

    public Stats(int heroLevel, int hp, int dp, int sp, int maxHp) {
        this.heroLevel = heroLevel;
        this.hp = hp;
        this.dp = dp;
        this.sp = sp;
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public void drawStats(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(720, 240, 250, 250);
        graphics.setColor(Color.black);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 18));
        graphics.drawString("Hero (Level " + heroLevel + ")", 730, 270);
        graphics.drawString("HP: " + hp + "/" + maxHp + " | DP: " + dp, 730, 320);
        graphics.drawString("SP: " + sp, 730, 370);
    }
}
