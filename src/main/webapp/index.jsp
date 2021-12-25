<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">

                    <form method="POST" action="/user/login" class="bg-light p-5 rounded">
                        <div>
                            <label for="staticEmail" class="col-sm-10 col-form-label">Nombre de usuario</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="user" name="user" >
                            </div>
                        </div>
                        <div>
                            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" id="password">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-dark col-sm-10 mt-3">Ingresar</button>
                    </form>

                </div>

                <div class="col">

                </div>
            </div>
        </div>


    </body>

</html>