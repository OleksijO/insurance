package training.derivative.model.entity.insurance;

import java.util.Comparator;

/**
 * This enum contains comparators for sorting insurances in derivative.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 1.0 17 NOV 2016
 */
public enum InsuranceSortMethod {

    /**
     * Sort method by insurance risk degree in increasing order
     */
    BY_RISK_DEGREE((o1, o2) -> Double.compare(o1.getRiskDegree(), o2.getRiskDegree())),

    /**
     * Sort method by insurance risk degree in decreasing order
     */
    BY_RISK_DEGREE_DESC((o1, o2) -> Double.compare(o2.getRiskDegree(), o1.getRiskDegree()));

    private Comparator<Insurance> comparator;

    InsuranceSortMethod(Comparator<Insurance> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Insurance> getComparator() {
        return comparator;
    }
}
