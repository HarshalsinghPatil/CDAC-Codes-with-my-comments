import shopping.*;
import javax.persistence.*;

//main purpose of this program saperate the dababase code from userInterface
//2 ways
//1. xml mapping 
//2. use annotations
class Program {

	public static void main(String[] args) throws Exception {
		//step1: create entity manager factory
		var emf = Persistence.createEntityManagerFactory("SalesPU");//it will look inside the persistance.xml and from there it will create entity manager factory
		//step2: createEntityManager which will fetch the data in the form entity
		var em = emf.createEntityManager();
		if(args.length == 0){
			var query = em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class);
			for(var entry : query.getResultList())
				System.out.printf("%d\t%.2f\t%d%n", entry.getProductNo(), entry.getPrice(), entry.getStock());
		}else{
			int id = Integer.parseInt(args[0]);
			ProductEntity product = em.find(ProductEntity.class, id);
			if(product != null){
				for(var entry : product.getOrders())
				System.out.printf("%s\t%d\t%tF%n", entry.getCustomerId(), entry.getQuantity(), entry.getOrderDate());
			}
		}
		em.close();
	}
}

