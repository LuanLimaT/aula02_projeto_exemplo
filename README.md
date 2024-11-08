CRUD de Veículos com JP

Este projeto é uma aplicação de CRUD (Create, Read, Update, Delete) para gerenciar veículos, implementado em Java utilizando JPA para persistência de dados. Ele permite o cadastro, atualização, visualização e exclusão de veículos em um banco de dados relacional.

Funcionalidades
Cadastro de Veículos: Permite inserir novos veículos no sistema, registrando informações como marca, modelo, ano de fabricação e preço.
Listagem de Veículos: Exibe uma lista com todos os veículos cadastrados, com detalhes completos.
Atualização de Veículos: Permite atualizar as informações de um veículo existente, como valor, modelo, ou ano de fabricação.
Exclusão de Veículos: Remove um veículo específico do sistema.

Tecnologias Utilizadas
Java
JPA (Java Persistence API)
Spring Framework (para injeção de dependências e configuração)
Banco de dados relacional
Maven para gerenciamento de dependências

Estrutura do Projeto
O projeto contém as seguintes classes principais:

Veículo - Entidade que representa o veículo com seus atributos (id, marca, modelo, ano de fabricação e preço).
Repositório - Interface responsável pela comunicação com o banco de dados.
Serviços - Classe de serviço que realiza as operações de CRUD no repositório.
Controladores - Controladores responsáveis por processar as requisições e retornar as respostas.
Configuração do Banco de Dados
Configure o banco de dados no arquivo application.properties, incluindo as credenciais e o nome do banco. O JPA irá gerar automaticamente a tabela para a entidade Veículo.
