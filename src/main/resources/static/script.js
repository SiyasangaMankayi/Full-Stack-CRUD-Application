// Get the form, table and message from HTML
const userForm = document.getElementById("userForm");
const userTable = document.getElementById("userTable");
const message = document.getElementById("message");

// Stores the ID when editing a user
let editId = null;


// GET: Load all users from the database
function loadUsers() {

    fetch("/api/users")
        .then(response => response.json())
        .then(users => {

            userTable.innerHTML = "";

            users.forEach(user => {

                userTable.innerHTML += `
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>
                            <button onclick="editUser(${user.id})">Edit</button>
                            <button onclick="deleteUser(${user.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}


// POST and PUT: Save a new user or update an existing user
userForm.addEventListener("submit", function(event) {

    event.preventDefault();

    // Get the values entered in the form
    const user = {
        name: document.getElementById("name").value.trim(),
        email: document.getElementById("email").value.trim()
    };

    // Check that the name does not exceed 50 characters
    if (user.name.length > 50) {
        alert("Name cannot exceed 50 characters");
        return;
    }

    // Default: create a new user
    let url = "/api/users";
    let method = "POST";

    // If editing, update the existing user
    if (editId !== null) {
        url = "/api/users/" + editId;
        method = "PUT";
    }

    fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then(response => {

            if (!response.ok) {
                return response.text().then(error => {
                    throw new Error(error);
                });
            }

            return response.json();
        })
        .then(() => {

            alert("User saved successfully");

            userForm.reset();
            editId = null;
            message.textContent = "";

            loadUsers();
        })
        .catch(error => {
            alert(error.message);
        });
});


// GET: Find one user and put their details in the form
function editUser(id) {

    fetch("/api/users/" + id)
        .then(response => response.json())
        .then(user => {

            document.getElementById("name").value = user.name;
            document.getElementById("email").value = user.email;

            editId = id;
        });
}


// DELETE: Remove a user
function deleteUser(id) {

    if (confirm("Are you sure you want to delete this user?")) {

        fetch("/api/users/" + id, {
            method: "DELETE"
        })
            .then(response => {

                if (!response.ok) {
                    throw new Error("Could not delete user");
                }

                alert("User deleted successfully");

                message.textContent = "";

                loadUsers();
            })
            .catch(error => {
                alert(error.message);
            });
    }
}


// Load users when the page opens
loadUsers();