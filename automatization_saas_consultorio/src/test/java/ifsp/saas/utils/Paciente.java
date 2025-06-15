package ifsp.saas.utils;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Locale;

@Getter
@Builder
public class Paciente {
  private String nome;
  private String telefone;
  private String email;
  private String senha;
  private String dataDeNascimento;


  public static Paciente criarPacienteAleatorio() {
    Faker faker = new Faker(new Locale("pt-BR"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String date = sdf.format(faker.date().birthday(18,65));
    return Paciente.builder()
            .nome(faker.name().fullName())
            .dataDeNascimento(date)
            .telefone(faker.phoneNumber().cellPhone())
            .email(faker.internet().emailAddress())
            .senha(faker.internet().password(6, 12,true))
            .build();
  }

}
