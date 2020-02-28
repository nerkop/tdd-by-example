package guru.springframework;

public class Sum implements Expression{

    MoneyCurrency augmend;
    MoneyCurrency addmend;

    public Sum(MoneyCurrency augmend, MoneyCurrency addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    public MoneyCurrency reduce(String to){
        int amount = augmend.amount + addmend.amount;
        return new MoneyCurrency(amount, to);

    }
}
