package utility;

import model.Movies;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieNameUtility {
    public final static String INPUT_FILE = "assets\\Movies.xlsx";

    public static List<Movies> retrievePeopleFromWorkbook(final File inputFile) throws IOException, InvalidFormatException {
        final List<Movies> movies = new ArrayList<>();

        final Workbook workbook = WorkbookFactory.create(inputFile);
        final Sheet sheet = workbook.getSheetAt(0);


        for(final Row row : sheet) {
            final Cell titleCell = row.getCell(0);
            final Cell directorCell = row.getCell(1);
            final Cell lengthInMinutesCell = row.getCell(2);


            final Movies movie = new Movies(titleCell.getStringCellValue().trim(),
                    directorCell.getStringCellValue().trim(),
                    (int) lengthInMinutesCell.getNumericCellValue());


            movies.add(movie);
        }
        return movies;
    }
}
