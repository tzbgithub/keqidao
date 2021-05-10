package com.qidao.qidao.invoice.invoice.domain;


import com.qidao.qidao.order.order.domain.TOrder;
import com.qidao.qidao.organization.organization.domain.TOrganization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceOrderRes {

   private  List<TOrder> list;

   private TOrganization TOrganization;
}
