package projetopoo3;

import java.util.Scanner;

public class Projetopoo3 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n======================================");
            System.out.println("     CLÍNICA VETERINÁRIA DO JHON");
            System.out.println("======================================");
            System.out.println("1 - Agendar consulta");
            System.out.println("2 - Consultar agenda");
            System.out.println("3 - Editar consulta");
            System.out.println("4 - Cancelar consulta");
            System.out.println("5 - Sair");
            System.out.println("======================================");

            System.out.print("Digite uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n---------- AGENDAR CONSULTA ----------");
                    if (AgendaManager.estaCheia()) {
                        System.out.println("A agenda está cheia!");
                        System.out.println("Não é possível realizar novos agendamentos.");
                    } else {
                        System.out.print("Horário desejado (1 a 10): ");
                        int horario = entrada.nextInt();
                        entrada.nextLine();
                        
                        if (horario < 1 || horario > 10) {
                            System.out.println("Horário inválido!");
                            
                        } else if (!AgendaManager.disponivel(horario - 1)) {
                            System.out.println("Não é possível agendar!");
                            System.out.println("Este horário já está ocupado." );
                            
                        } else {
                            System.out.print("Nome do animal: ");
                            String nome = entrada.nextLine();
                            
                            System.out.print("Idade do animal: ");
                            int idade = entrada.nextInt();
                            
                            entrada.nextLine();
                            System.out.print("Nome do dono: ");
                            String nomeDono = entrada.nextLine();
                            
                            System.out.print("Telefone do dono: ");
                            int telefone = entrada.nextInt();
                            
                            entrada.nextLine();
                            System.out.println("\nTipo de animal:");
                            System.out.println("1 - Cachorro");
                            System.out.println("2 - Gato");
                            System.out.print("Escolha: ");
                            int tipo = entrada.nextInt();
                            
                            entrada.nextLine();
                            Animal animal = null;
                            
                            if (tipo == 1) {
                                System.out.print(
                                        "Raça: "
                                );
                                String raca = entrada.nextLine();
                                
                                animal = new Cachorro(raca,nome,idade,nomeDono,telefone);
                            } else if (tipo == 2) {
                                
                                System.out.print("Temperamento: ");
                                String temperamento = entrada.nextLine();
                                animal = new Gato(temperamento,nome,idade,nomeDono,telefone);
                                
                            } else {
                                
                                System.out.println("Tipo de animal inválido!");
                                break;
                            }
                            
                            System.out.print("Sintomas / queixa principal: ");
                            String sintomas = entrada.nextLine();
                            
                            Consulta consulta = new Consulta(animal,horario - 1,sintomas);
                            AgendaManager.agendar(consulta);
                            
                            System.out.println("Consulta agendada com sucesso!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n---------- CONSULTA DA AGENDA ----------");
                    if (AgendaManager.estaVazia()) {
                        System.out.println("A agenda está completamente vazia.");
                        System.out.println("Nenhum atendimento foi agendado para o dia.");
                    } else {
                        AgendaManager.listar();
                    }
                    break;

                case 3:
                    System.out.println("\n---------- EDITAR CONSULTA ----------");
                    System.out.print("Informe o horário da consulta (1 a 10): ");
                    int horarioEditar = entrada.nextInt();
                    entrada.nextLine();
                    if (horarioEditar < 1 ||horarioEditar > 10) {
                        System.out.println("Horário inválido!");
                    } else if (AgendaManager.disponivel(horarioEditar - 1)) {
                        System.out.println("Não existe consulta cadastrada nesse horário.");
                    } else {
                        System.out.println("\nO que deseja alterar?");
                        System.out.println("1 - Horário");
                        System.out.println("2 - Sintomas");
                        System.out.println("3 - Animal");
                        System.out.print("Escolha: ");
                        int escolhaEditar = entrada.nextInt();
                        entrada.nextLine();
                        switch (escolhaEditar) {
                            case 1:
                                System.out.print("Novo horário (1 a 10): ");
                                int novoHorario = entrada.nextInt();
                                entrada.nextLine();
                                if (novoHorario < 1 || novoHorario > 10) {
                                    System.out.println("Horário inválido!");
                                } else if (!AgendaManager.disponivel(novoHorario - 1)) {
                                    System.out.println("Não foi possível alterar!");
                                    System.out.println("O novo horário já está ocupado.");
                                } else {
                                    AgendaManager.editar(horarioEditar - 1,novoHorario - 1);
                                    System.out.println("Horário alterado com sucesso!");
                                }
                                break;
                            case 2:
                                System.out.print("Digite os novos sintomas: ");
                                String novosSintomas = entrada.nextLine();
                                AgendaManager.editar(horarioEditar - 1,novosSintomas);
                                break;
                            case 3:
                                System.out.println("\nNovo tipo de animal:");
                                System.out.println("1 - Cachorro");
                                System.out.println("2 - Gato");
                                System.out.print("Escolha: ");
                                int tipoAnimal = entrada.nextInt();
                                entrada.nextLine();
                                if (tipoAnimal == 1) {
                                    System.out.print("Nome: ");
                                    String nome = entrada.nextLine();
                                    System.out.print("Idade: ");
                                    int idade = entrada.nextInt();
                                    entrada.nextLine();

                                    System.out.print("Nome do dono: ");
                                    String nomeDono = entrada.nextLine();

                                    System.out.print("Telefone: ");
                                    int telefone = entrada.nextInt();
                                    entrada.nextLine();

                                    System.out.print("Raça: ");
                                    String raca = entrada.nextLine();
                                    Cachorro cachorro = new Cachorro(raca, nome, idade, nomeDono, telefone);
                                    AgendaManager.editar(horarioEditar - 1, cachorro);
                                } else if (tipoAnimal == 2) {
                                    System.out.print("Nome: ");
                                    String nome = entrada.nextLine();
                                    
                                    System.out.print("Idade: ");
                                    int idade = entrada.nextInt();
                                    entrada.nextLine();

                                    System.out.print("Nome do dono: ");
                                    String nomeDono = entrada.nextLine();

                                    System.out.print("Telefone: ");
                                    int telefone = entrada.nextInt();
                                    entrada.nextLine();

                                    System.out.print("Temperamento: ");
                                    String temperamento = entrada.nextLine();

                                    Gato gato = new Gato(temperamento,nome,idade,nomeDono,telefone);

                                    AgendaManager.editar(horarioEditar - 1, gato);
                                } else {
                                    System.out.println("Tipo de animal inválido!");
                                }
                                break;
                            default:
                                System.out.println("Opção de edição inválida!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n---------- CANCELAR CONSULTA ----------");
                    System.out.print("Informe o horário (1 a 10): ");
                    int horarioExcluir = entrada.nextInt();
                    entrada.nextLine();

                    if ( horarioExcluir < 1 || horarioExcluir > 10) {
                        System.out.println("Horário inválido!");
                    } else if (AgendaManager.disponivel( horarioExcluir - 1 )) {
                        System.out.println("Não existe consulta cadastrada nesse horário.");
                    } else {
                        AgendaManager.Excluir(horarioExcluir - 1);
                    }
                    break;

                case 5:
                    System.out.println("\nSistema encerrado!");
                    break;
                    
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
        entrada.close();
    }
}