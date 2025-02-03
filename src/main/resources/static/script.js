async function getBossAndBuilds() {
    const bossName = document.getElementById("bossName").value;

    if (!bossName) {
        alert("Digite o nome do boss!");
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/bosses/${bossName}`); // Call the API

        if (!response.ok) {
            const data = await response.json();
            document.getElementById("response").innerHTML = `<p>${data.Message}</p>`;
            return;
        }

        const data = await response.json();
        displayBossAndBuilds(data);
    } catch (error) {
        console.error("Erro ao buscar os dados", error);
        alert("Erro ao conectar com o servidor!");
    }
}

function displayBossAndBuilds(data) {
    const boss = data.boss;
    const builds = data.builds;

    let buildsHtml = builds.map(build => {
        return `
            <div class="build">
                <h3>${build.nome}</h3>
                <p><strong>Tipo de Dano:</strong> ${build.tipoDano}</p>
                <p><strong>Arma:</strong> ${build.arma}</p>
                <p><strong>Magias:</strong> ${build.magias}</p>
                <p><strong>Talismas:</strong> ${build.talismas}</p>
                <p><strong>Estratégia:</strong> ${build.estrategia}</p>
            </div>
        `;
    }).join('');

    document.getElementById("response").innerHTML = `
        <h2>Informações do Boss: ${boss.nome}</h2>
        <p><strong>Descrição:</strong> ${boss.descricao}</p>
        <p><strong>Dificuldade:</strong> ${boss.dificuldade}</p>
        <p><strong>Fraquezas:</strong> ${boss.fraquezas}</p>
        <p><strong>Resistências:</strong> ${boss.resistencias}</p>

        <h2>Builds Recomendadas:</h2>
        ${buildsHtml}
    `;
}
