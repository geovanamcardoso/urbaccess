# UrbAccess — API RESTful

Plataforma colaborativa de acessibilidade urbana. Cidadãos registram denúncias, avaliações e contestações sobre a acessibilidade de estabelecimentos e pontos urbanos, e responsáveis e administradores acompanham e moderam essas informações.

Projeto da Global Solution 2026.2 (CitizenTech), disciplina de Domain Driven Design – Java, FIAP.

## Integrantes

- Eduarda Tiemi — RM 570630
- Geovana Cardoso — RM 566254
- Rodrigo Hiroshi  — RM 557374

Turma: 2ESPF

## Links

- Deploy: https://urbaccess.onrender.com
- Repositório: https://github.com/geovanamcardoso/urbaccess

> A raiz do deploy não tem rota própria. Use uma das rotas abaixo.

## Tecnologias

- Java 21
- Spring Boot 4.1.1
- Maven 3.9+
- JDBC (DAO puro, sem ORM)
- Banco de dados Oracle (FIAP)
- Docker e Render.com (deploy)

## Arquitetura

Padrão em camadas, dentro do pacote `br.com.fiap.urbaccess`:

- `entities`: classes do domínio (Usuario, Estabelecimento, Denuncia, Avaliacao, Contestacao, Categoria, RecursoAcessibilidade)
- `dao`: acesso ao banco via JDBC
- `bo`: regras de negócio
- `controller`: endpoints REST, tratamento global de exceções e CORS
- `conexoes`: fábrica de conexões com o Oracle
- `excecoes`: exceções personalizadas

## Endpoints

Todos retornam JSON. Erros seguem o formato `{"erro": "...", "detalhes": "..."}`.

| Recurso | Método | Endpoint | Descrição |
|---|---|---|---|
| Usuário | GET | `/usuario` | Lista todos |
| | GET | `/usuario/{id}` | Busca por ID |
| | POST | `/usuario` | Cadastra |
| | PUT | `/usuario` | Atualiza |
| | DELETE | `/usuario/{id}` | Remove |
| Estabelecimento | GET | `/estabelecimento` | Lista todos |
| | GET | `/estabelecimento/{id}` | Busca por ID |
| | POST | `/estabelecimento` | Cadastra |
| | PUT | `/estabelecimento` | Atualiza |
| | DELETE | `/estabelecimento/{id}` | Remove |
| Denúncia | GET | `/denuncia` | Lista todas |
| | GET | `/denuncia/{id}` | Busca por ID |
| | POST | `/denuncia` | Registra |
| | PUT | `/denuncia` | Atualiza |
| | PATCH | `/denuncia/{id}/status?status=X` | Atualiza somente o status |
| | DELETE | `/denuncia/{id}` | Remove |
| Avaliação | GET | `/avaliacao` | Lista todas |
| | GET | `/avaliacao/{id}` | Busca por ID |
| | GET | `/avaliacao/estabelecimento/{id}` | Lista por estabelecimento |
| | POST | `/avaliacao` | Registra |
| | PUT | `/avaliacao` | Atualiza |
| | DELETE | `/avaliacao/{id}` | Remove |
| Contestação | GET | `/contestacao` | Lista todas |
| | GET | `/contestacao/{id}` | Busca por ID |
| | GET | `/contestacao/denuncia/{id}` | Lista por denúncia |
| | POST | `/contestacao` | Registra |
| | PUT | `/contestacao` | Atualiza |
| | DELETE | `/contestacao/{id}` | Remove |

## Como executar localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/geovanamcardoso/urbaccess.git
   ```
2. Configure as variáveis de ambiente `DB_USUARIO` e `DB_SENHA` com o usuário e a senha do banco Oracle da FIAP.
   - No IntelliJ: Run > Edit Configurations > Environment variables.
   - Credenciais para teste: ver o PDF de documentação entregue.
3. Execute a classe `UrbaccessApplication.java` (ou `./mvnw spring-boot:run`).
4. A API estará em `http://localhost:8080`.

## Como testar o deploy

1. Abra uma das rotas no navegador (GET) ou no Insomnia:
   - https://urbaccess.onrender.com/usuario
   - https://urbaccess.onrender.com/estabelecimento
   - https://urbaccess.onrender.com/denuncia
   - https://urbaccess.onrender.com/avaliacao
   - https://urbaccess.onrender.com/contestacao
2. A primeira requisição pode levar cerca de 1 minuto, porque o plano gratuito do Render "dorme" quando fica sem uso.
3. Para POST, PUT, PATCH e DELETE, use o Insomnia, trocando `http://localhost:8080` pelo link do Render.

## Deploy

- O deploy usa Docker com a imagem base `eclipse-temurin:21-jdk-alpine`.
- O build roda dentro do container: `./mvnw -B -DskipTests clean package`.
- `DB_USUARIO` e `DB_SENHA` são configuradas no painel do Render.
