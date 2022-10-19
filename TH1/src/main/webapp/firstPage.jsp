<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Images</title>
    <style>
        .container {
            display: flex;
            flex-wrap: wrap;
        }

        .container .image {
            width: 50%;
        }

        .container img {
            width: calc(100% - (20px * 2));
            margin: 10px 20px;
            transition: transform 0.4s;
        }

        .container img:hover {
            transform: scale(1.05);
        }

        @media (max-width: 740px) {
            .container .image {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="image">
            <img src="./images/anh1.jpg" />
        </div>
        <div class="image">
            <img src="./images/anh1.jpg" />
        </div>
        <div class="image">
            <img src="./images/anh1.jpg" />
        </div>
        <div class="image">
            <img src="./images/anh1.jpg" />
        </div>
    </div>

</body>
</html>