import java.lang.reflect.Field;

class Program {
//Generic printxml method it can be worked with any class and any number of arguments
	public static void printAsXml(Object info) {
		Class<?> c = info.getClass();//when we don't know the classname
		System.out.printf("<%s>%n", c.getName());
		for(Field f : c.getDeclaredFields())//taking info of all the field of the unknown class
		{
			//
			System.out.printf("<%s>",f.getName());
			try{
				f.setAccessible(true);
				System.out.print(f.get(info));
			}catch(Exception e){
				System.out.print("error");
			}
			System.out.printf("</%s>%n", f.getName());
		}
		System.out.printf("</%s>%n", c.getName());
		System.out.println();
	}
	
	public static void main(String[] args) {
		printAsXml(new Item("cpu", "intel", 20));
		printAsXml(new Item("ssd", "samsung", 30));
		printAsXml(new Customer("Alex", 45000, 3));
		printAsXml(new Shop());
	}
}

