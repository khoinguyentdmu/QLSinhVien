-> Đầu tiên clone project về sau đó cấu hình lại thông số database cho phù hợp.
-> Bật dùng maven để run.
-> Bật postman để test.

Lấy danh sách tất cả sinh viên
URL

/student/

Method:

GET

URL Params

Required:

None

Data Params

None

Success Response:

[
    {
        "studentID": 30,
        "student_classid": 10,
        "monitor": "Nguyen Van A",
        "student_Name": "Nguyen Van C",
        "student_class_name": "D15HT01",
        "date_of_birth": "2018-06-06T10:06:26.000+0000"
    },
    {
        "studentID": 34,
        "student_classid": 33,
        "monitor": "Pham Nguyen Khang",
        "student_Name": "Nguyen Van Huu",
        "student_class_name": "D15HT02",
        "date_of_birth": "1997-10-09T17:00:00.000+0000"
    },
    {
        "studentID": 35,
        "student_classid": 33,
        "monitor": "Pham Nguyen Khang",
        "student_Name": "Le Bao Thinh",
        "student_class_name": "D15HT02",
        "date_of_birth": "2018-06-06T08:58:53.000+0000"
    }
]

Error Response:

None

Sample Call: http://127.0.0.1:8080/student/

----------------------------------------------------
Lấy thông tin của một sinh viên
URL

/student/:id

Method:

GET

URL Params

Required:

id = [Integer]

Data Params

None

Success Response:

    {
    "id": 13,
    "name": "Nguyen Van C",
    "studentClassID": 4,
    "dateOfBirth": "1997-10-09T17:00:00.000+0000"
}

Error Response:

{
    "timestamp": "2018-06-05T10:05:01.061+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Unable to find com.example.demo3.Model.Student with id 41213",
    "path": "/student/41213"
}

Sample Call: http://127.0.0.1:8080/student/41

----------------------------------------------------



Thêm một sinh viên

URL

/student/

Method:

POST

URL Params

Required:

None

Data Params

{
	"name" : [String],
	"studentClassID" : [Int],
	"dateOfBirth":"dd/MM/yyyy"
}

Success Response:

    {
    "id": 13,
    "name": "Nguyen Van C",
    "studentClassID": 4,
    "dateOfBirth": "1997-10-09T17:00:00.000+0000"
}

Error Response:

{
    "timestamp": "2018-06-05T09:43:48.475+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "For input string: \"4s\"",
    "path": "/student"
}

Sample Call: http://127.0.0.1:8080/student/
Body: {
	"name" : "Nguyen Van C",
	"studentClassID" : "4s",
	"dateOfBirth":"10/10/1997"
}
----------------------------------------------------


Sửa thông tin 1 sinh viên

URL

/student/:id

Method:

PUT

URL Params

Required:

id = [Int]

Data Params

{
	"name" : [String],
	"studentClassID" : [Int],
	"dateOfBirth":"dd/MM/yyyy"
}

Success Response:

    {
    "id": 13,
    "name": "Nguyen Van C",
    "studentClassID": 4,
    "dateOfBirth": "1997-10-09T17:00:00.000+0000"
}

Error Response:

{
    "timestamp": "2018-06-05T09:43:48.475+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "For input string: \"4s\"",
    "path": "/student"
}

Sample Call: http://127.0.0.1:8080/student/2
Body: {
	"name" : "Nguyen Van C",
	"studentClassID" : "4s",
	"dateOfBirth":"10/10/1997"
}
----------------------------------------------------
Xóa một sinh viên

URL

/student/:id

Method:

DELETE

URL Params

Required:

id = [Int]

Data Params

None

Success Response:

true

Error Response:

{
    "timestamp": "2018-06-05T09:48:39.184+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "No class com.example.demo3.Model.Student entity with id 13 exists!",
    "path": "/student/13"
}

Sample Call: http://127.0.0.1:8080/student/13
----------------------------------------------------

Lấy danh sách tất cả môn học
URL

/subject/

Method:

GET

URL Params

Required:

None

Data Params

None

Success Response:

[
    {
        "id": 24,
        "name": "1"
    },
    {
        "id": 17,
        "name": "Nguyen Van F"
    }
]

Error Response:

None

Sample Call: http://127.0.0.1:8080/subject/

----------------------------------------------------


Thêm một môn học

URL

/subject/

Method:

POST

URL Params

Required:

None

Data Params

{
	"name" : [String],
}

Success Response:

{
    "id": 32,
    "name": "dfs"
}

Error Response:

{
    "timestamp": "2018-06-05T09:58:52.603+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "could not execute statement; nested exception is org.hibernate.exception.GenericJDBCException: could not execute statement",
    "path": "/subject"
}

Sample Call: http://127.0.0.1:8080/subject/
Body: {
	"name": "hello"
}
----------------------------------------------------


Sửa thông tin 1 môn học

URL

/subject/:id

Method:

PUT

URL Params

Required:

id = [Int]

Data Params

{
	"name" : [String]
}

Success Response:

{
    "id": 33,
    "name": "dfds"
}

Error Response:

{
    "timestamp": "2018-06-05T10:02:03.699+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Unable to find com.example.demo3.Model.Subject with id 332",
    "path": "/subject/332"
}

Sample Call: http://127.0.0.1:8080/subject/332
Body: {
	"name" : "dfds"
}
----------------------------------------------------
Xóa 1 môn học

URL

/subject/:id

Method:

DELETE

URL Params

Required:

id = [Int]

