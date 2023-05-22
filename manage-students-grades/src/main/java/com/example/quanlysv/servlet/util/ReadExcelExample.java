package com.example.quanlysv.servlet.util;

import com.example.quanlysv.servlet.entity.GradeEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelExample  {
    public static final int COULUMN_INDEX_ID_SV=1;
    public static final int COULUMN_INDEX_CC=5;
    public static final int COULUMN_INDEX_KT=7;
    public static final int COULUMN_INDEX_THI=8;
    public static final int COULUMN_INDEX_BT=9;

    //    public static void main(String[] args) throws IOException {
//        getDataFromExcel();
//    }
    public static List<GradeEntity> getDataFromExcel(String filePath) throws IOException {
        String excelFilePath = filePath;
        final List<GradeEntity> gradeList = readExcel(excelFilePath);
//        for (GradeEntity grade : gradeList) {
//            System.out.println(grade.toString());
//        }
        return gradeList;
    }
    public static List<GradeEntity> readExcel(String excelFilePath) throws IOException {
        List<GradeEntity> gradeList = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() < 7 ) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            GradeEntity grade = new GradeEntity();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }

                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COULUMN_INDEX_ID_SV:
                        String IdSV= (String) (getCellValue(cell));
                        grade.setIdSv(IdSV);
                        break;
                    case COULUMN_INDEX_CC:
//                        System.out.println(columnIndex+" CC "+ cellValue);
                        Double diemCc= (Double)( getCellValue(cell));
                        grade.setDiemCc( diemCc );
                        break;
                    case COULUMN_INDEX_KT:
                        System.out.println(" KT "+ cellValue);

                        Double dienKt= (Double)( getCellValue(cell));

                        grade.setDiemKt( dienKt );
                        break;
                    case COULUMN_INDEX_THI:
                        Double diemThi= (Double)( getCellValue(cell));
                        System.out.println(" THI "+ cellValue);

                        grade.setDiemThi( diemThi );
                        break;
                    case COULUMN_INDEX_BT:
                        Double diemBt= (Double)( getCellValue(cell));
//                        System.out.println(columnIndex+" BT "+ cellValue);

                        grade.setDiemBt( diemBt );
                        break;
                    default:
                        break;
                }
            }
            Instant instant=Instant.now();
            grade.setNgayTao(instant);
            grade.setNgaySua(instant);
            gradeList.add(grade);

        }

        workbook.close();
        inputStream.close();

        return gradeList;
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }
}