package exercise;

import io.javalin.Javalin;
import java.util.List;

import io.javalin.http.HttpResponseException;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            if (id < 1 || id >= USERS.size()){
                throw new HttpResponseException(404);
            }
            var user = new UserPage(USERS.stream()
                    .filter(z-> z.getId() == id)
                    .findFirst()
                    .get());
            ctx.render("users/show.jte", model("page", user));
        });

        app.get("/users", ctx -> {
            var users = new UsersPage(USERS);
            ctx.render("users/index.jte", model("page", users));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
