# Secstor Library

Biblioteca para utilização de algoritmos de compartilhamento de segredos e anonimização de ados para adequação de 
sistemas à LGPD

## Requirementos

- JDK 17 ou superior
- JRE 1.8.0 ou superior
- Lombok Annotations Support for VS Code (extensão para o <b>Visual Studio Code</b>)

## Para utilizar a biblioteca

Utilize o comando abaixo:

```
git clone https://github.com/Acacio-coding/Secstor-library
```

Agora siga os seguintes passos:

1. Abra o projeto com a IDE ou editor de código de sua preferência;
2. Certifique-se de instalar as dependências presentes no arquivo <b>pom.xml</b>
3. Cheque o exemplo de utilização dentro no pacote <b>ifsc.secstor.library</b>
4. Crie uma classe com o método <b>main</b>
5. Utilize a biblioteca seguindo o exemplo abaixo:
```java
import com.ifsc.secstor.library.facade.EngineMaker;

public class Example {
    public static void main(String[] args) throws Exception {
        int N = 10;
        int K = 5;

        EngineMaker engineMaker = new EngineMaker(N, K);

        //Informação a ser dividida e reconstruída
        String data = "teste";

        //Divisão
        engineMaker.split(data, "shamir");

        
        //Printando as chaves geradas, lembre-se de utilizar 
        //o get na engine que você realizou split
        engineMaker.getShamir().getPieces().forEach(System.out::println);
        
        //Reconstrução 
        //N chaves
        String reconstructed = engineMaker.reconstruct("shamir");
        System.out.println("\n" + reconstructed);

        //K chaves ou um número de chaves, onde K <= número de chaves <= N
        reconstructed = engineMaker.reconstruct("shamir", K);
        System.out.println("\n" + reconstructed);
    }
}
```
Obs.: os algoritmos disponíveis são **shamir**, **pss**, **css**, **krawczyk** e **pvss**, as classes dentro do pacote <b>ifsc.secstor.library.facade</b> estão documentadas seguindo os padrões do <b>javadoc</b>

### Para utilizar os testes de tempo da biblioteca

Existem duas formas de realizar os testes, a primeira é utilizando o shellscript <b>timing-test-runner.sh</b>:

1. Certifique-se de ter o <b>maven</b> instalado utilizando o <b>JDK 17</b>;
2. Executre o script seguindo as informações requeridas.
3. Sempre que for realizar o teste novamente não esqueça de apagar os resultados gerados em <b>timing-tests/results/</b> para evitar que os novos resultados sejam anexados ao mesmo arquivo;
5. Todos os resultados são gerados em formato <b>.csv</b> na pasta citada acima.

A outra forma é pelo próprio executor das IDE's java

1. Realize um <b>build</b> do projeto;
2. Encontre o arquivo de configuração de execução gerado pela sua IDE;
3. Adicione os seguintes argumentos respectivamente separados por espaços:
   1. N número de chaves (número máximo de chaves gerados na divisão) ;
   2. K número de chaves (número mínimo de chaves utilizados na reconstrução);
   3. Número de chaves a serem utilizadas na reconstrução por rodada, podem ser vários números como 10 7 5 (onde N=10 e K=5) por exemplo;
   4. Tamanho do dataset (1, 3, 5 ou 10) seguido de _100objects_dataset_to_split.json, ex.: 1kb_100objects_dataset_to_split.json;
   5. Número de threads utilizadas paralelamente durante o teste.
4. Sempre que for realizar o teste novamente não esqueça de apagar os resultados gerados em <b>timing-tests/results/</b> para evitar que os novos resultados sejam anexados ao mesmo arquivo;
5. Todos os resultados são gerados em formato <b>.csv</b> na pasta citada acima.

## Referências
T. Loruenser, A. Happe, D. Slamanig: "ARCHISTAR: Towards Secure and Robust Cloud Based Data Sharing"; Vortrag: Cloud Computing Technology and Science (CloudCom), 2015, Vancouver, Canada; 30.11.2015 - 03.12.2015; in: "CloudCom 2015", IEEE, (2016), S. 371 - 378.

Disponível em: <https://github.com/Archistar/archistar-smc>