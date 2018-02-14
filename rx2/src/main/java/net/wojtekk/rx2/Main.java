package net.wojtekk.rx2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    System.out.println("\n\nCase 1 - subscribeOn\n");

    Flowable.range(1, 10)
      .flatMap(v ->
        Flowable.fromCallable(() -> {
          Thread.sleep(1000 - v * 100);
          return v;
        })
          .subscribeOn(Schedulers.computation())
          .map(w -> w * w)
      )
      .blockingSubscribe(System.out::println);

    System.out.println("\n\nCase 2 - onErrorReturn inside flatMap\n");

    Flowable.range(1, 10)
      .flatMap(v ->
        Flowable.fromCallable(() -> {
          Thread.sleep(1000 - v * 100);
          if (v == 4) {
            throw new Exception("Some error");
          }
          return v;
        })
          .subscribeOn(Schedulers.computation())
          .map(w -> w * w)
          .onErrorReturn(error -> -1)
      )
      .blockingSubscribe(System.out::println, error -> System.out.println(error.getMessage()));

    System.out.println("\n\nCase 3 - onErrorReturnItem\n");

    Flowable.range(1, 10)
      .map(v -> {
        if (v == 4) {
          throw new Exception("Some error");
        }
        return v;
      })
      .onErrorReturnItem(-1)
      .blockingSubscribe(System.out::println, error -> System.out.println(error.getMessage()));

    System.out.println("\n\nCase 4 - onErrorReturn\n");

    Flowable.range(1, 10)
      .map(v -> {
        if (v == 4) {
          throw new Exception("Some error");
        }
        return v;
      })
      .onErrorResumeNext(Flowable.range(100, 5))
      .blockingSubscribe(System.out::println, error -> System.out.println(error.getMessage()));

    System.out.println("\n\nCase 5 - CompletableFuture inside flatMap\n");

    Flowable.range(1, 10)
      .flatMap(v -> {
          CompletableFuture<Integer> future = new CompletableFuture<>();
          Flowable.timer(1000 - v * 100, TimeUnit.MILLISECONDS)
            .subscribe(s -> {
              System.out.println("o");
              future.complete(v);
            });
          System.out.print(".");
          return Flowable.fromFuture(future);
        }
      )
      .blockingSubscribe(System.out::println);

    System.out.println("\n\nCase 6 - CompletableFuture with subscribeOninside flatMap\n");

    Flowable.range(1, 10)
      .flatMap(v -> {
          CompletableFuture<Integer> future = new CompletableFuture<>();
          Flowable.timer(1000 - v * 100, TimeUnit.MILLISECONDS)
            .subscribe(s -> future.complete(v));
          return Flowable.fromFuture(future)
            .subscribeOn(Schedulers.computation());
        }
      )
      .blockingSubscribe(System.out::println);
  }
}
