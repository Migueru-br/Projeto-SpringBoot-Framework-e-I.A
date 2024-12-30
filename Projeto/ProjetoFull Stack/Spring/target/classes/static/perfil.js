function togglePassword() {
    const passwordInput = document.getElementById('password');
    const eyeIcon = document.getElementById('togglePassword');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text'; // Mostra a senha
        eyeIcon.textContent = '🙈'; // Ícone de olho fechado
    } else {
        passwordInput.type = 'password'; // Oculta a senha
        eyeIcon.textContent = '🐵'; // Ícone de olho aberto
    }
}