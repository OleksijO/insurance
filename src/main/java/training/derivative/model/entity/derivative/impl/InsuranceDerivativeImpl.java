package training.derivative.model.entity.derivative.impl;

import training.derivative.model.entity.derivative.InsuranceFindCondition;
import training.derivative.model.entity.derivative.InsuranceSortMethod;
import training.derivative.model.entity.insurance.Insurance;
import training.derivative.model.entity.derivative.InsuranceDerivative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by oleksij.onysymchuk@gmail on 13.11.2016.
 */
public class InsuranceDerivativeImpl implements InsuranceDerivative {
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
    public long getSummaryFee() {
        if ((insurances == null) || (insurances.isEmpty())) {
            return 0L;
        }
        return insurances.stream().map(Insurance::getFee).reduce(0L, (x, y) -> x + y);
    }

    @Override
    public void sortInsurances(InsuranceSortMethod method) {
        if ((insurances == null) || (insurances.isEmpty() || method==null)) {
            return;
        }
        Collections.sort(insurances, method.getComparator());
    }

    @Override
    public List<Insurance> findInsurances(InsuranceFindCondition... conditions) {
        if (conditions == null || conditions.length == 0) {
            return insurances;
        }
        if ((insurances == null) || (insurances.isEmpty())) {
            return new ArrayList<>();
        }

        Stream<Insurance> insuranceStream = insurances.stream();
        for (InsuranceFindCondition condition : conditions) {
            insuranceStream = insuranceStream.filter(condition.getPredicate());
        }

        return insuranceStream.collect(Collectors.toList());
    }

    @Override
    public void addInsurance(Insurance insurance) {
        if (insurances == null) {
            insurances = new ArrayList<>();
        }
        if (insurance != null) {
            insurances.add(insurance);
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsuranceDerivativeImpl that = (InsuranceDerivativeImpl) o;

        if (insurantPerson != null ? !insurantPerson.equals(that.insurantPerson) : that.insurantPerson != null)
            return false;
        return insurances != null ? insurances.equals(that.insurances) : that.insurances == null;

    }

    @Override
    public int hashCode() {
        int result = insurantPerson != null ? insurantPerson.hashCode() : 0;
        result = 31 * result + (insurances != null ? insurances.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsuranceDerivativeImpl{\n" +
                "insurantPerson='" + insurantPerson + '\'' +
                ",\ninsurances=\n" + getInsuranceList(insurances) +
                "fee = " + getSummaryFee() + " cents" +
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