Data Params

None

Success Response:

true

Error Response:

{
    "timestamp": "2018-06-05T10:03:03.655+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "No class com.example.demo3.Model.Subject entity with id 332 exists!",
    "path": "/subject/332"
}
Sample Call: http://127.0.0.1:8080/subject/332

----------------------------------------------------

Lấy danh sách tất cả lớp
URL

/studentClass/

Method:

GET

URL Params

Required:

None

Data Params

None

Success Response:

[
    {
        "id": 44,
        "name": "D15PM02",
        "monitor": "Nguyen Van A"
    },
    {
        "id": 45,
        "name": "D15PM02",
        "monitor": "Nguyen Van A"
    },
    {
        "id": 46,
        "name": "D15PM02",
        "monitor": "Nguyen Van A"
    }
]

Error Response:

None

Sample Call: http://127.0.0.1:8080/studentClass
----------------------------------------------------

Thêm một lớp

URL

/studentClass/

Method:

POST

URL Params

Required:

None

Data Params

{
	"name" : [String],
	"monitor" : [String]
}

Success Response:

{
    "id": 46,
    "name": "D15PM02",
    "monitor": "Nguyen Van A"
}

Error Response:

None

Sample Call: http://127.0.0.1:8080/studentClass
Body: {
	"name" : "D15PM02",
	"monitor" : "Nguyen Van A"
}
----------------------------------------------------


Sửa thông tin 1 lớp

URL

/subject/:id

Method:

PUT

URL Params

Required:

id = [Int]

Data Params

{
	"name" : [String],
	"monitor" : [String]
}

Success Response:

{
    "id": 33,
    "name": "dfds"
}{
	"name" : "D15PM02",
	"monitor" : "Nguyen Van A"
}

Error Response:

{
    "timestamp": "2018-06-05T10:12:41.922+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Unable to find com.example.demo3.Model.StudentClass with id 46213",
    "path": "/studentClass/46213"
}

Sample Call: http://127.0.0.1:8080/studentClass/46213
Body: {
	"name" : "D15PM02",
	"monitor" : "Nguyen Van A"
}
----------------------------------------------------
Xóa 1 lớp
URL

/subject/:id

Method:

DELETE

URL Params

Required:

id = [Int]

Data Params

None

Success Response:

true

Error Response:

{
    "timestamp": "2018-06-05T10:13:20.413+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Unable to find com.example.demo3.Model.StudentClass with id 46213",
    "path": "/studentClass/46213"
}

Sample Call: http://127.0.0.1:8080/studentClass/46213
----------------------------------------------------

Thêm điểm (Dùng để demo)

URL

/score

Method:

POST

URL Params

Required:

None

Data Params

{
	"studentID" : [INT],
	"subjectID" : [INT],
	"score" : [INT]
}

Success Response:

{
    "id": 11,
    "studentID": 9,
    "subjectID": 2,
    "score": 2
}

Error Response:

None

http://127.0.0.1:8080/score
Body: {
	"studentID" : "9",
	"subjectID" : "2",
	"score" : "2"
}
----------------------------------------------------
Lấy danh sách điểm

URL

/score

Method:

GET

URL Params

Required:

None

Data Params

NONE

Success Response:

[
    {
        "id": 39,
        "subject_id": 38,
        "subject_name": "Toan A3",
        "student_id": 30,
        "student_name": "Nguyen Van C",
        "score": 4
    },
    {
        "id": 41,
        "subject_id": 36,
        "subject_name": "Toan A1",
        "student_id": 30,
        "student_name": "Nguyen Van C",
        "score": 0
    }
]

Error Response:

None

Sample call: http://127.0.0.1:8080/score/subject/2
None
----------------------------------------------------


Sửa điểm

URL

/score/:id

Method:

PUT

URL Params

Required:

id = [Int]

Data Params

{
	"score" : [INT]
}

Success Response:

{
    "id": 11,
    "studentID": 9,
    "subjectID": 2,
    "score": 10
}

Error Response:

{
    "timestamp": "2018-06-06T02:05:08.483+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Unable to find com.example.demo3.Model.Score with id 11213",
    "path": "/score/11213"
}

Sample Call: http://127.0.0.1:8080/score/11
Body: {
	"score" : "10"
}

----------------------------------------------------
Loc cac sinh vien theo mon hoc 

URL

/score/subject/:id

Method:

GET

URL Params

Required:

id = [INT]

Data Params

NONE

Success Response:

[
    {
        "id": 41,
        "subject_id": 36,
        "subject_name": "Toan A1",
        "student_id": 30,
        "student_name": "Nguyen Van C",
        "score": 0
    }
]

Error Response:

{
    "timestamp": "2018-06-06T10:46:04.611+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "For input string: \"36sd\"",
    "path": "/score/subject/36sd"
}

Sample Call: http://127.0.0.1:8080/score/subject/36

----------------------------------------------------
Loc cac sinh vien theo khoang diem [a..b]

URL

/score/filter

Method:

GET

URL Params

Required:

NONE

Data Params
{
	"minVal" : [INT],
	"maxVal" : [INT]
}

Success Response:
[
    {
        "id": 39,
        "subject_id": 38,
        "subject_name": "Toan A3",
        "student_id": 30,
        "student_name": "Nguyen Van C",
        "score": 4
    }
]

Error Response:

{
    "timestamp": "2018-06-06T10:48:45.915+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "null",
    "path": "/score/filter"
}

Sample Call: http://127.0.0.1:8080/score/filter





