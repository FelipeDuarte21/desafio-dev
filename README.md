# Sistema Leitor de Arquivos CNAB

O sistema leitor de arquivo CNAB permite fazer o upload dos dados CNAB para uma base de dados e, além disso, apresenta uma tela amigável para que o usuario possa visualizar os dados com mais clareza. No sistema basicamente, o usuario escolhe um arquivo através de formulario e na sequência o sistema apresenta os dados contidos no arquivo. Um arquivo CNAB contém dados das movimentações finanaceira de várias lojas.

# Montando o Ambiente Localmente

Primeiramente baixe esse repositório em sua máquina. A arquitetura do sistema se divide em duas partes: O Backend, onde uma API faz a parte de toda lógica para o processamento dos dados; O FrontEnd onde estão as telas do sistema e onde são apresentados os dados já processados. A seguir instruções para rodar o backend e o frontend na sua máquina.

## Rodando Localmente o Backend

### O Que Preciso?
Você vai precisar ter instalado na sua máquina o banco de dados MySQL (Conhecer a porta, usuario e senha) e o JAVA na versão 17 ou superior. Você pode obter o MySQL nesse [link](https://www.mysql.com/) e o JAVA nesse [link](https://www.oracle.com/java/technologies/downloads/#java17). Caso já tenha o JAVA instalado verifique se a variável de ambiente JAVA_HOME aponta para versão 17 ou superior do Java.

### Instruções
Antes de tudo, saiba a porta, usuario e senha do banco de dados MySQL que está instalado na sua máquina, feito isso abra o terminal do seu sistema operacional e vá até dentro da pasta backend do projeto e rode os seguintes comandos:

1. mvn clean package.

Após terminar esse processo ainda no mesmo terminal vá até a pasta target (ela está na raiz da pasta backend) e digite o seguinte comando, obs: substitua depois do igual pelo o que se pede:

2. java -jar -DPORT=PORTA_DO_SEU_BANCO_DE_DADOS -DUSER=USUARIO_DO_SEU_BANCO_DE_DADOS -DPASSWORD=SENHA_DO_SEU_BANCO_DE_DADOS apiCNAB.jar.

Se der tudo certo, no final aparecerá uma mensagem dizendo que o servidor foi instanciado na porta 8080.
Tudo pronto seu backend já está rodando.

## Rodando Localmente o FrontEnd

### O Que Preciso? 
Você vai precisar ter instalado na sua máquina o NODE versão 14.16.0 ou superior, você pode encontrar nesse [link](https://nodejs.org/en/)

### Instruções.
Com o repositório já na sua máquina, abra o terminal do seu sistema operacional e vá até dentro da pasta frontend do projeto, e rode os seguintes comandos nessa ordem:

1. npm install.

2. npm start.

Se der tudo certo (creio que sim :) ) aparecerá uma mensagem da seguinte forma: Servidor iniciado na porta 4200 - Sistema Leitor de Arquivo CNAB.

Pronto o frontend já está rodando localmente.

Abra seu navegador no seguinte endereço: http://localhost:4200 e use e abuse do sistema!! :)

# Não Gostei da Tela :( , Como Utilizo Só a API ?

Reposta muito simples, você pode consultar a documentação da API em: http://localhost:8080/swagger-ui.html. Você também pode utilizar API através do link acima. Existem dois endpoints um é para fazer upload do arquivo cnab e outro é para obter uma lista de lojas desses dados já processados. Obs: só pode consultar a documentação com o Backend rodando na sua máquina!

# Deu ruim !:( , e a agora ?

Verifique se está tudo ok com o NODE, JAVA e o MySQL, verifique se a variável de ambiente JAVA_HOME aponta para o JAVA versão 17 ou superior. Pode ser também que tenha algo rodando na porta 8080 ou 4200 na sua máquina, neste caso deve parar o que estiver rodando e tentar rodar o projeto novamente. 

------------------------------------------------------------------------------------------------------------

# Desafio programação - para vaga desenvolvedor

Por favor leiam este documento do começo ao fim, com muita atenção.
O intuito deste teste é avaliar seus conhecimentos técnicos em programação.
O teste consiste em parsear [este arquivo de texto(CNAB)](https://github.com/ByCodersTec/desafio-ruby-on-rails/blob/master/CNAB.txt) e salvar suas informações(transações financeiras) em uma base de dados a critério do candidato.
Este desafio deve ser feito por você em sua casa. Gaste o tempo que você quiser, porém normalmente você não deve precisar de mais do que algumas horas.

# Instruções de entrega do desafio

1. Primeiro, faça um fork deste projeto para sua conta no Github (crie uma se você não possuir).
2. Em seguida, implemente o projeto tal qual descrito abaixo, em seu clone local.
3. Por fim, envie via email o projeto ou o fork/link do projeto para seu contato Bycoders_ com cópia para rh@bycoders.com.br.

# Descrição do projeto

Você recebeu um arquivo CNAB com os dados das movimentações finanaceira de várias lojas.
Precisamos criar uma maneira para que estes dados sejam importados para um banco de dados.

Sua tarefa é criar uma interface web que aceite upload do [arquivo CNAB](https://github.com/ByCodersTec/desafio-ruby-on-rails/blob/master/CNAB.txt), normalize os dados e armazene-os em um banco de dados relacional e exiba essas informações em tela.

**Sua aplicação web DEVE:**

1. Ter uma tela (via um formulário) para fazer o upload do arquivo(pontos extras se não usar um popular CSS Framework )
2. Interpretar ("parsear") o arquivo recebido, normalizar os dados, e salvar corretamente a informação em um banco de dados relacional, **se atente as documentações** que estão logo abaixo.
3. Exibir uma lista das operações importadas por lojas, e nesta lista deve conter um totalizador do saldo em conta
4. Ser escrita na sua linguagem de programação de preferência
5. Ser simples de configurar e rodar, funcionando em ambiente compatível com Unix (Linux ou Mac OS X). Ela deve utilizar apenas linguagens e bibliotecas livres ou gratuitas.
6. Git com commits atomicos e bem descritos
7. PostgreSQL, MySQL ou SQL Server
8. Ter testes automatizados
9. Docker compose (Pontos extras se utilizar)
10. Readme file descrevendo bem o projeto e seu setup
11. Incluir informação descrevendo como consumir o endpoint da API

**Sua aplicação web não precisa:**

1. Lidar com autenticação ou autorização (pontos extras se ela fizer, mais pontos extras se a autenticação for feita via OAuth).
2. Ser escrita usando algum framework específico (mas não há nada errado em usá-los também, use o que achar melhor).
3. Documentação da api.(Será um diferencial e pontos extras se fizer)

# Documentação do CNAB

| Descrição do campo  | Inicio | Fim | Tamanho | Comentário
| ------------- | ------------- | -----| ---- | ------
| Tipo  | 1  | 1 | 1 | Tipo da transação
| Data  | 2  | 9 | 8 | Data da ocorrência
| Valor | 10 | 19 | 10 | Valor da movimentação. *Obs.* O valor encontrado no arquivo precisa ser divido por cem(valor / 100.00) para normalizá-lo.
| CPF | 20 | 30 | 11 | CPF do beneficiário
| Cartão | 31 | 42 | 12 | Cartão utilizado na transação 
| Hora  | 43 | 48 | 6 | Hora da ocorrência atendendo ao fuso de UTC-3
| Dono da loja | 49 | 62 | 14 | Nome do representante da loja
| Nome loja | 63 | 81 | 19 | Nome da loja

# Documentação sobre os tipos das transações

| Tipo | Descrição | Natureza | Sinal |
| ---- | -------- | --------- | ----- |
| 1 | Débito | Entrada | + |
| 2 | Boleto | Saída | - |
| 3 | Financiamento | Saída | - |
| 4 | Crédito | Entrada | + |
| 5 | Recebimento Empréstimo | Entrada | + |
| 6 | Vendas | Entrada | + |
| 7 | Recebimento TED | Entrada | + |
| 8 | Recebimento DOC | Entrada | + |
| 9 | Aluguel | Saída | - |

# Avaliação

Seu projeto será avaliado de acordo com os seguintes critérios.

1. Sua aplicação preenche os requerimentos básicos?
2. Você documentou a maneira de configurar o ambiente e rodar sua aplicação?
3. Você seguiu as instruções de envio do desafio?
4. Qualidade e cobertura dos testes unitários.

Adicionalmente, tentaremos verificar a sua familiarização com as bibliotecas padrões (standard libs), bem como sua experiência com programação orientada a objetos a partir da estrutura de seu projeto.

# Referência

Este desafio foi baseado neste outro desafio: https://github.com/lschallenges/data-engineering

---

Boa sorte!
