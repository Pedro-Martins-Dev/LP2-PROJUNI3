package Model.pontoeletronico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class BancoHoras implements CalcularHoras
{
    @Override
    public LocalDateTime calcularHorasDia(Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia)
    {
        // Placeholder return value, replace with actual logic
        return LocalDateTime.now();
    }
    
}
