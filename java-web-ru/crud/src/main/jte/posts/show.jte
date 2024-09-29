@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(content =
        @`
            <div>
                ${page.getPost().getName()}
            </div>
        <div>
            ${page.getPost().getBody()}
        </div>
            <footer>
                <a href="/posts">Return back</a>
            </footer>
        `)