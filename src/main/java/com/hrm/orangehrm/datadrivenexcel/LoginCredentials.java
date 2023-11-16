package com.hrm.orangehrm.datadrivenexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class LoginCredentials {
        private LoginCredentials() {
        }
        public static class CustomException extends Exception {
            public CustomException(String message) {
                super(message);

            }
        }

        public static final String SEPARATOR = "/";
        public static final String JOB_NAME = System.getenv("JOB_NAME");
        public static final String JENKINS_HOME_PATH = System.getProperty("user.home");
        public static final String COMMON_PATH =  "src/test/resources/TestData/TestData.xlsx";
        public static final String EXCEL_PATH_IN_JENKINS = JENKINS_HOME_PATH + "/workspace" + SEPARATOR + JOB_NAME + SEPARATOR + COMMON_PATH;
        public static final String LOGIN_CRED = "LoginCred";
        protected static final Logger LOGGER = Logger.getLogger(LoginCredentials.class.getName());


        public static String loginPageCommon(int rowNumber, int columnNumber) throws IOException {
            //Create an object of file class to open xlsx file
            File file;
            if (JOB_NAME != null) {
                file = new File(EXCEL_PATH_IN_JENKINS);
            } else {
                file = new File(COMMON_PATH);
            }
            //Create an object of FileInputStream class to read xlsx file
            FileInputStream fs = new FileInputStream(file);
            XSSFSheet sheet = null;
            //Create workbook instance that refers to .xls file
            try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
                //Create a Sheet object using the sheet name
                sheet = workbook.getSheet(LOGIN_CRED);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception in loginPageCommon method in loginCredE2E :");
            }
            //Create a row object to retrieve row at index 1
            XSSFRow row = null;
            if (sheet != null) {
                row = sheet.getRow(rowNumber);
            }
            XSSFCell cell = null;
            if (row != null) {
                cell = row.getCell(columnNumber);
            }
            if (cell != null) {
                return cell.getStringCellValue();
            } else {
                return null;
            }
        }
        public static String returnURL() {
            String strURL="";
            try {
                strURL=loginPageCommon(1, 2);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception in returnURL method in LoginCredentials");
            }

            return strURL;
        }

        public static String returnUsername() {
            String username = "";
            try {
                username = loginPageCommon(1, 0);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception in returnUsername method in LoginCredentials:");
            }
            return username;
        }

        public static String returnPassword() {
            String password = "";
            try {
                password = loginPageCommon(1, 1);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception in returnPassword method in LoginCredentials");
            }
            return password;
        }

}
