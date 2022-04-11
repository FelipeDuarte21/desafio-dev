# Sistema Leitor de Arquivos CNAB

O sistema leitor de arquivo CNAB permite fazer o upload dos dados CNAB para uma base de dados e, além disso, apresenta uma tela amigável para que o usuario possa visualizar os dados com mais clareza. No sistema basicamente, o usuario escolhe um arquivo através de formulario e na sequência o sistema apresenta os dados contidos no arquivo. Um arquivo CNAB contém dados das movimentações finanaceira de várias lojas.

# Montando o Ambiente Localmente

Primeiramente baixe esse repositório em sua máquina. A arquitetura do sistema se divide em duas partes: O Backend, onde uma API faz a parte de toda lógica para o processamento dos dados; O FrontEnd onde estão as telas do sistema e onde são apresentados os dados já processados. A seguir instruções para rodar o backend e o frontend na sua máquina.

## Rodando Localmente o FrontEnd

### O Que Preciso? 
Você vai precisar ter instalado na sua máquina o NODE versão 14.16.0 ou superior, você pode encontrar nesse [link](https://nodejs.org/en/)

## Instruções.
Com o repositório já na sua máquina, abra o terminal do seu sistema operacional e vá até dentro da pasta frontend do projeto, e rode os seguintes comandos nessa ordem:
1. npm install
2. npm start
Se der tudo certo (creio que sim :) ) aparecerá uma mensagem da seguinte forma: Servidor iniciado na porta 4200 - Sistema Leitor de Arquivo CNAB.
Pronto o frontend já está rodando localmente.