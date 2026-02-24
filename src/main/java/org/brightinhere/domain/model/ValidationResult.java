package org.brightinhere.domain.model;

public record ValidationResult(
        boolean valid,
        String message
) {

    public static ValidationResult valid() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult invalid(String message) {
        return new ValidationResult(false, message);
    }

    public boolean isValid() {
        return valid;
    }
}