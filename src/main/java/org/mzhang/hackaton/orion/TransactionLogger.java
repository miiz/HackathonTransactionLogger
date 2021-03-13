package org.mzhang.hackaton.orion;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.UUID;

@Slf4j
public class TransactionLogger {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            String uniqueId = UUID.randomUUID().toString() + "-" + i;
            MDC.put("uniqueId",uniqueId);
            MDC.put("transactionType",String.valueOf(i));
            log.info("Debit Transaction {}", uniqueId);
        }
    }
}
