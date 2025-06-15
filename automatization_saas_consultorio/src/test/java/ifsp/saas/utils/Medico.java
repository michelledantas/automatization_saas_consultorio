package ifsp.saas.utils;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;

import java.util.Locale;

@Getter
@Builder
public class Medico {
  private String nome;
  private String especialidade;
  private String crm;

  public static Medico criarMedicoAleatorio() {
    Faker faker = new Faker(new Locale("pt-BR"));

    String[] especialidades = {"Cardiologia", "Dermatologia", "Pediatria", "Ortopedia", "Neurologia", "Ginecologia", "Psiquiatria"};
    String crm = String.valueOf(faker.number().numberBetween(10000, 99999));
    String[] ufs = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
        "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
        "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    String uf = ufs[faker.random().nextInt(ufs.length)];
    String crmCompleto = crm + "-" + uf;

    return Medico.builder()
        .nome(faker.name().fullName())
        .especialidade(especialidades[faker.random().nextInt(especialidades.length)])
        .crm(crmCompleto)
        .build();
  }
}
