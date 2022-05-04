package osago;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * <b> ����� ����������� �������� � ���������� �������� PDF �����.</b>
 * 
 * @author Kazantsev AV
 * @version 2.0 � ������ ���� ����������� c 2 �����������. ����� ������� ��
 *          ���������� itextpdf.
 * 
 *          ��� �������� PDF ����� ���������� ������� ��������� �������
 *          CreatePDF � ����� ��������� ����������� ������� (�����, ������� �
 *          �������). ����� ��������� ���������� ���������� ��������� �����
 *          getClose, ������� ������� � ��������� PDF ��������.
 * 
 */

public class Pdf {

	/** ���� �������� ������������� ������ */
	private BaseFont times;
	/** ���� � ������ ������������ PDF ����� */
	private String Namefile;
	/*
	 * ���� �� ���������� ����� �������/ private String[] NameCellHat; private
	 * String[][] arrayCell; /** ���� � ������� �� ����������� ��������
	 */
	private Document document;
	/** ���� � ����������� �������� � ������� */
	private int Size, SizeCell;
	/** */
	private PdfPTable table;

	/**
	 * ����������� - �������� ������� � ���������� PDF
	 * 
	 * @param Namefile    - ��� ���������� �����
	 * @param BaseFontPDF - ����� ��� ������
	 * @throws FileNotFoundException
	 */
	public Pdf(String Namefile, BaseFont BaseFontPDF) throws FileNotFoundException {
		this.Namefile = Namefile;
		this.times = BaseFontPDF;

		this.document = new Document(); // �������� ������� Document
		try {
			PdfWriter.getInstance(document, new FileOutputStream(this.Namefile)); // �������� ����� ��� �������� PDF, �
																					// ������ ��������� ����� ������ �
																					// ���������� ������
		} catch (DocumentException e) { // ���������� ����� ���� �� ������
			e.printStackTrace();
		}

		document.open(); // �������� ��� ����������� ������

	}

	/**
	 * ����� ���������� ����� � �������
	 * 
	 * @param table     - ������� ��� ����������
	 * @param arrayCell - ��������� ������ �� �������� �����
	 */

	private void addRows(PdfPTable table, String[][] arrayCell) {
		// ��������� �������� � ������ ��� ���������� ������ � ������
		int SizeTwo = arrayCell.length; // ���������� �����
		int SizeOne = arrayCell[0].length; // ������������� ���������� ��������

		for (int j = 0; j < SizeTwo; j++) {
			for (int i = 0; i < SizeOne; i++) {
				table.addCell(new Phrase(arrayCell[j][i], new Font(times, 14)));
			}
		}
	}

	/**
	 * ����� ���������� ����� �������
	 * 
	 * @param table - ������� ��� ����������
	 */

	private void setHeader(PdfPTable table, String[] NameCellHat) { // ����� ��� ������ � ������ �������
		for (int i = 0; i < NameCellHat.length; i++) {
			PdfPCell header = new PdfPCell(); // ���������� ������ � �������
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			// ��������� �������� � ������ ��� ���������� ������ � ������
			header.setPhrase(new Phrase(NameCellHat[i], new Font(times, 14)));
			table.addCell(header);
		}
	}

	/**
	 * ����� ��� ��������� ������ �� ����������� ��������
	 * 
	 * @return ���������� ������ �� ����������� ��������
	 */

	public Document getDocument() {
		return this.document;
	}

	/**
	 * ����� ��� �������� � ���������� PDF �����
	 */

	public void getClose() {
		this.document.close();
	}

	/**
	 * ����� ���������� ������ � PDF ��������. ���������� ���������� � ������
	 * ���������.
	 * 
	 * @param document - ������ �� ����������� ��������
	 * @param Text     - ���������� �����
	 * @param SizeFont - ������ ������
	 * @param Space    - �������� ��������� �� ������� �� ����� ������
	 */

	public void addText(Document document, String Text, int SizeFont, boolean Space) {
		Paragraph paragraph = new Paragraph(); // �������� ������� "��������" ��� ����������� ������ ������ � ����
		Paragraph paragraphadd = new Paragraph(Text, new Font(times, SizeFont));
		paragraphadd.setAlignment(com.itextpdf.text.Element.ALIGN_JUSTIFIED);
		paragraph.add(paragraphadd);

		try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		paragraph.clear();

		if (Space) {

			String string_pdf3 = " ";
			paragraph.add(new Paragraph(string_pdf3, new Font(times, 14)));

			try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
		}

		paragraph = null;
	}

	/**
	 * ����� ������������� ������� � ���������� ����� � �������.
	 * 
	 * @param document    - ������ �� ����������� ��������
	 * @param NameCellHat - ������ ��� ����� �������
	 */

	public void InitTableAndAddHat(Document document, String[] NameCellHat) {

		table = new PdfPTable(NameCellHat.length);
		setHeader(table, NameCellHat); // ������� ��������� (����� �������)

	}

	/**
	 * ����� ��������� ������ �� ����������� �������, ������� ����� ���������
	 * (������).
	 * 
	 * @return ���������� ������ �� ��������� �������
	 */

	public PdfPTable getTable() {
		return table;
	}

	/**
	 * ����� ������������� ������� � ���������� ����� � �������.
	 * 
	 * @param Table     - ������ �� ����������� �������, ������� �������� �������
	 *                  {@link InitTableAndAddHat}
	 * @param arrayCell - ������ ��� ����� � ������� (�������������� � ����
	 *                  ���������� �������)
	 */

	public void addRowsInTable(PdfPTable Table, String[][] arrayCell) {
		addRows(Table, arrayCell);

	}

	/**
	 * ����� ���������� ������� � PDF ��������.
	 * 
	 * @param document - ������ �� ����������� ��������
	 * @param Table    - ������ �� ����������� �������, ������� �������� �������
	 *                 {@link InitTableAndAddHat}
	 */

	public void addTable(Document document, PdfPTable Table) {
		try {
			document.add(Table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
