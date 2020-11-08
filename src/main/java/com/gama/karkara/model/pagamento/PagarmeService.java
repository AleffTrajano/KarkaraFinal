package com.gama.karkara.model.pagamento;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.pagar.model.Address;
import me.pagar.model.Billing;
import me.pagar.model.Customer;
import me.pagar.model.Document;
import me.pagar.model.Item;
import me.pagar.model.PagarMeException;
import me.pagar.model.Transaction;

@Service
public class PagarmeService {
	@Value("${token}")
	private String token;
	
	public Transaction criarTransacao() throws PagarMeException {
		System.out.println(token);
		Transaction transaction = new Transaction();
		
		Customer customer = new Customer(); // viajante
		customer.setType(Customer.Type.INDIVIDUAL);
		customer.setExternalId("1001");
		customer.setName("Phineas Flynn");
		customer.setBirthday("1999-07-09");
		customer.setEmail("phineas@threestatearea.com");
		customer.setCountry("br");

		Collection<Document> documents = new ArrayList<>(); 
		Document document = new Document();
		document.setType(Document.Type.CPF);
		document.setNumber("77551442758");
		documents.add(document);
		customer.setDocuments(documents);

		Collection<String> phones = new ArrayList<>();
		phones.add("+5511982657575");
		customer.setPhoneNumbers(phones);

		Billing billing = new Billing(); 
		billing.setName("Phineas Flynn");
		
		Address address  = new Address(); 
		address.setCity("Santo Andre");
		address.setCountry("br");
		address.setState("sp");
		address.setNeighborhood("Parque Miami");
		address.setStreet("Rua Rio Jari");
		address.setZipcode("09133180");
		address.setStreetNumber("7");
		billing.setAddress(address);
		
		/*
		Shipping shipping = new Shipping();
		shipping.setAddress(address);
		shipping.setName("Phineas Flynn");
		shipping.setFee(3200);
		*/

		Collection<Item> items = new ArrayList<>();
		Item item = new Item(); 
		item.setId("OX890");
		item.setQuantity(12);
		item.setTangible(Boolean.TRUE);
		item.setTitle("Rockets");
		item.setUnitPrice(120);
		
		DadosPagamento pagamento = pagamento();
		
		//transaction.setShipping(shipping);
		transaction.setBilling(billing);
		transaction.setItems(items);
		transaction.setPaymentMethod(Transaction.PaymentMethod.CREDIT_CARD);
		transaction.setAmount(pagamento.getValorCobrado());
		transaction.setCardHolderName(pagamento.getDadosCartao().getNomeTitular());
		transaction.setCardNumber(pagamento.getDadosCartao().getNumeroCartao());
		transaction.setCardCvv(pagamento.getDadosCartao().getCvvCartao());
		transaction.setCardExpirationDate(pagamento.getDadosCartao().getDataExpiracao()); 
		transaction.setCustomer(customer);
		
		return transaction.save();
		
		
	}
	
	private DadosPagamento pagamento() {
		/*	 
		 {
    "numPedido":"2",
    "dadosCartao":{
        "nomeTitular":"Elton Douglas",
        "numeroCartao": "4242724282424744",
        "cvvCartao": "385",
        "dataExpiracao": "0420"
    },
    "valorCobrado":1000
	
	}	 
		 */
		DadosPagamento dp = new DadosPagamento();
		dp.setValorCobrado(10000);
		dp.setNumPedido(2);
		DadosCartao dc = new DadosCartao();
		dc.setNomeTitular("Elton Douglas");
		dc.setNumeroCartao("4242724282424744");
		dc.setCvvCartao("385");
		dc.setDataExpiracao("0420");
		dp.setDadosCartao(dc);
		
		return dp;
	}

}
