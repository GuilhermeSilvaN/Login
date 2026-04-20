# Front-end - Sistema de Login

Este módulo é responsável pela interface do usuário e comunicação com o back-end.

---

##  Estrutura

- Componentes React
- Hooks (`useState`, `useEffect`)
- Navegação com React Router
- Consumo de API com Axios

---

## Autenticação

Fluxo:

1. Usuário faz login
2. Recebe um token JWT
3. Token é salvo no localStorage
4. Um interceptor do Axios adiciona o token automaticamente nas requisições

---

## Interceptor (ponto importante)

O Axios foi configurado para enviar automaticamente:
em todas as requisições protegidas.

```js
api.interceptors.request.use((config)=>{
    const token = localStorage.getItem("token");

    if(token){
        config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
})
```
---

##  Consumo de API

Exemplo:

```js
const response = await api.get("/product/list");
```

### Gerenciamento de estado
---
- useState → armazenar dados
- useEffect → chamadas à API

### Funcionalidades
---

- Tela de login
- Tela de cadastro
- Consumo de API protegida
- Exibição de produtos do usuário

### Problemas resolvidos no desenvolvimento
---

- Envio automático do token
- Erros de CORS
- Diferença entre Postman e navegador
- Atualização de estado no React

### Melhorias futuras

---
- AuthContext (controle global de autenticação)
- Proteção de rotas
- Feedback visual (loading, erros)
- UI mais moderna