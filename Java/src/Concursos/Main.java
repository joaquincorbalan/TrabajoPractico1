package Concursos;

import java.time.LocalDate;

public class Main {
    public static void main() {
        Export export = new MailExport("a61df6ee928375", "sandbox.smtp.mailtrap.io",
                "2525", "184b2d5fa04073", "joaquincorbalan7@gmail.com", "ejemplomail@gmail.com");
        //Export export = new BdExport();
        //Export export = new FileExport();
        Participante p = new Participante("Joaquin Corbalan", "44666492");
        Participante p1 = new Participante("Tania Rodriguez", "45209253");
        Concurso concurso = new Concurso(LocalDate.now().minusMonths(1)
                , LocalDate.now().plusMonths(1), LocalDate.now(), export);
        concurso.agregarParticipante(p);
    }
}
