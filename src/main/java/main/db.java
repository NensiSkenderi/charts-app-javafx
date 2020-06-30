package main;

import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class db {

	 public static void main(String[] args) {
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/simon_app","root","root");
	            con.setAutoCommit(false);
	            PreparedStatement pstm = null ;
	            FileInputStream input = new FileInputStream("nensi.xlsx");
	            XSSFWorkbook workbook = new XSSFWorkbook (input);
			    XSSFSheet sheet = workbook.getSheetAt(0);
			     Row row;
	            for(int i=1; i<=sheet.getLastRowNum() - 1; i++){
	                row = sheet.getRow(i);
	                String country = row.getCell(0).getStringCellValue();
	                String sql = "INSERT INTO simon_app.country VALUES('"+country+"')";
	                pstm = (PreparedStatement) con.prepareStatement(sql);
	                pstm.execute();
	                System.out.println("Import rows "+i);
	            }
	            con.commit();
	            pstm.close();
	            con.close();
	            input.close();
	            System.out.println("Success import excel to mysql table");
	        }catch(ClassNotFoundException e){
	            System.out.println(e);
	        }catch(SQLException ex){
	            System.out.println(ex);
	        }catch(IOException ioe){
	            System.out.println(ioe);
	        }

	    }

	}