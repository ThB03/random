package UserApi;

import DAO.PokemonMoveDAO;
import DatabaseConnection.DB;
import Model.PokemonMove;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pokedex/movesByPokemon/*")
public class MovesByPokemonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract Pokemon ID from the request URL
        String[] pathParts = request.getPathInfo().split("/");
        if (pathParts.length != 2) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        long pokemonId = Long.parseLong(pathParts[1]);

        // Use DAO to retrieve moves by Pokemon ID
        try {
            List<PokemonMove> pokemonMoves = new PokemonMoveDAO(DB.getConnection()).findByPokemonId(pokemonId);

            // Serialize moves to JSON using Gson library
            String json = new Gson().toJson(moves);

            // Set response content type and write response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}