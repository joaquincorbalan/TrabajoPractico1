package Concursos;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class MailExport implements Export {
    private final String HOST;
    private final String PORT;
    private final String USERNAME;
    private final String PASS;
    private final String from;
    private final String to;

    public MailExport(String username, String host, String port, String password, String from, String to) {
        this.HOST = host;
        this.PORT = port;
        this.USERNAME = username;
        this.PASS = password;
        this.from = from;
        this.to = to;
    }

    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        //Configuracion SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.HOST);
        props.put("mail.smtp.port", this.PORT);
        //Creacion del mail
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASS);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Registro En el concurso");
            message.setText(fecha + ": " + "Fuiste registrado en el concurso N°" + idConcurso + ". Su numero de concunsarte es N°" +
                    idParticipante);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
