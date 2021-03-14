package org.mzhang.hackaton.orion;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Transaction {
    private String uniqueId;
    private String transactionType;
}
