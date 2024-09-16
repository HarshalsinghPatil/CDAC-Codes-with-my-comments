namespace Met.Banking;

//a class defined with abstract modifier cannot be activated(i.e. making instances/objects), it can only be used as a base class
public abstract class Account
{//Internal can not be used by the derived class
    public long Id { get; internal set; }
//only derived classes can use the protected properties
    public double Balance { get; protected set; }

    //an instance method defined with abstract modifier
    //is pure(i.e. no body) and it must be overridden in a non-abstract
    //derived class
    public abstract void Deposit(double amount);

    public abstract void Withdraw(double amount);

    public bool Transfer(double amount, Account that)
    {//java (this == that)
        if(ReferenceEquals(this, that))
            return false;
        this.Withdraw(amount);
        that.Deposit(amount);
        return true;
    }
}
