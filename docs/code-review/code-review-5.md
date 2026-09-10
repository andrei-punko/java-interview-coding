# Perform review of this code

```java
// Микросервис чеков высоконагруженного маркетплейса, десятки тысяч заказов в сутки.
// Основная функция микросервиса - отправка чеков в налоговую (во внешний независимый сервис)
// Инфраструктура - Kubernetes 8 подов (реплик), высоконагруженный.
// TaxClient - клиент налоговой (feign) - timeout = 60 секунд (не наш, не можем повлиять)
//
@Service
@AllArgsConstructor
public class SomeServiceImpl implements SomeService {
    private final TaxClient taxClient;
    private final ReceiptDao receiptDao;
    private final SomeService self;

    @Override
    @Transactional
    @Scheduled(cron = "${cron.expression}") // "30 30 * * *"
    public void processJobRunning() {
        List<Receipt> receipts = self.getRefundReceipts();
        for (Receipt receipt : receipts) {
            receipt.setProcessed(true);
            receiptDao.save(receipt);
            var receiptDto = new ReceiptDto(receipt.getId(), receipt.getSum());
            taxClient.idempotentSendReceipt(receiptDto);
        }
    }

    @Transactional(readOnly = true)
    public List<Receipt> getRefundReceipts() {
        return receiptDao.findAllBySourceAndProcessedFalse(ReceiptSource.REFUND); // select * from receipt where source = 'REFUND' and processed = false;
    }
}

// граница класса ----
public interface ReceiptDao extends JpaRepository<Receipt, Long> {
    List<Receipt> findAllBySourceAndProcessedFalse(ReceiptSource source);
}

//ниже этой строки - все корректно - enum, dto, entity - только для наглядности
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean processed;
    private String sum;
    private ReceiptSource source;
}

@Data
@NoArgsConstructor
public class ReceiptDto {
    private Long id;
    private String sum;
    private ReceiptSource source;
}
public enum ReceiptSource { DISCOUNT, SELL, REFUND}
```
