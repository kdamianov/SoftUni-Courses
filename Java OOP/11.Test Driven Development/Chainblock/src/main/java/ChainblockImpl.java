import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    //Chainblock -> база от данни с транзакции
    private Map<Integer, Transaction> transactionsMap;
    //id -> транзакция

    public ChainblockImpl() {
        this.transactionsMap = new HashMap<>(); //създаваме конструктор, за да управялваме MAP-а
    }


    public int getCount() {
        //брой транзакции в БД
        return transactionsMap.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            this.transactionsMap.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        //true -> ако има такава транзакция в transactionMap
        //false -> ако няма такава транзакция в transactionMap
        return this.transactionsMap.containsValue(transaction);
    }

    public boolean contains(int id) {
        //true -> ако има транзакция с такова ID
        return this.transactionsMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        //нямаме транзакция с даденото Id
        if (!(contains(id))) {
            throw new IllegalArgumentException("Invalid Transaction ID!");
        }
        //имаме транзакция с дадено id
        Transaction transactionForChange = this.transactionsMap.get(id);
        transactionForChange.setStatus(newStatus);

    }

    public void removeTransactionById(int id) {
        //нямаме транзакция с дадено Id
        if (!contains(id)) {
            throw new IllegalArgumentException("Invalid transaction ID!");
        }
        //имаме такаава транзакция -> премахваме я
        this.transactionsMap.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException("Invalid transaction ID!");
        }
        // връща по даденото Id
        return transactionsMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : this.transactionsMap.values()) {
            if (transaction.getStatus() == status) {
                filteredTransactions.add(transaction);
            }
        }
        if (filteredTransactions.size() == 0) {
            throw new IllegalArgumentException("Transactions with given status not found!");
        }
        filteredTransactions.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return filteredTransactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> filteredTransactions = getByTransactionStatus(status);
        List<String> senders = new ArrayList<>();

        filteredTransactions.forEach(transaction -> senders.add(transaction.getFrom()));

        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
