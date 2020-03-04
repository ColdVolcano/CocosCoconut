package fracciones;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José Javier Flores López
 */
public class TraductorFraccion {
    public static Fraccion fromString(String input)
    {
        input = input.toLowerCase();
        Fraccion ret;
        Integer numerador = 0;
        String trimmed = input.trim();
        String[] numeralSeparator;
        Integer lastSpace = trimmed.lastIndexOf(' ');
        String numeral = trimmed.substring(0, lastSpace);
        String denominator = trimmed.substring(lastSpace + 1);
        System.out.println("");
        
        if(numeral.startsWith("dieci"))
        {
            numeral = numeral.replaceAll("dieci", "");
            numerador += 10;
        }
        if(numeral.startsWith("veinti"))
        {
            numeral = numeral.replaceAll("veinti", "");
            numerador += 20;
        }
        
        numeralSeparator = numeral.split(" y ");
        
        for (String string : numeralSeparator) {
            Integer num = unidades.get(string);
            if(num == null)
                return null;
            numerador += num;
        }
        
        return new Fraccion(numerador, 0);
    }
    
    private static final Map<String, Integer> unidades = new HashMap<>();
    
    private static final Map<String, Integer> denominadores = new HashMap<>();
    
    static 
    {
        unidades.put("un", 1);
        unidades.put("uno", 1);
        unidades.put("dos", 2);
        unidades.put("tres", 3);
        unidades.put("cuatro", 4);
        unidades.put("cinco", 5);
        unidades.put("seis", 6);
        unidades.put("siete", 7);
        unidades.put("ocho", 8);
        unidades.put("nueve", 9);
        unidades.put("diez", 10);
        unidades.put("once", 11);
        unidades.put("doce", 12);
        unidades.put("trece", 13);
        unidades.put("catorce", 14);
        unidades.put("quince", 15);
        unidades.put("veinte", 20);
        unidades.put("treinta", 30);
        unidades.put("cuarenta", 40);
        unidades.put("cincuenta", 50);
        unidades.put("sesenta", 60);
        unidades.put("setenta", 70);
        unidades.put("ochenta", 80);
        unidades.put("noventa", 90);
        unidades.put("cien", 100);
        
        denominadores.put("entero", 1);
        denominadores.put("medio", 2);
        denominadores.put("tercio", 3);
        denominadores.put("cuarto", 4);
        denominadores.put("quinto", 5);
        denominadores.put("sexto", 6);
        denominadores.put("septimo", 7);
        denominadores.put("octavo", 8);
        denominadores.put("noveno", 9);
        denominadores.put("decimo", 10);
        denominadores.put("centesimo", 100);
    }
}
