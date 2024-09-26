@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page = null

@template.layout.page(content =
@`
    @if(page != null)
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div>
            <label>
                Title
                <input type="text" required name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div>
            <label>
                    Content
                    <textarea required name="content">
                        ${page.getContent()}
                    </textarea>
            </label>
        </div>
        <input type="submit" value="Завести статью" />
    </form>
    @endif
`))