package com.inatel.dm112.logisticservice.service;

import com.inatel.dm112.logisticservice.dto.MailDto;
import com.inatel.dm112.logisticservice.model.DeliveryOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MailService {

  @Value("${mail.rest.url}")
  private String restUrl;

  @Value("${email.from}")
  private String from;

  @Value("${email.to}")
  private String to;

  @Value("${email.password}")
  private String password;

  public void mailNotify(DeliveryOrder order) {
    MailDto emailBody = generateEmail(order);

    WebClient client = WebClient.create();

    client
      .post()
      .uri(restUrl)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
      .body(Mono.just(emailBody), MailDto.class)
      .retrieve()
      .bodyToMono(String.class)
      .log()
      .block();
  }

  public MailDto generateEmail(DeliveryOrder order) {
    String mailBody = '\n' + "Order " + order.getId() + " has been delivered \n\nProduct: " + order.getName()
      + "\n\nEnjoy!! ^^";

    MailDto mail = new MailDto(from, password, to, mailBody);
    System.out.println("Mail sent suscessfully...");
    return mail;
  }
}
