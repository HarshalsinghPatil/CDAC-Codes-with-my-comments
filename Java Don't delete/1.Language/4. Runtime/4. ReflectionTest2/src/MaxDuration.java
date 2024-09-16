package finance;

import java.lang.annotation.*;
/* we can restrict the java usage
1. by default it is the for complete program 
2. but we can apply it only for specific method
3. or ?????
*/ 

//@Target(ElementType.TYPE) ==> class/interface/enum/record type annotation= default ==> useless hence we don't use it
//@Target({ElementType.METHOD, ElementType.FIELD}) ==> THIS WAY WE CAN USE ANNOTATION FOR TWO DIFFERENT THINGS
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)//We use it for the runtime late binding
public @interface MaxDuration {
//this are not the normal interface hence they are called as meta interface shown by ==> @interface
	int value() default 5;
}

