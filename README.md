# BugigSolar — Sistema de Vendas (Java)

Sistema de **console em Java** para uma loja de produtos de energia solar. Projeto Integrador (PI) que cobre autenticação, cadastro e um fluxo de compra completo, com persistência em **banco de dados MySQL** via JDBC.

## Tecnologias
- **Java** (aplicação de console)
- **MySQL** via JDBC (`mysql-connector-j` incluído em `Conexao/`)

## Funcionalidades
- **Login** e **cadastro** de usuários
- Gestão de **clientes** e **fornecedores**
- **Compras** e **ofertas** de produtos
- **Pagamentos**
- **Relatórios**
- Validação de entradas do usuário

## Estrutura
```text
Main.java             # menu principal e fluxo do sistema
Usuarios / Cliente / Fornecedor / Compra / Ofertas / Pagamentos / Relatorios
CadastroDB / CadastroInterface / Conexao   # acesso ao banco (JDBC)
Input / Validacao     # utilitários de entrada e validação
Conexao/              # driver mysql-connector-j
```

## Como rodar
Requer **JDK** e um **MySQL** configurado. As credenciais ficam em `db.properties` (fora do controle de versão):

```bash
# 1. Configure o banco: copie o modelo e ajuste as credenciais
cp db.properties.example db.properties

# 2. Compilar
javac *.java

# 3. Executar (Windows usa ';' no classpath; Linux/Mac usa ':')
java -cp ".;Conexao/mysql-connector-j-9.2.0.jar" Main
```
