package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movies;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.WorkBookUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name ="SearchServlet", urlPatterns = "/SearchTitle")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get access to our spreadsheet
        final String filePath = getServletContext().getRealPath(WorkBookUtility.INPUT_FILE);
        final File inputFile = new File(filePath);

        //fetch the list of movies
        try {
            final List<Movies> movies = WorkBookUtility.retrieveMoviesFromWorkbook(inputFile);

            String filterTitle = request.getParameter("title");

        //filter the list
        final List<Movies>  filteredMovies =   movies.stream()
                .filter((Movies m) -> m.getTitle()
                        .equalsIgnoreCase(filterTitle))
                            .collect(Collectors.toList());

        //attach the list(model) to the request
        request.setAttribute("movies",filteredMovies);

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        //forward the request (to the view)
        getServletContext().getRequestDispatcher("/view-all.jsp").forward(request, response);
    }
}
