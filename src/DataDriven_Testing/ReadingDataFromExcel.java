package DataDriven_Testing;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		// Open Excel File 
		FileInputStream  file = new FileInputStream ("C:\\Users\\CODECLOUDS-ARKA\\eclipse-workspace\\Introduction\\TestData\\DataSheet.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Number Of Row - "+totalRows+",Total Number Of Cells For 1st Cells - "+totalCells);
		for (int row=1; row<=totalRows; row++ ){
			XSSFRow currentRow = sheet.getRow(row);
			for (int cell=0;  cell<totalCells; cell++){
				XSSFCell dataCell = currentRow.getCell(cell);
				System.out.print(dataCell.toString()+"\t");
			}
			System.out.println();
		}
		workBook.close();
		file.close();
	}

}
