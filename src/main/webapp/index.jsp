<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<body style="background-color:powderblue;">
<style>
    div.relative {
        position: relative;
        width: 1320px;
        height: 1043px;
    }

    div.message {
        position: absolute;
        top: 100px;
        left: 50px;
        width: 558px;
        height: 200px;
    }

    div.mainimage {
        position: absolute;
        top: -40px;
        left: 700px;
        width: 558px;
        height: 961px;
    }
</style>
</head>

<div class="relative">
    <div class="message">
        <h1>
            Hello,welcome to Nanjing Xuanwumen
        </h1>
        <br>
        <form method="post" action="login">
            <label>Name:</label>
            <br>
            <input type="neme" name="name">
            <br>
            <label>Last name:</label>
            <br>
            <input type="lastNeme" name="lastName">
            <br>
            <label>National Code:</label>
            <br>
            <input type="nationalCode" name="nationalCode">
            <br>

            <input type="submit" value="login">
        </form>

    </div>
    <div class="mainimage">
        <img src="https://ak-d.tripcdn.com/images/200d1h000001hnx0z3D55_Z_1080_808_R5_D.jpg" alt=""
             style="width: 558px; height: 761px; object-fit: cover; object-position: 50% 50%;">
    </div>
</div>

</body>
</html>