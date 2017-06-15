package com.mijiaokj.sys.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by wb-scg178938 on 2017/6/15.
 */
public class ExcelUtil {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public ExcelUtil() {
    }

    private static void addHeader(Sheet sheet, Collection<String> values, CellStyle style, int rowNum) {
        Row row = sheet.createRow(rowNum);
        Iterator it = values.iterator();

        for(int index = 0; it.hasNext(); ++index) {
            String name = (String)it.next();
            sheet.setColumnWidth(index, 550 * name.length());
            Cell cell = row.createCell(index, 1);
            cell.setCellValue(name);
            if(style != null) {
                cell.setCellStyle(style);
            }
        }

    }

    private static <T> void writeRow(Sheet sheet, List<T> dataList, Collection<String> pros, CellStyle style, int rowNumStart) throws Exception {
        if(dataList != null && !dataList.isEmpty()) {
            Class cls = dataList.get(0).getClass();

            for(Iterator i$ = dataList.iterator(); i$.hasNext(); ++rowNumStart) {
                Object t = i$.next();
                Row row = sheet.createRow(rowNumStart);
                int index = 0;

                for(Iterator i$1 = pros.iterator(); i$1.hasNext(); ++index) {
                    String pro = (String)i$1.next();
                    PropertyDescriptor pd = new PropertyDescriptor(pro, cls);
                    Method method = pd.getReadMethod();
                    Object val = method.invoke(t, new Object[0]);
                    Cell cell = row.createCell(index, 1);
                    setCellValue(cell, val);
                    if(style != null) {
                        cell.setCellStyle(style);
                    }
                }
            }
        }

    }

    public static <T> void defaultExport(OutputStream os, List<T> dataList, Map<String, String> mapping) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle headStyle = getDefautHeaderStyle(wb);
        CellStyle dataStyle = getDefautDataStyle(wb);
        Sheet sheet = wb.createSheet("default");
        Collection<String> headers = mapping.values();
        Set<String> pros = mapping.keySet();
        addHeader(sheet, headers, headStyle, 0);
        writeRow(sheet, dataList, pros, dataStyle, 1);

        File file = new File("c:/text.xls");//Excel文件生成后存储的位置。
        try
        {
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        wb.write(os);
    }

    public static <T> void defaultExport(FileOutputStream fileOutputStream,String filePath, List<T> dataList, Map<String, String> mapping) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle headStyle = getDefautHeaderStyle(wb);
        CellStyle dataStyle = getDefautDataStyle(wb);
        Sheet sheet = wb.createSheet("default");
        Collection<String> headers = mapping.values();
        Set<String> pros = mapping.keySet();
        addHeader(sheet, headers, headStyle, 0);
        writeRow(sheet, dataList, pros, dataStyle, 1);
//        String filePath = "c:/text.xls";
        try
        {
            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        wb.write(fileOutputStream);
    }

    public static <T> void declareExport(OutputStream os, List<T> dataList, Map<String, String> mapping, int width) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle headStyle = getDefautHeaderStyle(wb);
        CellStyle dataStyle = getDefautDataStyle(wb);
        Sheet sheet = wb.createSheet("default");
        Collection headers = mapping.values();
        Set pros = mapping.keySet();
        byte rowNum = 0;
        CellStyle style = headStyle;
        Row row = sheet.createRow(rowNum);
        Iterator it = headers.iterator();

        for(int index = 0; it.hasNext(); ++index) {
            String name = (String)it.next();
            sheet.setColumnWidth(index, 256 * width);
            Cell cell = row.createCell(index, 1);
            cell.setCellValue(name);
            if(style != null) {
                cell.setCellStyle(style);
            }
        }

        writeRow(sheet, dataList, pros, dataStyle, 1);
        wb.write(os);
    }


