package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    protected void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    protected void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    protected void setProtection(int protection) {
        if (protection < 0){
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    protected void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        int damageReceived = this.protection - points;
        this.protection -= damageReceived;
        if (this.protection <= 0) {
            this.protection = 0;
            this.health -= Math.abs(damageReceived);
        }

        if (protection == 0) {
            this.health = this.health - points;
            if (health == 0) {
                isAlive = false;
            }
        }
    }
}
