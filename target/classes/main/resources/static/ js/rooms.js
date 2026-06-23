fetch("/rooms")
    .then(response => response.json())
    .then(data => {

        let table = document.getElementById("roomTable");

        data.forEach(room => {

            table.innerHTML += `
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.roomName}</td>
                    <td>${room.floor}</td>
                    <td>${room.maxCapacity}</td>
                    <td>${room.status}</td>
                </tr>
            `;

        });

    })
    .catch(error => {
        console.error(error);
        alert("Không lấy được dữ liệu phòng.");
    });