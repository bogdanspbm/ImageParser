package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelEditor {

    private String path;
    HSSFWorkbook workbook;

    public ExcelEditor(String path) {
        this.path = path;

        if (doesBookExist()) {
            openWorkbook();
        } else {
            createWorkbook();
        }

    }

    private HSSFSheet getFirstSheet() {
        if (workbook != null) {
            if (workbook.getNumberOfSheets() == 0) {
                return workbook.createSheet();
            } else {
                return workbook.getSheetAt(0);
            }
        }
        return null;
    }

    private void addRow(List<String> elements) {
        HSSFSheet sheet = getFirstSheet();
        int lastRowIndex = sheet.getPhysicalNumberOfRows();
        HSSFRow row = sheet.createRow(lastRowIndex);

        for (int i = 0; i < elements.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(elements.get(i));
        }
    }

    private boolean doesBookExist() {
        File file = new File(path);
        return file.exists();
    }

    private void createWorkbook() {
        try {
            workbook = new HSSFWorkbook();
            System.out.println("Workbook created");
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

    private void openWorkbook() {
        try {
            workbook = new HSSFWorkbook(new FileInputStream(path));
            System.out.println("Workbook opened");
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            workbook.write(new FileOutputStream(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFileAndClose() {
        try {
            workbook.write(new FileOutputStream(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
