package exercise;
import io.javalin.Javalin;
// BEGIN

// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            // Включаем логгирование при разработке
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
