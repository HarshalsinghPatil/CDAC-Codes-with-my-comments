//We are mapping this entity using annotations
package shopping;
//counters table has two columns 1.ctr_name 2.cur_val
import javax.persistence.*;

@Entity//now turn this pojo in to entity using annotations

@Table(name="counters")//mapping counterEntity class to counters table
public class CounterEntity implements java.io.Serializable {
//some people apply it on fields and some people apply it on getters/setters
	@Id//primary key(identity field)
	@Column(name="ctr_name")
	private String name;

	@Column(name="cur_val")
	private int currentValue;
	// @Id//primary key(identity field)
	// @Column(name="ctr_name")
	public String getName() { return name; }
	public void setName(String value) { name = value; }

	public int getCurrentValue() { return currentValue; }
	public void setCurrentValue(int value) { currentValue = value; }

	public int getNextValue() { return ++currentValue; }

}

