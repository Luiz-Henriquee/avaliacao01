package Aplicativo;

import java.io.IOException;
import java.util.Scanner;
import Classe.Aeronave;
import Classe.Pilotos;


public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pilotos[] piloto = new Pilotos[MAX_ELEMENTOS];
        Aeronave[] aeronave = new Aeronave[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                Pilotos pilotos = new Pilotos();
                Aeronave aeronaves = new Aeronave();

                piloto[qtdCadastrados] = new Pilotos();
                aeronave[qtdCadastrados] = new Aeronave();

                System.out.print("Digite o nome do piloto: ");
                pilotos.setNome(in.nextLine());
                
                System.out.print("Digite o CPF do piloto: ");
                pilotos.setCpf(in.nextLine());
                  
                System.out.print("Digite o Brevê do piloto: ");
                pilotos.setBrevê(in.nextLine());

                System.out.print("Digite o Numero de Serie da aeronave do Piloto: ");
                aeronaves.setNumSerie(in.nextLine());

                piloto[qtdCadastrados] = pilotos;
                aeronave[qtdCadastrados] = aeronaves;
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);


            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                 for (int i = 0; i < qtdCadastrados; i++) {

                System.out.println("--------------------");
                System.out.println("Pilotos Cadastrados:");
                System.out.println("--------------------");
                    
                Pilotos p = new Pilotos();
                Aeronave a = new Aeronave();
                
                a = aeronave [i];
                p = piloto [i];
                    
                System.out.printf("Nome do piloto: %s\nCPF do piloto: %s\nBrevê do Piloto: %s\nNumero de Serie da Aeronave do Piloto: %s\n", p.getNome(), p.getCpf(), p.getBrevê(), a.getNumSerie());

                }


                voltarMenu(in);
            } else if (opcao == 3) {

                Pilotos p = new Pilotos();
                Aeronave a = new Aeronave();
                String BuscaCPF;

                if (qtdCadastrados == 0){
                        System.out.println("Ainda não foi cadastrado nenhum piloto!");
                        continue;
                    }

                else { 
                    System.out.print("Digite o CPF do piloto: ");
                    BuscaCPF = (in.nextLine());
                    if (BuscaCPF != p.getCpf()){

                        System.out.println("O CPF digitado, não consta no sistema.");
                    
                    }
                    
                    for (int i = 0; i < qtdCadastrados; i++){
                        a = aeronave [i];
                        p = piloto [i];  


                    if(BuscaCPF.equals(piloto[i].getCpf())){
                        System.out.println("-------------------------------"  );
                        System.out.println("Dados do piloto que você buscou"  );
                        System.out.println("-------------------------------"  );
                        System.out.printf("Nome do piloto: %s\nCPF do piloto: %s\nBrevê do Piloto: %s\nNumero de Serie da Aeronave do Piloto: %s\n", p.getNome(), p.getCpf(), p.getBrevê(), a.getNumSerie());
                        }
                    }}
                
                }
    
                 
                
             else if (opcao == 4) {

                int nv;
                System.out.print("Digite o tamanho do armazenamento: ");
                nv = (in.nextInt());

                if (nv >= MAX_ELEMENTOS){

                    MAX_ELEMENTOS = nv;
                    System.out.println("Novo vetor cadastrado com sucesso!");
                    System.out.println("O tamanho do novo armazenamento é: " + MAX_ELEMENTOS);
                    continue;
                } else {

                    System.out.print("Tamanho ínvalido, o novo tamanho deve ser maior que "+ MAX_ELEMENTOS);

                }

                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}