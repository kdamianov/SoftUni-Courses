package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P04Articles2 {
    static class Articles {
        //характеристики
        private String title;
        private String content;
        private String author;
        //конструктор
        public Articles (String title, String content, String author) {
            //нов обект
            this.title = title;
            this.content = content;
            this.author = author;
        }

        private String getTitle() {
            return title;
        }

        private String getContent() {
            return content;
        }

        private String getAuthor() {
            return author;
        }

        //методи - функционалности
        public String toString () {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Articles> articleList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] articleData = scanner.nextLine().split(", ");
            String title = articleData[0];
            String content = articleData[1];
            String author = articleData[2];

            Articles article = new Articles(title, content, author);
            articleList.add(article);
        }
        String input = scanner.nextLine();

        for (Articles article: articleList) {
            System.out.println(article.toString());
        }
    }
}
