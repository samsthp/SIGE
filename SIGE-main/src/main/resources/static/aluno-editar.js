// ID do aluno logado — futuramente pegará do login.
const alunoId = 1;

window.onload = function() {
    fetch(`http://localhost:8081/alunos/${alunoId}`)
        .then(r => r.json())
        .then(dados => {
            document.getElementById("nome").value = dados.nome;
            document.getElementById("email").value = dados.email;
            document.getElementById("telefone").value = dados.telefone;
            document.getElementById("endereco").value = dados.endereco;
            document.getElementById("senha").value = dados.senha;

            if (dados.fotoPerfil) {
                document.getElementById("fotoPreview").src = dados.fotoPerfil;
            }
        });
};

document.getElementById("fotoInput").addEventListener("change", function () {
    const file = this.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById("fotoPreview").src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});

function salvar() {
    const aluno = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        telefone: document.getElementById("telefone").value,
        endereco: document.getElementById("endereco").value,
        senha: document.getElementById("senha").value,
        fotoPerfil: document.getElementById("fotoPreview").src
    };

    fetch(`http://localhost:8081/alunos/${alunoId}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(aluno)
    })
        .then(r => r.text())
        .then(msg => alert("Perfil atualizado com sucesso!"));
}
