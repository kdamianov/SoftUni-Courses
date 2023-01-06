package magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    private static final int FIRE_BULLETS = 10;
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() > FIRE_BULLETS) {
            setBulletsCount(getBulletsCount() - 10);
            return 10;
        } else {
            return 0;
        }
    }
}
