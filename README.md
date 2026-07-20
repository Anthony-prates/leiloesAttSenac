# LeiloesTDSat

Sistema desktop para cadastro e consulta de produtos em leilão. O usuário pode registrar novos itens, visualizar a lista de produtos cadastrados e marcar produtos como vendidos.

## Tecnologias utilizadas

- Java
- Java Swing
- MySQL
- JDBC

## Configuração do banco de dados

O projeto usa MySQL. As credenciais de conexão ficam no arquivo `config/database.properties`, que não é enviado ao Git.

Para configurar:

1. Crie o banco de dados no MySQL (ex.: `leiloes`) e a tabela `produtos` com as colunas `id`, `nome`, `valor` e `status` (conforme arquivo mysql nos materiais complementares).
2. Copie o arquivo de exemplo:
   ```bash
   cp config/database.properties.example config/database.properties
   ```
3. Edite o `config/database.properties` com os dados da sua conexão:
   ```properties
   db.url=jdbc:mysql://localhost:3306/leiloes
   db.user=seu_usuario
   db.password=sua_senha
   ```

Ajuste o nome do banco, usuário e senha conforme o seu ambiente local.
