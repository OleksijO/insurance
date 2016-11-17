package training.derivative;

import org.junit.Before;
import org.junit.Test;
import training.derivative.model.Model;
import training.derivative.model.entity.Insurance;
import training.derivative.model.entity.InsuranceDerivative;
import training.derivative.model.entity.InsuranceSortMethod;
import training.derivative.model.entity.derivative.InsuranceDerivativeImpl;
import training.derivative.model.entity.insurance.find.condition.RiskDegreeRange;
import training.derivative.model.entity.insurance.find.condition.SpecifiedType;
import training.derivative.model.entity.insurance.find.condition.SumInsuredRange;
import training.derivative.model.init.InitInsurance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static training.derivative.model.init.InitInsurance.*;

/**
 * This test class is using for test model's entity logic
 *
 * @author oleksij.onysymchuk@gmail
 */
public class InsuranceDerivativeImplTest {
    private InsuranceDerivative derivative;
    private List<Insurance> insurances;
    private Model model = new Model();

    @Before
    public void initDerivative() {
        insurances = new ArrayList<>();
        for (InitInsurance initInsurance : values()) {
            insurances.add(initInsurance.getInsurance());
        }
        derivative = model.createDerivative("Ivan Sidorov", insurances);
    }

    @Test
    public void testGetSummaryFee() {
        assertEquals(3969470, derivative.getSummaryFee());

        derivative.getInsurances().remove(0);
        assertEquals(2969470, derivative.getSummaryFee());

        ((InsuranceDerivativeImpl) derivative).setInsurances(new ArrayList<>());
        assertEquals(0, derivative.getSummaryFee());

        derivative.addInsurance(A.getInsurance());
        assertEquals(A.getInsurance().getFee(), derivative.getSummaryFee());

        ((InsuranceDerivativeImpl) derivative).setInsurances(null);
        assertEquals(0, derivative.getSummaryFee());
    }

    @Test
    public void testSortInsurances() {
        List<Insurance> insurancesSorted = new ArrayList<>();
        insurancesSorted.add(D.getInsurance());
        insurancesSorted.add(E.getInsurance());
        insurancesSorted.add(A.getInsurance());
        insurancesSorted.add(B.getInsurance());
        insurancesSorted.add(C.getInsurance());

        derivative.sortInsurances(InsuranceSortMethod.BY_RISK_DEGREE);
        assertEquals(insurancesSorted, derivative.getInsurances());

        insurancesSorted = new ArrayList<>();
        insurancesSorted.add(C.getInsurance());
        insurancesSorted.add(B.getInsurance());
        insurancesSorted.add(A.getInsurance());
        insurancesSorted.add(E.getInsurance());
        insurancesSorted.add(D.getInsurance());

        derivative.sortInsurances(InsuranceSortMethod.BY_RISK_DEGREE_DESC);
        assertEquals(insurancesSorted, derivative.getInsurances());

        derivative.sortInsurances(null);
        assertEquals(insurancesSorted, derivative.getInsurances());


    }

    @Test
    public void testFindInsurances() {
        assertEquals(insurances, derivative.findInsurances());
        assertEquals(insurances, derivative.findInsurances(null));

        assertEquals(0, derivative.findInsurances(new SpecifiedType("bla bla bla")).size());
        assertEquals(1, derivative.findInsurances(new SpecifiedType("CASCOInsurance")).size());

        assertEquals(2, derivative.findInsurances(new RiskDegreeRange(0.007, 0.012)).size());

        assertEquals(0, derivative.findInsurances(
                new RiskDegreeRange(0.007, 0.012),
                new SpecifiedType("bla bla bla"))
                .size());
        assertEquals(1, derivative.findInsurances(
                new RiskDegreeRange(0.007, 0.012),
                new SumInsuredRange(5000000, 6000000))
                .size());
        assertEquals(0, derivative.findInsurances(
                new RiskDegreeRange(0.007, 0.012),
                new SumInsuredRange(5000000, 6000000),
                new SpecifiedType("bla bla bla"))
                .size());

    }

}
