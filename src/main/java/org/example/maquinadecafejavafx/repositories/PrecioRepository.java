package org.example.maquinadecafejavafx.repositories;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.maquinadecafejavafx.entities.Menu;
import org.example.maquinadecafejavafx.entities.Producto;

public class PrecioRepository {

    private static final Path RUTA_JSON = Path.of("data", "precios.json");

    public Menu obtenerMenu() {
        if (!Files.exists(RUTA_JSON)) {
            throw new RuntimeException(
                    "No se encontró el archivo de precios.\n"
                            + "  Ruta buscada : " + RUTA_JSON.toAbsolutePath() + "\n"
                            + "  Ejecutando en: " + Path.of("").toAbsolutePath());
        }

        try (Reader reader = Files.newBufferedReader(RUTA_JSON, StandardCharsets.UTF_8)) {
            Type tipoLista = new TypeToken<List<Producto>>() {}.getType();
            List<Producto> productos = new Gson().fromJson(reader, tipoLista);
            return new Menu(productos);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo de precios: "
                    + RUTA_JSON.toAbsolutePath(), e);
        }
    }
}