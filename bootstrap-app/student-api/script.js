var apiUrl = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students";
$(document).ready(function () {
    var studentList = [];
    var count;

    window.onload = refreshData;

    function refreshData() {
        $('#myModal').hide();
        $('#addStudentTable').css('display', 'none');
        $.ajax({

            url: apiUrl, success: function (result) {
                studentList = result;
                generateList();
            }

        });
    }

    $("#button").click(function () {
        refreshData();
    });

    $("#close").click(function () {
        $('#myModal').hide()
    });


    function generateList() {
        $("#table").css("display", "show");
        $("#table").html('');
        var heading = "<tr>" +
            "<td>RollNo</td>" +
            "<td>Name</td>" +
            "<td>Age</td>" +
            "<td>Email</td>" +
            "<td>DOB</td>" +
            "<td>Gender</td>" +
            "</tr>"
        $('#table').append(heading);
        count = studentList.length;
        $('#count').html("Total count of students are " + count);
        for (var i = 0; i < studentList.length; i++) {
            var tableRow = document.createElement('tr');

            var gender = "female";
            if (studentList[i]['isMale'] == true)
                var gender = "male";
            var rollNo = studentList[i]['rollNo'];
            var name = studentList[i]['name'];
            var age = studentList[i]['age'];
            var email = studentList[i]['email'];
            var date = studentList[i]['date'];

            var data = "<tr><td>" + rollNo + "</td>" +
                "<td>" + name + "</td>" +
                "<td>" + age + "</td>" +
                "<td>" + email + "</td>" +
                "<td>" + date + "</td>" +
                "<td>" + gender + "</td>" +
                "<td><div class='btn btn-success' id='updateRow' value='" + rollNo + "'>" + "<div class='glyphicon glyphicon-pencil'></div>" + "</div></td>" +
                "<td><div class='btn btn-danger' id='deleteRow' value='" + rollNo + "'>" + "<div class='glyphicon glyphicon-remove'></div>" + "</div></td>" +
                "</tr>";
            $('#table').append(data);

        }
    }
    $('#addStudent').click(function () {
        $('#myModal').show();
        refreshStudentTable();
        $('#addStudentTable').css('display', 'show');

    });

    function refreshStudentTable() {
        $('#inputRollNo').prop('disabled', false);
        $('#update').hide();
        $('#submit').show();
        $("#form")[0].reset();
    }

    $(document).on('click', '#deleteRow', function (e) {
        var rollNo = $(this).attr('value');
        console.log(rollNo);
        $.ajax({
            url: apiUrl + "/" + rollNo, method: 'DELETE',
            success: function (result) {
                console.log(result);

                refreshData();
            }
        })

    });

    $(document).on('click', '#updateRow', function (e) {
        $('#myModal').show();
        $("#submit").hide();
        $("#update").show();
        var rollNo = $(this).attr('value');
        console.log(rollNo);
        $('#addStudentTable').css('display', 'show');
        $('#inputRollNo').val(rollNo);
        $('#inputRollNo').prop('disabled', true);
        $.ajax({
            url: apiUrl + "/" + rollNo, method: 'get',
            success: function (result) {
                updateStudent(result);
            }
        })

    });
    function updateStudent(student) {
        $('#inputName').val(student['name']);
        $('#inputAge').val(student['age']);
        $('#inputEmail').val(student['email']);
        $("#male").prop("checked", true);
        if (student['isMale'] == false)
            $("#female").prop("checked", true);
        $('#inputDate').val(student['date']);

    }

    $('#update').click(function (e) {
        student = {};
        student.rollNo = $('#inputRollNo').val();
        student.name = $('#inputName').val();
        student.age = $('#inputAge').val();
        student.email = $('#inputEmail').val();
        var dates = new Date($('#inputDate').val());
        day = dates.getDate();
        month = dates.getMonth() + 1;
        year = dates.getFullYear();
        student.date = $('#inputDate').val();//year + '-' + month + '-' + day;
        student.isMale = false;
        if ($('input[name=gender]:checked').val() == "male")
            student.isMale = true;
        console.log(student);
        $.ajax({
            url: apiUrl + "/" + student.rollNo, data: student, method: 'put', beforeSend: function () {
                $('#update').css('display', 'none');
                $('#loader').css('display', 'show');
            },
            success: function (result) {
                console.log(result);

            },
            complete: function () {
                $('#loader').css('display', 'none');
                $('#update').css('display', 'show');
                refreshData();
            }
        })
    });
    $('#submit').click(function (e) {

        var isValid = true;
        $('input[type="text"]').each(function () {
            border = "";
            background = "";
            if ($.trim($(this).val()) == '') {
                isValid = false;
                border = "1px solid red";
                background = "#FFCECE";

            }
            $(this).css({
                "border": border,
                "background": background
            });
        });

        if (isValid == false)
            e.preventDefault();
        if (isValid) {
            student = {}
            student.rollNo = $('#inputRollNo').val();
            student.name = $('#inputName').val();
            student.age = $('#inputAge').val();
            student.email = $('#inputEmail').val();
            var dates = new Date($('#inputDate').val());
            day = dates.getDate();
            month = dates.getMonth() + 1;
            year = dates.getFullYear();
            student.date = $('#inputDate').val();//year + '-' + month + '-' + day;
            student.isMale = false;
            if ($('input[name=gender]:checked').val() == "male")
                student.isMale = true;
            console.log(student);
            $.ajax({
                url: apiUrl, data: student, method: 'post', beforeSend: function () {
                    $('#submit').css('display', 'none');
                    $('#loader').css('display', 'show');
                },
                success: function (result) {
                    console.log(result);

                },
                complete: function () {
                    $('#loader').css('display', 'none');
                    $('#submit').css('display', 'show');
                    refreshData();
                }
            })
        }

    });
});