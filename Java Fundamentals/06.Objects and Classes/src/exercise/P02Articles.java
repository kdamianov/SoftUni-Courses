package exercise;

import java.util.Scanner;

public class P02Articles {
    //характеристики
    private String title;
    private String content;
    private String author;

    //контруктор
    public P02Articles (String title, String content, String author){
        //Нов обект
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //Функционалности -> Методи
    public void edit (String newContent) {

        this.content = newContent;
    }
    public void changeAuthor (String newAuthor) {
        this.author = newAuthor;
    }
    public void rename (String newTitle) {
        this.title = newTitle;
    }
    //пренаписваме toString метод
    public String toString () {
        return this.title + " - " + this.content + ": " + this.author;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];

        P02Articles article = new P02Articles (title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            String commandName = command.split("\\: ")[0];
            String newValue = command.split("\\: ")[1];

            switch (commandName) {
                case "Edit":
                    article.edit(newValue);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newValue);
                    break;
                case "Rename":
                    article.rename(newValue);
                    break;
            }
        }
        System.out.println(article.toString());
    }

}
