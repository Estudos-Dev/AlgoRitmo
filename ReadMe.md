Sales Rank Backend - Java Spring Boot
API RESTful para gerenciamento e ranking de vendas com análise comparativa de algoritmos de ordenação.

📋 Resumo
Backend responsável por:

CRUD de vendas, clientes, vendedores e produtos

Endpoints otimizados para consumo pelo frontend

Persistência com PostgreSQL

Validação e tratamento de erros

🛠️ Tecnologias
Java 17+

Spring Boot 3.x

Spring Data JPA

PostgreSQL 14+

Maven

🚀 Como Rodar
Pré-requisitos
bash
Java 17+
PostgreSQL 14+
Maven 3.8+
Setup do Banco de Dados
sql
CREATE DATABASE sales_db;
CREATE USER sales_user WITH PASSWORD 'senha123';
ALTER ROLE sales_user WITH CREATEDB;
GRANT ALL PRIVILEGES ON DATABASE sales_rank TO sales_user;
Configurar Variáveis de Ambiente
Criar .env na raiz do projeto:

text
DB_URL=jdbc:postgresql://localhost:5432/sales_rank
DB_USERNAME=sales_user
DB_PASSWORD=senha123
SERVER_PORT=8080
SPRING_PROFILE=dev
Instalar e Rodar
bash
# Clonar
git clone https://github.com/seu-usuario/sales-rank-backend.git
cd sales-rank-backend

# Instalar dependências
mvn clean install

# Rodar
mvn spring-boot:run
API disponível em: http://localhost:8080/api

🌐 Variáveis de Ambiente
Variável	Descrição	Exemplo
DB_URL	URL do banco de dados	jdbc:postgresql://localhost:5432/sales_rank
DB_USERNAME	Usuário do banco	sales_user
DB_PASSWORD	Senha do banco	senha123
SERVER_PORT	Porta do servidor	8080
SPRING_PROFILE	Perfil (dev/prod)	dev
