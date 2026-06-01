package lab8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HtmlParser {

    private static final String URL         = "http://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "src/lab8/html/news_output.txt";
    private static final int    MAX_RETRIES = 3;
    private static final int    TIMEOUT_MS  = 10_000;

    public static void main(String[] args) {
        Document doc = fetchWithRetry(URL, MAX_RETRIES);

        if (doc == null) {
            System.err.println("Не удалось получить страницу после " + MAX_RETRIES + " попыток. Завершение работы.");
            return;
        }

        Elements newsItems = doc.select("div.news-item, li.news, .newsitem, article");
        if (newsItems.isEmpty()) {
            newsItems = doc.select("h1, h2, h3");
        }

        System.out.println("Найдено элементов: " + newsItems.size());

        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println("Новости с " + URL);
            writer.println("Дата парсинга: " + timestamp);
            writer.println();

            if (newsItems.isEmpty()) {
                String msg = "Новости не найдены — возможно, структура сайта изменилась.";
                writer.println(msg);
                System.out.println(msg);
            } else {
                int idx = 1;
                for (Element item : newsItems) {
                    String text = item.text().trim();
                    if (!text.isEmpty()) {
                        String line = idx++ + ". " + text;
                        writer.println(line);
                        System.out.println(line);
                    }
                }
            }

            System.out.println("\nДанные сохранены в: " + OUTPUT_FILE);

        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static Document fetchWithRetry(String url, int maxRetries) {
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                System.out.printf("Попытка подключения %d/%d: %s%n", attempt, maxRetries, url);
                Document doc = Jsoup.connect(url)
                        .timeout(TIMEOUT_MS)
                        .userAgent("Mozilla/5.0 (compatible; Java-Parser/1.0)")
                        .get();
                System.out.println("Подключение успешно.");
                return doc;
            } catch (IOException e) {
                System.err.printf("Ошибка при попытке %d: %s%n", attempt, e.getMessage());
                if (attempt < maxRetries) {
                    System.out.println("Повторная попытка через 2 секунды...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
        return null;
    }
}
