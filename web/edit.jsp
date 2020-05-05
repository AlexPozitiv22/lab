<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit сity</title>
</head>
<body>
<h3>Edit city</h3>
<form method="post">
    <input type="hidden" value="${city.id}" name="id" />
    <label>Name</label><br>
    <input name="name" value="${city.name}" /><br><br>
    <label>State id</label><br>
    <input name="stateId" value="${city.stateId}" type="number"/><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
