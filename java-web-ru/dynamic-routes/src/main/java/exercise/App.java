package exercise;

import io.javalin.Javalin;
import io.javalin.http.HttpResponseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            if (id > COMPANIES.size() || id < 1) {
                throw new HttpResponseException(404, "Company not found");
            }
            Map<String, String > result = new HashMap<>();
            COMPANIES.forEach(key -> {
                if (key.get("id").equals(String.valueOf(id))){
                    result.putAll(key);
                }
            });
            ctx.json(result);
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
