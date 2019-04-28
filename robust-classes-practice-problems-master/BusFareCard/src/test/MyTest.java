package test;

import exceptions.IllegalAgeException;
import exceptions.IllegalAmountException;
import exceptions.MissingFareException;
import exceptions.NoBalanceException;
import model.BusFareCard;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class MyTest {
    BusFareCard  MohamedCard,AhmedCard,MinusCard;
    @Before
    public void setup(){
        try {
            MohamedCard=new BusFareCard("Mohamed",25,2.75);
            AhmedCard=new BusFareCard("Ahmed",17,1);
        } catch (IllegalAmountException e) {
            fail(e.getMessage());
        }
        try {
            MinusCard=new BusFareCard("zero",22,-2);
        } catch (IllegalAmountException e) {

        }
    }
    @Test
    public void gettersTest(){
        assertEquals(MohamedCard.getAge(),25);
        assertEquals(MohamedCard.getBalance(),2.75,.001);
        assertEquals(MohamedCard.getName(),"Mohamed");
        assertEquals(MohamedCard.isFareLoaded(),false);
    }
    @Test
    public void purchaseFareTest(){
        try {
            MohamedCard.purchaseConcessionTicket();
        } catch (IllegalAgeException e) {
        } catch (NoBalanceException e) {
           fail();
        }
        try {
            AhmedCard.purchaseConcessionTicket();
        } catch (IllegalAgeException e) {
            fail();
        } catch (NoBalanceException e) {
        }
        assertEquals(AhmedCard.isFareLoaded(),false);
        assertEquals(AhmedCard.getBalance(),1,.001);
        try {
            MohamedCard.purchaseAdultFare();
        } catch (IllegalAgeException e) {
            fail();
        } catch (NoBalanceException e) {
            fail();
        }
        assertEquals(MohamedCard.isFareLoaded(),true);
        assertEquals(MohamedCard.getBalance(),0,.001);
    }
    @Test
    public void reloadBalanceTest(){
        try {
            AhmedCard.reloadBalance(3);
        } catch (IllegalAmountException e) {
            fail();
        }
        assertEquals(AhmedCard.getBalance(),4,.001);
    }
    @Test
    public void boardBusTest(){
        try {
            MohamedCard.boardBus();
        } catch (MissingFareException e) {

        }
        assertEquals(MohamedCard.isFareLoaded(),false);
        try {
            MohamedCard.purchaseAdultFare();
        } catch (IllegalAgeException e) {
            fail();
        } catch (NoBalanceException e) {
            fail();
        }
        try {
            MohamedCard.boardBus();
        } catch (MissingFareException e) {
            fail();
        }

        assertEquals(MohamedCard.isFareLoaded(),false);
    }

}
