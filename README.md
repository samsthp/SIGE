# SIGE: Sistema Integrado de Gestão ao Estágio

O SIGE é um sistema que visa facilitar a visibilidade dos estágios disponíveis por parte dos alunos interessados e a comunicação entre as empresas e o aluno estagiário. Ele permite o cadastro e gerenciamento de vagas, controle documental, avaliação mútua e emissão de certificados.

## Equipe de Desenvolvimento
| Ordem | Nome        |
|:------|:-------------|
| 1     | Samuel       |
| 2     | João Paulo   |
| 3     | Emily        |
| 4     | Gabriel      |
| 5     | Wesley       |

## Atores do Sistema
| Ator        | Definição                                                                 |
|:-------------|:--------------------------------------------------------------------------|
| Empresa      | Cadastra-se no sistema para divulgar vagas de estágio e atrair alunos.   |
| Aluno        | Cadastra-se para buscar vagas de estágio relacionadas ao seu curso.      |
| Coordenador  | Disponibiliza documentos e valida os estágios realizados pelos alunos.   |

## Requisitos Funcionais
| Id      | Ator        | Descrição                                                                 |
|:--------|:-------------|:-------------------------------------------------------------------------|
| REQ001  | Aluno        | O sistema deve permitir que o aluno faça o cadastro pela matrícula.      |
| REQ002  | Empresa      | O sistema deve permitir que a empresa faça o cadastro pelo CNPJ.         |
| REQ003  | Coordenador  | O sistema deve permitir que o coordenador faça o cadastro pela identidade única. |
| REQ004  | Todos        | O sistema deve permitir login com validação de credenciais.              |
| REQ005  | Empresa      | A empresa poderá realizar postagens de vagas com descrição e contato.    |
| REQ006  | Empresa      | O sistema deve permitir que a empresa apague vagas.                      |
| REQ007  | Todos        | O sistema deve permitir edição de perfis e formas de contato.            |
| REQ008  | Aluno        | O sistema deve permitir que o aluno visualize vagas de estágio.          |
| REQ009  | Aluno        | O sistema deve permitir que o aluno visualize e baixe documentações.     |
| REQ010  | Coordenador  | O sistema deve permitir que o coordenador valide o estágio do aluno.     |
| REQ011  | Aluno        | O aluno pode avaliar a empresa ao final do estágio.                      |
| REQ012  | Empresa      | A empresa pode avaliar o aluno após o estágio.                           |
| REQ013  | Todos        | O sistema deve permitir cadastro de, no mínimo, duas formas de contato.  |
| REQ014  | Aluno        | O aluno acessa apenas os documentos disponibilizados pelo coordenador.   |
| REQ015  | Aluno        | O aluno acessa o certificado de conclusão do estágio.                    |
| REQ016  | Coordenador  | O coordenador visualiza e valida os documentos enviados pelos alunos.    |
| REQ017  | Aluno        | O sistema deve permitir acompanhar o andamento do estágio.              |
| REQ018  | Aluno        | O sistema deve permitir consultar histórico de candidaturas.            |
| REQ019  | Todos        | O sistema deve permitir pesquisa avançada de vagas.                     |
| REQ020  | Coordenador  | O sistema deve permitir inativação técnica de usuários.                 |

## Regras de Negócio
| Id     | Nome                     | Descrição                                                                 |
|:-------|:--------------------------|:--------------------------------------------------------------------------|
| RN001  | Controle de Acesso        | Apenas usuários cadastrados têm acesso às funcionalidades internas.       |
| RN002  | Exclusividade de Vagas    | Somente empresas podem criar, editar ou apagar vagas.                     |
| RN003  | Avaliações Mútuas         | Após o estágio, aluno e empresa podem se avaliar mutuamente.              |
| RN004  | Validação Documental      | O coordenador deve validar documentos antes de liberar o certificado.     |
| RN005  | Confidencialidade         | Coordenadores veem documentos dos alunos; empresas veem os das vagas.     |

## Casos de Uso
| Id      | Nome                                   | Requisitos                | Regras de Negócio        |
|:---------|:---------------------------------------|:---------------------------|:--------------------------|
| CSU001  | Cadastro de Alunos                     | REQ001                     | RN001                    |
| CSU002  | Cadastro de Empresas                   | REQ002                     | RN001                    |
| CSU003  | Cadastro de Coordenador                | REQ003                     | RN001                    |
| CSU004  | Login no Sistema                       | REQ004                     | RN001                    |
| CSU005  | Publicar Vagas de Estágio              | REQ005                     | RN002                    |
| CSU006  | Excluir Vaga de Estágio                | REQ006                     | RN002                    |
| CSU007  | Editar Perfil e Contato                | REQ007                     | RN001                    |
| CSU008  | Visualizar Vagas de Estágio            | REQ008                     | RN001, RN002             |
| CSU009  | Visualizar e Baixar Documentos         | REQ009, REQ014             | RN005                    |
| CSU010  | Validação de Documentos de Estágio     | REQ010, REQ016             | RN004                    |
| CSU011  | Avaliar Empresa                        | REQ011                     | RN003                    |
| CSU012  | Avaliar Aluno                          | REQ012                     | RN003                    |
| CSU013  | Gerenciar Formas de Comunicação        | REQ013                     | RN001                    |
| CSU014  | Emissão de Certificado de Estágio      | REQ015, REQ016             | RN004                    |
| CSU015  | Controle de Acesso                     | REQ004                     | RN001                    |
| CSU018  | Acompanhamento do Estágio              | REQ017                     | RN004                    |
| CSU020  | Pesquisa Avançada de Vagas             | REQ019                     | RN001                    |
| CSU021  | Histórico de Candidaturas              | REQ018                     | RN001                    |


## Planejamento
| Sprint | Caso de Uso                                   | Desenvolvedor |
|:--------|:---------------------------------------------|:---------------|
| 1      | CSU004 – Login no Sistema                    | Samuel         |
| 1      | CSU008 – Visualizar Vagas de Estágio         | João Paulo     |
| 1      | CSU005 – Publicar Vagas de Estágio           | Emily          |
| 1      | CSU014 – Emissão de Certificado de Estágio   | Wesley         |
| 2      | CSU007 – Editar Perfil e Contato             | Samuel         |
| 2      | CSU001 – Cadastro de Aluno                   | João Paulo     |
| 2      | CSU002 – Cadastro de Empresa                 | Emily          |
| 2      | CSU003 – Cadastro de Coordenador             | Gabriel        |
| 2      | CSU010 – Validação de Documentos de Estágio  | Emily          |
| 3      | CSU011 – Avaliar Empresa                     | Samuel         |
| 3      | CSU013 – Gerenciar Formas de Comunicação     | João Paulo     |
| 3      | CSU006 – Excluir Vaga de Estágio             | Emily          |
| 3      | CSU012 – Avaliar Aluno                       | Gabriel        |
| 3      | CSU015 – Controle de Acesso                  | João Paulo     |
| 3      | CSU018 – Acompanhamento do Estágio           | Emily          |
| 3      | CSU020 – Pesquisa Avançada de Vagas          | Wesley         |
| 3      | CSU021 – Histórico de Candidaturas           | Wesley         |
