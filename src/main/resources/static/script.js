const API_URL = "http://localhost:8081/vagas";

async function listarTodas() {
    const response = await fetch(API_URL);
    const vagas = await response.json();
    exibirVagas(vagas);
}

async function buscarVagas() {
    const curso = document.getElementById("filtroCurso").value.trim();
    const estado = document.getElementById("filtroEstado").value.trim();
    const empresa = document.getElementById("filtroEmpresa").value.trim();

    let url = API_URL;
    if (curso) url += `/curso/${curso}`;
    else if (estado) url += `/estado/${estado}`;
    else if (empresa) url += `/empresa/${empresa}`;

    const response = await fetch(url);
    const vagas = await response.json();
    exibirVagas(vagas);
}

function exibirVagas(vagas) {
    const tabela = document.getElementById("tabelaVagas");
    tabela.innerHTML = "";

    if (vagas.length === 0) {
        tabela.innerHTML = `<tr><td colspan="6" style="text-align:center;">Nenhuma vaga encontrada.</td></tr>`;
        return;
    }

    vagas.forEach(v => {
        tabela.innerHTML += `
            <tr>
                <td>${v.titulo || '-'}</td>
                <td>${v.empresa || '-'}</td>
                <td>${v.descricao || '-'}</td>
                <td>${v.cursoRelacionado || '-'}</td>
                <td>${v.estado || '-'}</td>
                <td>${v.contato || '-'}</td>
            </tr>
        `;
    });
}

listarTodas();
