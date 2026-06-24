fetch("/bookings")
    .then(response => response.json())
    .then(data => {

        let table = document.getElementById("bookingTable");

        data.forEach(booking => {

            table.innerHTML += `
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.student.fullName}</td>
                    <td>${booking.room.roomName}</td>
                    <td>${booking.numberOfParticipants}</td>
                    <td>${booking.status}</td>
                    <td>${booking.totalFee}</td>
                </tr>
            `;
        });

    })
    .catch(error => {
        console.error(error);
        alert("Không lấy được dữ liệu đặt phòng.");
    });