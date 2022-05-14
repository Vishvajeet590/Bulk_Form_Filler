import com.opencsv.CSVReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException {


        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        String[] lineInArray;
        String[] pointers = reader.readNext();
        while ((lineInArray = reader.readNext()) != null) {
            File file = new File("./Sample.pdf");
            PDDocument newPdf = PDDocument.load(file);
            PDPage firstPage=newPdf.getPage(0);
            PDFont pdfFont= PDType1Font.HELVETICA_BOLD;
            int fontSize = 14;
            PDPageContentStream contentStream = new PDPageContentStream(newPdf, firstPage, PDPageContentStream.AppendMode.APPEND,true,true);
            contentStream.setFont(pdfFont, fontSize);
            for (int i = 0; i<pointers.length;i++) {

                contentStream.beginText();
                String[] coordinates  = pointers[i].split("\\s+");

                System.out.println(Integer.parseInt(coordinates[0]) +"  " +Integer.parseInt(coordinates[1]));
                System.out.println(lineInArray[i]);
                contentStream.newLineAtOffset(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
                contentStream.showText(lineInArray[i]);
                contentStream.endText();
            }
            contentStream.close();
            newPdf.save(new File("./exports/"+lineInArray[0]+".pdf"));
        }




    }



}
