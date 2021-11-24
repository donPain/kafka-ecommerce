package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

     public static void main (String[] args) throws ExecutionException, InterruptedException {
         var dispatcher = new kafkaDispatcher();
         for (var i = 0; i < 10; i++) {
             var key = UUID.randomUUID().toString();
             var value = key + ",Compras novas, 1234";
             dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
             var email = "Thank you for your order, mank!";
//             var emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL",email,email);
             dispatcher.send("ECOMMERCE_SEND_EMAIL",key,email);
         }
     }}

