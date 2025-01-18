package Model.pontoeletronico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.ArrayList;

public interface CalcularHoras
{
    public LocalDateTime calcularHorasDia(Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia);
}
