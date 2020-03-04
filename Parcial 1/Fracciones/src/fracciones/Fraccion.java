package fracciones;

/**
 *
 * @author José Javier Flores López
 */
public class Fraccion {
    
    public Integer numerador;
    public Integer denominador;
    
    public Fraccion(Integer num, Integer denom)
    {
        numerador = num;
        denominador = denom;
    }
    
    public Fraccion add(Fraccion f2)
    {
        if (!denominador.equals(f2.denominador))
            return new Fraccion(numerador + f2.numerador, denominador);
        
        return new Fraccion(numerador * f2.denominador + f2.numerador * denominador, denominador * denominador);
    }
    
    public Fraccion substract(Fraccion f2)
    {
        return add(new Fraccion(-f2.numerador, f2.denominador));
    }
    
    public Fraccion multiply(Fraccion f2)
    {
        return new Fraccion(numerador * f2.numerador, denominador * f2.denominador);
    }
    
    public Fraccion divide(Fraccion f2)
    {
        return new Fraccion(numerador * f2.denominador, denominador * f2.numerador);
    }
}
