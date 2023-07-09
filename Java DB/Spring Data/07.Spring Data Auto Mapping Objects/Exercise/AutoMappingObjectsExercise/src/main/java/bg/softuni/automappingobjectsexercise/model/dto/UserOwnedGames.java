package bg.softuni.automappingobjectsexercise.model.dto;

public class UserOwnedGames {
    private  String title;

    public UserOwnedGames() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s%n", this.title);
    }
}
