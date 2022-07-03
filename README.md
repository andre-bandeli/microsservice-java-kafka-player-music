## Microsservices Spring Boot Aplication + Mensageria com Kafka
![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
)
![KAFKA](https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white
)
![Badge](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
)


Aplicação spring boot, desenvolvida utilizando arquitetura de microserviços e mensageria com o Apache Kafka.

### Ferramentas utilizadas

- Java 11
- Docker
- Apache Kafka
- Spring Boot
- Apache Maven
- MySQL
- Conduktor
- DBeaver

### Para rodar o projeto:

certifique-se de ter instalado em sua máquina o Docker e o Maven. Cada um dos módulos possue um arquivo de 
configurações para dependências (pom) e suas configurações de propriedades (application).  

- clone o repositório:

      git clone https://github.com/andre-bandeli/microsservice-java-kafka-player-music.git
- configure o maven realizando as instalações das dependências. Para isto, caminhe até a pasta onde encontra-se
o arquivo 'pom.xml' em cada um dos microsserviços e rode o comando: 

      mvn clean install
  obs: altere as configurações de acesso ao banco de dados no arquvio docker-compose.yaml

- Imagem Docker para o banco de dados MySQL 

      version: '3.1' services:

      db:
          image: mysql
          command: --default-authentication-plugin=mysql_native_password
          restart: always
          environment:
              MYSQL_ROOT_PASSWORD: example

       adminer:
           image: adminer
           restart: always
           ports:
             - 8080:8080

    
