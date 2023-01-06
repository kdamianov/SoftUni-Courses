package magicGame.models.magics;

public class RedMagic extends MagicImpl {
    private static final int FIRE_BULLETS = 1;

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() > FIRE_BULLETS) {
            setBulletsCount(getBulletsCount() - 1);
            return 1;
        } else {
            return 0;
        }
    }
}
