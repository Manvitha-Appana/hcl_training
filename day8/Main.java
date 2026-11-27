import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
      
      CompletableFuture<Integer> foodprice = CompletableFuture.supplyAsync(()->{
        System.out.println("call foodd price");

        return 500;
      });
     
     CompletableFuture<Double> finalprice = foodprice.thenApply(price->{
      return price + (price * 5 /100.0);
     });

    //  CompletableFuture<Void> display = finalprice.thenAccept(ammount->{
    //   System.out.println("your bill amount is "+ ammount);
    //  });

    CompletableFuture<Double> delivery = CompletableFuture.supplyAsync(()->{
        System.out.println("del charges are added");

        return 50.0;
    });


    CompletableFuture<Double> totalprice = finalprice.thenCombine(delivery,(food,charge)->{
         
         return food + charge;
    });

    System.out.println(totalprice.join());





     

    }
}
