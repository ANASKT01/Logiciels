package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){

		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getRomanFromNumber(10), equalTo("X"));
        assertThat(RomanConverter.getRomanFromNumber(50), equalTo("L"));
        assertThat(RomanConverter.getRomanFromNumber(100), equalTo("C"));
        assertThat(RomanConverter.getRomanFromNumber(500), equalTo("D"));


        assertThat(RomanConverter.getNumberFromRoman("IV"),equalTo(4));
        assertThat(RomanConverter.getNumberFromRoman("X"),equalTo(10));
        assertThat(RomanConverter.getNumberFromRoman("L"),equalTo(50));
        assertThat(RomanConverter.getNumberFromRoman("C"),equalTo(100));
        assertThat(RomanConverter.getNumberFromRoman("DC"),equalTo(600));

		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("MMMM")), instanceOf(IllegalArgumentException.class));


    }
        
	
	
	//TODO : les autres tests
	


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
