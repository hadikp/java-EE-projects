package org.example.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static com.itextpdf.text.Font.*;

@Stateless
public class Itext {

    public String createPdf() {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("iText.pdf"));
            writer.setInitialLeading(16);
            document.open();
            Font font = new Font(FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.BLUE);
            Font font2 = new Font(FontFamily.TIMES_ROMAN, 22, Font.BOLD, BaseColor.CYAN);
            Font font3 = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 17, BaseColor.GRAY);
            Chunk chunk = new Chunk("Write text equals Hello world", font);
            Chunk chunk2 = new Chunk("Write text equals Hello world in next line", font2);
            Chunk chunk3 = new Chunk("Write text equals Hello world in next line", font3);

            chunk.setBackground(BaseColor.GRAY);
            Paragraph paragraph = new Paragraph(chunk);
            Paragraph paragraph2 = new Paragraph(chunk2);
            Paragraph paragraph3 = new Paragraph(chunk3);

            document.add(paragraph);
            document.add(paragraph2);
            document.add(paragraph3);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
