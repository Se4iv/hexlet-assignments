@import exercise.dto.users.UsersPage
@param UsersPage page = null

@template.layout.page(content =
@`


    <form action="/users" method="get">
        <input type="search" required name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>

    @if(page != null)
        @for(var user : page.getUsers())
            <a href="/users/${user.getFirstName()}">${user.getFirstName()}
                ${user.getLastName()}</a>
        @endfor
    @endif
`
)