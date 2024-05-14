@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
              crossorigin="anonymous">
        <title>Список пользователей</title>
    </head>
    <body>
        @if(page.getUsers().isEmpty())
            <p>Список пользователей пустой</p>
        @else
            @for(var pages : page.getUsers())
               <ul>
                   <li><a href="/users/${pages.getId()}">${pages.getFirstName() + pages.getLastName()}</a></li>
               </ul>
            @endfor
        @endif
    </body>
</html>