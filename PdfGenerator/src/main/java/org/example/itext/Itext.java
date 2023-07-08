package org.example.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Stateless
public class Itext {

    public Object createPdf() {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("iText.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 22, BaseColor.BLUE);
            Chunk chunk = new Chunk("Hello world", font);
            document.add(chunk);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
