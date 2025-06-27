import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	Map<String,String> data = new HashMap<>();
	
	try {
	FileInputStream fis = new FileInputStream("D:\\DataSheet.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet1");
	for(Row row : sheet) {
		Cell keyCell = row.getCell(0);
		Cell valueCell = row.getCell(1);
		
		if(keyCell!=null && valueCell!=null) {
			keyCell.setCellType(CellType.STRING);
			valueCell.setCellType(CellType.STRING);
			data.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
		}
	}
	
	for(Map.Entry<String,String> entry : data.entrySet()) {
		System.out.println(entry.getKey()+" : "+entry.getValue());
	}

}catch(FileNotFoundException e) {
	System.out.println(e);
}
}
}