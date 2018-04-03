package autoextender;


import autoextender.testcase.AbstractClass;
import autoextender.testcase.Interface;
import autoextender.testcase.WrongAbstractClass;
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

    private Interface stubbed = AutoExtender.extend(AbstractClass.class).to(Interface.class);

    @Test
    public void shouldReturnValueForImplementedMethods(){
        assertThat(stubbed.implementedInAbstractClass()).isEqualTo(VALUE);
    }

    @Test
    public void shouldThrowExceptionForStubbedMethods(){
        expectedException.expect(UnsupportedOperationException.class);

        stubbed.returnBoolean();
    }

    @Test
    public void shouldThrowExceptionForWrongHierarchy(){
        expectedException.expect(IllegalArgumentException.class);

        AutoExtender.extend(WrongAbstractClass.class).to(Interface.class);
    }

}
