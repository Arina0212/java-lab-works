package lab8.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelReader {

    public static void main(String[] args) {
        readExcel(ExcelCreator.FILE_PATH);
    }

    public static void readExcel(String filePath) {

        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Ошибка: файл не найден — " + filePath);
            return;
        }

        if (!filePath.toLowerCase().endsWith(".xlsx")) {
            System.err.println("Ошибка: ожидается файл .xlsx, получено: " + filePath);
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            String sheetName = "Предметы";
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.err.println("Ошибка: лист \"" + sheetName + "\" не найден в файле.");
                System.err.println("Доступные листы:");
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.err.println("  - " + workbook.getSheetName(i));
                }
                return;
            }

            System.out.println("Содержимое файла: " + filePath);
            System.out.printf("%-30s %-32s %-10s %s%n",
                    "Предмет", "Преподаватель", "Семестр", "Зач. ед.");
            System.out.println("-".repeat(80));

            int rowsRead = 0;
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                String col0 = getCellValue(row.getCell(0));
                String col1 = getCellValue(row.getCell(1));
                String col2 = getCellValue(row.getCell(2));
                String col3 = getCellValue(row.getCell(3));

                if (!col0.trim().isEmpty()) {
                    System.out.printf("%-30s %-32s %-10s %s%n", col0, col1, col2, col3);
                    rowsRead++;
                }
            }

            System.out.println("-".repeat(80));
            System.out.println("Всего строк прочитано: " + rowsRead);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            System.err.println("Возможные причины: файл открыт в другой программе или нет прав на чтение.");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getClass().getSimpleName() + " — " + e.getMessage());
            System.err.println("Убедитесь, что файл не повреждён. При необходимости пересоздайте его через ExcelCreator.");
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toString();
                }
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
