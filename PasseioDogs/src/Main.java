import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //Criar meus Dogs
        Dog dog = new Dog("Bruce", "spitz", 2, "Dir 1");
        Dog dog2 = new Dog("Bout", "Doberman", 3, "Dir 2");
        Dog dog3 = new Dog("Madona", "Buldog Francês", 3, "Dir 3");
        Dog dog4 = new Dog("Calipso", "spitz", 5, "Dir 4");
        Dog dog5 = new Dog("Maia", "Collie", 1, "Dir 5");

        //Declaro um array list e vou add o cachorro que irá passear em cada dia da semana

        ArrayList<Dog> segunda = new ArrayList<>();
        ArrayList<Dog> terca = new ArrayList<>();
        ArrayList<Dog> quarta = new ArrayList<>();
        ArrayList<Dog> quinta = new ArrayList<>();
        ArrayList<Dog> sexta = new ArrayList<>();
        ArrayList<Dog> sabado = new ArrayList<>();
        ArrayList<Dog> domingo = new ArrayList<>();

        //Adicionar nos dias quais cachorros devo passear
        segunda.add(dog);
        segunda.add(dog2);
        segunda.add(dog3);

        terca.add(dog2);
        terca.add(dog4);

        quarta.add(dog);
        quarta.add(dog3);
        quarta.add(dog5);

        quinta.add(dog);
        quinta.add(dog4);
        quinta.add(dog3);
        quinta.add(dog5);

        sexta.add(dog);

        sabado.add(dog2);
        sabado.add(dog4);


        //Serialização
        try {
            FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(new File("Docs.Dat")); //nome do arquivo onde salvo as informações
            //Irá aparecer um erro de Exception, por isso implementa o TRY/CATCH
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //Dentro do Object vou manipular os objetos e salvar no arquivo
            //Irá mostrar um novo erro, pois precisa criar outra exceção (outro Catch)

            /*Agora que tenho0 o Objeto de OutPut que vai enviar o arquivo, vou trazer ele e especificar o que quero salvar*/
            objectOutputStream.writeObject(segunda);
            objectOutputStream.writeObject(terca);
            objectOutputStream.writeObject(quarta);
            objectOutputStream.writeObject(quinta);
            objectOutputStream.writeObject(sexta);
            objectOutputStream.writeObject(sabado);
            objectOutputStream.writeObject(domingo);
            objectOutputStream.close();

            //O Arquivo está externo, e preciso buscar esses arquivos, então utilizo o input
            FileInputStream fileInputStream = new FileInputStream("Docs.Dat");
            //Objeto de entrada
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //Lista de Dogs, salva e armazena o que está no input do Objeto
            ArrayList<Dog> dias;

            //Lê o objeto e prepara um texto para a saída
            for (int i = 0; i < 5; i++) {
                System.out.println("Dia:  " + (i + 1)); //pegará posição por posição dos dias da semana
                System.out.println("______________________________");
                dias = (ArrayList<Dog>) objectInputStream.readObject(); //e armazenará em dias, o arrayList de cachorros
                //For EACH
                for (Dog c : dias) {
                //ele irá ler na sequência e irá atribuir ao "c" o primeiro cachorro na posição 0
                System.out.println(c); //imprimei cada um dos cachorros que está no arquivo
            }
        }
        //fechar o objeto
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //imprime o erro
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}