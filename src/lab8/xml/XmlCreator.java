package lab8.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlCreator {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("university");
        doc.appendChild(root);

        root.appendChild(createLesson(doc, "Математический анализ", "Иванов Иван Иванович", "1", "5"));
        root.appendChild(createLesson(doc, "Линейная алгебра", "Петрова Мария Сергеевна", "1", "4"));
        root.appendChild(createLesson(doc, "Программирование на Java", "Сидоров Алексей Николаевич", "2", "6"));
        root.appendChild(createLesson(doc, "Базы данных", "Козлова Елена Дмитриевна", "3", "5"));
        root.appendChild(createLesson(doc, "Операционные системы", "Новиков Сергей Павлович", "3", "4"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/lab8/xml/example.xml"));
        transformer.transform(source, result);

        System.out.println("XML-файл успешно создан: src/lab8/xml/example.xml");
    }

    static Element createLesson(Document doc, String name, String teacher, String semester, String units) {
        Element lesson = doc.createElement("lesson");

        Element nameEl = doc.createElement("name");
        nameEl.setTextContent(name);
        lesson.appendChild(nameEl);

        Element teacherEl = doc.createElement("teacher");
        teacherEl.setTextContent(teacher);
        lesson.appendChild(teacherEl);

        Element semesterEl = doc.createElement("semester");
        semesterEl.setTextContent(semester);
        lesson.appendChild(semesterEl);

        Element unitsEl = doc.createElement("units");
        unitsEl.setTextContent(units);
        lesson.appendChild(unitsEl);

        return lesson;
    }
}
