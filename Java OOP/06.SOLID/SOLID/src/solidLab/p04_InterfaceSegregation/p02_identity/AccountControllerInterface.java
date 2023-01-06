package solidLab.p04_InterfaceSegregation.p02_identity;

public interface AccountControllerInterface {
    boolean getRequireUniqueEmail();

    int getMinRequiredPasswordLength();

    int getMaxRequiredPasswordLength();
}
