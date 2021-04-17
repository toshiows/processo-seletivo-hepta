

# Sistema de cadastro de funcionarios



</h1>

<p align="center">
	  <a href="#user-content--thinking">Sobre 		</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
	  <a href="#user-content--Preview">Preview</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
	  <a href="#user-content--Tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
	  <a href="#user-content--Como rodar o projeto">Como rodar</a>
</p>

### Sobre :thinking:
Projeto crud para cadastro de funcionários feito para o processo seletivo da Hepta, desenvolvido em Java para o backend e VueJS para o frontend.
<div>

</div>


### :eyeglasses: Preview
![enter image description here](https://i.imgur.com/9h6J2xCl.png)

### :hammer:	Tecnologias
Este projeto foi desenvolvido utilizando as seguintes tecnologias:
- [VueJS](https://vuejs.org/)
- [Html5](https://www.w3schools.com/html/default.asp)
- [CSS3](https://www.w3schools.com/css/default.asp)
- [Bootstrap](https://getbootstrap.com/)
- [Java 8](https://www.java.com)
- [Bootstrap](https://getbootstrap.com/)
- [Axios](https://github.com/axios/axios)

### :question: Como rodar o projeto
Clone esse repositorio no diretório que desejar e entre na pasta raiz do projeto.

## **Com Docker** :whale:

Caso não possua o docker, siga as [instruções](https://github.com/axios/axios) para instalação.

**Faça o build do projeto:**

```
$ cd <processo-seletivo-hepta-master>

$ docker-compose build --no-cache
```

**Para iniciar a aplicação utilize o comando:**

```
$ docker-compose up -d
```

**Para interromper a aplicação:**

```
$ docker-compose down
```
<br>

## **Sem o Docker** :computer:

**1. Executar o backend Java** :coffee:

**Realize a instalação dos itens seguintes:**
 - Mysql
 - Maven
 - JDK 8+
 - Apache Tomcat 6+

**Preparando o ambiente:**
 - Configure as variáveis de ambiente do [Maven](https://pt.stackoverflow.com/questions/259927/como-configurar-vari%C3%A1veis-de-ambiente-maven-java#:~:text=Nos%20campos%20nome%20e%20valor,e%20adicione%20%25MAVEN_HOME%25%5Cbin%20.) e [Java](https://www.devmedia.com.br/preparacao-do-ambiente-para-desenvolvimento-em-java/25188)
 - Baixe o [Apache Tomcat](http://tomcat.apache.org/) e descompacte na pasta que preferir e é necessário [configurar o Tomcat](http://www.mhavila.com.br/topicos/java/tomcat.html).
 - Instale o Mysql e configure com o usuário ***root*** e senha ***123987*** ou as credencias que preferir, porém será necessário alterar o arquivo **persistence.xml**.
 
 **Executando o projeto:**
 
 Pelo terminal entre na pasta **funcionarios-back-end** que fica logo após o diretório raiz.
 
 ```
 $ cd <processo-seletivo-hepta-master>
 $ cd <funcionarios-back-end>
 ```

Compile o projeto para gerar o arquivo **.war**

    $ mvn clean install

Copie o arquivo .war gerado na pasta target e cole dentro da pasta webapps do tomcat configurado acima e inicie conforme informado na seção de [configuração](http://www.mhavila.com.br/topicos/java/tomcat.html).

<br>

**2. Executar o front-end em VueJS** :leaves:

- Realize a instalação do [NodeJS](https://nodejs.org/en/).
- Após a instalação entre no diretório front-end do projeto clonado.

```
 $ cd <processo-seletivo-hepta-master>
 $ cd <funcionarios-front-end>
 ```
- Realize a instação do Vue CLI:
```
$ npm install -g vue-cli
```
- Instale as dependências do Vue:
```
$ npm install
```
- Suba o servidor local para o front-end:
```
$ npm run serve
```
<br>

Tudo certo! agora basta acessar o endereço retornado pelo terminal, que provavelmente será http://localhost:8081 ou alguma outra porta.


## **Execução dos testes de integração** :vertical_traffic_light:

Após subir o backend como demonstrado acima, acesse o diretório raiz do back-end.

 ```
 $ cd <processo-seletivo-hepta-master>
 $ cd <funcionarios-back-end>
 ```

Rode o seguinte comando para executar os testes:
```
$ mvn test 
```
