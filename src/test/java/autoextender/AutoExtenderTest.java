package autoextender;


import autoextender.testcase.AbstractClass;
import autoextender.testcase.Interface;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static autoextender.testcase.AbstractClass.VALUE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sergii Karpenko
 */
public class AutoExtenderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Interface stubbed = AutoImplementer.implement(AbstractClass.class);

    @Test
    public void shouldReturnValueForImplementedMethods(){
        assertThat(stubbed.implemented()).isEqualTo(VALUE);
    }

    @Test
    public void shouldThrowExceptionForStubbedMethods(){
        expectedException.expect(UnsupportedOperationException.class);

        stubbed.returnBoolean();
    }

}
