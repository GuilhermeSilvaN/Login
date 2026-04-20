#  Sistema de Login com Autenticação

Este projeto é um sistema completo de login onde usuários podem criar uma conta, entrar no sistema e acessar seus próprios dados de forma segura.

## O que o sistema faz?

- Permite que o usuário se cadastre
- Permite realizar login com email e senha
- Gera um token de segurança (JWT)
- Mantém o usuário autenticado
- Exibe dados (produtos) vinculados ao usuário logado

## Segurança

O sistema utiliza autenticação com token (JWT), garantindo que cada usuário só consiga acessar seus próprios dados.

## Como funciona (de forma simples)

1. O usuário cria uma conta
2. Faz login
3. O sistema gera um "token de acesso"
4. Esse token é enviado em todas as requisições
5. O backend valida e libera os dados do usuário

##  Tecnologias utilizadas

- Front-end: React
- Back-end: Spring Boot
- Banco de dados: MySql e H2
- Autenticação: JWT
