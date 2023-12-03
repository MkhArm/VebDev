package org.example.models.enums;

public enum TransmissionType {
    MANUAL(1),
    AUTOMATIC(2), DEFAULT(0);

    private final int transmissionTypeCode;

    private TransmissionType(int transmissionTypeCode) {
        this.transmissionTypeCode = transmissionTypeCode;
    }

    public int getTransmissionTypeCode() {
        return transmissionTypeCode;
    }
}
