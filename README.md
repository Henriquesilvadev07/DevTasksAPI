API REST desenvolvida em Java para gerenciamento de usuários e autenticação segura baseada em tokens. O projeto implementa um sistema completo de controle de acesso (CRUD de usuários) aliado a um fluxo robusto de autenticação via JSON Web Token (JWT), garantindo que apenas usuários autenticados possam acessar rotas protegidas.

Funcionalidades
Gerenciamento de Usuários: Cadastro, atualização, consulta e exclusão de contas.

Autenticação Stateless: Login com emissão de token JWT, ideal para arquiteturas modernas de API REST.

Segurança Avançada com Spring Security: Proteção de rotas, criptografia de senhas utilizando BCrypt
e gerenciamento de estado sem sessão (STATELESS).

Tecnologias e Ferramentas
Java 21
Spring Boot 3
Spring Security
Spring Data JPA
PostgreSQL
Auth0 Java JWT (para geração e validação de tokens)
Lombok
Validation

 Boas Práticas e Arquitetura
O projeto foi construído seguindo padrões de mercado e arquitetura limpa

Senhas Criptografadas: As senhas nunca são salvas em texto plano no banco de dados;
o Spring Security utiliza o BCryptPasswordEncoder para o hash seguro.

Arquitetura Stateless: O servidor não armazena sessão de usuário;
toda a validação de identidade é feita de forma independente por meio do token JWT enviado via cabeçalho (Authorization: Bearer <token>).

Separação de Responsabilidades: Organização clara entre Controllers, Services, Repositories e DTOs (Records),
isolando as regras de negócio da camada de transporte.

Injeção de Dependências: Uso rigoroso da inversão de controle do Spring para desacoplar as classes e facilitar testes e manutenção.
