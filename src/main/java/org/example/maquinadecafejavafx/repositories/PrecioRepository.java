package org.example.maquinadecafejavafx.repositories;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.maquinadecafejavafx.entities.Menu;
import org.example.maquinadecafejavafx.entities.Producto;

public class PrecioRepository {

    private static final String RUTA_JSON = "/data/precios.json";

    public Menu obtenerMenu() {
        try (InputStream in = getClass().getResourceAsStream(RUTA_JSON);
             InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {

            Type tipoLista = new TypeToken<List<Producto>>() {}.getType();
            List<Producto> productos = new Gson().fromJson(reader, tipoLista);
            return new Menu(productos);

        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo de precios: " + RUTA_JSON, e);
        }
    }
}