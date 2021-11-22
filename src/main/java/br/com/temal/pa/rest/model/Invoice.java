package br.com.temal.pa.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(value = "Parametros de entrada obrigatórios para fazer um transferencia")
public class Invoice implements Serializable {


	private static final long serialVersionUID = 1492453980104260017L;

	@ApiModelProperty( example = "ce4d0520-75c0-48e6-8484-674cfb56f79f")
	@Id
    private String nsu;

	@ApiModelProperty( example = "20.52")
    private Double amount;

	@ApiModelProperty( example = "65147475")
	private String originAccount;

	@ApiModelProperty( example = "547421")
	private String targetISPB;

	@ApiModelProperty( example = "65147475")
	private String targetAccount;

	@ApiModelProperty( example = "0001")
	private String targetBranch;

	@ApiModelProperty( example = "2021-12-31")
	private LocalDate paymentDate;

	@ApiModelProperty( example = "SOLICITADO", hidden = true)
	@Enumerated(EnumType.STRING)
	private SituationInvoiceType status = SituationInvoiceType.SOLICITADO;

	@ApiModelProperty(
			value = "Nome do cliente destino",
			example = "Joao da Silva Lopes",
			required = true,
			position = 9)
	private String targetCustomerName;


	@ApiModelProperty(
			value = "Número do documento do cliente destino",
			example = "85152636450",
			required = true,
			position = 11)
	private String targetNumberDocumentCustomer;


	@ApiModelProperty(
			value = "Comentário - até 25 caracteres.",
			example = "Maximo 25 caracteres.",
			required = false,
			position = 16)
	private String comments;
	@ApiModelProperty(
			value = "Tipo da transação ",
			example = "TED",
			required = true,
			position = 1)
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
}
