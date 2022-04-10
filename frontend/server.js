const PORT = 4200;

const express = require('express');
const app = new express();

app.use(express.static(`${__dirname}/dist/frontend`));

app.get('/**',(req,resp) => {
    resp.sendFile(`${__dirname}/dist/frontend/index.html`);
});

app.listen(PORT, () => {
    console.log(`Servidor iniciado na porta ${PORT} - Sistema Leitor de Arquivo CNAB`);
});