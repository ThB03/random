package UserApi;

import DAO.*;
import DatabaseConnection.DB;
import Model.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pokedex/*")
public class PokedexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // Handle request for /pokedex endpoint to fetch all Pokémon
            handleGetAll(request, response);
        } else if (pathInfo.startsWith("/simple")) {
            // Handle request for /pokedex/simple endpoint to fetch simple Pokédex entries
            handleGetSimple(request, response);
        } else {
            // Handle request for /pokedex/{id} endpoint to fetch specific Pokémon by ID
            handleGetById(request, response);
        }
    }

    private void handleGetAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PokemonDAO pokemonDAO = new PokemonDAO(DB.getConnection()); // Replace with your DB connection logic
            List<Pokemon> pokemons = pokemonDAO.findAll();

            List<PokedexEntryClass> pokedexEntries = new ArrayList<>();
            for (Pokemon pokemon : pokemons) {
                List<String> types = new PokemonTypeDAO(DB.getConnection()).findByPokemonId(pokemon.getId());
                pokedexEntries.add(new PokedexEntryClass(pokemon,types));
            }
            // Convert PokedexEntries list to JSON
            Gson gson = new Gson();
            String pokemonsJson = gson.toJson(pokedexEntries);

            // Set content type and write JSON response
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(pokemonsJson);
            out.flush();

        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(); // Log exception
        }
    }

    private void handleGetSimple(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PokemonDAO pokemonDAO = new PokemonDAO(DB.getConnection()); // Replace with your DB connection logic
            List<SimplePokedexEntryClass> simplePokedex = pokemonDAO.findSimpleAll();

            // Convert SimplePokedexEntryClass list to JSON
            Gson gson = new Gson();
            String simplePokedexJson = gson.toJson(simplePokedex);

            // Set content type and write JSON response
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(simplePokedexJson);
            out.flush();

        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(); // Log exception
        }
    }

    private void handleGetById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        try {
            long id = Long.parseLong(pathInfo.substring(1)); // remove leading slash
            PokemonDAO pokemonDAO = new PokemonDAO(DB.getConnection()); // Replace with your DB connection logic
            Pokemon pokemon = pokemonDAO.findById(id);

            if (pokemon == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }


            List<String> types = new PokemonTypeDAO(DB.getConnection()).findByPokemonId(pokemon.getId());
            List<PokemonAbility> pokemonAbilities = new PokemonAbilityDAO(DB.getConnection()).findByPokemonId(pokemon.getId());
            AbilityDAO abilityDAO = new AbilityDAO(DB.getConnection());
            List<Ability> abilities = new ArrayList<>();
            for (PokemonAbility pokemonAbility : pokemonAbilities) {
                abilities.add(abilityDAO.findById(pokemonAbility.getAbilityId()));
            }
            List<PokemonMove> pokemonMoves = new PokemonMoveDAO(DB.getConnection()).findByPokemonId(pokemon.getId());
            List<Move> moves = new ArrayList<>();
            MoveDAO moveDAO = new MoveDAO(DB.getConnection());
            for (PokemonMove pokemonMove : pokemonMoves) {
                moves.add(moveDAO.findById(pokemonMove.getMoveId()));
            }

            PokemonClass pokemonClass = new PokemonClass(pokemon, types, abilities, moves);


            // Convert PokemonClass object to JSON
            Gson gson = new Gson();
            String pokemonJson = gson.toJson(pokemonClass);

            // Set content type and write JSON response
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(pokemonJson);
            out.flush();

        } catch (NumberFormatException | SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(); // Log exception
        }
    }
}
