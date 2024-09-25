@import exercise.dto.users.UserPage
@import gg.jte.Content
@param UserPage page = null
@param Content content
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Testing</title>
</head>
<body>
<header>
<p>Тяжело было, тяжело</p>
    <a href='/'>Main page</a>
    <a href='/users'>Users list</a>
</header>
${content}
<footer>
    Тяжеловатый урок, сложно понять...
</footer>
</body>
</html>