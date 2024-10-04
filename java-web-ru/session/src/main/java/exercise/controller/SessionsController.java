package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.Collections;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx){
        var page = new LoginPage("", "");
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }
    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(UsersRepository::existsByName, "Wrong username or password")
                    .get();
            var passwordHash = Security.encrypt(ctx.formParam("password"));
            var user = UsersRepository.findByName(name)
                    .orElseThrow(() -> new NotFoundResponse("No user found"));
            if (user != null && user.getPassword().equals(passwordHash)) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect("/");
            } else throw new NotFoundResponse("Wrong name or password");
        } catch (NotFoundResponse e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void show(Context ctx) {
        var name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");

        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", model("page", page));
    }
    // END
}
