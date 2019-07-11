# app

Get Request: 
End point: /customer/getPossibleProducts

        @RequestParam("age") String age,
        @RequestParam("student") boolean student,
        @RequestParam("income") String income)

"age" possible values [0-17, 18-64, 65+]
"income" possible values [0, 1-12000, 12001-40000, 40001+]

Example http://localhost:8080/customer/getPossibleProducts?age=18-64&student=false&income=1-12000