/*
    public static <T> void dcpExport(OutputStream os, List<T> dataList, Map<String, String> mapping) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle headStyle = getDefautHeaderStyle(wb);
        CellStyle dataStyle = getDefautDataStyle(wb);
        Sheet sheet = wb.createSheet("default");
        Collection headers = mapping.values();
        Set pros = mapping.keySet();
        addHeader(sheet, headers, headStyle, 0);
        writeRow(sheet, dataList, pros, dataStyle, 1);
        wb.write(os);
    }
// 根据TFS地址查询file
            String tfsAddress = cfFileBatch.getTfsFileName();
            InputStream in = tfsManager.fetchFile(tfsAddress, "");

            // 输出文件
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(),"ISO-8859-1"));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[4068];
            int len;
            while ((len = in.read(b)) > 0)
                os.write(b, 0, len);
            in.close();
            os.flush();
            os.close();
*/

    public static <T> void cndcpCategoryTaxcodeExport(OutputStream os, List<T> dataList, Map<String, String> mapping) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle headStyle = getSpecialHeaderStyle(wb);
        CellStyle dataStyle = getDefautDataStyle(wb);
        Sheet sheet = wb.createSheet("default");
        Collection headers = mapping.values();
        Set pros = mapping.keySet();
        addHeader(sheet, headers, headStyle, 0);
        writeRow(sheet, dataList, pros, dataStyle, 1);
        wb.write(os);
    }

    public static void setCellValue(Cell cell, Object value) {
        if(value == null) {
            cell.setCellValue("");
        } else if(value instanceof Float) {
            cell.setCellValue(value.toString());
        } else if(value instanceof Double) {
            cell.setCellValue(value.toString());
        } else if(value instanceof Boolean) {
            cell.setCellValue(((Boolean)value).booleanValue());
        } else if(value instanceof Date) {
            cell.setCellValue((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(value));
        } else {
            cell.setCellValue(value.toString());
        }

    }

    public static CellStyle getDefautHeaderStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        style.setBorderTop((short)1);
        style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        style.setFillPattern((short)1);
        return style;
    }

    public static CellStyle getSpecialHeaderStyle(Workbook wb) {
        Font font = wb.createFont();
        font.setFontHeightInPoints((short)14);
        font.setFontName("楷体");
        font.setBoldweight((short)700);
        font.setColor((short)8);
        CellStyle style = wb.createCellStyle();
        style.setFont(font);
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        style.setBorderTop((short)1);
        style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
        style.setFillPattern((short)1);
        return style;
    }

    public static CellStyle getDefautDataStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        return style;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if(cell != null) {
            switch(cell.getCellType()) {
                case 0:
//                    if(DateUtil.isCellDateFormatted(cell)) {
//                        cellValue = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cell.getDateCellValue());
//                    } else {
                        cellValue = NumberFormat.getNumberInstance().format(cell.getNumericCellValue()).replaceAll(",", "");
//                    }
                    break;
                case 1:
                    cellValue = StringUtils.trim(cell.getRichStringCellValue().getString());
                    break;
                case 2:
                    cellValue = StringUtils.trim(cell.getCellFormula());
                    break;
                case 3:
                default:
                    cellValue = "";
                    break;
                case 4:
                    cellValue = cell.getBooleanCellValue()?"TRUE":"FALSE";
                    break;
                case 5:
                    cellValue = StringUtils.trim(String.valueOf(cell.getErrorCellValue()));
            }
        }

        return cellValue;
    }

    public static List<String[]> readAllData(InputStream is, int sheetIndex) throws Exception {
        Workbook wb = null;

        try {
            wb = WorkbookFactory.create(is);
            ArrayList e = new ArrayList();
            int columnNum = 0;
            short startColNum = 0;
            boolean endColNum = false;
            Sheet sheet = wb.getSheetAt(sheetIndex);
            if(sheet.getRow(0) != null) {
                startColNum = sheet.getRow(0).getFirstCellNum();
                short var23 = sheet.getRow(0).getLastCellNum();
                columnNum = var23 - startColNum;
            }

            if(columnNum > 0) {
                Iterator i$ = sheet.iterator();

                label130:
                while(true) {
                    Row e1;
                    do {
                        if(!i$.hasNext()) {
                            break label130;
                        }

                        e1 = (Row)i$.next();
                    } while(e1 == null);

                    String[] singleRow = new String[columnNum + 1];
                    singleRow[0] = e1.getRowNum() + 1 + "";

                    for(int i = 0; i < columnNum; ++i) {
                        Cell cell = e1.getCell(i + startColNum);
                        if(cell != null) {
                            singleRow[i + 1] = getCellValue(cell);
                        } else {
                            singleRow[i + 1] = "";
                        }
                    }

                    e.add(singleRow);
                }
            }

            ArrayList var24 = e;
            return var24;
        } catch (IOException var21) {
            logger.error("io exception", var21);
        } finally {
            try {
                is.close();
            } catch (IOException var20) {
                logger.error("io close error", var20);
            }

        }

        return Collections.EMPTY_LIST;
    }

}
