fetch("/students")
    .then(response => response.json())
    .then(data => {

        let table = document.getElementById("studentTable");

        data.forEach(student => {

            table.innerHTML += `
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.fullName}</td>
                    <td>${student.phoneNumber}</td>
                    <td>${student.className}</td>
                    <td>${student.email}</td>
                </tr>
            `;
        });

    })
    .catch(error => {
        console.error(error);
        alert("Không lấy được dữ liệu sinh viên.");
    });