document.addEventListener("DOMContentLoaded", function () {

    const form = document.getElementById("loginForm");
    const username = document.getElementById("username");
    const password = document.getElementById("password");
    const toggle = document.getElementById("togglePassword");
    const message = document.getElementById("loginMessage");
    const button = form.querySelector(".login-button");

    console.log("BuildSphere Login JS Loaded");

    // Show / Hide Password
    if (toggle) {
        toggle.addEventListener("click", function () {

            if (password.type === "password") {
                password.type = "text";
                toggle.textContent = "Hide";
            } else {
                password.type = "password";
                toggle.textContent = "Show";
            }

        });
    }

    // Login
    form.addEventListener("submit", async function (event) {

        event.preventDefault();

        const user = username.value.trim();
        const pass = password.value;

        message.textContent = "";
        message.className = "login-message";

        button.disabled = true;
        button.textContent = "Signing in...";

        try {

            const response = await fetch("/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: new URLSearchParams({
                    username: user,
                    password: pass
                })
            });

            const result = await response.text();

            if (result === "success") {

                message.textContent = "Login successful!";
                message.className = "login-message success";

                setTimeout(function () {
                    window.location.href = "/dashboard";
                }, 500);

            } else {

                message.textContent = "Invalid username or password.";
                message.className = "login-message error";

                button.disabled = false;
                button.textContent = "Sign In";
            }

        } catch (error) {

            console.error("Login Error:", error);

            message.textContent = "Server error. Please try again.";
            message.className = "login-message error";

            button.disabled = false;
            button.textContent = "Sign In";
        }

    });

});