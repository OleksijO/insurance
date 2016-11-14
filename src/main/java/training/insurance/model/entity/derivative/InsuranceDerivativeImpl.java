package training.insurance.model.entity.derivative;

import training.insurance.model.entity.InsuranceDerivative;
import training.insurance.model.entity.Insurance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public class InsuranceDerivativeImpl implements InsuranceDerivative {
    private static final Comparator<Insurance> COMPARATOR_BY_RICK_DEGREE = new RiskDegreeComparator();
    private String insurantPerson;
    private List<Insurance> insurances;

    public InsuranceDerivativeImpl() {
        insurances = new ArrayList<>();
    }

    public InsuranceDerivativeImpl(String insurantPerson, List<Insurance> insurances) {
        this.insurantPerson = insurantPerson;
        this.insurances = insurances;
    }

    @Override
    public BigDecimal getSummaryFee() {
        BigDecimal summaryFee = BigDecimal.ZERO;
        for (Insurance insurance : insurances) {
            summaryFee = summaryFee.add(insurance.getFee());
        }
        return summaryFee;
    }

    @Override
    public List<Insurance> getInsurances() {
        return insurances;
    }

    public String getInsurantPerson() {
        return insurantPerson;
    }

    public void setInsurantPerson(String insurantPerson) {
        this.insurantPerson = insurantPerson;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    @Override
    public void sortInsurancesByRiskDegree() {
        Collections.sort(insurances, COMPARATOR_BY_RICK_DEGREE);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }

    private static class RiskDegreeComparator implements Comparator<Insurance> {
        @Override
        public int compare(Insurance o1, Insurance o2) {
            return Double.compare(o1.getRiskDegree(), o2.getRiskDegree());
        }
    }

    @Override
    public String toString() {
        return "InsuranceDerivativeImpl{\n" +
                "insurantPerson='" + insurantPerson + '\'' +
                ",\ninsurances=\n" + getInsuranceList(insurances) +
                "fee = " + getSummaryFee() +
                "}";
    }

    private String getInsuranceList(List<Insurance> insurances) {
        StringBuilder stringBuilder = new StringBuilder("\t{\n");
        insurances.forEach(
                insurance -> stringBuilder.append("\t\t")
                        .append(insurance)
                        .append("\n"));
        stringBuilder.append("\t}\n");
        return stringBuilder.toString();
    }
}
