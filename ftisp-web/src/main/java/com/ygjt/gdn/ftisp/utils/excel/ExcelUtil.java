package com.ygjt.gdn.ftisp.utils.excel;


import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.exception.ExcelException;
import com.ygjt.gdn.ftisp.exception.ImportOutNumException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;


/**
 * @author zlj
 * @title util
 * @date 2016年5月17日上午10:37:02
 * @filename ExcelUtil
 * @Description TODO excel工具类
 */
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
    private static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @param sheet     读取的sheet页
     * @param clazz     实例化类
     * @param rowTitles 标题所在行数
     * @return List
     * @author zlj
     * @date 2016年5月16日下午10:25:35
     * @descript TODO 读取excel标题所对应的值。封装成类
     */
    @SuppressWarnings("unchecked")
    public static List excelXlsxCoverList(Sheet sheet, Class clazz, int rowTitles) {
        List list = new ArrayList();
        try {
            int rowNum = sheet.getLastRowNum();//总行数量
            Field[] fields = clazz.getDeclaredFields();
            Row row0 = sheet.getRow(0);
            Row row;

            int excelNumCell = 0;
            for (int j = 0; j < fields.length; j++) {
                Field f = fields[j];
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    excelNumCell++;
                }
            }
            //取需要导入属性字段
            int[] datanum = new int[excelNumCell];
            excelNumCell = 0;
            for (int j = 0; j < fields.length; j++) {
                Field f = fields[j];
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    //if(row0.getCell(excelNumCell).getStringCellValue().equals(hidden.exportName())){
                    datanum[excelNumCell] = j;
                    excelNumCell++;
                    //}
                }
            }
            Map<String, Integer> titleMap = getExcelTitle(row0);//标题对应的行数
            String value = "";
            Class c = Class.forName(clazz.getName());
            Object tempOrderbill;
            PropertyDescriptor pd1;
            for (int i = rowTitles + 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                if (row == null || row.getCell(0) == null) {
                    continue;
                } else {
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    if (StringUtils.isEmpty(row.getCell(0).getStringCellValue())) {
                        logger.info("第" + i + "行关键值为空。第一列为关键值");
                        continue;
                    } else if (row.getCell(0).getStringCellValue().startsWith("*说明*")) {
                        continue;
                    }
                }
                tempOrderbill = c.newInstance();
                excelNumCell = 0;
                int k = 0;
                for (int j = 0; j < datanum.length; j++) {
                    Field f = fields[datanum[j]];
                    Excel hidden = f.getAnnotation(Excel.class);
                    if (hidden != null) {
                        pd1 = new PropertyDescriptor(f.getName(), clazz);
                        k = titleMap.get(hidden.exportName());
                        Method wM = pd1.getWriteMethod();
                        if (row.getCell(k) != null) {
                            row.getCell(k).setCellType(Cell.CELL_TYPE_STRING);
                            value = row.getCell(k).getStringCellValue();
                            logger.info(value + " | " + hidden.exportName());
                            wM.invoke(tempOrderbill, value);
                        } else {

                        }
                        excelNumCell++;
                    }

                }
                list.add(tempOrderbill);
            }
        } catch (IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    /**
     * @param sheet     读取的sheet页
     * @param clazz     实例化类
     * @param rowTitles 标题所在行数
     * @return List
     * @author zlj
     * @date 2016年5月16日下午10:25:35
     * @descript TODO 读取excel标题所对应的值。封装成类
     */
    @SuppressWarnings("rawtypes")
    public static List excelXlsCoverList(Sheet sheet, Class clazz, int rowTitles) throws ExcelException {
        List list = new ArrayList();
        try {
            int rowNum = sheet.getLastRowNum();//总行数量
            //System.out.println(rowNum+"多少行");
            Field[] fields = clazz.getDeclaredFields();
            Row row0 = sheet.getRow(rowTitles);//标题行
            Row row = row0;
            int excelNumCell = 0;
            for (int j = 0; j < fields.length; j++) {
                Field f = fields[j];
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    excelNumCell++;
                }
            }
            //取需要导入属性字段
            int[] datanum = new int[excelNumCell];
            excelNumCell = 0;
            for (int j = 0; j < fields.length; j++) {
                Field f = fields[j];
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    //if(row0.getCell(excelNumCell).getStringCellValue().equals(hidden.exportName())){
                    datanum[excelNumCell] = j;
                    excelNumCell++;
                    //}
                }
            }

            Map<String, Integer> titleMap = getExcelTitle(row0);//标题对应的行数
            String value = "";
            //System.out.println("属性个数"+excelNumCell);
            Class c = Class.forName(clazz.getName());
            Object tempOrderbill;
            PropertyDescriptor pd1;
            for (int i = rowTitles + 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                if (row == null) {
                    continue;
                } else if (null != row.getCell(0)) {
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                }
                tempOrderbill = c.newInstance();
                excelNumCell = 0;
                Integer k = 0;
                for (int j = 0; j < datanum.length; j++) {
                    Field f = fields[datanum[j]];
                    Excel hidden = f.getAnnotation(Excel.class);
                    if (hidden != null) {
                        pd1 = new PropertyDescriptor(f.getName(), clazz);
                        k = titleMap.get(hidden.exportName());
                        if (k == null) {
                            throw new ExcelException("导入模板有误:【" + hidden.exportName() + "】列异常");
                        }
                        Method wM = pd1.getWriteMethod();
                        if (row.getCell(k) != null) {
                            //判断单元格是否为时间格式
                            if(row.getCell(k).getCellType() == 0){//先判断是否是数值型0(日期属于数值型)
                                if(HSSFDateUtil.isCellDateFormatted(row.getCell(k))){//判断是否是日期
                                    value = formater.format(row.getCell(k).getDateCellValue());
                                }else {
                                    row.getCell(k).setCellType(Cell.CELL_TYPE_STRING);
                                    value = row.getCell(k).getStringCellValue();
                                }
                            }else {
                                row.getCell(k).setCellType(Cell.CELL_TYPE_STRING);
                                value = row.getCell(k).getStringCellValue();
                            }
                            // logger.info(value+" | "+hidden.exportName());
                            wM.invoke(tempOrderbill, value);
                        } else {

                        }
                        excelNumCell++;
                    }

                }
                list.add(tempOrderbill);
            }
        } catch (ExcelException e) {
            throw new ExcelException(e.getMessage());
        } catch (IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    public static void writeExcel(Sheet sheet1, CellStyle cellStyle, List list, Class clazz, CellStyle cellStyleTitle) {
        try {
            // TODO Auto-generated method stub
            int i = 0;
            Field[] fields = clazz.getDeclaredFields();
            Row row0 = (Row) sheet1.createRow(0);

            int excelNumCell = 0;
            for (int j = 0; j < fields.length; j++) {
                Field f = fields[j];
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    excelNumCell++;
                }
            }
            //取需要导入属性字段
            int[] datanum = new int[excelNumCell];
            excelNumCell = 0;
            for (int j = 0; j < fields.length; j++) {
                Field f = fields[j];
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    //if(row0.getCell(excelNumCell).getStringCellValue().equals(hidden.exportName())){
                    datanum[excelNumCell] = j;
                    excelNumCell++;
                    //}
                }
            }
            row0.setHeightInPoints(20);
            //表头
            for (Field f : fields) {
                Excel hidden = f.getAnnotation(Excel.class);
                if (hidden != null) {
                    sheet1.setColumnWidth(i, 20 * 256);
                    String isHidden = hidden.exportName();
                    int ishidden11 = hidden.exportFieldWidth();
                    Cell cell = row0.createCell(i);
                    cell.setCellValue(isHidden);
                    cell.setCellStyle(cellStyleTitle);
                    // System.out.println(cls.getName());
                    // System.out.println(f.getName());
                    // System.out.println(isHidden);
                    // System.out.println(ishidden11);
                    i++;
                }
            }
            Row row;
            int k = 1;
            PropertyDescriptor pd;
            for (Object object : list) {
                row = (Row) sheet1.createRow(k);
                for (int j = 0; j < datanum.length; j++) {
                    Field f = fields[datanum[j]];
                    Excel hidden = f.getAnnotation(Excel.class);
                    if (hidden != null) {
                        pd = new PropertyDescriptor(f.getName(), clazz);
                        Method rM = pd.getReadMethod();// 获得读方法
                        String num = (String) rM.invoke(object);// 因为知道是int类型的属性,所以转换成integer就是了。。也可以不转换直接打印
                        System.out.println(num + "============");
                        Cell cell = row.createCell(j);
                        cell.setCellValue(num);
                        cell.setCellStyle(cellStyle);
                    }
                }
                k++;
            }
        } catch (IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    /**
     * @param row0 标题行
     * @return map<标题，对应列>
     * @author zlj
     * @date 2016年5月16日下午10:43:05
     * @descript TODO 获取标题行标题
     */
    private static Map<String, Integer> getExcelTitle(Row row0) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String title = null;
        for (int i = 0; i < row0.getLastCellNum(); i++) {
            if (null == row0.getCell(i)) {
                continue;
            }
            row0.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
            title = row0.getCell(i).getStringCellValue().trim();
            if (StringUtils.isEmpty(title)) {
                continue;
            }
            map.put(title, i);
        }
        return map;
    }


    /**
     * @param inputstream
     * @param clazz       excel数据模型
     * @param title       标题所在行0开始
     * @param sheetNum    读取的shet页
     * @return Collection<?> 集合
     * @author zlj
     * @date 2016年5月17日上午10:33:16
     * @descript TODO 读取excel并分装成类
     */
    @SuppressWarnings("unchecked")
    public static Collection<?> importExcel(InputStream inputstream, Class clazz, int title, int sheetNum) throws ExcelException,ImportOutNumException {
        Collection<T> result = new ArrayList<T>();
        InputStream inputstream2 = null;
        Workbook book = null;
        try {
            if (!(inputstream.markSupported())) {
                inputstream = new PushbackInputStream(inputstream, 8);
            }
            if (POIFSFileSystem.hasPOIFSHeader(inputstream)) {
                book = new HSSFWorkbook(inputstream);
                Sheet sheet = book.getSheetAt(sheetNum);
                int lastRowNu = sheet.getLastRowNum();
                if(lastRowNu > Constants.IMPORT_NUM){
                    throw new ImportOutNumException("导入的数据大于"+ Constants.IMPORT_NUM +"条，超出限制!");
                }
                result = excelXlsCoverList(sheet, clazz, title);
            }/*else if (POIXMLDocument.hasOOXMLHeader(inputstream)) {
                book = new XSSFWorkbook(inputstream);
				Sheet sheet = book.getSheetAt(sheetNum);
				result =excelXlsxCoverList(sheet, clazz, title);
			}*/
        } catch (ExcelException e) {
            throw new ExcelException(e.getMessage());
        }catch (ImportOutNumException ioe){
            throw new ImportOutNumException("导入的数据大于"+ Constants.IMPORT_NUM +"条，超出限制!");
        }catch (Exception e) {
            logger.info("excel读取错误===", e);
        }
        return result;
    }

    /**
     *没有标题（title）的导出excel
     * @param sheetName sheet页名
     * @param dataSet 行数据
     * @param pojoClass 数据类
     * @param map 列数据
     * @return
     */
    public static HSSFWorkbook exportExcelNoTitle(String sheetName, Collection<?>
            dataSet, Class<?> pojoClass, Map<String, String> map) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        createSheetNoTitle(workbook, sheetName, dataSet, pojoClass, map);
        return workbook;
    }
    private static void createSheetNoTitle(HSSFWorkbook workbook, String sheetName, Collection<?>
            dataSet, Class<?> pojoClass, Map<String, String> map){
        Sheet sheet = workbook.createSheet(sheetName);
        //创建表格属性奇数行和偶数行
        Map<String, HSSFCellStyle> styles = createStyles(workbook);
        Drawing patriarch = sheet.createDrawingPatriarch();
        Field[] fields = pojoClass.getDeclaredFields();
        List<String> titles = createTitle(fields);
        sheet.createFreezePane(0, 2, 0, 2);
        if (null != map) {
            createSecondTitle(map, sheet);
        }
        getTitle(workbook, titles, sheet, null == map ? 0 : 1);
        setValue(sheet, null == map ? 1 : 2, styles, dataSet);
    }
    /**
     * @param title     标题名称
     * @param sheetName sheet页名
     * @param dataSet   行数据
     * @param pojoClass 数据类
     * @param map       列数据。
     * @return HSSFWorkbook
     * @author zlj
     * @date 2016年5月19日下午10:23:39
     * @descript TODO  生成excel
     */
    public static HSSFWorkbook exportExcel(String title, String sheetName, Collection<?>
            dataSet, Class<?> pojoClass, Map<String, String> map) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        createSheet(workbook, title, sheetName, dataSet, pojoClass, map);
        return workbook;
    }

    private static void createSheet(HSSFWorkbook workbook, String title, String sheetName, Collection<?>
            dataSet, Class<?> pojoClass, Map<String, String> map) {
        Sheet sheet = workbook.createSheet(sheetName);
        //创建表格属性奇数行和偶数行
        Map<String, HSSFCellStyle> styles = createStyles(workbook);
        Drawing patriarch = sheet.createDrawingPatriarch();
        Field[] fields = pojoClass.getDeclaredFields();
        List<String> titles = createTitle(fields);
        int i = createHeaderRow(title, sheet, workbook, titles.size());
        if (null == title || "".equals(title)) {
            i = 0;
        }
        sheet.createFreezePane(0, 2, 0, 2);
        if (null != map) {
            createSecondTitle(map, sheet);
        }
        getTitle(workbook, titles, sheet, null == map ? 0 : 1);
        setValue(sheet, null == map ? 1 : 2, styles, dataSet);

    }

    private static Map<String, HSSFCellStyle> createStyles(HSSFWorkbook workbook) {
        Map<String, HSSFCellStyle> map = new HashMap<String, HSSFCellStyle>();
        map.put("one", getOneStyle(workbook, false));
        map.put("oneWrap", getOneStyle(workbook, true));
        map.put("two", getTwoStyle(workbook, false));
        map.put("twoWrap", getTwoStyle(workbook, true));
        return map;
    }

    public static HSSFCellStyle getOneStyle(HSSFWorkbook workbook, boolean isWarp) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderLeft((short) 1); // 左边框
        style.setBorderRight((short) 1); // 右边框
        style.setBorderBottom((short) 1);
        style.setBorderTop((short) 1);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        if (isWarp) {
            style.setWrapText(true);
        }
        return style;
    }

    public static HSSFCellStyle getTwoStyle(HSSFWorkbook workbook, boolean isWarp) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderLeft((short) 1); // 左边框
        style.setBorderRight((short) 1); // 右边框
        style.setBorderBottom((short) 1);
        style.setBorderTop((short) 1);
        style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index); // 填充的背景颜色
        style.setFillPattern(CellStyle.SOLID_FOREGROUND); // 填充图案
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        if (isWarp) {
            style.setWrapText(true);
        }
        return style;
    }

    @SuppressWarnings("unused")
    private static int createHeaderRow(String title, Sheet sheet,
                                       HSSFWorkbook workbook, int feildWidth) {
        Row row = sheet.createRow(0);
        row.setHeight((short) 900);
        createStringCell(row, 0, title, getHeaderStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, feildWidth));
        return 1;
    }

    /**
     * 表明的Style
     *
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getHeaderStyle(HSSFWorkbook workbook) {
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 24);
        titleStyle.setFont(font);
        titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return titleStyle;
    }

    /**
     * 创建文本类型的Cell
     *
     * @param row
     * @param index
     * @param text
     * @param style
     */
    private static void createStringCell(Row row, int index, String text,
                                         CellStyle style) {
        Cell cell = row.createCell(index);
        RichTextString Rtext = new HSSFRichTextString(text);
        cell.setCellValue(Rtext);
        cell.setCellStyle(style);
    }

    private static List<String> createTitle(Field[] fields) {
        List<String> list = new ArrayList<String>();
        for (Field f : fields) {
            Excel hidden = f.getAnnotation(Excel.class);
            if (hidden != null) {
                list.add(hidden.exportName());
            }
        }
        return list;
    }

    private static void createSecondTitle(Map<String, String> map, Sheet sheet) {
        Row row = sheet.createRow(1);
        int i = 0;
        Cell cell = null;
        for (Entry<String, String> entry : map.entrySet()) {
            cell = row.createCell(i);
            cell.setCellValue(entry.getKey());
            i++;
            cell = row.createCell(i);
            cell.setCellValue(entry.getValue());
            i++;
        }
    }

    /**
     * 字段说明的Style
     *
     * @param workbook
     * @return
     */
    public static void getTitle(HSSFWorkbook workbook, List<String> list, Sheet sheet, int i) {
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index); // 填充的背景颜色
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); // 填充图案
        titleStyle.setWrapText(true);
        Row row = sheet.createRow(i);
        Cell cell = null;
        for (int j = 0; j < list.size(); j++) {
            cell = row.createCell(j);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(list.get(j));
        }
    }

    public static void setValue(Sheet sheet, int i, Map<String, HSSFCellStyle> styles
            , Collection<?> dataSet) {
        try {
            Row row = null;
            Cell cell = null;
            HSSFCellStyle style = null;
            for (Object obj : dataSet) {
                int j = 0;
                row = sheet.createRow(i);
                i++;
                if (i % 2 == 0) {
                    style = styles.get("one");
                } else {
                    style = styles.get("two");
                }
                Class<?> c = obj.getClass();
                Field[] fields = c.getDeclaredFields();
                PropertyDescriptor pd1;
                for (Field f : fields) {
                    Excel hidden = f.getAnnotation(Excel.class);
                    if (null != hidden) {
                        pd1 = new PropertyDescriptor(f.getName(), c);
                        Method rM = pd1.getReadMethod();// 获得读方法
                        Object value = rM.invoke(obj);
                        cell = row.createCell(j);
                        cell.setCellStyle(style);
                        cell.setCellValue(value == null ? "" : value.toString());
                        j++;
                    }
                }
            }
        } catch (Exception e) {
            logger.info("excel数据读写错误", e);
        }
    }
}
