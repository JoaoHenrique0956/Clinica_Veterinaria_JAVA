package projetopoo3;

public class AgendaManager {

    private static Consulta[] agenda = new Consulta[10];

    public AgendaManager() {

    }

    public static void agendar(Consulta consulta) {
        if (agenda[consulta.getHorario()] == null) {
            agenda[consulta.getHorario()] = consulta;
        } else {
            System.out.println("Operação impossível! " + "Já existe uma consulta cadastrada nesse horário.");
        }
    }

    public static void listar() {

        for (int i = 0; i < 10; i++) {
            if (agenda[i] != null) {
                System.out.println("----------------------------------------------------------------------");
                System.out.printf("Horario: %d",agenda[i].getHorario() + 1);
                System.out.printf("\nTipo de animal: %s",agenda[i].getAnimal().getClass().getSimpleName());
                System.out.printf("\nNome do animal: %s",agenda[i].getAnimalNome());
                System.out.printf("\nIdade do animal: %d",agenda[i].getAnimalIdade());
                System.out.printf("\nSintomas: %s",agenda[i].getSintomas());
                System.out.printf("\n\nNome do Dono: %s",agenda[i].getDonoNome());
                System.out.printf("\nTelefone do Dono: %d",agenda[i].getDonoTel());
                System.out.printf("\nSom emitido: %s\n",agenda[i].getAnimal().emitirSom());
            } else {
                System.out.println("----------------------------------------------------------------------");
                System.out.printf("Horario: %d",i + 1);
                System.out.println("\n[Disponível]");
            }
        }
    }

    public static void editar(int horario, int novoHorario) {

        System.out.println("----------------------------------------------------------------------");
        if (agenda[horario] != null) {
            if (agenda[novoHorario] == null) {
                agenda[horario].setHorario(novoHorario);
                agenda[novoHorario] = agenda[horario];
                agenda[horario] = null;
                System.out.println("Consulta editada com sucesso!");
            } else {
                System.out.println("Não foi possível editar a consulta: " + "novo horário já possui consulta cadastrada.");
            }
        } else {
            System.out.println("Não foi possível editar a consulta: "+ "horário sem consulta cadastrada.");
        }
    }

    public static void editar(int horario, String novosSintomas) {

        System.out.println("----------------------------------------------------------------------" );
        if (agenda[horario] != null) {
            agenda[horario].setSintomas(novosSintomas);
            System.out.println("Sintomas editados com sucesso!");
        } else {
            System.out.println("Não foi possível editar os sintomas: "+ "horário sem consulta cadastrada.");
        }
    }

    public static void editar(int horario, Animal novoAnimal) {
        System.out.println("----------------------------------------------------------------------");
        if (agenda[horario] != null) {
            agenda[horario].setAnimal(novoAnimal);
            System.out.println(
                    "Animal editado com sucesso!"
            );
        } else {
            System.out.println(
                    "Não foi possível editar o animal: "
                    + "horário sem consulta cadastrada."
            );
        }
    }

    public static void Excluir(int horario) {
        System.out.println("----------------------------------------------------------------------");
        if (agenda[horario] != null) {
            agenda[horario] = null;
            System.out.println("Consulta excluída com sucesso!");
        } else {
            System.out.println("Não foi possível excluir a consulta: "+ "horário sem consulta cadastrada.");
        }
    }

    public static boolean disponivel(int horario) {
        return agenda[horario] == null;
    }

    public static boolean estaVazia() {
        for (int i = 0; i < 10; i++) {
            if (agenda[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean estaCheia() {
        for (int i = 0; i < 10; i++) {
            if (agenda[i] == null) {
                return false;
            }
        }
        return true;
    }
}