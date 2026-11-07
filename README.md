# 🎉 EventClean

API REST para gerenciamento de eventos, desenvolvida com **Java** e **Spring Boot** seguindo os princípios de **Clean Architecture**: o núcleo de negócio não depende de framework, e os detalhes técnicos (web, banco, mapeamentos) ficam isolados na infraestrutura.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Docker-336791)
![License](https://img.shields.io/badge/license-MIT-blue)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

---

## 📑 Sumário

- [📊 Status do projeto](#-status-do-projeto)
- [🧰 Tecnologias](#-tecnologias)
- [📋 Pré-requisitos](#-pré-requisitos)
- [🚀 Como executar](#-como-executar)
- [🔧 Configuração](#-configuração)
- [📡 Como usar a API](#-como-usar-a-api)
- [🧱 Arquitetura](#-arquitetura)
- [💾 Modelo de dados](#-modelo-de-dados)
- [🧪 Testes](#-testes)
- [📦 Deploy](#-deploy)
- [🩺 Solução de problemas](#-solução-de-problemas)
- [🎯 Roadmap](#-roadmap)
- [🤝 Como contribuir](#-como-contribuir)
- [📄 Licença](#-licença)
- [💜 Autora](#-autora)

---

## 📊 Status do projeto

| Item | Situação |
|---|---|
| CRUD de eventos (criar, listar, buscar, atualizar, remover) | ✅ Concluído |
| Busca por identificador único | ✅ Concluído |
| Atualização parcial (`PATCH`) | ✅ Concluído |
| Tratamento global de exceções e respostas padronizadas | ✅ Concluído |
| Migrations com Flyway | ✅ Concluído |
| Banco local com Docker Compose | ✅ Concluído |
| Testes automatizados | 🚧 Em andamento (apenas `contextLoads`) |
| Validação de entrada com `@Valid` | 📝 Planejado |
| Documentação OpenAPI/Swagger | 📝 Planejado |

---

## 🧰 Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 17 | Linguagem |
| Spring Boot 4.0.6 | Framework |
| Spring Web MVC | Camada REST |
| Spring Data JPA | Persistência |
| Bean Validation | Anotações de validação nos DTOs |
| PostgreSQL | Banco de dados |
| Flyway | Versionamento do schema |
| Lombok | Redução de código repetitivo |
| Maven Wrapper | Build e dependências |
| Docker Compose | Banco PostgreSQL local |

---

## 📋 Pré-requisitos

- [JDK 17 ou superior](https://adoptium.net/)
- [Docker](https://www.docker.com/) com Docker Compose
- Git

O Maven não precisa estar instalado: o projeto inclui o Maven Wrapper (`mvnw` / `mvnw.cmd`).

---

## 🚀 Como executar

### 1️⃣ Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
cd EventClean
```

### 2️⃣ Criar o arquivo `.env`

```bash
cp .env.example .env
```

Edite os valores, principalmente `DB_PASSWORD`. Detalhes na seção [Configuração](#-configuração).

### 3️⃣ Subir o banco de dados

```bash
docker compose up -d
```

Cria um container PostgreSQL chamado `eventclean` com as credenciais do `.env`.

### 4️⃣ Iniciar a aplicação

O Spring Boot **não lê o `.env` sozinho** (só o Docker Compose lê). Carregue as variáveis no terminal antes de executar:

🐧 **Linux / macOS**

```bash
export $(grep -v '^#' .env | xargs)
./mvnw spring-boot:run
```

🪟 **Windows (PowerShell)**

```powershell
Get-Content .env | ForEach-Object {
  if ($_ -match '^\s*([^#=]+)=(.*)$') { [Environment]::SetEnvironmentVariable($matches[1].Trim(), $matches[2].Trim()) }
}
.\mvnw.cmd spring-boot:run
```

💡 **IntelliJ IDEA:** adicione as variáveis em *Run → Edit Configurations → Environment variables*.

As migrations do Flyway rodam automaticamente na inicialização. A API ficará disponível em:

```text
http://localhost:8080
```

---

## 🔧 Configuração

Todas as variáveis são lidas pelo `application.yaml` e pelo `docker-compose.yml`.

| Variável | Descrição | Exemplo |
|---|---|---|
| `DB_HOST` | Host do PostgreSQL | `localhost` |
| `DB_PORT` | Porta do PostgreSQL | `5432` |
| `DB_NAME` | Nome do banco | `eventclean` |
| `DB_USER` | Usuário do banco | `eventclean_user` |
| `DB_PASSWORD` | Senha do banco | *(defina a sua)* |

> ⚠️ **Atenção:** o arquivo `.env` está no `.gitignore` e nunca deve ser enviado ao repositório. Versione apenas o `.env.example`, com valores fictícios.

---

## 📡 Como usar a API

Rota base: `/v1/eventos`

| Método | Endpoint | Descrição | Sucesso |
|---|---|---|---|
| `POST` | `/v1/eventos` | Criar evento | `201 Created` |
| `GET` | `/v1/eventos` | Listar eventos | `200 OK` |
| `GET` | `/v1/eventos/{id}` | Buscar por ID | `200 OK` |
| `GET` | `/v1/eventos/identificador/{identificador}` | Buscar por identificador | `200 OK` |
| `PUT` | `/v1/eventos/{id}` | Atualizar evento (completo) | `200 OK` |
| `PATCH` | `/v1/eventos/{id}` | Atualizar evento (parcial) | `200 OK` |
| `DELETE` | `/v1/eventos/{id}` | Remover evento | `200 OK` |

### ➕ Exemplo: criar um evento

```bash
curl -X POST http://localhost:8080/v1/eventos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Java Summit",
    "descricao": "Encontro sobre o ecossistema Java",
    "identificador": "JAVA-SUMMIT-2026",
    "dataInicio": "2026-09-10T09:00:00",
    "dataFim": "2026-09-10T18:00:00",
    "localEvento": "Centro de Convenções",
    "organizador": "Comunidade Java",
    "capacidade": 300,
    "tipo": "PALESTRA"
  }'
```

### 🔎 Exemplo: buscar por identificador

```bash
curl http://localhost:8080/v1/eventos/identificador/JAVA-SUMMIT-2026
```

### ✅ Resposta de sucesso

```json
{
  "success": true,
  "message": "Evento criado com sucesso",
  "data": {
    "id": 1,
    "nome": "Java Summit",
    "descricao": "Encontro sobre o ecossistema Java",
    "identificador": "JAVA-SUMMIT-2026",
    "dataInicio": "2026-09-10T09:00:00",
    "dataFim": "2026-09-10T18:00:00",
    "localEvento": "Centro de Convenções",
    "organizador": "Comunidade Java",
    "capacidade": 300,
    "tipo": "PALESTRA"
  },
  "timestamp": "2026-05-27T14:00:00"
}
```

### ❌ Resposta de erro

```json
{
  "success": false,
  "message": "Evento não encontrado",
  "errors": [
    "Evento de ID 99 não encontrado"
  ],
  "timestamp": "2026-05-27T14:00:00"
}
```

### 🚦 Códigos de erro

| Status | Situação |
|---|---|
| `404 Not Found` | Evento não encontrado |
| `409 Conflict` | Identificador já utilizado por outro evento (a comparação ignora maiúsculas e minúsculas) |

### 🎭 Tipos de evento

🛠️ `WORKSHOP` · 🎤 `PALESTRA` · 🎵 `MUSICA` · 🎓 `SEMINARIO`

---

## 🧱 Arquitetura

O `Core` contém as regras de negócio e define contratos; a `Infrastructure` implementa esses contratos. A dependência aponta sempre para dentro.

```text
src/main/java/dev/alexandraemmeline/EventClean
│
├── Core
│   ├── Domains        # Entidades de domínio (EventoDomain)
│   ├── Enums          # TipoEvento
│   ├── Exceptions     # EventNotFoundException, DuplicateEventException
│   ├── Gateway        # Contratos de acesso a dados (interfaces)
│   └── UseCases       # Regras de negócio (interface + implementação)
│
├── Infrastructure
│   ├── Beans          # Configuração dos beans (injeção dos use cases)
│   ├── Controllers    # EventoController
│   ├── DTOs           # EventoDTO
│   ├── Gateway        # Implementação do gateway com JPA
│   ├── Handler        # GlobalExceptionHandler, SuccessResponse, ErrorResponse
│   ├── Mappers        # DTO <-> Domain <-> Entity
│   └── Persistence    # EventoEntity e EventoRepository
│
└── EventCleanApplication.java
```

### 🔄 Fluxo de uma requisição

```text
Controller → Mapper (DTO → Domain) → UseCase → Gateway (interface)
                                                    │
                                        GatewayImpl → Repository → PostgreSQL
```

### ⚡ Use cases

| Use case | Responsabilidade |
|---|---|
| `CriarEventoUseCase` | Cria um evento e impede identificador duplicado |
| `ListarEventosUseCase` | Lista todos os eventos |
| `BuscarEventoUseCase` | Busca por ID |
| `BuscarEventoPorIdentificadorUseCase` | Busca por identificador |
| `AtualizarEventoUseCase` | Atualização completa |
| `AtualizarEventoParcialmenteUseCase` | Atualização parcial |
| `DeletarEventoUseCase` | Remoção |

---

## 💾 Modelo de dados

Tabela `eventos`, criada pela migration `V1__criar_tabela_eventos.sql`:

| Coluna | Tipo | Restrições |
|---|---|---|
| `id` | `BIGSERIAL` | Chave primária |
| `nome` | `VARCHAR(255)` | Obrigatório |
| `descricao` | `TEXT` | Opcional |
| `identificador` | `VARCHAR(255)` | Obrigatório, **único** |
| `data_inicio` | `TIMESTAMP` | Obrigatório |
| `data_fim` | `TIMESTAMP` | Obrigatório |
| `local_evento` | `VARCHAR(255)` | Obrigatório |
| `organizador` | `VARCHAR(255)` | Obrigatório |
| `capacidade` | `INTEGER` | Obrigatório |
| `tipo` | `VARCHAR(50)` | Obrigatório |

---

## 🧪 Testes

```bash
./mvnw test
```

Hoje existe apenas o teste `EventCleanApplicationTests` (`contextLoads`). Ele sobe o contexto completo da aplicação, por isso **precisa do PostgreSQL em execução** e das variáveis de ambiente carregadas.

---

## 📦 Deploy

O projeto ainda não possui `Dockerfile`. Para gerar e executar o pacote manualmente:

```bash
./mvnw clean package
java -jar target/EventClean-0.0.1-SNAPSHOT.jar
```

Em produção, defina as variáveis `DB_*` no ambiente da plataforma (ou em um gerenciador de segredos), em vez de usar o arquivo `.env`, e use credenciais diferentes das de desenvolvimento.

---

## 🩺 Solução de problemas

| Sintoma | Causa provável | Solução |
|---|---|---|
| `Could not resolve placeholder 'DB_HOST'` | As variáveis de ambiente não foram carregadas | Execute o `export` (ou o equivalente do seu sistema) antes de iniciar a aplicação |
| `Connection refused` ao conectar no banco | O container não está rodando ou a porta está errada | Rode `docker compose ps` e confira `DB_HOST` e `DB_PORT` |
| `password authentication failed` | O banco foi criado com outra senha | Confira o `.env`; se mudou a senha depois de criar o container, recrie-o com `docker compose down -v` (apaga os dados) |
| `port is already allocated` | A porta do banco já está em uso | Altere `DB_PORT` no `.env` e suba o container de novo |
| Erro de versão do Java ao compilar | JDK anterior ao 17 | Instale o JDK 17+ e confira com `java -version` |

---

## 🎯 Roadmap

- [ ] 🧪 Testes unitários dos use cases e testes de integração dos endpoints
- [ ] 🛡️ Ativar `@Valid` nos controllers e tratar `MethodArgumentNotValidException` no handler global
- [ ] 📖 Documentação com Swagger/OpenAPI
- [ ] 🔍 Paginação e filtros de busca
- [ ] 🔐 Autenticação com JWT
- [ ] 🐳 `Dockerfile` da aplicação e pipeline de deploy
- [ ] 📝 Logs estruturados

---

## 🤝 Como contribuir

1. Faça um fork do repositório.
2. Crie uma branch para a sua alteração: `git checkout -b feature/minha-feature`.
3. Faça commits pequenos e com mensagens claras (por exemplo, `feat: adiciona filtro por tipo`).
4. Rode `./mvnw test` antes de enviar.
5. Abra um Pull Request descrevendo o que mudou e por quê.

Sugestões e problemas encontrados podem ser registrados nas *issues* do repositório.

---

## 📄 Licença

Distribuído sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 💜 Autora

Desenvolvido por **Alexandra Emmeline**.
