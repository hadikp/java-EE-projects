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
            Font font = new Font(FontFamily.COURIER, 22, Font.BOLD, BaseColor.BLUE);
            Chunk chunk = new Chunk("Write text equals Hello world", font);
            chunk.setBackground(BaseColor.GRAY);
            Paragraph paragraph = new Paragraph(chunk);
            System.out.println(paragraph);
            document.add(paragraph);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
