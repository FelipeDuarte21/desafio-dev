# Sistema Leitor de Arquivos CNAB

O sistema leitor de arquivo CNAB permite fazer o upload dos dados CNAB para uma base de dados e, além disso, apresenta uma tela amigável para que o usuario possa visualizar os dados com mais clareza. No sistema basicamente, o usuario escolhe um arquivo através de formulario e na sequência o sistema apresenta os dados contidos no arquivo. Um arquivo CNAB contém dados das movimentações finanaceira de várias lojas.

# Montando o Ambiente Localmente

Primeiramente baixe esse repositório em sua máquina. A arquitetura do sistema se divide em duas partes: O Backend, onde uma API faz a parte de toda lógica para o processamento dos dados; O FrontEnd onde estão as telas do sistema e onde são apresentados os dados já processados. A seguir instruções para rodar o backend e o frontend na sua máquina.

## Rodando Localmente o Backend

### O Que Preciso?
Você vai precisar ter instalado na sua máquina o banco de dados MySQL (Conhecer a porta, usuario e senha) e o JAVA na versão 17 ou superior. Você pode obter o MySQL nesse [link](https://www.mysql.com/) e o JAVA nesse [link](https://www.oracle.com/java/technologies/downloads/#java17). Caso já tenha o JAVA instalado verifique se a variável de ambiente JAVA_HOME aponta para versão 17 ou superior do Java.

# Instruções ?
Antes de tudo, saiba a porta, usuario e senha do banco de dados MySQL que está instalado na sua máquina, feito isso abra o terminal do seu sistema operacional e vá até dentro da pasta backend do projeto e rode os seguintes comandos:
1. mvn clean package
Após terminar esse processo ainda no mesmo terminal vá até a pasta target (ela está na raiz da pasta backend) e digite o seguinte comando, obs: substitua depois do igual pelo o que se pede:
2. java -jar -DPORT=PORTA_DO_SEU_BANCO_DE_DADOS -DUSER=USUARIO_DO_SEU_BANCO_DE_DADOS -DPASSWORD=SENHA_DO_SEU_BANCO_DE_DADOS apiCNAB.jar
Se der tudo certo, no final aparecerá uma mensagem dizendo que o servidor foi instanciado na porta 8080.
Tudo pronto seu backend já está rodando.