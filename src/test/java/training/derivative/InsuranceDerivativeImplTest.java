package training.derivative;

import org.junit.Before;
import org.junit.Test;
import training.derivative.init.InitInsurance;
import training.derivative.model.entity.derivative.InsuranceDerivative;
import training.derivative.model.entity.derivative.impl.InsuranceDerivativeImpl;
import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.insurance.InsuranceSortMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static training.derivative.init.InitInsurance.*;

/**
 * This test class is using for test model's entity logic
 *
 * @author oleksij.onysymchuk@gmail
 */
public class InsuranceDerivativeImplTest {
    private InsuranceDerivative derivative;
    private List<Insurance> insurances;

    private Predicate<Insurance> predicateByClassFake =
            insurance -> (insurance.getClass().getSimpleName().equals("bla bla bla"));
    private Predicate<Insurance> predicateByClass =
            insurance -> (insurance.getClass().getSimpleName().equals("CASCOInsurance"));
    private Predicate<Insurance> predicateRiskDegreeRange =
            i -> (i.getRiskDegree() > 0.007) && (i.getRiskDegree() < 0.012);
    private Predicate<Insurance> predicateRiskDegreeRangeFake =
            i -> (i.getRiskDegree() > 0.00007) && (i.getRiskDegree() < 0.00012);
    private Predicate<Insurance> predicateSumInsuredRange =
            i -> (i.getSumInsured() >= 5000000) && (i.getSumInsured() <= 6000000);


    @Before
    public void initDerivative() {

        insurances = new ArrayList<>();
        for (InitInsurance initInsurance : values()) {
            insurances.add(initInsurance.getInsurance());
        }
        derivative = new InsuranceDerivativeImpl("Ivan Sidorov", insurances);
    }

    @Test
    public void testGetSummaryFee() {

        assertEquals("1. Initial summary fee",3969470, derivative.getSummaryFee());

        derivative.getInsurances().remove(0);
        assertEquals("2. Summary fee without 1 insurance",2969470, derivative.getSummaryFee());

        ((InsuranceDerivativeImpl) derivative).setInsurances(new ArrayList<>());
        derivative.addInsurance(A.getInsurance());
        assertEquals("3. Summary fee of 1 insurance", A.getInsurance().getFee(), derivative.getSummaryFee());
    }

    @Test
    public void testGetSummaryFeeNullAndEmptyListCase() {

        ((InsuranceDerivativeImpl) derivative).setInsurances(new ArrayList<>());
        assertEquals("1. Summary fee on empty insurance list", 0, derivative.getSummaryFee());

        ((InsuranceDerivativeImpl) derivative).setInsurances(null);
        assertEquals("2. Summary fee on insurance list = null", 0, derivative.getSummaryFee());
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
        assertEquals("1. Assert increasing order", insurancesSorted, derivative.getInsurances());

        insurancesSorted = new ArrayList<>();
        insurancesSorted.add(C.getInsurance());
        insurancesSorted.add(B.getInsurance());
        insurancesSorted.add(A.getInsurance());
        insurancesSorted.add(E.getInsurance());
        insurancesSorted.add(D.getInsurance());

        derivative.sortInsurances(InsuranceSortMethod.BY_RISK_DEGREE_DESC);
        assertEquals("2. Assert increasing order", insurancesSorted, derivative.getInsurances());

        derivative.sortInsurances(null);
        assertEquals("3. Null parameter", insurancesSorted, derivative.getInsurances());


    }

    @Test
    public void testFindInsurances() {

        assertEquals("1. No such insurance type",
                0, derivative.findInsurances(predicateByClassFake).size());
        assertEquals("2. Not empty search result by type", 1, derivative.findInsurances(predicateByClass).size());
        assertEquals("3. Risk degree range - not empty", 2, derivative.findInsurances(predicateRiskDegreeRange).size());
        assertEquals("4. Risk degree range - empty", 0, derivative.findInsurances(predicateRiskDegreeRangeFake).size());
    }

    @Test
    public void testFindInsurancesCombinedPredicates() {

        Predicate<Insurance> condition = predicateRiskDegreeRange.and(predicateByClassFake);
        assertEquals("1", 0, derivative.findInsurances(condition).size());

        condition = predicateRiskDegreeRange.and(predicateSumInsuredRange);
        assertEquals("2", 1, derivative.findInsurances(condition).size());

        condition = condition.and(predicateByClassFake);
        assertEquals("3", 0, derivative.findInsurances(condition).size());
    }

    @Test
    public void testFindInsurancesNullParameter() {
        assertEquals("Method must return all insurances if predicate is null",
                insurances, derivative.findInsurances(null));
    }
}
