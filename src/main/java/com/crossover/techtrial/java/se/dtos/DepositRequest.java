package com.crossover.techtrial.java.se.dtos;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accountId",
"monetaryAmount"
})
public class DepositRequest {

@JsonProperty("accountId")
private String accountId;
@JsonProperty("monetaryAmount")
private MonetaryAmount monetaryAmount;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("accountId")
public String getAccountId() {
return accountId;
}

@JsonProperty("accountId")
public void setAccountId(String accountId) {
this.accountId = accountId;
}

@JsonProperty("monetaryAmount")
public MonetaryAmount getMonetaryAmount() {
return monetaryAmount;
}

@JsonProperty("monetaryAmount")
public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
this.monetaryAmount = monetaryAmount;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}