package org.mzhang.hackaton.orion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.UUID;

@Slf4j
public class TransactionLogger {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        for(int i=0;i<10;i++){
            String uniqueId = UUID.randomUUID().toString() + "-" + i;
            String transactionType = String.valueOf(i);

            Transaction transaction = Transaction.builder()
                    .uniqueId(uniqueId)
                    .transactionType(transactionType)
                    .build();

            MDC.put("uniqueId",uniqueId);
            MDC.put("transactionType", transactionType);
            log.info(objectMapper.writer().forType(Transaction.class)
                    .writeValueAsString(transaction));
        }
    }
}
