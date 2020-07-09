package by.epamtc.degtyarovea.validator;

import by.epamtc.degtyarovea.entity.Criteria;

public class CriteriaValidator {

    public boolean isValid(Criteria criteria) {
        return criteria != null &&
                !criteria.getDeviceType().isEmpty() &&
                !criteria.getAttribute().isEmpty() &&
                !criteria.getValue().isEmpty();
    }
}
