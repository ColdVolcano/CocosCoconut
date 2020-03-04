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
        Integer numerador = 0;
        Integer denominador = 0;
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
        
        if(denominator.endsWith("s"))
        {
            denominator = denominator.substring(0, denominator.length() - 1);
        }
        
        if(denominator.endsWith("vo"))
        {
            denominator = denominator.substring(0, denominator.length() - 2);
            
            Integer inNoTrim = unidades.get(denominator);
            Integer inTrim = unidades.get(denominator.substring(0, denominator.length() - 1));
            if(inNoTrim != null || inTrim != null)
            {
                denominador = inNoTrim != null ? inNoTrim : inTrim;
            }
            else if(denominator.indexOf('i', 0) != -1)
            {
                Integer index = denominator.indexOf('i', 0);
                while(denominator.indexOf('i', index) != -1)
                {
                    inNoTrim = unidades.get(denominator.substring(index + 1));
                    if(inNoTrim != null)
                    {
                        denominador += unidades.get(denominator.substring(0, index));
                        break;
                    }
                }
            }
        }
        else
        {
            denominador = unidades.get(denominator);
        }
        
        return new Fraccion(numerador, denominador);
    }
    
    private static final Map<String, Integer> unidades = new HashMap<>();
    
    static 
    {
        unidades.put("un", 1);
        unidades.put("uno", 1);
        unidades.put("entero", 1);
        unidades.put("dos", 2);
        unidades.put("medio", 2);
        unidades.put("tres", 3);
        unidades.put("tercio", 3);
        unidades.put("cuatro", 4);
        unidades.put("cuarto", 4);
        unidades.put("cinco", 5);
        unidades.put("quinto", 5);
        unidades.put("seis", 6);
        unidades.put("sexto", 6);
        unidades.put("siete", 7);
        unidades.put("septimo", 7);
        unidades.put("ocho", 8);
        unidades.put("octavo", 8);
        unidades.put("nueve", 9);
        unidades.put("noveno", 9);
        unidades.put("diez", 10);
        unidades.put("decimo", 10);
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
        unidades.put("centesimo", 100);
    }
}
