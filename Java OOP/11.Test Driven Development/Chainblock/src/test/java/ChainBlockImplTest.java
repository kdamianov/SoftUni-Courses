import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChainBlockImplTest {
    private Chainblock database; //база данни с транзакциите

    @Before
    public void setUp() {
        this.database = new ChainblockImpl(); //празна база данни от транзакции
    }

    private Transaction addOneTransaction() {
        Assert.assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 150.90);
        this.database.add(transaction1);
        return transaction1;
    }
    private void addFourTransactions() {
        Assert.assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 50.90);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Desi", "Ivan", 140.90);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Desi", "Ganyo", 50.50);
        Transaction transaction4 = new TransactionImpl(3, TransactionStatus.ABORTED, "Desi", "Kiro", 30.50);
        this.database.add(transaction1);
        this.database.add(transaction2);
        this.database.add(transaction3);
        this.database.add(transaction4);
    }

    //добавяме транзакция, която я няма
    @Test
    public void testAddCorrectTransaction() {
        //проверяване дали е празна базата
        Assert.assertEquals("Initial DB is not empty!", 0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 150.90);
        //добавяме транзакция
        this.database.add(transaction1);
        //1 транзакция
        Assert.assertEquals("Error in addTransaction!", 1, this.database.getCount());
        Assert.assertTrue("Transaction does not exist in DB!", this.database.contains(transaction1));
    }

    //добавяме транзакция, която я има
    @Test
    public void testAddExistingTransaction() {
        Transaction transaction1 = addOneTransaction();
        //1 транзакция
        Assert.assertEquals(1, this.database.getCount());
        Assert.assertTrue(this.database.contains(transaction1.getId()));
        //добавяме съшествуваща транзакция / съществуваща
        this.database.add(transaction1);

        Assert.assertEquals(1, this.database.getCount());
    }

    //change transaction status

    //намираме транзакция с дадено Id -> сменя статусът й с дадения
    @Test
    public void testTransactionStatus() {
        addOneTransaction();
        Assert.assertEquals(1, this.database.getCount());

        this.database.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Transaction expected = new TransactionImpl(1, TransactionStatus.ABORTED, "Desi", "Stoyan", 150.90);
        Assert.assertEquals(TransactionStatus.ABORTED, this.database.getById(1).getStatus());

    }

    //не намираме транзакция с даденото ID -> IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusInvalidId() {
        addOneTransaction();
        this.database.changeTransactionStatus(2, TransactionStatus.ABORTED);

    }

    //съществуващо Id
    @Test
    public void testRemoveTransactionById() {
        Assert.assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 150.90);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Ivan", "Pencho", 250.90);
        this.database.add(transaction1);
        this.database.add(transaction2);
        Assert.assertEquals(2, this.database.getCount());
        //премахваме транзакция с id = 1
        this.database.removeTransactionById(1);
        Assert.assertEquals(1, this.database.getCount());
        Assert.assertFalse(this.database.contains(1));
    }

    //невалидно id
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveInvalidTransaction() {
        addOneTransaction();
        this.database.removeTransactionById(5);

    }

    //getById
    //съществува с такова Id -> връщаме я с даденото Id
    @Test
    public void testGetTransactionById() {
        Transaction transaction1 = addOneTransaction();
        Transaction returned = this.database.getById(1);
        //дали върнатата е еднаква с първата с  Id = 1
        Assert.assertEquals(transaction1, returned);
        //Стойността на всяко поле
        Assert.assertEquals(1, returned.getId());
        Assert.assertEquals(TransactionStatus.SUCCESSFUL, returned.getStatus());

    }


    //не съществува с такова Id -> IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testGetTransactionByInvalidId() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 150.90);
        this.database.add(transaction1);

        this.database.getById(5);
    }

    //get by Transaction Statut
    //валиден статус -> всички транзкции с този статус подредени descending по стойност
    @Test
    public void testGetTransactionByValidStatus() {
        Assert.assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 50.90);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Desi", "Ivan", 140.90);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Desi", "Ganyo", 50.50);
        this.database.add(transaction1);
        this.database.add(transaction2);
        this.database.add(transaction3);
        Assert.assertEquals(3, this.database.getCount());

        Iterable<Transaction> result = this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> returnedTransactions = new ArrayList<>(); //всички транзакции със SUCCESSFUL

        result.forEach(returnedTransactions::add);
        //верен брой върнати транзакции
        Assert.assertEquals(2, returnedTransactions.size());
        //вс върнати са със SUCCESSFUL
        returnedTransactions.forEach(tr -> Assert.assertEquals(TransactionStatus.SUCCESSFUL, tr.getStatus()));
        //върнантите транзакции са правилно подредени -> descending по стойност
        Assert.assertEquals(returnedTransactions.get(0), transaction2);
        Assert.assertEquals(returnedTransactions.get(1), transaction1);
    }

    //невалиден статус -> IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testGetTransactionByInvalidTransactionStatus() {
        Assert.assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 150.90);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Desi", "Ivan", 140.90);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Desi", "Ganyo", 50.50);
        this.database.add(transaction1);
        this.database.add(transaction2);
        this.database.add(transaction3);
        Assert.assertEquals(3, this.database.getCount());

        Iterable<Transaction> result = this.database.getByTransactionStatus(TransactionStatus.FAILED);
    }

    //getAllSendersWithTransactionStatus
    //връщаме податели с даден статус -> сортирани в descending
    @Test
    public void testGetAllSendersWithExistingTransactionStatus() {
        Assert.assertEquals(0, this.database.getCount());
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Stoyan", 50.90);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Kuncho", "Ivan", 140.90);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Trayan", "Ganyo", 50.50);
        Transaction transaction4 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Pencho", "Kiro", 30.50);
        this.database.add(transaction1);
        this.database.add(transaction2);
        this.database.add(transaction3);
        this.database.add(transaction4);
        Assert.assertEquals(3, this.database.getCount());

        Iterable<String> result = this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> resultSenders = new ArrayList<>();//Всички податели със статус SUCCESSFUL

        result.forEach(resultSenders::add);
        //брой върнати податели
        Assert.assertEquals(3, resultSenders.size());
        Assert.assertEquals("Kuncho", resultSenders.get(0));
        Assert.assertEquals("Desi", resultSenders.get(1));
        Assert.assertEquals("Pencho", resultSenders.get(2));

    }

    //нямаме транзакции с даден статус -> IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithMissingTransactionStatus() {
        addFourTransactions();
        Assert.assertEquals(3, this.database.getCount());
        this.database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }


}
