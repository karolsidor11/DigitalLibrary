package pl.sidor.utils;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfView extends AbstractView {


    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

//        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=myReport.pdf");
//        Report report = (Report) model.get("report");
//
//        //IText API
//        PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
//        PdfDocument pdf = new PdfDocument(pdfWriter);
//        Document pdfDocument = new Document(pdf);
//
//        //title
//        Paragraph title = new Paragraph(report.getName());
//        title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
//        title.setFontSize(18f);
//        title.setItalic();
//        pdfDocument.add(title);
//
//        //date
//        Paragraph date = new Paragraph(report.getDate().format(
//                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
//        date.setFontSize(16f);
//        pdfDocument.add(date);
//
//        //content
//        Paragraph content = new Paragraph(report.getContent());
//        pdfDocument.add(content);
//
//        pdfDocument.close();
//    }
//    }
    }
}
