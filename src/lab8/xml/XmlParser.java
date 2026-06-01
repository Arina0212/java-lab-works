package lab8.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XmlParser {

    private static final String FILE_PATH = "src/lab8/xml/example.xml";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nXML Парсер. Предметы университета");
            System.out.println("1. Показать все предметы");
            System.out.println("2. Добавить предмет");
            System.out.println("3. Поиск по преподавателю");
            System.out.println("4. Поиск по семестру");
            System.out.println("5. Удалить предмет по названию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> showAll();
                case "2" -> addLesson(scanner);
                case "3" -> searchByTeacher(scanner);
                case "4" -> searchBySemester(scanner);
                case "5" -> deleteLesson(scanner);
                case "0" -> running = false;
                default -> System.out.println("Неверный выбор.");
            }
        }
        System.out.println("Выход.");
    }
    private static Document loadDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));
    }

    private static List<Element> getLessons(Document doc) {
        NodeList nl = doc.getElementsByTagName("lesson");
        return IntStream.range(0, nl.getLength())
                .mapToObj(nl::item)
                .filter(n -> n.getNodeType() == Node.ELEMENT_NODE)
                .map(n -> (Element) n)
                .collect(Collectors.toList());
    }

    private static String getText(Element el, String tag) {
        NodeList nl = el.getElementsByTagName(tag);
        return nl.getLength() > 0 ? nl.item(0).getTextContent() : "";
    }

    private static void printLesson(Element el) {
        System.out.printf("  Предмет: %-30s Преподаватель: %-30s Семестр: %-3s Зач. ед.: %s%n",
                getText(el, "name"), getText(el, "teacher"),
                getText(el, "semester"), getText(el, "units"));
    }

    private static void showAll() throws Exception {
        List<Element> lessons = getLessons(loadDocument());
        if (lessons.isEmpty()) { System.out.println("Список предметов пуст."); return; }
        System.out.println("\nВсе предметы (" + lessons.size() + "):");
        lessons.forEach(XmlParser::printLesson);
    }

    private static void addLesson(Scanner scanner) throws Exception {
        System.out.print("Название предмета: ");
        String name = scanner.nextLine().trim();
        System.out.print("Преподаватель: ");
        String teacher = scanner.nextLine().trim();
        System.out.print("Семестр: ");
        String semester = scanner.nextLine().trim();
        System.out.print("Количество зач. ед.: ");
        String units = scanner.nextLine().trim();

        Document doc = loadDocument();
        doc.getDocumentElement().appendChild(
                XmlCreator.createLesson(doc, name, teacher, semester, units));
        saveDocument(doc);
        System.out.println("Предмет \"" + name + "\" добавлен.");
    }

    private static void searchByTeacher(Scanner scanner) throws Exception {
        System.out.print("Введите фамилию/имя преподавателя: ");
        String query = scanner.nextLine().trim().toLowerCase();

        List<Element> found = getLessons(loadDocument()).stream()
                .filter(l -> getText(l, "teacher").toLowerCase().contains(query))
                .collect(Collectors.toList());

        if (found.isEmpty()) System.out.println("Предметы не найдены.");
        else { System.out.println("Найдено: " + found.size()); found.forEach(XmlParser::printLesson); }
    }

    private static void searchBySemester(Scanner scanner) throws Exception {
        System.out.print("Введите номер семестра: ");
        String sem = scanner.nextLine().trim();

        List<Element> found = getLessons(loadDocument()).stream()
                .filter(l -> getText(l, "semester").equals(sem))
                .collect(Collectors.toList());

        if (found.isEmpty()) System.out.println("Предметы семестра " + sem + " не найдены.");
        else { System.out.println("Найдено: " + found.size()); found.forEach(XmlParser::printLesson); }
    }

    private static void deleteLesson(Scanner scanner) throws Exception {
        System.out.print("Название предмета для удаления: ");
        String nameToDelete = scanner.nextLine().trim();

        Document doc = loadDocument();
        List<Element> toRemove = getLessons(doc).stream()
                .filter(l -> getText(l, "name").equalsIgnoreCase(nameToDelete))
                .collect(Collectors.toList());

        if (toRemove.isEmpty()) {
            System.out.println("Предмет \"" + nameToDelete + "\" не найден.");
        } else {
            toRemove.forEach(l -> l.getParentNode().removeChild(l));
            saveDocument(doc);
            System.out.println("Удалено записей: " + toRemove.size());
        }
    }
}
