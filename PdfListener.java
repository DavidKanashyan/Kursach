package osago;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

public class PdfListener {

	public PdfListener(String TB, String KT, String KBM, String KBC, String KO, String KM, String KC, String RES)
			throws FileNotFoundException, IOException {

		String[][] KanashyanCell = new String[8][2];
		KanashyanCell[0][1] = TB;
		KanashyanCell[1][1] = KT;
		KanashyanCell[2][1] = KBM;
		KanashyanCell[3][1] = KBC;
		KanashyanCell[4][1] = KO;
		KanashyanCell[5][1] = KM;
		KanashyanCell[6][1] = KC;
		KanashyanCell[7][1] = RES;
		KanashyanCell[0][0] = "TБ";
		KanashyanCell[1][0] = "KT";
		KanashyanCell[2][0] = "KБM";
		KanashyanCell[3][0] = "KBC";
		KanashyanCell[4][0] = "KO";
		KanashyanCell[5][0] = "KM";
		KanashyanCell[6][0] = "KC";
		KanashyanCell[7][0] = "К оплате";

		String[] Hat = new String[2];
		Hat[0] = "Тип коэффициента";
		Hat[1] = "Коэффициент";

		String Texthat = "Стоимость осаго для вашего автомобиля";
		String Textgeneral = "Расчёты стоимости ОСАГО: ";
		String filepath;
		filepath = new File("").getCanonicalPath();

		String[] parsfilepath = filepath.split("/");

		int lengthpath = parsfilepath.length;
		String abspath = "";
		for (int i = 0; i < (lengthpath - 1); i++) {
			abspath = abspath + parsfilepath[i] + "/";
		}
		// filepath=abspath+"webapps/CreatePDF/Check.pdf";
		String Namefile = Math.random() + "OSAGO.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/TimesNewRoman.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		Pdf pdf = new Pdf(Namefile, times);
		Document document = pdf.getDocument();
		pdf.addText(document, Texthat, 18, true);
		pdf.addText(document, Textgeneral, 14, true);
		pdf.InitTableAndAddHat(document, Hat);
		pdf.addRowsInTable(pdf.getTable(), KanashyanCell);
		pdf.addTable(document, pdf.getTable());
		pdf.getClose();

	}
}
