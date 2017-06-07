package com.ygjt.gdn.ftisp.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by wyh on 2016/10/29.
 */
public class CellValueUtils {
    @SuppressWarnings("unused")
    public static String getStringCellValue(HSSFCell cell){
        String strCell = "";
        switch (cell.getCellType()){
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if(strCell.equals("") || strCell == null){
            return "";
        }
        if(cell == null){
            return "";
        }
        return strCell;
    }

    public static boolean isNull(HSSFCell cell){
        if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
            return true;
        }else{
            return false;
        }
    }

    public static void setValue(String str, HSSFCell cell, HSSFWorkbook wb){
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell.setCellValue(str);
        cell.setCellStyle(style);
    }

    public static boolean isRowNull(int i, HSSFRow row){
        int k = 0;
        for(int t = 0; t < i; t ++){
            if(row.getCell(t) == null || row.getCell(t).getCellType() == Cell.CELL_TYPE_BLANK){
                k ++;
            }
        }
        if(k == i){
            return true;
        }
        return false;
    }
}
