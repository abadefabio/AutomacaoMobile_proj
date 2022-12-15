package br.com.next.automacao.core.annotations;

import br.com.next.automacao.core.constantes.Jornadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Jornada {
    Jornadas value();
}
