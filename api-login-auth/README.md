#  Back-end - Sistema de Login

Este módulo é responsável por toda a lógica de autenticação, segurança e gerenciamento de dados.

---

## Arquitetura

O projeto segue o padrão:

- Controller → recebe requisições HTTP
- Service → lógica de negócio
- Repository → acesso ao banco de dados

---

## Autenticação com JWT

Fluxo:

1. Usuário envia email e senha
2. Spring Security valida as credenciais
3. Um token JWT é gerado
4. O token é enviado para o cliente
5. Em cada requisição, o token é validado

---

## Segurança

- Spring Security configurado
- Endpoints protegidos
- Apenas `/login/**` é público
- Outros endpoints exigem autenticação

---

##  Endpoints principais

### 🔹 Login

POST /login


### 🔹 Registro

POST /login/register


### 🔹 Listar produtos (protegido)

GET /product/list


---

## Como o usuário é identificado

O backend utiliza o token JWT para:

- Extrair o email do usuário
- Buscar no banco de dados
- Retornar apenas os dados daquele usuário

---

## CORS

Foi configurado para permitir comunicação com o front-end (React).

---

## ️ Banco de dados

- Relacionamento entre usuário e produtos
- Cada produto pertence a um usuário

---

## Possíveis melhorias

- Refresh token
- Melhor tratamento de exceções
- Logs estruturados
- Testes automatizados