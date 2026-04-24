package pl.piomin.microservices.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    public Account(int id, int customerId, String number) {
		this.id	= id;
		this.customerId= customerId;
		this.number= number;
		}
	private Integer id;
    private Integer customerId;
    private String number;
	

}
