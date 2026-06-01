package lab8.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelCreator {

    public static final String FILE_PATH = "src/lab8/excel/lessons.xlsx";

    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Предметы");

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            String[] columns = {"Название предмета", "Преподаватель", "Семестр", "Зач. ед."};
            Row header = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
                sheet.setColumnWidth(i, i < 2 ? 8000 : 4000);
            }

            Object[][] data = {
                    {"Математический анализ",      "Иванов Иван Иванович",          1, 5},
                    {"Линейная алгебра",            "Петрова Мария Сергеевна",       1, 4},
                    {"Программирование на Java",    "Сидоров Алексей Николаевич",    2, 6},
                    {"Базы данных",                 "Козлова Елена Дмитриевна",      3, 5},
                    {"Операционные системы",        "Новиков Сергей Павлович",       3, 4},
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((String)  data[i][0]);
                row.createCell(1).setCellValue((String)  data[i][1]);
                row.createCell(2).setCellValue((int)     data[i][2]);
                row.createCell(3).setCellValue((int)     data[i][3]);
            }

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }
            System.out.println("Excel-файл успешно создан: " + FILE_PATH);

        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
