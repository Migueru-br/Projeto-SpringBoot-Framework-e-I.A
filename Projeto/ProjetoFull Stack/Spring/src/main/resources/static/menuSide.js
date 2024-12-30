const toggleButton = document.getElementById('toggle-button');
const sidebar = document.getElementById('sidebar');
toggleButton.addEventListener('click', () => {
    sidebar.classList.toggle('collapsed');
});
document.getElementById('predictionForm').onsubmit = async function (event) {
    event.preventDefault(); // Previne o comportamento padrão do formulário
    const formData = new FormData(this);
    const data = {};

    // Converte os dados do formulário para JSON
    formData.forEach((value, key) => {
        if (!isNaN(value) && value.trim() !== '') {
            data[key] = parseFloat(value); // Converte números para float
        } else {
            data[key] = value.trim(); // Mantém strings como estão
        }
    });

    try {
        const response = await fetch('/predict', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            throw new Error(errorResponse.error || response.statusText);
        }

        const result = await response.json();
        alert('O tipo do ataque é: ' + result.resultado); // Exibe o campo "resultado" da resposta JSON
    } catch (error) {
        alert('Erro ao enviar os dados: ' + error.message); // Mostra a mensagem de erro
    }
};
