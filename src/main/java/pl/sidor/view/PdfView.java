package pl.sidor.view;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import pl.sidor.model.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        generateParagraph(document);

        PdfPTable table = new PdfPTable(6);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        List<Book> books = (List<Book>) map.get("books");

        table.addCell("Numer ");
        table.addCell("Tytuł ");
        table.addCell("Autor");
        table.addCell("Ilość stron");
        table.addCell("Numer ISBN");
        table.addCell("Data zwrotu");


        for (Book book : books) {
            table.addCell(String.valueOf(book.getId()));
            table.addCell(book.getTitle());
            table.addCell(book.getAuthor());
            table.addCell(String.valueOf(book.getPages()));
            table.addCell(book.getIsbn());
            table.addCell(dateOfReturnBook());

        }

        document.add(table);
    }

    private Paragraph generateParagraph(Document document) throws DocumentException {
        Paragraph header = new Paragraph(new Chunk("Zamowione egzemplarze ksiazek ", FontFactory.getFont(FontFactory.HELVETICA, 30)));
        Paragraph by = new Paragraph(new Chunk("Uzytkownik :  " + getName(), FontFactory.getFont(FontFactory.HELVETICA, 20)));
        Paragraph paragraph = new Paragraph(new Chunk("      "));

        header.setAlignment("center");
        by.setAlignment("center");

        document.add(header);
        document.add(by);
        document.add(paragraph);
        document.addAuthor("Karol Sidor");
        document.addTitle("Zestawie zamówienia ");

        return paragraph;
    }

    private String dateOfReturnBook() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        return sdf.format(date);
    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
