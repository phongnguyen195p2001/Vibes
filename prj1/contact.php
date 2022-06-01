<html>

<head>
    <title>Contact Us Form</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <style>
        body {
            font-family: Arial;
        }

        .form-container {
            background: #f1ecdf;
            border: #e2ddd2 1px solid;
            padding: 20px;
            border-radius: 2px;
        }

        .input-row {
            margin-bottom: 20px;
        }

        .input-row label {
            color: #75726c;
        }

        .input-field {
            width: 100%;
            border-radius: 2px;
            padding: 10px;
            border: #e0dfdf 1px solid;
            box-sizing: border-box;
            margin-top: 2px;
        }

        .span-field {
            font: Arial;
            font-size: small;
            text-decoration: none;
        }

        .btn-submit {
            padding: 10px 60px;
            background: #9e9a91;
            border: #8c8880 1px solid;
            color: #ffffff;
            font-size: 0.9em;
            border-radius: 2px;
            cursor: pointer;
        }

        .errorMessage {
            background-color: #e66262;
            border: #AA4502 1px solid;
            padding: 5px 10px;
            color: #FFFFFF;
            border-radius: 3px;
        }

        .successMessage {
            background-color: #9fd2a1;
            border: #91bf93 1px solid;
            padding: 5px 10px;
            color: #3d503d;
            border-radius: 3px;
            cursor: pointer;
            font-size: 0.9em;
        }

        .info {
            font-size: .8em;
            color: #e66262;
            letter-spacing: 2px;
            padding-left: 5px;
        }

        p.P{
            font-size: 30px;
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="form-container">
        <p class="P">Contact</p>
        <form name="frmContact" id="" frmContact"" method="post" action="" enctype="multipart/form-data" onsubmit="return validateContactForm()">

            <div class="input-row">
                <label style="padding-top: 20px;">Name</label> <span id="userName-info" class="info"></span><br /> <input type="text" class="input-field" name="userName" id="userName" />
            </div>
            <div class="input-row">
                <label>Email</label> <span id="userEmail-info" class="info"></span><br /> <input type="text" class="input-field" name="userEmail" id="userEmail" />
            </div>
            <div class="input-row">
                <label>Message</label> <span id="userMessage-info" class="info"></span><br />
                <textarea name="content" id="content" class="input-field" cols="60" rows="6"></textarea>
            </div>
            <div>
                <input type="submit" name="send" class="btn-submit" value="Send" />

                <div id="statusMessage">
                    <?php
                    if (!empty($message)) {
                    ?>
                        <p class='<?php echo $type; ?>Message'><?php echo $message; ?></p>
                    <?php
                    }
                    ?>
                </div>
            </div>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function validateContactForm() {
            var valid = true;

            $(".info").html("");
            $(".input-field").css('border', '#e0dfdf 1px solid');
            var userName = $("#userName").val();
            var userEmail = $("#userEmail").val();
            var subject = $("#subject").val();
            var content = $("#content").val();

            if (userName == "") {
                $("#userName-info").html("Required.");
                $("#userName").css('border', '#e66262 1px solid');
                valid = false;
            }
            if (userEmail == "") {
                $("#userEmail-info").html("Required.");
                $("#userEmail").css('border', '#e66262 1px solid');
                valid = false;
            }
            if (!userEmail.match(/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/)) {
                $("#userEmail-info").html("Invalid Email Address.");
                $("#userEmail").css('border', '#e66262 1px solid');
                valid = false;
            }

            if (content == "") {
                $("#userMessage-info").html("Required.");
                $("#content").css('border', '#e66262 1px solid');
                valid = false;
            }
            return valid;
        }
    </script>
</body>

</html>