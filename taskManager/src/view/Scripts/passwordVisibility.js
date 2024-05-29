function togglePasswordVisibility() {
    const passwordField = document.getElementById("password");
    const eyeIcon = document.getElementById("eyeIcon");
    if(passwordField.type === "password") {
        passwordField.type = "text";
        eyeIcon.src = "../Images/Icons/solidEye.svg";
        eyeIcon.alt = "Password is visible";
    } else {
        passwordField.type = "password";
        eyeIcon.src = "../Images/Icons/solidEyeSlash.svg";
        eyeIcon.alt = "Password not visible";
    }
}