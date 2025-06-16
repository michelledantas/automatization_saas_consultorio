package ifsp.saas.consultasAgendadas;

import org.openqa.selenium.WebDriver;

public class ConsultasAgendadasLogic {


    private final WebDriver driver;
    private final ConsultasAgendadasPage page;

    public ConsultasAgendadasLogic(WebDriver driver) {
        this.driver = driver;
        this.page = new ConsultasAgendadasPage(driver);
    }

    public boolean verificarSeHaConsultasAgendadas() {
        return page.haConsultasAgendadas();
    }

    public void cancelarPrimeiraConsultaDaLista() {
        if (page.haConsultasAgendadas()) {
            page.cancelarPrimeiraConsulta();
        } else {
            System.out.println("Nenhuma consulta encontrada para cancelamento.");
        }
    }
}

