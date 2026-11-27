import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
      
      
      CompletableFuture<Integer> foodprice = CompletableFuture.supplyAsync(()->{
       

         System.out.println(" calulc.. food price");

         return 490;
      });

      CompletableFuture<Double> finalprice = foodprice.thenApply(price->{
        return price + (price * 5 /100.0);
      });


      CompletableFuture<Void> display =  finalprice.thenAccept(Amount->{
     System.out.print(Amount);
      });

   

   display.join();
   
    }
}