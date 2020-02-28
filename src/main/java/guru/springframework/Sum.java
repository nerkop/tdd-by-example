package guru.springframework;

public class Sum implements Expression{

    MoneyCurrency augmend;
    MoneyCurrency addmend;

    public Sum(MoneyCurrency augmend, MoneyCurrency addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }
    @Override
    public MoneyCurrency reduce(Bank bank, String to){
        int amount = augmend.amount + addmend.amount;
        return new MoneyCurrency(amount, to);

    }
}
