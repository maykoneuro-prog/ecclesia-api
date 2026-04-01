function login() {
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
    const erro = document.getElementById("erro");

    erro.innerText = "";

    fetch(`${API_URL}/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ email, senha })
    })
        .then(res => {
            if (!res.ok) {
                throw new Error("Credenciais inválidas");
            }
            return res.json();
        })
        .then(usuario => {
            localStorage.setItem("usuario", JSON.stringify(usuario));
            window.location.href = "home.html";
        })
        .catch(() => {
            erro.innerText = "E-mail ou senha inválidos";
        });
}