fetch("/rooms")
    .then(res => res.json())
    .then(data => {
        document.getElementById("roomCount").innerText = data.length;
    });

fetch("/students")
    .then(res => res.json())
    .then(data => {
        document.getElementById("studentCount").innerText = data.length;
    });

fetch("/bookings")
    .then(res => res.json())
    .then(data => {
        document.getElementById("bookingCount").innerText = data.length;
    });